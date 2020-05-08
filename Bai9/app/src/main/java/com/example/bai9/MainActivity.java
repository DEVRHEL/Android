package com.example.bai9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView ezView;
    String playerList[]={"Messi","CR7","VG","AA"};
    String dobList[]={"10/10/1997 (21 age)","11/11/1996 (21 age)","09/09/1999 (21 age)","10/10/1999 (21 age)"};
    int flags[] =  {R.drawable.india, R.drawable.china, R.drawable.aus, R.drawable.india2};
    int avatar[] =  {R.drawable.m10, R.drawable.cr7, R.drawable.sl, R.drawable.vg};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        ezView = findViewById(R.id.ListView);
    }
    private void setEvent()
    {
        CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_list, playerList, dobList, flags, avatar);
        ezView.setAdapter(adapter);
        ezView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Ban da click vao: " + playerList[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
