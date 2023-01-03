package android.statistics.dataBase;

import android.annotation.SuppressLint;
import android.statistics.kernel.Instance;
import android.provider.Settings;
import android.text.format.DateFormat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

/**
 * The type Schema.
 */
@Entity(tableName = "DataBase")
public class Schema {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "User Id")
    private final String userId;

    @ColumnInfo(name = "Host Id")
    private final String hostId;

    @ColumnInfo(name = "Location Number")
    private final String locationNumber;

    @ColumnInfo(name = "Route Number")
    private final Number routeNumber;

    @ColumnInfo(name = "Logger")
    private final String logger;

    @ColumnInfo(name = "Event Number")
    private final String eventNumber;

    @ColumnInfo(name = "Additional Description")
    private final String additionalDescription;

    @ColumnInfo(name = "Additional Number")
    private final Number additionalNumber;

    @SuppressLint("HardwareIds")
    @ColumnInfo(name = "Device ID")
    private String deviceId = Settings.Secure.getString(Instance.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    @ColumnInfo(name = "Log Entry Date")
    private String logEntryDate = String.valueOf(DateFormat.format("yyyy-MM-dd", new Date()));

    public Schema(String userId, String hostId, String locationNumber, Number routeNumber, String logger, String eventNumber, String additionalDescription, Number additionalNumber) {
        this.userId = userId;
        this.hostId = hostId;
        this.locationNumber = locationNumber;
        this.routeNumber = routeNumber;
        this.logger = logger;
        this.eventNumber = eventNumber;
        this.additionalDescription = additionalDescription;
        this.additionalNumber = additionalNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public String getHostId() {
        return hostId;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public Number getRouteNumber() {
        return routeNumber;
    }

    public String getLogger() {
        return logger;
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public Number getAdditionalNumber() {
        return additionalNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLogEntryDate() {
        return logEntryDate;
    }

    public void setLogEntryDate(String logEntryDate) {
        this.logEntryDate = logEntryDate;
    }
}
