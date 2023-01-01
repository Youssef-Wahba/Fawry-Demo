package com.example.fawrydemo.controllers.PersonController;

import com.example.fawrydemo.services.PersonServices.AdminService;
import com.example.fawrydemo.utils.Persons.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admins")
public class AdminController {
    AdminService adminService = new AdminService();
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) { return adminService.logIn(admin); }
    @GetMapping("/list")
    public ResponseEntity<?> list() { return adminService.list(); }
    @PostMapping("/overall-discount/{discount}")
    public ResponseEntity<?> addOverallDiscount(@PathVariable double discount) { return adminService.addOverallDiscount(discount); }
    @GetMapping("/overall-discount/remove")
    public ResponseEntity<?> removeOverallDiscount() { return adminService.removeOverallDiscount(); }
}