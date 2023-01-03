package android.statistics.optimizer;

import android.Util;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Instance;

/**
 * The type Log factory.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class LogFactory extends Instance {

    /**
     * Delete expiry logs.
     */
    public static void deleteExpiryLogs() {

        new Thread(() -> {

            for (Schema schema : getInstance().getDao().getAllScheme()) {
                if (Util.dateCompare(schema.getLogEntryDate()) <= 0) {
                    getInstance().getDao().delete(schema);
                }
            }

        }).start();
    }
}
