package com.example.mow.fix_vfy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class UportSetup extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uport_setup);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                webIntent.setData(Uri.parse(url));
                startActivity(webIntent);
                return true;
            }
        });

        webView.loadUrl("https://1d5b3e71.ngrok.io/testuportlogin");
    }

    public void openActivity(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

}
