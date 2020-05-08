package com.example.chuong1bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnActive1, btnActive2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        btnActive1 = findViewById(R.id.SubActivity1);
        btnActive2 = findViewById(R.id.SubActivity2);
    }
    private void setEvent()
    {
//        btnActive1.setOnClickListener(this);
//        btnActive2.setOnClickListener(this);
    }
    public void onClick(View v)
    {
//        if(v.getId()==R.id.SubActivity1){
//            Intent intent = new Intent (this, btnActive1.class);
//            startActivity(intent);
//        }
//        if(v.getId()==R.id.SubActivity2){
//            Intent intent = new Intent (this, SubActivity2.class);
//            startActivity(intent);
//        }
    }
}
