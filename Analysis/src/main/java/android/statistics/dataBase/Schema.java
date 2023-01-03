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

    /**
     * Instantiates a new Schema.
     *
     * @param userId                the user id
     * @param hostId                the host id
     * @param locationNumber        the location number
     * @param routeNumber           the route number
     * @param logger                the logger
     * @param eventNumber           the event number
     * @param additionalDescription the additional description
     * @param additionalNumber      the additional number
     */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets host id.
     *
     * @return the host id
     */
    public String getHostId() {
        return hostId;
    }

    /**
     * Gets location number.
     *
     * @return the location number
     */
    public String getLocationNumber() {
        return locationNumber;
    }

    /**
     * Gets route number.
     *
     * @return the route number
     */
    public Number getRouteNumber() {
        return routeNumber;
    }

    /**
     * Gets logger.
     *
     * @return the logger
     */
    public String getLogger() {
        return logger;
    }

    /**
     * Gets event number.
     *
     * @return the event number
     */
    public String getEventNumber() {
        return eventNumber;
    }

    /**
     * Gets additional description.
     *
     * @return the additional description
     */
    public String getAdditionalDescription() {
        return additionalDescription;
    }

    /**
     * Gets additional number.
     *
     * @return the additional number
     */
    public Number getAdditionalNumber() {
        return additionalNumber;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     *
     * @param deviceId the device id
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets log entry date.
     *
     * @return the log entry date
     */
    public String getLogEntryDate() {
        return logEntryDate;
    }

    /**
     * Sets log entry date.
     *
     * @param logEntryDate the log entry date
     */
    public void setLogEntryDate(String logEntryDate) {
        this.logEntryDate = logEntryDate;
    }
}
