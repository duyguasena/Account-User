package com.example.Account.User.controller;


import com.example.Account.User.dto.request.UserRequest;
import com.example.Account.User.dto.response.UserResponse;
import com.example.Account.User.service.UserService;
import com.example.Account.User.shared.UserEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserEndpoint.USERS)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest dto){
        return UserService.saveUser(dto);
    }
    @GetMapping("{id}")
    public  UserResponse getById(@PathVariable Long id){
        return userService.getById(id);
    }
    @GetMapping
    public List<UserResponse> getAll(){
        return userService.getAll();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @DeleteMapping("{name}")
    public void deleteByName(@RequestParam String name,@RequestParam String surname){
        userService.deleteByName(name,surname);
    }
    @PutMapping
    public UserResponse updateUser(@PathVariable Long id,@RequestBody UserRequest dto){
        return userService.updateUser(id,dto);
    }


}
