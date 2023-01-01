package com.example.fawrydemo.utils.Form.Field;

import java.util.ArrayList;

public class DropDownMenu implements IField{
    private String question,answer;
    private ArrayList<String> answersList;

    public DropDownMenu(String question, ArrayList<String> answersList) {
        this.question = question;
        this.answersList = answersList;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getAnswersList() {
        return answersList;
    }
    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "DropDownMenu{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", answersList=" + answersList +
                '}';
    }
}
