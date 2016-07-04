package com.owlab.admobtest;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.owlab.admobtest.util.Etc;

public class InterstitialAdActivity extends AppCompatActivity {
    public static final String TAG = InterstitialAdActivity.class.getSimpleName();

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                //super.onAdClosed();
                Log.d(TAG, ">>>>> closed");
                requestNewInterstitial();
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(Etc.md5(android_id))
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void showAd(View view) {
        if(mInterstitialAd.isLoaded()) {
            Log.d(TAG, ">>>>> laoded");
            mInterstitialAd.show();
        } else {
            Log.d(TAG, ">>>>> not laoded yet");
        }
    }
}
