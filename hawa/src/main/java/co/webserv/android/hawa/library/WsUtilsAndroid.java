package co.webserv.android.hawa.library;

import android.content.Context;
import android.util.Log;

public class WsUtilsAndroid {

    /**
     * Log tag.
     */
    public static final String LOG_TAG = "COWEBSERVANDROID";

    protected static final int REQUEST_CODE_FILE_UPLOAD = 1;

    public static void logDebug(Context context, String msg) {
        if (WsSettings.LOG_DEBUG) {
            Log.d(WsUtilsAndroid.LOG_TAG, msg);
        }
    }
}