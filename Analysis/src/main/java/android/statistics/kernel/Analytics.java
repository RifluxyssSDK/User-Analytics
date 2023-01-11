package android.statistics.kernel;

import android.content.Context;
import android.statistics.api.Api;
import android.statistics.api.ResponseCallback;
import android.statistics.dataBase.Database;
import android.statistics.dataBase.Schema;
import android.utility.XmlBuilder;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * The type Analytics.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics extends Instance {

    /**
     * Init.
     *
     * @param mContext the m context
     */
    public static void init(@NonNull final Context mContext) {
        getInstance().setContext(mContext);
        getInstance().setDao(Database.getInstance().dao());
    }

    /**
     * Insert log.
     *
     * @param schema the schema
     */
    public static void insertLog(@NonNull final Schema schema) {
        if (authentication()) getInstance().getDao().insert(schema);

    }

    /**
     * Gets log list.
     *
     * @return the log list
     */
    public static List<Schema> getLogList() {
        return authentication() ? getInstance().getDao().getAllScheme() : null;
    }

    /**
     * Gets log list as string.
     *
     * @return the log list as string
     */
    public static String getLogListAsString() {
        return authentication() ? new XmlBuilder().init() : null;
    }

    /**
     * Delete all.
     */
    public static void deleteAll() {
        if (authentication()) getInstance().getDao().deleteAllScheme();
    }

    private static boolean authentication() {
        if (getInstance().getContext() != null) {
            return true;
        } else {
            throw new NullPointerException("You have been must call 'init' method to initialize analytics library or Null Context");
        }
    }

    /**
     * Upload data.
     *
     * @param callback the callback
     */
    public static void uploadData(final ResponseCallback callback) {
        if (authentication()) new Api().init(callback);
    }
}
