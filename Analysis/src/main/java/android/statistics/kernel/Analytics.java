package android.statistics.kernel;

import android.content.Context;
import android.statistics.api.ResponseCallback;
import android.statistics.api.RetrofitAPI;
import android.statistics.dataBase.Database;
import android.statistics.dataBase.Schema;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

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
    public static void init(Context mContext) {
        getInstance().setContext(mContext);
        getInstance().setDao(Database.getInstance().dao());
    }

    /**
     * Insert log.
     *
     * @param schema the schema
     */
    public static void insertLog(Schema schema) {
        if (authentication()) getInstance().getDao().insert(schema);

    }

    /**
     * Gets logs.
     *
     * @return the logs
     */
    public static List<Schema> getLogs() {
        return authentication() ? getInstance().getDao().getAllScheme() : null;
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
            throw new NullPointerException("You have been must call 'init' method before inserting Log's or Null Context");
        }
    }

    /**
     * Upload data.
     *
     * @param xml      the xml
     * @param callback the callback
     */
    public static void uploadData(String xml , ResponseCallback callback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://cpas100.na.cintas.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RetrofitAPI retrofitCall = retrofit.create(RetrofitAPI.class);
        Call<String> call = retrofitCall.uploadLogs(xml);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> res) {
                if (res.isSuccessful()) {
                    callback.onSuccess(res.message());
                } else {
                    callback.onError(res.message());
                }
            }
            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable throwable) {
                callback.onError(Objects.requireNonNull(throwable.getLocalizedMessage()));
            }
        });
    }
}
