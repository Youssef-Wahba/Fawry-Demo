package com.example.fawrydemo.controllers.ServicesController;

import com.example.fawrydemo.services.ServiceServices.LandlineService;
import com.example.fawrydemo.utils.Form.LandlineForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("landline")
public class LandlineController {
    LandlineService landlineService=new LandlineService();
    @PostMapping("/creditCard-pay")
    public ResponseEntity<?> pay(@RequestBody LandlineForm form){
        System.out.println(form);
        return landlineService.pay(form); }
    @PostMapping("/wallet-pay")
    public ResponseEntity<?> walletPay(@RequestBody LandlineForm form){ return landlineService.walletPay(form); }
    @GetMapping("/list-requirements")
    public ResponseEntity<?> listRequirements(){ return landlineService.getRequirements(); }
    @PostMapping("/add-discount/{discount}")
    public ResponseEntity<?> addDiscount(@PathVariable double discount){
        return landlineService.addDiscount(discount);
    }
    @GetMapping("/remove-discount")
    public ResponseEntity<?> removeDiscount(){
        return landlineService.removeDiscount();
    }
}
