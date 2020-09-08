package com.runa.springmvc.entities.user;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String address;

    public static List<UserDto> convertList(List<User> users) {
        List<UserDto> listDto = new ArrayList<>();
        for (User user : users) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setAddress(user.getAddress());
            dto.setEmail(user.getEmail());
            listDto.add(dto);
        }
        return listDto;
    }

    public static UserDto entityToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        if (entity.getId() != null) {
            dto.setId(entity.getId());
            dto.setAddress(entity.getAddress());
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
        } else {
            dto.setId(null);
        }
        return dto;
    }

    public static User dtoToEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}