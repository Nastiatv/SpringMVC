package com.runa.springmvc.entities.developer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDeveloperService {

    DeveloperDto getDeveloperById(Long id);

    Page<DeveloperDto> getAllDevelopers(Pageable pageable);

}