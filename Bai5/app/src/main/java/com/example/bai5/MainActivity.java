package com.example.bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    ImageView imgV;
    RadioButton rbtCat, rbtPig, rbtRabit, rbtTdc, rbtDog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        imgV = findViewById(R.id.imageView);
        rbtCat = findViewById(R.id.radioButtonCat);
        rbtDog = findViewById(R.id.radioButtonDog);
        rbtRabit = findViewById(R.id.radioButtonRabit);
        rbtPig = findViewById(R.id.radioButtonPig);
        rbtTdc = findViewById(R.id.radioButtonTdc);
    }
    private void setEvent()
    {
        rbtCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgV.setImageResource(R.drawable.cat);
            }
        });
        rbtPig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgV.setImageResource(R.drawable.pig);
            }
        });
        rbtRabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgV.setImageResource(R.drawable.rabit);
            }
        });
        rbtDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgV.setImageResource(R.drawable.dog);
            }
        });
        rbtTdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgV.setImageResource(R.drawable.tdc);
            }
        });
    }
}
