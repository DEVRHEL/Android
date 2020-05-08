package com.example.viduimage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgDemo;
    Button btnDemo1, btnDemo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        imgDemo = (ImageView)findViewById(R.id.imgDemo);
        btnDemo1 = (Button)findViewById(R.id.btnDemo1);
        btnDemo2 = (Button)findViewById(R.id.btnDemo2);
    }
    private void setEvent()
    {
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgDemo.setImageResource(R.drawable.img1);
            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgDemo.setImageResource(R.drawable.img2);
            }
        });
    }
}
