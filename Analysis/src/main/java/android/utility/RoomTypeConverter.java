package android.utility;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

@SuppressWarnings({"unused,UnusedReturnValue"})
public class RoomTypeConverter {

    @TypeConverter
    public static Number numberFromString(String string) {
        return new Gson().fromJson(string,Number.class);
    }

    @TypeConverter
    public static String numberToString(Number number) {
        return new Gson().toJson(number);
    }
}
