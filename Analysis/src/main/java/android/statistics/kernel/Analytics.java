package android.statistics.kernel;

import android.content.Context;
import android.statistics.api.Api;
import android.statistics.api.ResponseCallback;
import android.statistics.dataBase.Schema;
import android.utility.Constants;
import android.utility.XmlBuilder;

import androidx.annotation.NonNull;

import java.util.List;

/**
 * The type Analytics.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Analytics {

    /**
     * Init.
     * <p>
     * Context used to create DAO Object for
     * store schema's on local database
     *
     * @param mContext the m context
     */
    public void init(@NonNull final Context mContext) {
        Instance.getInstance().initArgs(mContext);
    }

    /**
     * Insert log.
     *
     * @param schema the schema
     */
    public void insertLog(@NonNull final Schema schema) {
        if (authentication()) Instance.getInstance().getDao().insert(schema);
    }

    /**
     * Gets log list.
     *
     * @return the log list
     */
    public List<Schema> getLogList() {
        return authentication() ? Instance.getInstance().getDao().getAllScheme() : null;
    }

    /**
     * Gets log list as string.
     *
     * @return the log list as string
     */
    public String getLogListAsString() {
        return authentication() ? new XmlBuilder().init() : null;
    }

    /**
     * Delete all.
     */
    public void deleteAll() {
        if (authentication()) Instance.getInstance().getDao().deleteAllScheme();
    }

    private boolean authentication() {
        if (Instance.getInstance().getDao() != null) {
            return true;
        } else {
            throw new NullPointerException(Constants.nullErrorMessage);
        }
    }

    /**
     * Upload data.
     *
     * @param callback the callback
     */
    public void uploadData(final ResponseCallback callback) {
        if (authentication()) new Api().init(callback);
    }
}
