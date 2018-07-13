package com.example.mow.vfy_6;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
     WebView wv ;
     EditText e1;

    //When you press back, it should go back
    @Override
    public void onBackPressed(){
        if (wv.canGoBack()) {
            wv.goBack();
        } else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* wv = (WebView) findViewById(R.id.wv);
        //Enable Javascript
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        //Set Render Priority to High
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setDomStorageEnabled(true);
        wv.getSettings().setDatabaseEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        //Load URL
       // wv.loadUrl("google.com");
      //  wv.loadUrl("https://smepitch.in/ActionHTML.php");
     //   wv.loadUrl("http://b9d0e833.ngrok.io/testuportlogin");
       // wv.loadUrl("https://google.com/");
        wv.loadUrl("https://2e72cac0.ngrok.io/testuportlogin");
        wv.setWebViewClient(new WebViewClient());

        @Override
                public boolean shouldOverrideUrlLoading(WebView wv, String url) */

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
       webView.loadUrl("http://1d5b3e71.ngrok.io/testuportlogin");
    }


    public void send(View v){
        Sender sender = new Sender();
       // sender.execute(e1.getText().toString());


    }

   /* private void handleNewUrl(String url,WebView view){
        Uri uri = Uri.parse(url);
        if(uri.getScheme().equals("http")||uri.getScheme().equals("https")){
            view.loadUrl(url);
        }
        else if(uri.getScheme().equals("intent")){
            String appPackage = getAppPackageFromUri(uri);

            if(appPackage != null){
                PackageManager manager = getPackageManager();
                Intent appIntent = manager.getLaunchIntentForPackage(appPackage);

                if(appIntent != null){
                    startActivity(appIntent);
                }
                else{
                    view.loadUrl(url);
                }
            }
        }
    }

    private  String getAppPackageFromUri(Uri intentUri) {
        Pattern pattern = Pattern.compile("package=(.*?);");
        Matcher matcher = pattern.matcher(intentUri.getFragment());

        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    } */
}
