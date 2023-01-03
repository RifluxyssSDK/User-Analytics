package android.statistics.dataBase;

import android.statistics.kernel.Instance;
import android.utility.RoomTypeConverter;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * The type Database.
 */
@androidx.room.Database(entities = {Schema.class}, exportSchema = false, version = 1)
@TypeConverters({RoomTypeConverter.class})
public abstract class Database extends RoomDatabase {

    /**
     * Dao dao.
     *
     * @return the dao
     */
    public abstract Dao dao();

    private static Database database;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized Database getInstance() {
        if (database == null) {
            database = Room.databaseBuilder(Instance.getInstance().getContext(), Database.class, "Database").allowMainThreadQueries().build();
        }
        return database;
    }
}
