package com.jointstock.jointstokbe.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/user")
    public HttpEntity<User> user(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        User user = new User(String.format(TEMPLATE, name));
        user.add(linkTo(methodOn(UserController.class).user(name)).withSelfRel());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
