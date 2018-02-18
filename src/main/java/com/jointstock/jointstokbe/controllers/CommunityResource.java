package com.jointstock.jointstokbe.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;

public class CommunityResource extends ResourceSupport {

    private final Iterable<Community> content;
    @Autowired
    CommunityRepository repository;

    @JsonCreator
    public CommunityResource(@JsonProperty("content") Iterable<Community> communities) {
        this.content = communities;
    }

    public Iterable<Community> getContent() {
        return content;
    }
}
