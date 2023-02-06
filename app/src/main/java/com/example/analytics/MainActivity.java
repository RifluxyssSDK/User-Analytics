package com.example.analytics;

import android.os.Bundle;
import android.os.Handler;
import android.statistics.api.ResponseCallback;
import android.statistics.kernel.Analytics;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getBaseContext());

        /*Analytics.insertLog(new Schema("Mukesh", "hostID", "locationNumber", 100.8957, "PRC Test", "eventNBR", "assDES", 123));*/

        new Handler().post(() -> new Thread(() -> Analytics.uploadData(new ResponseCallback() {

            @Override
            public void onSuccess(@NonNull String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(@NonNull String error) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
            }

        })).start());


    }
}