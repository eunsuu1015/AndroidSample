package com.lifecyle.callbacks;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

    private ForegroundDetector foregroundDetector;

    @Override
    public void onCreate() {
        super.onCreate();

        foregroundDetector = new ForegroundDetector(MyApplication.this);
        foregroundDetector.addListener(new ForegroundDetector.Listener() {
            @Override
            public void onBecameForeground() {
                Log.d("TAG", "Became Foreground");
            }

            @Override
            public void onBecameBackground() {
                Log.d("TAG", "Became Background");
            }
        });
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        foregroundDetector.unregisterCallbacks();
    }
}
