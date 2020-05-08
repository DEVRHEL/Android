package com.example.viduradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen,edtCMND,edtThongTin;
    //RadioButton chkDaihoc,chkCaodang,chkTrungcap;
    CheckBox chkGame,chkSach,chkBao;
    TextView txtKetQua;
    Button btnGui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_layout);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        edtHoTen = (EditText) findViewById(R.id.edtFirstName);
        edtCMND = (EditText) findViewById(R.id.edtID);
        edtThongTin = (EditText) findViewById(R.id.edtAddInformation);
//        chkDaihoc = (RadioButton) findViewById(R.id.radioButton_daihoc);
//        chkCaodang = (RadioButton) findViewById(R.id.radioButton_caodang);
//        chkTrungcap = (RadioButton) findViewById(R.id.radioButton_trungcap);
        chkGame = (CheckBox) findViewById(R.id.chkGame);
        chkSach = (CheckBox) findViewById(R.id.chkBook);
        chkBao = (CheckBox) findViewById(R.id.chkNewspaper);
        btnGui = (Button) findViewById(R.id.btninsert);
        txtKetQua = (TextView) findViewById(R.id.txtResult);
    }
    private void setEvent()
    {
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInformation();
            }
        });
    }
    private void showInformation()
    {
        try
        {
            String message="";
            String firstname = edtHoTen.getText().toString().trim();
            if(firstname.length()<=3)
            {
                edtHoTen.selectAll();
                edtHoTen.requestFocus();
                Toast.makeText(getApplication(),"Ho va ten khong nho hon 3 ky tu",Toast.LENGTH_LONG).show();
                return;
            }
            message+="Ho va ten: "+firstname+"\n";
            String strId = edtCMND.getText().toString().trim();
            if (strId.length() != 9)
            {
                edtCMND.selectAll();
                edtCMND.requestFocus();
                Toast.makeText(getApplication(),"So CMND phai 9 so",Toast.LENGTH_LONG).show();
                return;
            }
            String degree;
            RadioGroup rdogroupDegree = (RadioGroup)findViewById(R.id.rdiGroupDegree);
            int id = rdogroupDegree.getCheckedRadioButtonId();
            if (id==-1)
            {
                Toast.makeText(getApplication(),"Vui long chon bang cap",Toast.LENGTH_LONG).show();
                return;
            }
            RadioButton radDegree = (RadioButton)findViewById(id);
            degree = radDegree.getText()+" ";
            message += "Bang cap: "+degree+"\n";
            String favorate="";
            if (chkGame.isChecked())
                favorate+= chkGame.getText()+" ";
            if (chkSach.isChecked())
                favorate+= chkSach.getText()+" ";
            if (chkBao.isChecked())
                favorate+= chkBao.getText()+" ";
            if (favorate.trim().length()==0)
            {
                Toast.makeText(getApplication(), "Vui lòng chọn một sở thích", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                message+="Sở thích: "+favorate+"\n";
            }
            if (edtThongTin.getText().toString().trim().length()!=0)
            {
                message+="Thong tin bo sung: "+edtThongTin.getText().toString().trim();
            }
            txtKetQua.setText(message);
        }
        catch (Exception ex)
        {
            Log.d("1", ex.getMessage());
        }
    }
}
