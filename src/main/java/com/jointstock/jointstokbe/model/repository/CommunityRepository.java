package com.jointstock.jointstokbe.model.repository;

import com.jointstock.jointstokbe.model.Community;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommunityRepository extends CrudRepository<Community, Long> {
    Optional<Community> findById(Long id);
    Optional<Community> findByName(String name);
}
