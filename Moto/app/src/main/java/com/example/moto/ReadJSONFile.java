package com.example.moto;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadJSONFile
{
    public static ArrayList<Question> readJSONFile(Context context) throws IOException, JSONException
    {
        ArrayList<Question> ListQuestion = new ArrayList<>();
        String jsonText = readText(context);
        JSONArray jsonArray = new JSONArray(jsonText);
        for (int i=0; i< jsonArray.length(); i++)
        {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String description = jsonObject.getString("description");
            String pathImge = jsonObject.getString("pathImage");
            JSONArray jsonArrayAnswer = jsonObject.getJSONArray("answer");
            String[] answer = new String[jsonArrayAnswer.length()];
            for (int j=0; j<jsonArrayAnswer.length(); j++)
            {
                answer[j] = jsonArrayAnswer.getString(j);
            }
            JSONArray jsonArrayResult = jsonObject.getJSONArray("result");
            String[] result = new String[jsonArrayResult.length()];
            for (int j=0; j<jsonArrayResult.length(); j++)
            {
                result[j] = jsonArrayResult.getString(j);
            }
            Question question = new Question(description,answer,result,pathImge);
            ListQuestion.add(question);
        }
        return ListQuestion;
    }

    private static String readText(Context context) throws IOException
    {
        InputStream is = context.getResources().openRawResource(R.raw.resource);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s= null;
        while((s = br.readLine())!=null)
        {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
    /*
    public ArrayList<Question> readJSON(ArrayList<Question> ListQuestion)
    {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        String tmp="";
        try
        {
            br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.resource)));
            while((tmp = br.readLine()) != null)
            {
                sb.append(tmp);
            }
            JSONArray jsonArray = new JSONArray(sb.toString());
            for (int i=0; i< jsonArray.length(); i++)
            {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String description = jsonObject.getString("description");
                String pathImge = jsonObject.getString("pathImage");
                JSONArray jsonArrayAnswer = jsonObject.getJSONArray("answer");
                String[] answer = new String[jsonArrayAnswer.length()];
                for (int j=0; j<jsonArrayAnswer.length(); j++)
                {
                    answer[j] = jsonArrayAnswer.getString(j);
                }
                JSONArray jsonArrayResult = jsonObject.getJSONArray("result");
                String[] result = new String[jsonArrayResult.length()];
                for (int j=0; j<jsonArrayResult.length(); j++)
                {
                    result[j] = jsonArrayResult.getString(j);
                }
                Question question = new Question(description,answer,result,pathImge);
                ListQuestion.add(question);
            }
        }
        catch (Exception e)
        {
            Log.d("Error JSON", "readJSON: Fail");
        }
        return ListQuestion;
    }
     */
}
