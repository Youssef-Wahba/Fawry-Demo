package com.example.fawrydemo.controllers.ServicesController;

import com.example.fawrydemo.services.ServiceServices.EtisalatInternetService;
import com.example.fawrydemo.utils.Form.EtisalatInternetForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("etisalat-internet")
public class EtisalatInternetController {
    EtisalatInternetService etisalatInternetService=new EtisalatInternetService();

    @PostMapping("/creditCard-pay")
    public ResponseEntity<?> pay(@RequestBody EtisalatInternetForm form){ return etisalatInternetService.pay(form); }
    @PostMapping("/wallet-pay")
    public ResponseEntity<?> walletPay(@RequestBody EtisalatInternetForm form){ return etisalatInternetService.walletPay(form); }
    @GetMapping("/list-requirements")
    public ResponseEntity<?> listRequirements(){ return etisalatInternetService.getRequirements(); }
    @PostMapping("/add-discount/{discount}")
    public ResponseEntity<?> addDiscount(@PathVariable double discount){ return etisalatInternetService.addDiscount(discount); }
    @GetMapping("/remove-discount")
    public ResponseEntity<?> removeDiscount(){
        return etisalatInternetService.removeDiscount();
    }
}
