package com.jointstock.jointstokbe.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(of = "id")
public class AbstractEntity {
    @Id
    @GeneratedValue Long id;

    @CreatedDate
    LocalDateTime createdDate;
    @LastModifiedDate
    LocalDateTime modifiedDate;

    public EntityId getId() {
        return new EntityId(id);
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
}
