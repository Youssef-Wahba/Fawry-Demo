package com.example.fawrydemo.controllers.ServicesController;

import com.example.fawrydemo.services.ServiceServices.ServicesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class ServiceController {
    ServicesService service=new ServicesService();
    @GetMapping("/list")
    public ResponseEntity<?> getAllServices(){
        return service.getAllServices();
    }

    @PostMapping("/search/{name}")
    public ResponseEntity<?> searchService(@PathVariable String name){
        return service.searchService(name);
    }
}
