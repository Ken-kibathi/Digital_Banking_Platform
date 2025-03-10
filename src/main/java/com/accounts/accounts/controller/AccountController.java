package com.accounts.accounts.controller;

import com.accounts.accounts.model.Account;
import com.accounts.accounts.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestParam Long customerId) {
        Account account = accountService.createAccount(customerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Optional<Account>> getAccountByAccountNo(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByAccountNo(accountNumber));
    }

    @PutMapping("/freeze/{id}")
    public ResponseEntity<String> freezeAccount(@PathVariable Long id) {
        accountService.freezeAccount(id);
        return ResponseEntity.ok("Account " + accountService.getAccountNumber(id) + "frozen successfully.");
    }

    @PutMapping("/unfreeze/{id}")
    public ResponseEntity<String> unfreezeAccount(@PathVariable Long id) {
        accountService.unfreezeAccount(id);
        return ResponseEntity.ok("Account " + accountService.getAccountNumber(id) + "unfrozen successfully.");
    }
}
