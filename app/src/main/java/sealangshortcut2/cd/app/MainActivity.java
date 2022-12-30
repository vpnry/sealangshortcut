package sealangshortcut2.cd.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.annotation.SuppressLint;
import android.os.Build;
import android.webkit.WebChromeClient;


public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        
        
        webSettings.setJavaScriptEnabled(true);
        
        // Enable localStorage
        webSettings.setDomStorageEnabled(true);
        
        // Enable Cache Mode
        webSettings.setAllowFileAccess(true);
        
        // webSettings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        


        // mWebView.setWebViewClient(new MyWebViewClient());
        
        // Use setWebChromeClient for JS alert
        mWebView.setWebChromeClient(new WebChromeClient());


        // REMOTE RESOURCE
        // mWebView.loadUrl("https://sealang.cuong.eu.org/index.html");

        // LOCAL RESOURCE
        mWebView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
