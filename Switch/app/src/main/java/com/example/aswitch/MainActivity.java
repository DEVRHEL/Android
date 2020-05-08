package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    Switch swt1, swt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        btnShow = findViewById(R.id.button);
        swt1 = findViewById(R.id.switch1);
        swt2 = findViewById(R.id.switch2);
    }
    private void setEvent()
    {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="";
                if (swt1.isChecked())
                    message+="Switch 1: "+swt1.getTextOn().toString()+"\n";
                else
                    message+="Switch 1: "+swt1.getTextOff().toString()+"\n";
                if (swt2.isChecked())
                    message+="Switch 2: "+swt2.getTextOn().toString()+"\n";
                else
                    message+="Switch 2: "+swt2.getTextOff().toString()+"\n";
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            }
        });
    }
}
