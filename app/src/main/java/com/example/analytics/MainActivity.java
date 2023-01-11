package com.example.analytics;

import android.os.Bundle;
import android.statistics.api.ResponseCallback;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Analytics;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getApplicationContext());

        for (int i = 1; i <= 10000; i++) {
            Analytics.insertLog(new Schema(i+"Mukesh", "hostID", "locationNumber", 100.8957, "PRC Test", "eventNBR", "assDES", 123));
        }

        try {

            Analytics.uploadData(new ResponseCallback() {
                @Override
                public void onSuccess(@NonNull String message) {
                    Toast.makeText(getApplicationContext(), "Posted", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onError(@NonNull String error) {
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                }
            });

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }

        Log.i("TAG", "onCreate: ");
    }
}