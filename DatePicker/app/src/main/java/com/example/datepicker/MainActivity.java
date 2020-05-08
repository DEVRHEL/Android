package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker simpleDatePicker;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        simpleDatePicker = findViewById(R.id.simpleDatePicker);
        btnSubmit = findViewById(R.id.btnSubmit);
    }
    public void setEvent()
    {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Ngày: " + simpleDatePicker.getDayOfMonth();
                String month = "\nTháng: " + simpleDatePicker.getMonth();
                String year = "\n Năm:" + simpleDatePicker.getYear();
                Toast.makeText(MainActivity.this, day + month + year,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
