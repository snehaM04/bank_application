package com.example.onlineBankingSystem.controller;

import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.model.Login;
import com.example.onlineBankingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;
    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody Login login)
    {
        Customer customer = customerRepository.findByEmail(login.getEmail());
            if(customer != null && customer.getPassword().equals(login.getPassword()))
            {
                return ResponseEntity.status(HttpStatus.OK).body("Login successfully for the customerId " + customer.getcustomerId());
            }
            else
            {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email or password is not exist");
            }
    }
}
