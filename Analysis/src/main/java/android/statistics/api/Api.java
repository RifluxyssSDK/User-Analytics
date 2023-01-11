package android.statistics.api;

import android.utility.Constants;
import android.utility.XmlBuilder;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * The type Api.
 */
public class Api {

    /**
     * Init.
     *
     * @param callback the callback
     * @throws IOException the io exception
     */
    public void init(ResponseCallback callback) throws IOException {

        String xmlString = new XmlBuilder().init();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RetrofitAPI retrofitCall = retrofit.create(RetrofitAPI.class);
        Call<String> call = retrofitCall.uploadLogs(xmlString);

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