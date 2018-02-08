package com.jointstock.jointstokbe.controllers;

import com.jointstock.jointstokbe.model.User;
import com.jointstock.jointstokbe.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

public class UserResource extends ResourceSupport {

    private final Iterable<User> content;
    @Autowired
    UserRepository repository;

    @JsonCreator
    public UserResource(@JsonProperty("content") Iterable<User> users) {
        this.content = users;
    }

    public Iterable<User> getContent() {
        return content;
    }
}
