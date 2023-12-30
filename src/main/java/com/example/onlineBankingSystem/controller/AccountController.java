package com.example.onlineBankingSystem.controller;
import com.example.onlineBankingSystem.model.Account;
import com.example.onlineBankingSystem.service.AccountService;
import com.example.onlineBankingSystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    //create new account for the customer
    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Account account)
    {
        Account updatedAccount = accountService.createAccount(account);
        if (updatedAccount==null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CustomerId doesnot exists,please create a new customer profile");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Account created successfully");
    }
}
