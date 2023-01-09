package android.statistics.kernel;

import android.statistics.dataBase.Database;
import android.statistics.dataBase.Schema;
import android.statistics.optimizer.LogFactory;
import android.content.Context;

import java.util.List;

/**
 * The type Analytics.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics extends Instance {

    /**
     * Init.
     *
     * @param mContext           the context
     * @param mLogExpireDayCount the log expire day count
     * <p> Remark:
     * <OL><BR>
     * <LI>Store the given data's as static variable.
     * <LI>Initiating database.
     * <LI>Delete expired logs on local database.
     * </OL><BR>
     */
    public static void init(Context mContext, int mLogExpireDayCount) {
        getInstance().setContext(mContext);
        getInstance().setLogExpireDayCount(mLogExpireDayCount);
        getInstance().setDao(Database.getInstance().dao());
//        LogFactory.deleteExpiryLogs();
    }

    /**
     * Insert log.
     *
     * @param schema the schema
     */
    public static void insertLog(Schema schema) {
        if (authentication())
            getInstance().getDao().insert(schema);

    }

    /**
     * Gets logs.
     *
     * @return the logs
     */
    public static List<Schema> getLogs() {
        return authentication() ? getInstance().getDao().getAllScheme() : null;
    }

    /**
     * Delete all.
     */
    public static void deleteAll() {
        if (authentication())
            getInstance().getDao().deleteAllScheme();
    }

    private static boolean authentication() {
        if (getInstance().getContext() != null) {
            return true;
        } else {
            throw new NullPointerException("You have been must call 'init' method before inserting Log's or Null Context");
        }
    }
}
