package com.example.shock.memelauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.applications_text_view) TextView mApplicationsTextView;

    private static final String SKYPE_PACKAGE = "com.skype.raider";
    private static final String FLORIAN_PACKAGE = "com.example.shock.florian";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mApplicationsTextView.setAllCaps(true);
        loadApps();
    }


    /**
     * Ignore back pressed
     */
    @Override
    public void onBackPressed() {
    }


    private class AppDetail {
        String label;
        String name;
        Drawable icon;
    }

    private void loadApps(){
        PackageManager manager = getPackageManager();
        List<AppDetail> apps = new ArrayList<>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for(ResolveInfo ri:availableActivities){
            AppDetail app = new AppDetail();
            app.label = ri.loadLabel(manager).toString();
            app.name = ri.activityInfo.packageName;
            Log.d("LOG", app.name);
            app.icon = ri.activityInfo.loadIcon(manager);
            apps.add(app);
        }
    }

    private void startAppWithPackageName(String packageName) {
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
        startActivity(intent);
    }



    /////////////////////
    // CLICK LISTENERS //
    /////////////////////

    @OnClick(R.id.applications_card)
    void openWarningScreen() {
        Intent startWarning = new Intent(this, WarningActivity.class);
        startActivity(startWarning);
    }

    @OnClick(R.id.florian_card)
    void callFlorian() {
        startAppWithPackageName(FLORIAN_PACKAGE);
    }

}
