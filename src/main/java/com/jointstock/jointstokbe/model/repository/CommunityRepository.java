package com.jointstock.jointstokbe.model.repository;

import com.jointstock.jointstokbe.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CommunityRepository extends CrudRepository<Community, Long> {
    /*Optional<Community> findById(Long id);
    Optional<Community> findByName(String name);*/
}
