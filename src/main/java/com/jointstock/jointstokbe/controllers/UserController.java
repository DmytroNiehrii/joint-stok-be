package com.jointstock.jointstokbe.controllers;

import com.jointstock.jointstokbe.model.User;
import com.jointstock.jointstokbe.model.extra.UserCard;
import com.jointstock.jointstokbe.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Transactional(transactionManager = "transactionManager")
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository repository;
    @Autowired
    ConversionService conversionService;

    @RequestMapping("/user")
    public HttpEntity<User> user() {
        List<User> users = new ArrayList<>();
        users = (ArrayList)repository.findAll();

        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping("/user/{id}")
    public HttpEntity<UserCard> getCommunityById(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        return new ResponseEntity(conversionService.convert(user.get(), UserCard.class), HttpStatus.OK);
    }
}
