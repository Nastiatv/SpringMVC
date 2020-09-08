package com.runa.springmvc.entities.developer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    @EntityGraph(value = "Developer.users")
    public Developer findDeveloperById(Long id);
    
    public Page<Developer> findAll(Pageable pageReq);
}

