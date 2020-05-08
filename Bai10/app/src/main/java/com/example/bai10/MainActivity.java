package com.example.bai10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView ezView;
    String playerList[]={"Messi","CR7","VG","AA"};
    String dobList[]={"98","99","100","110"};
    String fcList[]={"vn","fc","db","db"};
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
        CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_list, playerList, dobList, fcList, flags, avatar);
        ezView.setAdapter(adapter);
        ezView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Ban da click vao: " + playerList[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
