package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    TextView tvThongBao;
    ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa
        setControl();
        //code
        setEvent();
    }
    private void setControl()
    {
        tvThongBao=(TextView)findViewById(R.id.txt);
        btnClick=(Button)findViewById(R.id.btn);
        imgV = findViewById(R.id.imageView);
    }
    private void setEvent()
    {
        btnClick.setOnClickListener(new View.OnClickListener(){
            @Override
                 public void onClick(View v){
                    tvThongBao.setText("OK");
                    imgV.setImageResource(getImage("img91"));
                }
        });
    }
    public int getImage(String imageName)
    {
        int drawableImageId = this.getResources().getIdentifier(imageName, "drawable",this.getPackageName());
        return drawableImageId;
    }
}
