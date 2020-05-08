package com.example.my_app_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox cbJava, cbPhp, cbRuby, cbPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testcheckbox);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        cbJava=findViewById(R.id.checkbox_java);
        cbPhp=findViewById(R.id.checkbox_php);
        cbRuby=findViewById(R.id.checkbox_ruby);
        cbPython=findViewById(R.id.checkbox_python);
    }
    private void setEvent()
    {
        cbJava.setOnClickListener(this);
        cbPhp.setOnClickListener(this);
        cbRuby.setOnClickListener(this);
        cbPython.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.checkbox_java:
                if (cbJava.isChecked())
                    Toast.makeText(getApplicationContext(),"Android",Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_php:
                if (cbPhp.isChecked())
                    Toast.makeText(getApplicationContext(),"PHP",Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_ruby:
                if (cbRuby.isChecked())
                    Toast.makeText(getApplicationContext(),"Ruby",Toast.LENGTH_LONG).show();
                break;
            case R.id.checkbox_python:
                if (cbPython.isChecked())
                    Toast.makeText(getApplicationContext(),"Python",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
