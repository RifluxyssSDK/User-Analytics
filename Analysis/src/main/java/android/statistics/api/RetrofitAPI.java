package android.statistics.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * The interface Retrofit api.
 */
public interface RetrofitAPI {

    /**
     * Upload logs call.
     *
     * @param message the message
     * @return the call
     */
    @Headers({"Content-Type: Application/xml; charset=utf-8"})
    @POST("/CoPilotServices/UploadLogFile.aspx")
    Call<String> uploadLogs(@Body String message);
}
