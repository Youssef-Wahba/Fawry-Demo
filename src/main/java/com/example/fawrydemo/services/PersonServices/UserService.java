package com.example.fawrydemo.services.PersonServices;

import com.example.fawrydemo.models.UserModel;
import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.utils.Persons.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

import java.util.Iterator;

public class UserService {
    private final ObjectMapper  mapper=new ObjectMapper();
    public ResponseEntity<?> getAllUsers(){
        ObjectNode response = mapper.createObjectNode();
        //        if no user logged in
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","users not allowed");
            return ResponseEntity.status(400).body(response);
        }
        //        if admin is logged in
        if(UserModel.getINSTANCE().getUsers().size()>0){
            ArrayNode usersList=mapper.valueToTree(UserModel.getINSTANCE().getUsers());
            response.put("message","success");
            response.put("UsersNo", UserModel.getINSTANCE().getUsers().size());
            response.putArray("users").addAll(usersList);
            return ResponseEntity.ok(response);
        }
        response.put("message","no users found");
        return ResponseEntity.status(404).body(response);
    }

    public ResponseEntity<?> addUser(User user){
        ObjectNode response = mapper.createObjectNode();
        if(user.getEmail() == null || user.getPassword() == null || user.getUsername() == null){
            response.put("message","credentials is missing");
            return ResponseEntity.status(400).body(response);
        }
        Iterator<User> iterator = UserModel.getINSTANCE().getUsers().iterator();
        while(iterator.hasNext()){
            User u=iterator.next();
            if(u.getEmail().toLowerCase().equals(user.getEmail().toLowerCase()) || u.getUsername().equals(user.getUsername())){
                response.put("message","username or email already exists");
                return ResponseEntity.status(400).body(response);
            }
        }
        int c= UserModel.getINSTANCE().getUsersCounter()+1;
        UserModel.getINSTANCE().setUsersCounter(c);
        user.setId(Integer.toString(UserModel.getINSTANCE().getUsersCounter()));
        user.setEmail(user.getEmail().toLowerCase());   //lower case the email
        UserModel.getINSTANCE().getUsers().add(user);
        ArrayNode usersList=mapper.valueToTree(UserModel.getINSTANCE().getUsers());
        response.put("message","success");
        ObjectNode newUser=mapper.valueToTree(UserModel.getINSTANCE().getUsers().get(UserModel.getINSTANCE().getUsers().size()-1));
        response.put("user",newUser);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> logIn(User user){
        ObjectNode response =mapper.createObjectNode();
        if(user.getEmail()==null || user.getPassword()==null){
            response.put("message","email or password or both is missing");
            return ResponseEntity.status(400).body(response);
        }
        for (User u: UserModel.getINSTANCE().getUsers()) {
            if(u.getEmail().toLowerCase().equals(user.getEmail().toLowerCase())) {
                if (u.getPassword().equals(user.getPassword())) {
                    response.put("message", "success");
                    GlobalUser globalUser=GlobalUser.getGlobalUser();
                    globalUser.setUser(u);
                    return ResponseEntity.ok(response);
                } else {
                    response.put("message", "incorrect password");
                    return ResponseEntity.status(400).body(response);
                }
            }
        }
        response.put("message","email not registered yet");
        return ResponseEntity.status(404).body(response);
    }
    public ResponseEntity<?> signOut(){
        ObjectNode response =mapper.createObjectNode();
        GlobalUser globalUser=GlobalUser.getGlobalUser();
        if(globalUser.getUserMode()!=-1){
            globalUser.setUser(null);
            response.put("message","success");
        }
        else{
            response.put("message","no logged in person");
        }
        return ResponseEntity.ok(response);
    }
}
