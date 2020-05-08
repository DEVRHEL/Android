package com.example.moto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VaoHocActivity extends AppCompatActivity {
    Button btnBack, btnNext, btnHome, btnA, btnB, btnC, btnD;
    TextView txtCauHoiSo, txtNoiDung;
    ImageView imgAnhBienBao;
    ArrayList<Question> ListQuestion = new ArrayList<>();
    int so = 91;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vao_hoc);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        btnBack = findViewById(R.id.button_Back);
        btnNext = findViewById(R.id.button_Next);
        btnHome = findViewById(R.id.button_Home);
        btnA = findViewById(R.id.button_A);
        btnB = findViewById(R.id.button_B);
        btnC = findViewById(R.id.button_C);
        btnD = findViewById(R.id.button_D);
        txtCauHoiSo = findViewById(R.id.textView_CauHoiSo);
        txtNoiDung = findViewById(R.id.textView_NoiDungCauHoi);
        imgAnhBienBao = findViewById(R.id.imageView_Image);
        try {
           ListQuestion = ReadJSONFile.readJSONFile(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        controlContent(so);
    }
    public void setEvent()
    {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so++;
                if (so >= 0 && so < ListQuestion.size())
                {
                    controlContent(so);
                }
                else so--;
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so--;
                if (so >= 0 && so < ListQuestion.size())
                {
                    controlContent(so);
                }
                else so++;
            }
        });
    }
    public void controlContent(int so)
    {
        btnA.setBackgroundColor(Color.GRAY);
        btnB.setBackgroundColor(Color.GRAY);
        btnC.setBackgroundColor(Color.GRAY);
        btnD.setBackgroundColor(Color.GRAY);
        imgAnhBienBao.setVisibility(View.INVISIBLE);
        txtCauHoiSo.setText("Câu hỏi số "+so);
        txtNoiDung.setText(ListQuestion.get(so).getDescription());
        btnA.setText("A. "+(ListQuestion.get(so).getAnswer()[0].isEmpty()?"":ListQuestion.get(so).getAnswer()[0]));
        btnB.setText("B. "+(ListQuestion.get(so).getAnswer()[1].isEmpty()?"":ListQuestion.get(so).getAnswer()[1]));
        btnC.setText("C. "+(ListQuestion.get(so).getAnswer()[2].isEmpty()?"":ListQuestion.get(so).getAnswer()[2]));
        btnD.setText("D. "+(ListQuestion.get(so).getAnswer()[3].isEmpty()?"":ListQuestion.get(so).getAnswer()[3]));
        String[] arrResult = ListQuestion.get(so).getResult();
        for (int i=0 ; i<arrResult.length; i++)
        {
            switch (Integer.parseInt(arrResult[i]))
            {
                case 0:
                    btnA.setBackgroundColor(Color.GREEN);
                    break;
                case 1:
                    btnB.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    btnC.setBackgroundColor(Color.GREEN);
                    break;
                case 3:
                    btnD.setBackgroundColor(Color.GREEN);
                    break;
            }
        }
        if (!ListQuestion.get(so).getPathImage().isEmpty())
        {
            imgAnhBienBao.setVisibility(View.VISIBLE);
            String imageName = ListQuestion.get(so).getPathImage();
            imgAnhBienBao.setImageResource(getImageId(imageName));
        }
    }
    public int getImageId(String imageName)
    {
        int drawableImageId = this.getResources().getIdentifier(imageName, "drawable",this.getPackageName());
        return drawableImageId;
    }
}
