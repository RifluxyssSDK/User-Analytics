package com.example.analytics;

import android.os.Bundle;
import android.os.Handler;
import android.statistics.api.ResponseCallback;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Analytics;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Analytics().insertLog(new Schema("Mukesh", "hostID", "locationNumber", 100.8957, "PRC Test", "eventNBR", "assDES", 123));

        List<Schema> schema = new Analytics().getLogList();

        String mData = new Analytics().getLogListAsString();

        new Handler().post(() -> new Thread(() -> new Analytics().uploadData(new ResponseCallback() {

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