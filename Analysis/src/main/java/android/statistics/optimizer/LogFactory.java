package android.statistics.optimizer;

import android.statistics.dataBase.Schema;
import android.statistics.kernel.Instance;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * The type Log factory.
 */
@SuppressWarnings({"unused,UnusedReturnValue"})
public class LogFactory extends Instance {

    /**
     * Delete expiry logs.
     */
    public static void deleteExpiryLogs() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -(getInstance().getLogExpireDayCount()));

        for (Schema schema : getInstance().getDao().getExpireLog(String.valueOf(DateFormat.format("yyyy-MM-dd", calendar)))) {
            getInstance().getDao().delete(schema);
        }
    }
}
