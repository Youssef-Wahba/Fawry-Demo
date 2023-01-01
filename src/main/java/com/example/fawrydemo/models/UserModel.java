package com.example.fawrydemo.models;

import com.example.fawrydemo.utils.Persons.User;

import java.util.ArrayList;
import java.util.Arrays;

public final class UserModel {
    private static UserModel INSTANCE;
    private int usersCounter=5;
    private ArrayList<User> users = new ArrayList<>(Arrays.asList(
            new User("1","joe", "youssef@gmail.com", "youssef"),
            new User("2", "mo","mohamed@gmail.com", "mohamed"),
            new User("3","amr1", "amr@gmail.com", "amr"),
            new User("4","hoda", "ahmed@gmail.com", "ahmed"),
            new User("5", "3elwa","ali@gmail.com", "ali")
    ));
    private UserModel(){}

    public static UserModel getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE=new UserModel();
        return INSTANCE;
    }

    public int getUsersCounter() {
        return usersCounter;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsersCounter(int usersCounter) {
        this.usersCounter = usersCounter;
    }
}
