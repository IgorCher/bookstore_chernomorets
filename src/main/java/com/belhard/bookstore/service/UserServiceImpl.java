package com.belhard.bookstore.service;

import com.belhard.bookstore.dao.UserDao;
import com.belhard.bookstore.dao.UserDaoImpl;
import com.belhard.bookstore.dao.entity.User;
import com.belhard.bookstore.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public UserDto getById(long id) {
        log.debug("Service method running");
        User user = userDao.find(id);
        if (user == null) {
            throw new RuntimeException("User with id: " + id + "not found");
        }
        return toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        log.debug("Service method running");
        return userDao.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public UserDto create(UserDto userDto) {
        log.debug("Service method running");
        if (userDto.getEmail() == null && userDto.getLogin() == null && userDto.getPassword() == null) {
            throw new RuntimeException("Invalid information");
        }
        User entity = toEntity(userDto);
        User created = userDao.create(entity);
        return toDto(created);
    }

    @Override
    public UserDto update(UserDto userDto) {
        log.debug("Service method running");
        if (userDto.getEmail() == null && userDto.getLogin() == null && userDto.getPassword() == null) {
            throw new RuntimeException("Invalid information");
        }
        User entity = toEntity(userDto);
        User updated = userDao.update(entity);
        return toDto(updated);
    }

    @Override
    public void delete(long id) {
        log.debug("Service method running");
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
