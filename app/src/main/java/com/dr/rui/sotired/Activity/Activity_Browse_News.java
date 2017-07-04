package com.dr.rui.sotired.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.dr.rui.sotired.R;

public class Activity_Browse_News extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brower_news);

        webView = (WebView) findViewById(R.id.webView);
        String url = getIntent().getStringExtra("content_url");
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }
}
