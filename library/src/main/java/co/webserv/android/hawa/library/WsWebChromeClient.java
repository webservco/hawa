package co.webserv.android.hawa.library;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WsWebChromeClient extends WebChromeClient {

    private WsActivity mActivity;

    public WsWebChromeClient(WsActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        mActivity.mProgressBar.setProgress(newProgress);
        if (newProgress == 100) {
            mActivity.mProgressBar.setProgress(0);
        }
    }

    @Override
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
        WsUtilsAndroid.logDebug(mActivity, "WsWebChromeClient:onShowFileChooser");
        if (mActivity.mUploadFilePaths != null) {
            mActivity.mUploadFilePaths.onReceiveValue(null);
        }
        mActivity.mUploadFilePaths = filePathCallback;
        Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
        contentSelectionIntent.setType("*/*");
        contentSelectionIntent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image/*", "video/*"});

        mActivity.startActivityForResult(
                Intent.createChooser(contentSelectionIntent, mActivity.getResources().getString(R.string.choose_intent_title)),
                WsUtilsAndroid.REQUEST_CODE_FILE_UPLOAD
        );

        return true;
    }
}
