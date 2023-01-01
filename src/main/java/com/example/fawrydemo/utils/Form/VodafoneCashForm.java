package com.example.fawrydemo.utils.Form;

import com.example.fawrydemo.utils.Form.Field.IField;
import com.example.fawrydemo.utils.Form.Field.TextField;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

public class VodafoneCashForm implements IForm{
    private String phoneNumber;
    private double amount;
    private ArrayList<String>req=new ArrayList<>(Arrays.asList("Phone number","amount"));
    private ArrayList<IField> requirements = new ArrayList<>();
    @JsonCreator
    public VodafoneCashForm(@JsonProperty("phoneNumber") String phoneNumber,@JsonProperty("amount") double amount ) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;

        TextField phoneNumberField=new TextField("phone number");
        phoneNumberField.setAnswer(phoneNumber);

        TextField amountField=new TextField("amount");
        amountField.setAnswer(Double.toString(amount));

        requirements=new ArrayList<>(Arrays.asList(phoneNumberField,amountField));
    }

    @Override
    public ArrayList<IField> getRequirements() {
        return requirements;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getAmount() {
        return amount;
    }
    @Override
    public ArrayList<String> getReq() {
        return req;
    }

    @Override
    public String toString() {
        return "VodafoneCashForm{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", amount=" + amount +
                ", req=" + req +
                ", requirements=" + requirements +
                '}';
    }
}
