package com.example.jntuhces.results;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jntuhces.R;

public class server1fragment extends Fragment {

    WebView wb1;
    private class setWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.server1, container, false);
        wb1 = view.findViewById(R.id.webview1);
        wb1.getSettings().setJavaScriptEnabled(true);
        wb1.getSettings().setLoadWithOverviewMode(true);
        wb1.getSettings().setUseWideViewPort(true);
        wb1.getSettings().setBuiltInZoomControls(true);
        wb1.getSettings().setPluginState(WebSettings.PluginState.ON);
        wb1.setWebViewClient(new setWebViewClient());
        wb1.getSettings().setLoadsImagesAutomatically(true);
        wb1.getSettings().setAllowContentAccess(true);
        wb1.loadUrl("http://results.jntuh.ac.in/");
        return view;

    }
}