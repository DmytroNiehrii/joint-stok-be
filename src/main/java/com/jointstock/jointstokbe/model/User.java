package com.jointstock.jointstokbe.model;

import lombok.*;
import javax.persistence.Entity;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {
    String firstname, lastname;

}

