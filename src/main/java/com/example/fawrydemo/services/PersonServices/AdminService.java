package com.example.fawrydemo.services.PersonServices;

import com.example.fawrydemo.models.AdminModel;
import com.example.fawrydemo.models.GlobalUser;
import com.example.fawrydemo.models.UserModel;
import com.example.fawrydemo.utils.Persons.Admin;
import com.example.fawrydemo.utils.Persons.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminService {
    private final ObjectMapper mapper=new ObjectMapper();
    public ResponseEntity<?> logIn(Admin admin){
        ObjectNode response =mapper.createObjectNode();
        if(admin.getEmail()==null || admin.getPassword()==null){
            response.put("message","email or password or both is missing");
            return ResponseEntity.status(400).body(response);
        }
        for (Admin a: AdminModel.getINSTANCE().getAdmins()) {
            if(a.getEmail().toLowerCase().equals(admin.getEmail().toLowerCase())) {
                if (a.getPassword().equals(admin.getPassword())) {
                    response.put("message", "success");
                    GlobalUser globalUser=GlobalUser.getGlobalUser();
                    globalUser.setUser(a);
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
    public ResponseEntity<?> list(){
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
            ArrayNode arr=mapper.valueToTree(AdminModel.getINSTANCE().getAdmins());
            response.put("message","success");
            response.put("adminNo", AdminModel.getINSTANCE().getAdminCounter());
            response.putArray("admins").addAll(arr);
            return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> addOverallDiscount(double discount){
        ObjectNode response = mapper.createObjectNode();
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","users not allowed");
            return ResponseEntity.status(400).body(response);
        }
        GlobalUser.getGlobalUser().setOverallDiscount(discount);
        response.put("message","success");
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<?> removeOverallDiscount(){
        ObjectNode response = mapper.createObjectNode();
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        //        if user is logged in
        if(GlobalUser.getGlobalUser().getUserMode() == 1){
            response.put("message","users not allowed");
            return ResponseEntity.status(400).body(response);
        }
        GlobalUser.getGlobalUser().setOverallDiscount(0);
        GlobalUser.getGlobalUser().getUser().setOverallDiscountUsed(false);
        ArrayList<User> users = UserModel.getINSTANCE().getUsers();
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            iterator.next().setOverallDiscountUsed(false);
        }
        response.put("message","success");
        return ResponseEntity.ok(response);
    }
}
