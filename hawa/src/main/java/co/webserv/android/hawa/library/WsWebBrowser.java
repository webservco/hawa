package co.webserv.android.hawa.library;

import android.webkit.WebSettings;
import android.webkit.WebView;

public class WsWebBrowser {

    private WsActivity mActivity;

    private WebView mWebView;

    private WebSettings mWebSettings;

    public WsWebBrowser(WsActivity activity, WebView webView) {
        mActivity = activity;
        mWebView = webView;
    }

    public void loadUrl(String url) {

        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WsWebViewClient(mActivity));

        mWebView.setWebChromeClient(new WsWebChromeClient(mActivity));

        mWebView.loadUrl(url);
    }
}
