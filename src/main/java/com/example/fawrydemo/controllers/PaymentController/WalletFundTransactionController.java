package com.example.fawrydemo.controllers.PaymentController;

import com.example.fawrydemo.services.PaymentServices.WalletFundsTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wallet-funds")
public class WalletFundTransactionController {
    WalletFundsTransactionService walletFundsTransactionService = new WalletFundsTransactionService();
    @PostMapping("/add-funds/{amount}")
    public ResponseEntity<?> addFunds(@PathVariable double amount){
        return walletFundsTransactionService.pay(amount);
    }
    @GetMapping("/list")
    public ResponseEntity<?> list(){
        return walletFundsTransactionService.list();
    }
}
