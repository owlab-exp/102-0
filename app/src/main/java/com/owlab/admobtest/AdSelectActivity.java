package com.owlab.admobtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class AdSelectActivity extends AppCompatActivity {
    public static final String TAG = AdSelectActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_select);
    }

    public void showBannerActivity(View view) {
        Log.d(TAG, ">>> showBannerActivity");
        startActivity(new Intent(this, BannerActivity.class));
    }

    public void showSmartBannerActivity(View view) {
        Log.d(TAG, ">>> showSmartBannerActivity");
        startActivity(new Intent(this, SmartBannerActivity.class));
    }

    public void showInterstitialAdActivity(View view) {
        Log.d(TAG, ">>> showInterstitialAdActivity");
        startActivity(new Intent(this, InterstitialAdActivity.class));
    }
}
