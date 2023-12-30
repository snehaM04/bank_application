package com.example.onlineBankingSystem.service;
import com.example.onlineBankingSystem.model.Account;
import com.example.onlineBankingSystem.model.Customer;
import com.example.onlineBankingSystem.repository.AccountRepository;
import com.example.onlineBankingSystem.repository.CustomerRepository;
import com.example.onlineBankingSystem.util.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public Account createAccount(Account account) {
        Long RandomAccountId = RandomNumber.generateRandomLongId();
        account.setAccountId(RandomAccountId);
        Optional<Customer> existCustomerId = customerRepository.findByCustomerId(account.getCustomerId().getcustomerId());
        if (existCustomerId.isPresent()) {
            return accountRepository.save(account);
        } else {
            return null;
        }
    }
}

