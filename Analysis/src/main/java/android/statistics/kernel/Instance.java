package android.statistics.kernel;

import android.content.Context;
import android.statistics.dataBase.Dao;

/**
 * The type Instance.
 */
public class Instance {

    private Dao dao;

    private Context context;

    private int logExpireDayCount;

    private static Instance instance;

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
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Gets log expire day count.
     *
     * @return the log expire day count
     */
    public int getLogExpireDayCount() {
        return logExpireDayCount;
    }

    /**
     * Sets log expire day count.
     *
     * @param logExpireDayCount the log expire day count
     */
    public void setLogExpireDayCount(int logExpireDayCount) {
        this.logExpireDayCount = logExpireDayCount;
    }
}
