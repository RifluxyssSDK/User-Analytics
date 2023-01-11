package android.statistics.dataBase;

import android.statistics.kernel.Instance;
import android.text.format.DateFormat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

/**
 * The type Schema.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
@Entity(tableName = "DataBase")
public class Schema {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "EventTime")
    private String eventTime = String.valueOf(DateFormat.format("yyyy/MM/dd HH:mm:ss aa", new Date()));

    @ColumnInfo(name = "HostId")
    private final String hostId;

    @ColumnInfo(name = "UserId")
    private final String userId;

    @ColumnInfo(name = "LocationNumber")
    private final String locationNumber;

    @ColumnInfo(name = "RouteNumber")
    private final Number routeNumber;

    @ColumnInfo(name = "Day")
    private Number day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

    @ColumnInfo(name = "Logger")
    private final String logger;

    @ColumnInfo(name = "EventNumber")
    private final String eventNumber;

    @ColumnInfo(name = "AdditionalDescription")
    private final String additionalDescription;

    @ColumnInfo(name = "AdditionalNumber")
    private final Number additionalNumber;

    @ColumnInfo(name = "DeviceID")
    private String deviceID = Instance.getInstance().getDeviceId();

    /**
     * Instantiates a new Schema.
     *
     * @param hostId                the host id
     * @param userId                the user id
     * @param locationNumber        the location number
     * @param routeNumber           the route number
     * @param logger                the logger
     * @param eventNumber           the event number
     * @param additionalDescription the additional description
     * @param additionalNumber      the additional number
     */
    public Schema(String hostId, String userId, String locationNumber, Number routeNumber, String logger, String eventNumber, String additionalDescription, Number additionalNumber) {
        this.hostId = hostId;
        this.userId = userId;
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
     * Gets event time.
     *
     * @return the event time
     */
    public String getEventTime() {
        return eventTime;
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
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
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
     * Gets day.
     *
     * @return the day
     */
    public Number getDay() {
        return day;
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
     * Sets event time.
     *
     * @param eventTime the event time
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(Number day) {
        this.day = day;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Sets device id.
     *
     * @param deviceID the device id
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
}
