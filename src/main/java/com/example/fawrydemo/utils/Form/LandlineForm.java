package com.example.fawrydemo.utils.Form;

import com.example.fawrydemo.utils.Form.Field.IField;
import com.example.fawrydemo.utils.Form.Field.TextField;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

public class LandlineForm implements IForm {
    private String telephoneNumber;
    private ArrayList<String> req=new ArrayList<>(Arrays.asList("Telephone Number"));
    private ArrayList<IField> requirements = new ArrayList<>();
    @JsonCreator
    public LandlineForm(@JsonProperty("telephoneNumber") String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;

        TextField telephoneNumberField=new TextField("telephone number");
        telephoneNumberField.setAnswer(telephoneNumber);

        requirements.add(telephoneNumberField);
    }

    @Override
    public ArrayList<IField> getRequirements() {
        return requirements;
    }
    @Override
    public ArrayList<String> getReq() {
        return req;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }


    @Override
    public String toString() {
        return "LandlineForm{" +
                "telephoneNumber='" + telephoneNumber + '\'' +
                ", req=" + req +
                ", requirements=" + requirements +
                '}';
    }
}
