package com.example.todolistzzz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ContentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        WebView wv = findViewById(R.id.webView);
        wv.setWebViewClient(new mybrowser());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://todolistbyateeq.pythonanywhere.com");

    }

    private class mybrowser extends WebViewClient{
       @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
           if (url.startsWith("mailto:")) {
               //Handle mail Urls
               startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(url)));
           } else if (url.startsWith("tel:")) {
               //Handle telephony Urls
               startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
           } else {
               wv.loadUrl(url);
           }
           return true;
       }
    }
}
