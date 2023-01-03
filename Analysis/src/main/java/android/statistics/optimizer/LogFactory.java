package android.statistics.optimizer;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.statistics.dataBase.Schema;
import android.statistics.kernel.Instance;

import java.util.Calendar;

/**
 * The type Log factory.
 */
@SuppressWarnings({"unused,UnusedReturnValue,SimpleDateFormat"})
public class LogFactory extends Instance {

    /**
     * Delete expiry logs.
     */
    public static void deleteExpiryLogs() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -(getInstance().getLogExpireDayCount()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for (Schema schema : getInstance().getDao().getExpireLog(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()))) {
                getInstance().getDao().delete(schema);
            }
        }
    }
}
