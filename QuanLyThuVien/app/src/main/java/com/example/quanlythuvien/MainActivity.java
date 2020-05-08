package com.example.quanlythuvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtSoPhieu, edtNgay, edtGhiChu;
    Spinner spdDocGia, spdSach;
    Button btnThem, btnSua, btnXoa, btnThoat;
    ListView ltvThuVien;
    String[] arrDG = {"A","B","C"};
    String[] arrSH = {"G","H","I"};
    ArrayList<PhieuMuon> data = new ArrayList<>();
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ql);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        edtSoPhieu = findViewById(R.id.edt_sophieu);
        edtGhiChu = findViewById(R.id.edt_ghichu);
        edtNgay = findViewById(R.id.edt_ngaymuon);
        spdDocGia = findViewById(R.id.spinner);
        spdSach = findViewById(R.id.spinner2);
        btnThem = findViewById(R.id.button_them);
        btnSua = findViewById(R.id.button_sua);
        btnXoa = findViewById(R.id.button_xoa);
        btnThoat = findViewById(R.id.button_thoat);
        ltvThuVien = findViewById(R.id.ListView_ts);
    }
    public void setEvent()
    {
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrDG);
        spdDocGia.setAdapter(adapter);
        ArrayAdapter adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrSH);
        spdSach.setAdapter(adapter2);
        final CustomAdapter adapter3 = new CustomAdapter(this, R.layout.activity_main, data);
        ltvThuVien.setAdapter(adapter3);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNgay.getText().toString().isEmpty())
                {
                    edtNgay.setError("Ban phai nhap ngay");
                    edtNgay.requestFocus();
                    return;
                }
                if(edtSoPhieu.getText().toString().isEmpty())
                {
                    edtSoPhieu.setError("Ban phai nhap so phieu");
                    edtSoPhieu.requestFocus();
                    return;
                }
                PhieuMuon pm = new PhieuMuon();
                pm.setSophieumuon(edtSoPhieu.getText().toString());
                pm.setNgaymuon(edtNgay.getText().toString());
                pm.setGhichu(edtGhiChu.getText().toString());
                pm.setDocgia(spdDocGia.getSelectedItem().toString());
                pm.setTensach(spdSach.getSelectedItem().toString());
                data.add(pm);
                adapter3.notifyDataSetChanged(); // khi thay doi du lieu thi goi thang nay
            }
        });
        ltvThuVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                edtSoPhieu.setText(data.get(position).getSophieumuon());
                edtGhiChu.setText(data.get(position).getGhichu());
                edtNgay.setText(data.get(position).getNgaymuon());
                //spdDocGia.getSelectedItem(data.get(position).getDocgia())
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == -1) return;
                if(edtNgay.getText().toString().isEmpty())
                {
                    edtNgay.setError("Ban phai nhap ngay");
                    edtNgay.requestFocus();
                    return;
                }
                if(edtSoPhieu.getText().toString().isEmpty())
                {
                    edtSoPhieu.setError("Ban phai nhap so phieu");
                    edtSoPhieu.requestFocus();
                    return;
                }
                PhieuMuon pm = data.get(index);
                pm.setSophieumuon(edtSoPhieu.getText().toString());
                pm.setNgaymuon(edtNgay.getText().toString());
                pm.setGhichu(edtGhiChu.getText().toString());
                pm.setDocgia(spdDocGia.getSelectedItem().toString());
                pm.setTensach(spdSach.getSelectedItem().toString());
                index = -1;
                adapter3.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == -1) return;
                data.remove(index);
                index = -1;
                adapter3.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
