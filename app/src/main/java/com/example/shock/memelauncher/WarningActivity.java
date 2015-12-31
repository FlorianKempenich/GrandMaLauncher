package com.example.shock.memelauncher;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WarningActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.continue_button)
    void openNovaLauncher() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.teslacoilsw.launcher");
        startActivity(launchIntent);
    }

}
