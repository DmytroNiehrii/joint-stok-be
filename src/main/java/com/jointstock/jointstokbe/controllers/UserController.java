package com.jointstock.jointstokbe.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.jointstock.jointstokbe.model.User;
import com.jointstock.jointstokbe.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@Transactional(transactionManager = "transactionManager")
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private static final String TEMPLATE = "Hello, %s!";

    @Autowired
    UserRepository repository;

    @RequestMapping("/user")
    public HttpEntity<UserResource> user() {
        List<User> users = new ArrayList<>();
        users = (ArrayList)repository.findAll();

        UserResource userResource = new UserResource(users);
        userResource.add(linkTo(methodOn(UserController.class).user()).withSelfRel());

        return new ResponseEntity<UserResource>(userResource, HttpStatus.OK);
    }


}
