package android.statistics.optimizer;

import android.Util;
import android.statistics.dataBase.Dao;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Instance;

/**
 * The type Log factory.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class LogFactory {

    /**
     * Delete expiry logs.
     */
    public static void deleteExpiryLogs() {

        new Thread(() -> {

            Dao dao = Instance.getDao();

            for (Schema schema : dao.getAllScheme()) {
                if (Util.dateCompare(schema.getExpiryDate()) <= 0) {
                    dao.delete(schema);
                }
            }

        }).start();
    }
}
