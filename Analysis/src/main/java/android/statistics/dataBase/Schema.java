package android.statistics.dataBase;

import android.Util;
import android.annotation.SuppressLint;
import android.statistics.kernel.Instance;
import android.provider.Settings;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    @ColumnInfo(name = "Route Number")
    private final Double routeNumber;

    @ColumnInfo(name = "Logger")
    private final String logger;

    @ColumnInfo(name = "Event Number")
    private final String eventNumber;

    @ColumnInfo(name = "Additional Description")
    private final String additionalDescription;

    @ColumnInfo(name = "Additional Number")
    private final String additionalNumber;

    @SuppressLint("HardwareIds")
    @ColumnInfo(name = "Device ID")
    private String deviceId = Settings.Secure.getString(Instance.getInstance().getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    @ColumnInfo(name = "Log Entry Date")
    private String logEntryDate = Util.getDate(0);

    /**
     * Instantiates a new Schema.
     *
     * @param userId                the user id
     * @param hostId                the host id
     * @param routeNumber           the route number
     * @param logger                the logger
     * @param eventNumber           the event number
     * @param additionalDescription the additional description
     * @param additionalNumber      the additional number
     */
    public Schema(String userId, String hostId, Double routeNumber, String logger, String eventNumber, String additionalDescription, String additionalNumber) {
        this.userId = userId;
        this.hostId = hostId;
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

    public Double getRouteNumber() {
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

    public String getAdditionalNumber() {
        return additionalNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getLogEntryDate() {
        return logEntryDate;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setLogEntryDate(String logEntryDate) {
        this.logEntryDate = logEntryDate;
    }
}
