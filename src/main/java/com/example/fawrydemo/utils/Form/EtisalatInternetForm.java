package com.example.fawrydemo.utils.Form;

import com.example.fawrydemo.utils.Form.Field.IField;
import com.example.fawrydemo.utils.Form.Field.TextField;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

public class EtisalatInternetForm implements IForm {
    private String secretInternetCode;
    private double amount;
    private ArrayList<String> req=new ArrayList<>(Arrays.asList("Telephone Number"));
    private ArrayList<IField> requirements = new ArrayList<>();

    @JsonCreator
    public EtisalatInternetForm(@JsonProperty("secretInternetCode") String secretInternetCode, @JsonProperty("amount") double amount) {
        this.secretInternetCode = secretInternetCode;
        this.amount = amount;

        TextField secretInternetCodeField=new TextField("secrete internet code");
        secretInternetCodeField.setAnswer(secretInternetCode);

        TextField amountField=new TextField("amount");
        amountField.setAnswer(Double.toString(amount));

        requirements = new ArrayList<>(Arrays.asList(secretInternetCodeField,amountField));
    }

    @Override
    public ArrayList<IField> getRequirements() { return requirements; }
    @Override
    public ArrayList<String> getReq() {
        return req;
    }

    public String getSecretInternetCode() { return secretInternetCode; }

    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return "EtisalatInternetForm{" +
                "secretInternetCode='" + secretInternetCode + '\'' +
                ", amount=" + amount +
                ", req=" + req +
                ", requirements=" + requirements +
                '}';
    }
}
