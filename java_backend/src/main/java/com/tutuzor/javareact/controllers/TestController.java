package com.tutuzor.javareact.controllers;

import com.tutuzor.javareact.models.requests.NewAccountRequest;

import java.util.ArrayList;
import java.util.List;

import com.tutuzor.javareact.models.Account;
import com.tutuzor.javareact.models.Customer;
import com.tutuzor.javareact.repositories.AccountRepo;
import com.tutuzor.javareact.repositories.CustomerRepo;
import com.tutuzor.javareact.repositories.TransactionRepo;
import com.tutuzor.javareact.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired private AccountRepo accountRepo;
    @Autowired private TransactionRepo transactionRepo;
    @Autowired private CustomerRepo customerRepo;

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void addNewAccount(@RequestBody NewAccountRequest newAccount){
        if(null != newAccount.getCustId()){
            Account addedAccount = new Account(newAccount.getCustId());
            accountRepo.save(addedAccount);
            if(newAccount.getAmount() > 0){
                Transaction transaction = new Transaction(addedAccount.getId(), newAccount.getAmount());
                transactionRepo.save(transaction);
            }
        }
    }

    @GetMapping("/get_all_accounts")
    public Long getAllUsers(){
        return accountRepo.count();
    }

    @GetMapping("/get_all_transactions")
    public Long getAllTransactions(){
        return transactionRepo.count();
    }

    @GetMapping("/get_all_customers")
    public Iterable<Customer> getAllCustomers(){
        Iterable<Customer> result = customerRepo.findAll();
        List<Customer> listResult = new ArrayList<>();
        result.forEach(listResult::add);
        return result;
    }
}
