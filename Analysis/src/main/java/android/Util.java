package android;

import android.annotation.SuppressLint;
import android.statistics.kernel.Instance;
import android.text.format.DateFormat;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * The type Util.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Util extends Instance {

    /**
     * Gets date.
     *
     * @param addExtraDays the add extra days
     * @return the date
     */
    public static String getDate(int addExtraDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, addExtraDays);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.getDefault());
        return simpleDateFormat.format(date);
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public static String getTime() {
        return (String) DateFormat.format("HH:mm aaa",Calendar.getInstance().getTime());
    }

    /**
     * Date compare int.
     *
     * @param entryDate  the entry date
     * @return the int
     */
    public static int dateCompare(String entryDate) {

        try {

            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

            Date startDate = simpleDateFormat.parse(entryDate);
            Date endDate = simpleDateFormat.parse(getDate(getInstance().getLogExpireDayCount()));

            long different = Objects.requireNonNull(endDate).getTime() - Objects.requireNonNull(startDate).getTime();

            long secondsInMilli = 1000;
            long minutesInMilli = secondsInMilli * 60;
            long hoursInMilli = minutesInMilli * 60;
            long daysInMilli = hoursInMilli * 24;

            long elapsedDays = different / daysInMilli;
            different = different % daysInMilli;

            long elapsedHours = different / hoursInMilli;
            different = different % hoursInMilli;

            long elapsedMinutes = different / minutesInMilli;
            different = different % minutesInMilli;

            long elapsedSeconds = different / secondsInMilli;

            Log.i("DATE", "" + elapsedDays);

            return (int) elapsedDays;

        } catch (ParseException error) {
            error.printStackTrace();
            return 1;
        }
    }

}
