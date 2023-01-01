package com.example.fawrydemo.utils.Form;

import com.example.fawrydemo.utils.Form.Field.IField;

import java.util.ArrayList;

public interface IForm {
    ArrayList<IField> getRequirements();
    ArrayList<String> getReq();
}
