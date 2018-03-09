package com.jointstock.jointstokbe.model.repository;

import com.jointstock.jointstokbe.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByLastname(String lastname);
}
