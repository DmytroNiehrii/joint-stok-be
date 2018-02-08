package com.jointstock.jointstokbe.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@EqualsAndHashCode(of = "id")
public class AbstractEntity {
    @Id
    @GeneratedValue protected Long id;

    @CreatedDate
    protected LocalDateTime createdDate;
    @LastModifiedDate
    protected LocalDateTime modifiedDate;

    public EntityId getId() {
        return new EntityId(id);
    }

    @Value
    @Embeddable
    @RequiredArgsConstructor
    @SuppressWarnings("serial")
    public static class EntityId implements Serializable {

        private final Long entityId;

        EntityId() {
            this.entityId = null;
        }
    }
}
