package com.example.tpoapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    String postUrl = "https://www.w3schools.com/php/showphp.asp?filename=demo_form_post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView webView = findViewById(R.id.webView);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register");
        actionBar.setDisplayHomeAsUpEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(postUrl);
        webView.setHorizontalScrollBarEnabled(false);
//        webView.setWebViewClient(new WebViewClient(){
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                if (url != null) {
//                    Toast.makeText(WebViewActivity.this,url,Toast.LENGTH_LONG).show();
//                    view.getContext().startActivity(
//                            new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
