package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.UserDto;
import com.belhard.bookstore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsersController implements Controller{
    private final UserService userService;
    @Override
    public String process(HttpServletRequest req) {
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        return "jsp/users.jsp";
    }
}
