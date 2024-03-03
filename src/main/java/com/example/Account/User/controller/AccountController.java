package com.example.Account.User.controller;

import com.example.Account.User.dto.request.AccountRequest;
import com.example.Account.User.dto.response.AccountResponse;
import com.example.Account.User.service.AccountService;
import com.example.Account.User.shared.AcoountEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AcoountEndpoint.ACCOUNT)
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountResponse save(@RequestBody AccountRequest dto){
        return accountService.save(dto);
    }
    @GetMapping("/{id}")
    public AccountResponse getById(@PathVariable Long id ){
        return accountService.getById(id);
    }

}
