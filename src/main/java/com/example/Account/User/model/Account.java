package com.example.Account.User.model;

import com.example.Account.User.core.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Account extends BaseModel {
    private String accountName;

    @OneToMany(mappedBy = "account",cascade = CascadeType.MERGE,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<User> users=new ArrayList<>();
}
