package com.codelagi.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.alathar.net");

         editText = (EditText) findViewById(R.id.editText);
    }

    public void backButton(View view, String inputUser) {
        if(webView.canGoBack()){
            webView.goBack();
        }

    }

    public void fwdButton(View view) {
       if(webView.canGoForward()) {
           webView.goForward();
       }
    }

    public void reloadButton(View view) {
        webView.reload();
    }

    public void goButton(View view) {
        String url = editText.getText().toString();
        webView.loadUrl(url);
    }
}