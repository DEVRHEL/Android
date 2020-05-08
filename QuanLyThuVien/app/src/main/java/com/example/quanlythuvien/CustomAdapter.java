package com.example.quanlythuvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter
{
    private Context context;
    private ArrayList<PhieuMuon> pm;
    int layoutID;
    public CustomAdapter(Context context, int layoutID, ArrayList<PhieuMuon> pm)
    {
        super(context,layoutID);
        this.context=context;
        this.layoutID=layoutID;
        this.pm=pm;
    }
    @Override
    public int getCount()
    {
        return pm.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater.from(context));
        convertView = inflater.inflate(layoutID, null);
        TextView dg = (TextView) convertView.findViewById(R.id.textView_docgia);
        TextView sh = (TextView) convertView.findViewById(R.id.textView_tensach);
        TextView ngay = (TextView) convertView.findViewById(R.id.textView_ngay);
        dg.setText(pm.get(position).getDocgia().toString());
        sh.setText(pm.get(position).getTensach().toString());
        ngay.setText(pm.get(position).getNgaymuon().toString());
        return convertView;
    }
}
