package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.UserDto;
import com.belhard.bookstore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUser implements Controller {
    public final UserService userService;

    @Override
    public String process(HttpServletRequest req) {
        String name = req.getParameter("name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        UserDto user = new UserDto();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleDto(UserDto.RoleDto.valueOf(role));
        UserDto created = userService.create(user);
        req.setAttribute("user",created);
        return "jsp/user.jsp";
    }
}
