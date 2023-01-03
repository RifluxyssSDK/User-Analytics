package com.example.analytics;

import android.os.Bundle;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Analytics;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getApplicationContext(),3);

        for (int i = 1; i <= 5; i++) {
            Analytics.insertLog(new Schema("userID","hostID","locationNumber",100.8957,"log","eventNBR","assDES",123));
        }


    }
}