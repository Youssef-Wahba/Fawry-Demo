package com.example.fawrydemo.utils.Form.Field;

public class TextField implements IField{
    private String question;
    private String answer;
    public TextField(String question){
        this.question = question;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }
    @Override
    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "TextField{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
