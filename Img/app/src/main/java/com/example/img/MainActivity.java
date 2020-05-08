package com.example.img;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgDemo;
    Button btnImg1, btnImg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        imgDemo = findViewById(R.id.imageView);
        btnImg1 = findViewById(R.id.btnDemo1);
        btnImg2 = findViewById(R.id.btnDemo2);
    }
    private void setEvent()
    {
        btnImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgDemo.setImageResource(R.drawable.img1);
            }
        });
        btnImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgDemo.setImageResource(R.drawable.img2);
            }
        });
    }
}
