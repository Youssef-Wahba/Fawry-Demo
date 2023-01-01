package com.example.fawrydemo.models;

import java.util.ArrayList;

public final class GlobalServices {
    private static GlobalServices INSTANCE;
    private ArrayList<String> serviceNames=new ArrayList<>();
    public static GlobalServices getGlobalUser(){
        if(INSTANCE == null)
            INSTANCE = new GlobalServices();
        return INSTANCE;
    }
    private GlobalServices() {}

    public void addServiceName(String s){
        serviceNames.add(s);
    }
    public ArrayList<String> getServiceNames(){
        return this.serviceNames;
    }
}
