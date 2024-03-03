package com.example.Account.User.convertor;

import com.example.Account.User.dto.request.UserRequest;
import com.example.Account.User.dto.response.UserResponse;
import com.example.Account.User.model.User;

import java.util.Objects;

public class UserConvertor {

    public UserResponse toResponse(User entity){
        UserResponse userResponse=new UserResponse();
        userResponse.setId(entity.getId());
        userResponse.setAccountId(Objects.isNull(entity.getAccount())?null:entity.getAccount().getId()));
        userResponse.setName(entity.getName());
        userResponse.setPassword(entity.getPassword());
        userResponse.setSurname(entity.getSurname());
        userResponse.setEmail(entity.getEmail());
        userResponse.setPhoneNumber(entity.getPhoneNumber());
        userResponse.setCreatedDate(entity.getCreatedDate());// TODO buraya ayrı convertor gelebilir
        userResponse.setUpdatedDate(entity.getUpdatedDate());
        return userResponse;

    }
    public User toEntity(UserRequest dto){
        User user=new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
