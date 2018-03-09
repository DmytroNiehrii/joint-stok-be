package com.jointstock.jointstokbe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "members")
public class Community extends AbstractEntity {
    String name, description;
    @OneToOne
    User createdBy;

    @ManyToMany
    @JsonIgnore
    List<User> members = new ArrayList<>();

    public Community(String name, User createdBy) {
        super();
        this.name = name;
        this.createdBy = createdBy;
    }

    public int getMemberCount() {
        return members.size();
    }
}

