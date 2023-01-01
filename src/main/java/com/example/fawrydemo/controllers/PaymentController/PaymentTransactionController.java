package com.example.fawrydemo.controllers.PaymentController;

import com.example.fawrydemo.services.PaymentServices.PaymentTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment-transaction")
public class PaymentTransactionController {
    PaymentTransactionService paymentTransactionService=new PaymentTransactionService();
    @GetMapping("/list")
    public ResponseEntity<?> list(){ return paymentTransactionService.list(); }
    @GetMapping("/user-transactions")
    public ResponseEntity<?> getUserTransaction(){ return paymentTransactionService.getUserTransaction(); }

}
