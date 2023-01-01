package com.example.fawrydemo.models;

import com.example.fawrydemo.utils.Persons.Admin;

import java.util.ArrayList;
import java.util.Arrays;

public final class AdminModel {
    private int adminCounter=1;
    private static AdminModel INSTANCE;
    private ArrayList<Admin> admins = new ArrayList<>(Arrays.asList(
            new Admin("1","joe", "y@gmail.com", "11111")
    ));

    private AdminModel() {
    }

    public static AdminModel getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE=new AdminModel();
        return INSTANCE;
    }

    public int getAdminCounter() {
        return adminCounter;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdminCounter(int adminCounter) {
        this.adminCounter = adminCounter;
    }
}
