package com.example.fawrydemo.controllers.PaymentController;

import com.example.fawrydemo.services.PaymentServices.RefundTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("refund")
public class RefundTransactionController {
    RefundTransactionService refundTransactionService=new RefundTransactionService();
    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return refundTransactionService.list();
    }
    @PostMapping("/add-refund/{index}")
    public ResponseEntity<?> addRefund(@PathVariable int index){
        return refundTransactionService.addRefund(index);
    }

    @PostMapping("/accept/{index}")
    public ResponseEntity<?> acceptRefund(@PathVariable int index){
        return refundTransactionService.acceptRefund(index);
    }
    @PostMapping("/reject/{index}")
    public ResponseEntity<?> rejectRefund(@PathVariable int index){
        return refundTransactionService.rejectRefund(index);
    }

}
