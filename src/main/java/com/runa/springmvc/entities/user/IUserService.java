package com.runa.springmvc.entities.user;

import java.util.List;

public interface IUserService {


    UserDto getUser(Long userId);

    List<UserDto> deleteUser(Long userId);

    List<UserDto> saveOrUpdateUser(User user);

    List<UserDto> getAllUsers();

}
