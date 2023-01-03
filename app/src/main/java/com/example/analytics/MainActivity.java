package com.example.analytics;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Analytics;
import android.statistics.kernel.Instance;
import android.util.Log;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getApplicationContext(),5);

        for (int i = 1; i <= 5; i++) {

            Analytics.insertLog(new Schema("userID","hostID","locationNumber",100.8957,"log","eventNBR","assDES",123));

        }

        Log.i("TAG", "onCreate: ");
    }
}