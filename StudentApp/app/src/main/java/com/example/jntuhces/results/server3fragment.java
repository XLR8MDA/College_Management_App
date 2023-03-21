package com.example.jntuhces.results;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jntuhces.R;

public class server3fragment extends Fragment {

    WebView wb3;
    private class setWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.server3, container, false);
        wb3 = (WebView) view.findViewById(R.id.webview3);
        wb3.getSettings().setJavaScriptEnabled(true);
        wb3.getSettings().setLoadWithOverviewMode(true);
        wb3.getSettings().setUseWideViewPort(true);
        wb3.getSettings().setBuiltInZoomControls(true);
        wb3.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb3.setWebViewClient(new server3fragment.setWebViewClient());
        wb3.getSettings().setLoadsImagesAutomatically(true);
        wb3.getSettings().setAllowContentAccess(true);
        wb3.loadUrl("http://202.63.105.185/RESULT/");

        return view;

    }

}