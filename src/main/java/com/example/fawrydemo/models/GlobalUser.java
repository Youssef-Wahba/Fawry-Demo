package com.example.fawrydemo.models;

import com.example.fawrydemo.utils.Persons.IPerson;

public final class GlobalUser {
    private static GlobalUser INSTANCE;
    private IPerson user = null;
    private int userMode = -1;//-1 not logged in , 0 admin , 1 user
    private GlobalUser(){}
    private double overallDiscount = 0;
    public static GlobalUser getGlobalUser(){
        if(INSTANCE == null)
            INSTANCE = new GlobalUser();
        return INSTANCE;
    }
    public IPerson getUser() {
        return user;
    }

    public void setUser(IPerson user) {
        this.user = user;
        if(user == null){
            userMode=-1;
            return;
        }
        if(user.getClass().toString().toLowerCase().contains("user")){
            userMode=1;
            return;
        }

        if(user.getClass().toString().toLowerCase().contains("admin"))
            userMode=0;
    }

    public double getOverallDiscount() {
        return overallDiscount;
    }

    public  void setOverallDiscount(double overallDiscount) {
        GlobalUser.getGlobalUser().overallDiscount = overallDiscount;
    }

    public int getUserMode() {
        return userMode;
    }
}
