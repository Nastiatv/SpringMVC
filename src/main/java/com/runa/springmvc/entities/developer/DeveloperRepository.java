package com.runa.springmvc.entities.developer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>, JpaSpecificationExecutor<Developer> {

    @EntityGraph(value = "Developer.users")
    public Developer findDeveloperById(Long id);

    public Page<Developer> findAll(Pageable pageReq);

    public List<NameView> getDeveloperByLastName(String lastName);
}    
