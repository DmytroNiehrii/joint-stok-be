package com.jointstock.jointstokbe.model.extra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jointstock.jointstokbe.model.Community;
import com.jointstock.jointstokbe.model.User;

import java.sql.Timestamp;
import java.util.List;

public class UserCard {
    @JsonIgnore
    User user;

    public UserCard(User user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public Timestamp getCreatedDate() {
        return user.getCreatedDate();
    }

    public Timestamp getModifiedDate() {
        return user.getModifiedDate();
    }

    public String getFirstname() {
        return user.getFirstname();
    }

    public int getCommunityCount() {
        return user.getCommunityCount();
    }

    public String getLastname() {
        return user.getLastname();
    }

    public List<Community> getCommunities() {
        return user.getCommunities();
    }
}
