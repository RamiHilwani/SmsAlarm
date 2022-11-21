package com.rami.mi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.tv);
        if (getIntent().getExtras() != null) {
            String body = getIntent().getExtras().get("body").toString();
            String phone = getIntent().getExtras().get("phone").toString();


            textView.setText(body + "\n\n" + phone);
        } else {
            textView.setText("No Text");

        }

    }
}