package com.belhard.bookstore.service;

import com.belhard.bookstore.dao.UserDao;
import com.belhard.bookstore.dao.UserDaoImpl;
import com.belhard.bookstore.dao.entity.User;
import com.belhard.bookstore.service.dto.UserDto;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public UserDto getById(long id) {
        User user = userDao.find(id);
        if (user == null) {
            throw new RuntimeException("User with id: " + id + "not found");
        }
        return toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userDao.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public UserDto create(UserDto userDto) {
        if (userDto.getEmail() == null && userDto.getLogin() == null && userDto.getPassword() == null) {
            throw new RuntimeException("Invalid information");
        }
        User entity = toEntity(userDto);
        User created = userDao.create(entity);
        return toDto(created);
    }

    @Override
    public UserDto update(UserDto userDto) {
        if (userDto.getEmail() == null && userDto.getLogin() == null && userDto.getPassword() == null) {
            throw new RuntimeException("Invalid information");
        }
        User entity = toEntity(userDto);
        User updated = userDao.update(entity);
        return toDto(updated);
    }

    @Override
    public void delete(long id) {
        if (!userDao.delete(id)) {
            throw new RuntimeException("User with id: " + id + "not found");
        }
    }

    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRoleDto(UserDto.RoleDto.valueOf(user.getRole().toString()));
        return userDto;
    }

    private User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setRole(User.Role.valueOf(userDto.getRoleDto().toString()));
        return user;
    }
}
