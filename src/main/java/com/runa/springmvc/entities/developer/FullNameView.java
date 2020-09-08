package com.runa.springmvc.entities.developer;

import org.springframework.beans.factory.annotation.Value;

public interface FullNameView {
    
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

}
