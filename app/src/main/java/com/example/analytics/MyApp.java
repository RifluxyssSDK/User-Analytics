package com.example.analytics;

import android.app.Application;
import android.statistics.kernel.Analytics;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new Analytics().init(this);
    }
}
