package com.jointstock.jointstokbe.services;

import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "transactionManager")
public class CommunityService {
    @Autowired
    private CommunityRepository repository;
    @Autowired
    ConversionService conversionService;

    @Transactional
    public Community save(Community entity) {
        // Add new
        if (entity.getId() == null) {
            return repository.save(entity);
        }

        // Update
        return repository.save(conversionService.convert(entity, Community.class));
    }
}
