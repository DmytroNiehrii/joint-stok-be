package com.jointstock.jointstokbe.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@ToString
@AllArgsConstructor
public class User /*extends AbstractEntity*/ {
    @Id
    @GeneratedValue Long id;
    public EntityId getId() {
        return new EntityId(id);
    }

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Value
    @Embeddable
    @RequiredArgsConstructor
    @SuppressWarnings("serial")
    public static class EntityId implements Serializable {

        private final Long customerId;

        EntityId() {
            this.customerId = null;
        }
    }

    String firstname, lastname;


    protected User() {
        this.firstname = null;
        this.lastname = null;
    }


}

