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

public class server2fragment extends Fragment {

    WebView wb2;
    private class setWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.server2, container, false);
        wb2 = (WebView) view.findViewById(R.id.webview2);
        wb2.getSettings().setJavaScriptEnabled(true);
        wb2.getSettings().setLoadWithOverviewMode(true);
        wb2.getSettings().setUseWideViewPort(true);
        wb2.getSettings().setBuiltInZoomControls(true);
        wb2.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb2.setWebViewClient(new setWebViewClient());
        wb2.getSettings().setLoadsImagesAutomatically(true);
        wb2.getSettings().setAllowContentAccess(true);
        wb2.loadUrl("http://202.63.105.184/results/");

        return view;

    }
}