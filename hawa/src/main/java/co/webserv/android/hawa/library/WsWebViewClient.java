package co.webserv.android.hawa.library;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WsWebViewClient extends WebViewClient {

    private WsActivity mActivity;

    public WsWebViewClient(WsActivity activity) {
        mActivity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        //IMPORTANT: shouldOverrideUrlLoading is not called for POST requests
        return false; // let WebView load the url
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        if (WsSettings.IGNORE_SSL_ERRORS) {
            handler.proceed();
        } else {
            super.onReceivedSslError(view, handler, error);
        }
    }
}
