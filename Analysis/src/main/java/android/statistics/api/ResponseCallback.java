package android.statistics.api;

import androidx.annotation.NonNull;

/**
 * The interface Response callback.
 */
public interface ResponseCallback {

    /**
     * On success.
     *
     * @param message the message
     */
    void onSuccess(@NonNull String message);

    /**
     * On error.
     *
     * @param error the error
     */
    void onError(@NonNull String error);

}
