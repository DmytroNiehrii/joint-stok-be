package com.jointstock.jointstokbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Version;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommunityCard {
    @JsonIgnore
    Community community;

    /*Long id;
    Timestamp createdDate;
    Timestamp modifiedDate;
    long version;
    String name, description;
    List<User> members = new ArrayList<>();*/

    public CommunityCard(Community community) {
        this.community = community;
    }

    public Long getId() {
        return community.getId();
    }

    public Timestamp getCreatedDate() {
        return community.getCreatedDate();
    }

    public Timestamp getModifiedDate() {
        return community.getModifiedDate();
    }

    public String getName() {
        return community.getName();
    }

    public String getDescription() {
        return community.getDescription();
    }

    public List<User> getMembers() {
        return community.getMembers();
    }
}
