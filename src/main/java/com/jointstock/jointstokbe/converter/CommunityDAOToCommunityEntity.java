package com.jointstock.jointstokbe.converter;

import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.extra.CommunityCard;
import com.jointstock.jointstokbe.model.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class CommunityDAOToCommunityEntity implements Converter<Community, Community> {
    private CommunityRepository repository;

    public CommunityDAOToCommunityEntity(CommunityRepository repository) {
        this.repository = repository;
    }

    public Community convert(Community source) {
        Community community = repository.findById(source.getId()).get();

        community.setDescription(source.getDescription());
        community.setName(source.getName());

        return community;
    }
}
