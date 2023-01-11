package android.utility;

import android.statistics.dataBase.Schema;
import android.statistics.kernel.Instance;
import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;

public class XmlBuilder extends Instance {

    public String init() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Schema schema : getInstance().getDao().getAllScheme()) {
            stringBuilder.append(build(schema));
        }

        return stringBuilder.toString();
    }

    private String build(Schema schema) {

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

            String xmlString = writer.toString();
            xmlString = xmlString.replace("\"", "'");
            xmlString = xmlString.replace("<?xml version='1.0' ?>", "");

            return xmlString;

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return "";
    }
}
