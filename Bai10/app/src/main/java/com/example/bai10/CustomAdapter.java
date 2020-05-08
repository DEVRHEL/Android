package com.example.bai10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter
{
    Context context;
    String playerList[];
    String dobList[];
    String fcList[];
    int avatar[];
    int flags[];
    int layoutID;
    public CustomAdapter(Context context, int layoutID, String[] playerList, String[] dobList, String[] fcList, int flags[], int avatar[])
    {
        super(context,layoutID);
        this.context=context;
        this.playerList=playerList;
        this.dobList=dobList;
        this.fcList=fcList;
        this.avatar=avatar;
        this.flags=flags;
        this.layoutID=layoutID;
    }
    @Override
    public int getCount()
    {
        return playerList.length;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater.from(context));
        convertView = inflater.inflate(layoutID, null);
        TextView player = (TextView) convertView.findViewById(R.id.textView_top);
        TextView dayofbirth = (TextView) convertView.findViewById(R.id.textView_down);
        TextView fc = (TextView) convertView.findViewById(R.id.textView_fc);
        ImageView avatar = (ImageView) convertView.findViewById(R.id.imageView_left);
        ImageView flag = (ImageView) convertView.findViewById(R.id.imageView_right);
        player.setText(playerList[position]);
        dayofbirth.setText(dobList[position]);
        fc.setText(fcList[position]);
        avatar.setImageResource(this.avatar[position]);
        flag.setImageResource(this.flags[position]);
        return convertView;
    }
}
