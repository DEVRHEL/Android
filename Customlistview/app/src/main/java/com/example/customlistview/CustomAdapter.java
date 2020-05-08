package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customlistview.R;

public class CustomAdapter extends ArrayAdapter
{
    Context context;
    String countryList[];
    int flags[];
    int layoutID;
    public CustomAdapter(Context context, int layoutID, String[] countryList, int flags[])
    {
        super(context,layoutID);
        this.context=context;
        this.countryList=countryList;
        this.flags=flags;
        this.layoutID=layoutID;
    }
    @Override
    public int getCount()
    {
        return countryList.length;
    }
    @Override
    public View getView(int postion, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater.from(context));
        convertView = inflater.inflate(layoutID, null);
        TextView country = (TextView) convertView.findViewById(R.id.textView);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        country.setText(countryList[postion]);
        icon.setImageResource(flags[postion]);
        return convertView;
    }
}
