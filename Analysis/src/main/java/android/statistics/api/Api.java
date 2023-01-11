package android.statistics.api;

import android.statistics.kernel.Instance;
import android.utility.Constants;
import android.utility.XmlBuilder;

import androidx.annotation.NonNull;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * The type Api.
 */
public class Api extends Instance {

    /**
     * Init.
     *
     * @param callback the callback
     */
    public void init(ResponseCallback callback) {

        String xmlString = new XmlBuilder().init();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> chain.proceed(chain.request().newBuilder().addHeader("parameter", "value").build()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RetrofitAPI retrofitCall = retrofit.create(RetrofitAPI.class);
        Call<String> call = retrofitCall.uploadLogs(xmlString);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> res) {
                if (res.isSuccessful()) {
                    callback.onSuccess(res.message());
                    getInstance().getDao().deleteAllScheme();
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
