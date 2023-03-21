package com.example.jntuhces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jntuhces.results.server1fragment;

public class covid extends AppCompatActivity {
    WebView wb1;

    private class setWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        wb1 = findViewById(R.id.webview1);
        wb1.getSettings().setJavaScriptEnabled(true);
        wb1.getSettings().setLoadWithOverviewMode(true);
        wb1.getSettings().setUseWideViewPort(true);
        wb1.getSettings().setBuiltInZoomControls(true);
        wb1.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb1.setWebViewClient(new WebViewClient());
        wb1.getSettings().setLoadsImagesAutomatically(true);
        wb1.getSettings().setAllowContentAccess(true);
        wb1.loadUrl("https://covid19.telangana.gov.in");
    }

    @Override
    public void onBackPressed() {
        if(wb1.canGoBack()){
            wb1.goBack();
        } else {
            super.onBackPressed();
        }
    }
}