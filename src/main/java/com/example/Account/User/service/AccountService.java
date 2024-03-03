package com.example.Account.User.service;

import com.example.Account.User.convertor.AccountConvertor;
import com.example.Account.User.dto.request.AccountRequest;
import com.example.Account.User.dto.response.AccountResponse;
import com.example.Account.User.model.Account;
import com.example.Account.User.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountConvertor accountConvertor;
    private UserService userService;
    public AccountResponse save(AccountRequest dto) {
        Account entity=accountConvertor.toEntity(dto);
        AccountResponse response=accountConvertor.toResponse(
                accountRepository.save(entity));
        userService.updateAccountId(dto.getUserId(),response);


        return response;
    }

    public AccountResponse getById(Long id) {
        Optional<Account> optionalAccount=accountRepository.findById(id);
        Account account=optionalAccount.orElseThrow(()->new RuntimeException("Id bulunamadı"));
        return accountConvertor.toResponse(account);
    }
}
