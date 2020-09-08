package com.runa.springmvc.entities.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return UserDto.convertList(userRepository.getAll());
    }

    @Override
    public List<UserDto> saveOrUpdateUser(User user) {
        userRepository.saveOrUpdate(user);
        return getAllUsers();

    }

    @Override
    public List<UserDto> deleteUser(Long userId) {
        userRepository.delete(userId);
        return getAllUsers();
    }

    @Override
    public UserDto getUser(Long userId) {
        return UserDto.entityToDto(
                userRepository.get(userId));
    }
}
