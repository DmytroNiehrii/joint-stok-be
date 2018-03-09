package com.jointstock.jointstokbe.controllers;

import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.extra.CommunityCard;
import com.jointstock.jointstokbe.model.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@Transactional(transactionManager = "transactionManager")
@RequestMapping("/api")
@CrossOrigin
public class CommunityController {
    @Autowired
    CommunityRepository repository;
    @Autowired
    ConversionService conversionService;

    @RequestMapping("/community")
    public HttpEntity<Iterable<Community>> community() {
        Iterable<Community> communities = new ArrayList<>();
        communities = repository.findAll();

        return new ResponseEntity(communities, HttpStatus.OK);
    }

    @RequestMapping("/community/{id}")
    public HttpEntity<CommunityCard> getCommunityById(@PathVariable Long id) {
        Optional<Community> community = repository.findById(id);
        return new ResponseEntity(conversionService.convert(community.get(), CommunityCard.class), HttpStatus.OK);
    }
}
