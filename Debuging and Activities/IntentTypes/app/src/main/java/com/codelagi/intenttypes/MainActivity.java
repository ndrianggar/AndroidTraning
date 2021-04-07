package com.codelagi.intenttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void whereIsJogloHouse(View view) {
        //-6.2297921,106.717145 Rumah Joglo

        //method call intent view app maps (Intent.ACTION_VIEW)
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:6.2297921,106.717145" ));
        Intent chooser = Intent.createChooser(intent, "Launch Maps");
        startActivity(chooser);
    }

    public void openAppMarket(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.webhappen.goo212"));
        Intent chooser = Intent.createChooser(intent, "Launch MarketApp");
        startActivity(chooser);
    }

    public void SendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[] = {"ndrianggar@gmail.com", "hendrilows@hotmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "HELLO FROM APP");
        intent.putExtra(Intent.EXTRA_TEXT, "This is Text");
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent, "Launch App Email");
        startActivity(chooser);
    }

    public void shareText(View view) {
        EditText textshare = findViewById(R.id.textshare);
        String str = textshare.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plan");
        intent.putExtra(Intent.EXTRA_TEXT, str);
        Intent chooser = Intent.createChooser(intent, "ShareText");
        startActivity(chooser);

    }
}