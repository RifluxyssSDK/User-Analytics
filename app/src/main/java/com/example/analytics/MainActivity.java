package com.example.analytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.statistics.kernel.Analytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getApplicationContext(),3);
    }
}