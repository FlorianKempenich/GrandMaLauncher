package com.example.shock.memelauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.shock.memelauncher.view.CompoundAppView;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.applications_text_view) TextView mApplicationsTextView;
    @BindView(R.id.skype_compound) CompoundAppView mSkypeCompoundView;
    @BindView(R.id.photo_compound) CompoundAppView mPhotoCompoundView;

    @BindString(R.string.album_link) String mAlbumLink;
    @BindString(R.string.album_photo_title) String mPhotoText;

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
        mPhotoCompoundView.setTextAndImage(R.drawable.photo, mPhotoText);
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

    @OnClick(R.id.skype_card)
    void startSkype() {
        startAppWithPackageName(SKYPE_PACKAGE);
    }

    @OnClick(R.id.photo_card)
    void startPhoto() {
//        startAppWithPackageName(PHOTO_PACKAGE);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(mAlbumLink));
        startActivity(i);
    }

}
