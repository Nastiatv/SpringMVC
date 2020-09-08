package com.runa.springmvc.entities.developer;

import com.runa.springmvc.entities.user.UserDto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeveloperDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<UserDto> users;

    public static List<DeveloperDto> convertList(List<Developer> developers) {
        List<DeveloperDto> listDto = new ArrayList<>();
        for (Developer developer : developers) {
            DeveloperDto dto = new DeveloperDto();
            dto.setId(developer.getId());
            dto.setFirstName(developer.getFirstName());
            dto.setLastName(developer.getLastName());
            listDto.add(dto);
        }
        return listDto;
    }

    public static DeveloperDto entityToDto(Developer entity) {
        DeveloperDto dto = new DeveloperDto();
        dto.setId(entity.getId());
        if (entity.getId() != null) {
            dto.setId(entity.getId());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setUsers(UserDto.convertList(entity.getUsers()));        
        } else {
            dto.setId(null);
        }
        return dto;
    }

    public static Developer dtoToEntity(DeveloperDto dto) {
        Developer entity = new Developer();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }
}