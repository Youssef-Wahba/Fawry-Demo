package com.example.fawrydemo.controllers.ServicesController;

import com.example.fawrydemo.services.ServiceServices.VodafoneCashService;
import com.example.fawrydemo.utils.Form.VodafoneCashForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("vodafone-cash")
public class VodafoneCashController {
    VodafoneCashService vfCashService=new VodafoneCashService();

    @PostMapping("/creditCard-pay")
    public ResponseEntity<?> pay(@RequestBody VodafoneCashForm form){

        return vfCashService.pay(form); }
    @PostMapping("/wallet-pay")
    public ResponseEntity<?> walletPay(@RequestBody VodafoneCashForm form){ return vfCashService.walletPay(form); }
    @GetMapping("/list-requirements")
    public ResponseEntity<?> listRequirements(){ return vfCashService.getRequirements(); }
    @PostMapping("/add-discount/{discount}")
    public ResponseEntity<?> addDiscount(@PathVariable double discount){
        return vfCashService.addDiscount(discount);
    }
    @GetMapping("/remove-discount")
    public ResponseEntity<?> removeDiscount(){
        return vfCashService.removeDiscount();
    }
}
