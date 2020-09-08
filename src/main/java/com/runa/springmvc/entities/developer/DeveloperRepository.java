package com.runa.springmvc.entities.developer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>, JpaSpecificationExecutor<Developer> {

    @EntityGraph(value = "Developer.users")
    public Developer findDeveloperById(Long id);

    public Page<Developer> findAll(Pageable pageReq);

    @Query(name = "Developer.getFullNameView", nativeQuery = true)
    public List<FullNameView> getDeveloperByLastName(String lastName);    
    
//    @Query(value = "SELECT * FROM developer WHERE id>2 and last_name=:lastName",nativeQuery = true)
//    public List<FullNameView> getDeveloperByLastNameAndId(@Param("lastName")String lastName);    
}    
