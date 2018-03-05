package com.jointstock.jointstokbe.controllers;

import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.CommunityCard;
import com.jointstock.jointstokbe.model.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@Transactional(transactionManager = "transactionManager")
@RequestMapping("/api")
@CrossOrigin
public class CommunityController {

    @Autowired
    CommunityRepository repository;

    @RequestMapping("/community")
    public HttpEntity<CommunityResource> user() {
        List<Community> communities = new ArrayList<>();
        communities = (ArrayList)repository.findAll();

        CommunityResource communityListResource = new CommunityResource(communities);
        communityListResource.add(linkTo(methodOn(CommunityController.class).user()).withSelfRel());

        return new ResponseEntity<CommunityResource>(communityListResource, HttpStatus.OK);
    }

    @RequestMapping("/community/{id}")
    public HttpEntity<CommunityCard> getCommunityById(@PathVariable Long id) {
        Optional<Community> community = repository.findById(id);
        return new ResponseEntity<CommunityCard>(new CommunityCard(community.get()), HttpStatus.OK);

    }
}
