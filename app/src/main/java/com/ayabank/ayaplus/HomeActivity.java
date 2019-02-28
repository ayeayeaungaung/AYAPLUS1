package com.ayabank.ayaplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
TextView textView;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=(TextView)findViewById(R.id.textview);
        imageView=(ImageView)findViewById(R.id.imageview);


    }
}
