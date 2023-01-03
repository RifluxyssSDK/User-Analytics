package com.example.analytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Analytics;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Analytics.init(getApplicationContext(),3);

        Analytics.insertLog(new Schema("userID","hostID",2.00,"log","eventNBR","assDES","addNBR"));
        Analytics.insertLog(new Schema("userID","hostID",1.00,"log","eventNBR","assDES","addNBR"));
        Analytics.insertLog(new Schema("userID","hostID",1.00,"log","eventNBR","assDES","addNBR"));
        Analytics.insertLog(new Schema("userID","hostID",1.00,"log","eventNBR","assDES","addNBR"));
        Analytics.insertLog(new Schema("userID","hostID",1.00,"log","eventNBR","assDES","addNBR"));
        Analytics.insertLog(new Schema("userID","hostID",1.00,"log","eventNBR","assDES","addNBR"));

        List<Schema> schemas = Analytics.getLogs();
        Log.i("TAG", "onCreate: ");
    }
}