package com.example.mow.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
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

public class MainActivity extends AppCompatActivity {

    public Button button;
    public TextView text;
    public EditText edit;
    public String message;
    private io.socket.client.Socket mSocket;
    {  try {
        mSocket = IO.socket("http://434f83a3.ngrok.io");
    } catch (URISyntaxException e) {
        Log.d("myTag", e.getMessage());
    }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void login(View v){
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

        webView.loadUrl("http://434f83a3.ngrok.io/testuportlogin");

        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        text =  (TextView) findViewById(R.id.text);
        //edit =  (EditText) findViewById(R.id.edit_text);
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


    }

}
