package com.example.mow.vfy_8;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;

public class Main2Activity extends AppCompatActivity {
    WebView webView ;
    private io.socket.client.Socket mSocket; //Socket
    public TextView text; //Socket
    public Button button; //Socket
    public EditText edit; //Socket

    private Button dash;


    {  try {
        mSocket = IO.socket("http://434f83a3.ngrok.io");
    } catch (URISyntaxException e) {
        Log.d("myTag", e.getMessage());
    }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.getSettings().setLoadsImagesAutomatically(true);

        text = (TextView) findViewById(R.id.text); //Socket
        button = (Button) findViewById(R.id.dashboard); //Socket
        edit = (EditText) findViewById(R.id.edit_Text); //Socket

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                webIntent.setData(Uri.parse(url));
                startActivity(webIntent);

                // view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://1d5b3e71.ngrok.io/testuportlogin");


        //Socket Part
        mSocket.connect();
        text.setText("");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = edit.getText().toString().trim();
                edit.setText("");
                if (!message.isEmpty()) {
                    //send message
                    String jsonString = "{message: " + "'" + message + "'" + "}";

                    try {
                        JSONObject jsonData = new JSONObject(jsonString);
                        mSocket.emit("CHAT", jsonData);
                    } catch (JSONException e) {
                        Log.d("me", "error send message " + e.getMessage());
                    }
                }
            }
        });


        dash = (Button) findViewById(R.id.button); // Dashboard
       dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDashboard();
            }
        });
    }
        public void openDashboard(){
            Intent intent = new Intent(this, NavDrawer.class);
            startActivity(intent);

    }
}
