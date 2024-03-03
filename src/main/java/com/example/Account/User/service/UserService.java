package com.example.Account.User.service;

import com.example.Account.User.convertor.UserConvertor;
import com.example.Account.User.dto.request.UserRequest;
import com.example.Account.User.dto.response.AccountResponse;
import com.example.Account.User.dto.response.UserResponse;
import com.example.Account.User.model.Account;
import com.example.Account.User.model.User;
import com.example.Account.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserConvertor userConvertor;
    public static UserResponse saveUser(UserRequest dto) {

        User entity=userConvertor.toEntity(dto);
        User saveUser=userRepository.save(entity);
        return userConvertor.toResponse(saveUser);


    }

    public UserResponse getById(Long id) {
        Optional<User> optUser=userRepository.findById(id);
        User user= optUser.orElseThrow(()->new RuntimeException("Id bulunamadı"));
        return userConvertor.toResponse(user);

    }

    public List<UserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userConvertor::toResponse)
                .collect(Collectors.toList());

    }

    public void deleteUser(Long id) {
        User user=userRepository.deleteById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı!"));

        userRepository.deleteById(id);

    }

    public void deleteByName(String name,String surname) {
        if(Objects.isNull(name)&&Objects.isNull(surname)){
            throw new RuntimeException("Silinecek kullanıcı adını ve soyadını giriniz");
        }else {
            User user =userRepository.findByNameandSurname(name,surname);
            userRepository.delete(user);
        }

    }

    public UserResponse updateUser(Long id, UserRequest dto) {
        User theRealUser =userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Id bulunamadı"));

        if (Objects.nonNull(dto.getName())){
            theRealUser.setName(dto.getName());
        }
        if (Objects.nonNull(dto.getSurname())){
            theRealUser.setSurname(dto.getSurname());
        }
        if (Objects.nonNull(dto.getEmail())){
            theRealUser.setEmail(dto.getEmail());
        }
        if (Objects.nonNull(dto.getPassword())){
            theRealUser.setPassword(dto.getPassword());
        }
        if (Objects.nonNull(dto.getPhoneNumber())){
            theRealUser.setPhoneNumber(dto.getPhoneNumber());
        }
        return userConvertor
                .toResponse( userRepository.save(theRealUser));

    }

    public UserResponse updateAccountId(Long userId, AccountResponse response) {
        User theRealUser=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("Id bulunamadı!"));

        Account account=new Account();
        account.setId(response.getId());
        theRealUser.setAccount(account);

        return userConvertor.toResponse(userRepository.save(theRealUser));

    }
}
