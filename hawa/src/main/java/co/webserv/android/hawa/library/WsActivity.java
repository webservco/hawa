package co.webserv.android.hawa.library;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class WsActivity extends AppCompatActivity {

    protected ProgressBar mProgressBar;

    private WsWebBrowser mWebBrowser;

    private WebView mWebView;

    protected ValueCallback<Uri[]> mUploadFilePaths;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == WsUtilsAndroid.REQUEST_CODE_FILE_UPLOAD) {
                if (mUploadFilePaths == null) {
                    return;
                }
                if (data != null && data.getData() != null) {
                    String dataString = data.getDataString();
                    if (dataString != null) {
                        results = new Uri[]{Uri.parse(dataString)};
                    }
                }
            }
        }
        mUploadFilePaths.onReceiveValue(results);
        mUploadFilePaths = null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WsUtilsAndroid.logDebug(this, "WsActivity:onCreate");

        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.web_view);
        mProgressBar = findViewById(R.id.progress_bar);

        webBrowserInit(webView);
        webBrowserLoadUrl(WsSettings.URL);
    }

    protected void webBrowserInit(WebView webView) {
        WsUtilsAndroid.logDebug(this, "WsActivity:webBrowserInit");
        if (mWebBrowser == null) {
            mWebView = webView; // will be used also in other places
            mWebBrowser = new WsWebBrowser(this, mWebView);
        }
    }

    protected void webBrowserLoadUrl(String url) {
        WsUtilsAndroid.logDebug(this, "WsActivity:webBrowserLoadUrl " + url);
        if (mWebBrowser instanceof WsWebBrowser) {
            mWebBrowser.loadUrl(url);
        }
    }
}