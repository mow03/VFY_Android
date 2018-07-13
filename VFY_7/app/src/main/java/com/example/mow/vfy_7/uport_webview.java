package com.example.mow.vfy_7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class uport_webview extends AppCompatActivity {

    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uport_webview);

        WebView webView=findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.getSettings().setLoadsImagesAutomatically(true);

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                Intent webeIntent = new Intent(Intent.ACTION_VIEW);
                webeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                webeIntent.setData(Uri.parse(url));
                startActivity(webeIntent);

                // view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://1d5b3e71.ngrok.io/te    stuportlogin");
    }
}
