package com.example.shock.memelauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.annotation.BinderThread;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.shock.memelauncher.view.CompoundAppView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.applications_text_view) TextView mApplicationsTextView;
    @Bind(R.id.skype_compound) CompoundAppView mSkypeCompoundView;
    @Bind(R.id.photo_compound) CompoundAppView mPhotoCompoundView;
    @Bind(R.id.florian_compound) CompoundAppView mFlorianCompoundView;

    private static final String SKYPE_PACKAGE = "com.skype.raider";
    private static final String FLORIAN_PACKAGE = "com.example.shock.florian";
    private static final String PHOTO_PACKAGE = "com.google.android.apps.photos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mApplicationsTextView.setAllCaps(true);

        // Set compound views
        mSkypeCompoundView.setTextAndImage(R.drawable.skype, null);
        mPhotoCompoundView.setTextAndImage(R.drawable.photo, null);
        mFlorianCompoundView.setTextAndImage(R.drawable.florian, null);

    }

    /**
     * Ignore back pressed
     */
    @Override
    public void onBackPressed() {
    }

    /**
     * Temp method to check package names
     */
    private void loadApps(){
        PackageManager manager = getPackageManager();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for(ResolveInfo ri:availableActivities){
            Log.d("PACKAGE_NAME", ri.activityInfo.packageName);
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

    @OnClick(R.id.skype_card)
    void startSkype() {
        startAppWithPackageName(SKYPE_PACKAGE);
    }

    @OnClick(R.id.photo_card)
    void startPhoto() {
        startAppWithPackageName(PHOTO_PACKAGE);
    }

}
