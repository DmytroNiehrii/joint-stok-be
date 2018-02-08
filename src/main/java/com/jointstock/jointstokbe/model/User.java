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
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {
    String firstname, lastname;

}

