package com.jointstock.jointstokbe.model;

import java.sql.Timestamp;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EqualsAndHashCode(of = "id")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Id
    @GeneratedValue protected Long id;

    protected Timestamp createdDate;
    protected Timestamp modifiedDate;
    @Version
    private long version;

    @PrePersist
    public void prePersist() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdDate = now;
        this.modifiedDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = new Timestamp(System.currentTimeMillis());
    }
}
