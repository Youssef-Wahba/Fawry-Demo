package com.example.fawrydemo.services.ServiceServices;

import com.example.fawrydemo.models.GlobalServices;
import com.example.fawrydemo.models.GlobalUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;

public class ServicesService {
    ObjectMapper mapper=new ObjectMapper();
    public ResponseEntity<?> getAllServices(){
        ObjectNode response=mapper.createObjectNode();
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        GlobalServices globalServices=GlobalServices.getGlobalUser();
        if(globalServices.getServiceNames().size()<1){
            response.put("messages","no services available");
            return ResponseEntity.status(404).body(response);
        }
        ArrayNode arr=mapper.valueToTree(globalServices.getServiceNames());
        response.put("services",arr);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> searchService(String query){
        ObjectNode response=mapper.createObjectNode();
        if(GlobalUser.getGlobalUser().getUserMode() == -1){
            response.put("message","user not logged in");
            return ResponseEntity.status(400).body(response);
        }
        GlobalServices globalServices=GlobalServices.getGlobalUser();
        if(globalServices.getServiceNames().size()<1){
            response.put("messages","no services available");
            return ResponseEntity.status(404).body(response);
        }
        ArrayList<String> list=new ArrayList<>();
        Iterator<String> iterator=globalServices.getServiceNames().iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if(s.toLowerCase().contains(query.toLowerCase()))
                list.add(s);
        }
        if(list.size()<1){
            response.put("messages","not found");
            return ResponseEntity.status(404).body(response);
        }
        ArrayNode arrayNode=mapper.valueToTree(list);
        response.put("result",arrayNode);
        return ResponseEntity.ok(response);
    }
}
