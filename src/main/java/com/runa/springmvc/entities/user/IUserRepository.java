package com.runa.springmvc.entities.user;

import java.util.List;

public interface IUserRepository {

    void saveOrUpdate(User user);

    void delete(Long userId);

    User get(Long userId);

    List<User> getAll();
}
