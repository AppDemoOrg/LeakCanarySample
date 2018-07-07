package com.abt.leak;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

public class MemoryApp extends Application {

    private static final String TAG = MemoryApp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        setupLeakCanary();
        getMaxMemory();
    }

    private void getMaxMemory() {
        Runtime rt=Runtime.getRuntime();
        long maxMemory=rt.maxMemory();
        String max=Long.toString(maxMemory/(1024*1024));
        Log.i(TAG,"maxMemory:"+max);
    }

    protected void setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        enabledStrictMode();
        LeakCanary.install(this);
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }
}
