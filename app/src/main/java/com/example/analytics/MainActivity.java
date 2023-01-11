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

//        for (int i = 1; i <= 1; i++) {
//            Analytics.insertLog(new Schema("Ajith", "hostID", "locationNumber", 100.8957, "PRC Test", "eventNBR", "assDES", 123));
//        }

        List<Schema> list = Analytics.getLogs();

        assert list != null;
        Schema schema = list.get(0);
        Schema schema1 = list.get(0);

//        Analytics.deleteAll();

        try {

            XmlSerializer serializer = Xml.newSerializer();
            StringWriter writer = new StringWriter();

            serializer.setOutput(writer);
            serializer.startDocument(null, null);

            serializer.startTag(null, "LogEntry");
            serializer.attribute(null, "EventTime", schema.getEventTime());
            serializer.attribute(null, "HostId", schema.getHostId());
            serializer.attribute(null, "UserId", schema.getUserId());
            serializer.attribute(null, "LocationNbr", schema.getLocationNumber());
            serializer.attribute(null, "RouteNbr", String.valueOf(schema.getRouteNumber()));
            serializer.attribute(null, "Day", String.valueOf(schema.getDay()));
            serializer.attribute(null, "Logger", schema.getLogger());
            serializer.attribute(null, "EventNbr", String.valueOf(schema.getEventNumber()));
            serializer.attribute(null, "AddtlDesc", schema.getAdditionalDescription());
            serializer.attribute(null, "AddtlNbr", String.valueOf(schema.getAdditionalNumber()));
            serializer.endTag(null, "LogEntry");
            serializer.endDocument();

            String xml = writer.toString();
            xml = xml.replace("\"","'");
            xml = xml.replace("<?xml version='1.0' ?>","");
            Log.i("TAG", "onCreate: ");

            Analytics.uploadData(xml, new ResponseCallback() {
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