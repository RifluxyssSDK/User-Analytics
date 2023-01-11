package android.statistics.kernel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.statistics.dataBase.Dao;
import android.statistics.dataBase.Database;

/**
 * The type Instance.
 */
public class Instance {

    private Dao dao;

    private String deviceId;

    private static Instance instance;

    /**
     * Gets dao.
     *
     * @return the dao
     */
    public Dao getDao() {
        return dao;
    }

    /**
     * Sets dao.
     *
     * @param dao the dao
     */
    public void setDao(Dao dao) {
        this.dao = dao;
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
     * Init args.
     *
     * @param context the context
     */
    @SuppressLint("HardwareIds")
    protected void initArgs(Context context) {
        getInstance().setDao(Database.getInstance(context).dao());
        getInstance().setDeviceId(Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID));
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }
}
