package com.example.moto;

import java.util.Arrays;

public class Question
{
    private String description;
    private String[] answer;
    private String[] result;
    private String pathImage;
    public Question(){}
    public Question(String description, String[] answer, String[] result, String pathImage)
    {
        this.description = description;
        this.answer = answer;
        this.result = result;
        this.pathImage = pathImage;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String[] getAnswer() {
        return answer;
    }
    public void setAnswer(String[] answer) {
        this.answer = answer;
    }
    public String[] getResult() {
        return result;
    }
    public void setResult(String[] result) {
        this.result = result;
    }
    public String getPathImage() {
        return pathImage;
    }
    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
