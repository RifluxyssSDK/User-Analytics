package android.utility;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

/**
 * The type Room type converter.
 */
@SuppressWarnings({"unused,UnusedReturnValue"})
public class RoomTypeConverter {

    /**
     * Number from string number.
     *
     * @param string the string
     * @return the number
     */
    @TypeConverter
    public static Number numberFromString(String string) {
        return new Gson().fromJson(string,Number.class);
    }

    /**
     * Number to string string.
     *
     * @param number the number
     * @return the string
     */
    @TypeConverter
    public static String numberToString(Number number) {
        return new Gson().toJson(number);
    }
}
