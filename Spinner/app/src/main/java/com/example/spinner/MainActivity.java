package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mobilePhone[] ={"Xiaomi","HTC","Iphone","Samsung","Nokia","Huawei"};
    Spinner spnMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        spnMobile = findViewById(R.id.spinner);
    }
    private void setEvent()
    {
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,mobilePhone);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spnMobile.setAdapter(adapter);
        spnMobile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(),mobilePhone[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplication(),"Ban chua chon",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
