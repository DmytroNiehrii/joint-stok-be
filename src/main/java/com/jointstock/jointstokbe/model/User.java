package com.jointstock.jointstokbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude="communities")
public class User extends AbstractEntity {
    String firstname, lastname;
    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    List<Community> communities = new ArrayList<>();

    public User(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getCommunityCount() {
        return communities.size();
    }
}

