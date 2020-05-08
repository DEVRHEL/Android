package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    String countryList[] = {"India","China","Aus"};
    int flags[] = {R.drawable.india, R.drawable.china, R.drawable.aus};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        simpleList = findViewById(R.id.listView);
    }
    private void setEvent()
    {
        CustomAdapter adapter = new CustomAdapter(this, R.layout.activity_listview,countryList,flags);
        simpleList.setAdapter(adapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn: " + countryList[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
