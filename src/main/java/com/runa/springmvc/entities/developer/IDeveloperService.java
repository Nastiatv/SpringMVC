package com.runa.springmvc.entities.developer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDeveloperService {

    DeveloperDto getDeveloperById(Long id);

    Page<DeveloperDto> getAllDevelopers(Pageable pageable);

    List<DeveloperDto> developerNameStartsWith(String firstLetter);

    List<FullNameView> getDeveloperByLastName(String lastName);

}