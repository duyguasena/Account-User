package com.example.Account.User.convertor;

import com.example.Account.User.dto.request.AccountRequest;
import com.example.Account.User.dto.response.AccountResponse;
import com.example.Account.User.model.Account;
import com.example.Account.User.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class AccountConvertor {
    public AccountResponse toResponse(Account entity) {
        AccountResponse response = new AccountResponse();
        response.setId(entity.getId());
        response.setUserId(Objects.nonNull(entity.getUsers().get(0)) ? entity.getUsers().get(0).getId() : null);
        response.setCreatedDate(entity.getCreatedDate());
        response.setUpdatedDate(entity.getUpdatedDate());
        response.setAccountName(entity.getAccountName());

        return response;
    }
    public Account toEntity(AccountRequest dto){
            Account account = new Account();
            account.setAccountName(dto.getAccountName());

            User user =new User();
            user.setId(dto.getUserId());

            account.setUsers(Collections.singletonList(user));
            return account;

    }
}
