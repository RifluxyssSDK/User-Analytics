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

    public static synchronized Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLogExpireDayCount() {
        return logExpireDayCount;
    }

    public void setLogExpireDayCount(int logExpireDayCount) {
        this.logExpireDayCount = logExpireDayCount;
    }
}
