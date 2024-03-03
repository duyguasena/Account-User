package com.example.Account.User.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
}
