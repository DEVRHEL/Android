package com.example.chuong1bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtSa, edtSb;
    TextView txvKetqua;
    Button btnCong,btnTru,btnNhan,btnChia;
    float a,b,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        edtSa = findViewById(R.id.edt_input1);
        edtSb = findViewById(R.id.edt_input2);
        txvKetqua = findViewById(R.id.textView_kq);
        btnCong = findViewById(R.id.btn_cong);
        btnTru = findViewById(R.id.btn_tru);
        btnNhan = findViewById(R.id.btn_nhan);
        btnChia = findViewById(R.id.btn_chia);
    }
    protected void setEvent()
    {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSa.getText().toString().isEmpty() || !edtSa.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so a",Toast.LENGTH_SHORT).show();
                    return;
                }else if(edtSb.getText().toString().isEmpty() || !edtSb.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so b",Toast.LENGTH_SHORT).show();
                    return;
                }
                a=Float.parseFloat(edtSa.getText().toString());
                b=Float.parseFloat(edtSb.getText().toString());
                y=a+b;
                txvKetqua.setText(String.valueOf(y));
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSa.getText().toString().isEmpty() || !edtSa.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so a",Toast.LENGTH_SHORT).show();
                    return;
                }else if(edtSb.getText().toString().isEmpty() || !edtSb.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so b",Toast.LENGTH_SHORT).show();
                    return;
                }
                a=Float.parseFloat(edtSa.getText().toString());
                b=Float.parseFloat(edtSb.getText().toString());
                y=a-b;
                txvKetqua.setText(String.valueOf(y));
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSa.getText().toString().isEmpty() || !edtSa.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so a",Toast.LENGTH_SHORT).show();
                    return;
                }else if(edtSb.getText().toString().isEmpty() || !edtSb.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so b",Toast.LENGTH_SHORT).show();
                    return;
                }
                a=Float.parseFloat(edtSa.getText().toString());
                b=Float.parseFloat(edtSb.getText().toString());
                y=a*b;
                txvKetqua.setText(String.valueOf(y));
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtSa.getText().toString().isEmpty() || !edtSa.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so a",Toast.LENGTH_SHORT).show();
                    return;
                }else if(edtSb.getText().toString().isEmpty() || !edtSb.getText().toString().matches("[0-9]+(.[0-9]+)?")){
                    Toast.makeText(MainActivity.this,"Hay nhap so b",Toast.LENGTH_SHORT).show();
                    return;
                }
                a=Float.parseFloat(edtSa.getText().toString());
                b=Float.parseFloat(edtSb.getText().toString());
                y=a/b;
                txvKetqua.setText(String.valueOf(y));
            }
        });
    }
}
