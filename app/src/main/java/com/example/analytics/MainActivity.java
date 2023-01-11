package com.example.analytics;

import android.os.Bundle;
import android.statistics.api.ResponseCallback;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Analytics;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getApplicationContext());

        Analytics.insertLog(new Schema("Mukesh", "hostID", "locationNumber", 100.8957, "PRC Test", "eventNBR", "assDES", 123));

        Analytics.uploadData(new ResponseCallback() {
            @Override
            public void onSuccess(@NonNull String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(@NonNull String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}