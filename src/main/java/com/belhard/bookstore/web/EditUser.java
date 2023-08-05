package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.UserDto;
import com.belhard.bookstore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public class EditUser implements Controller {
    public final UserService userService;

    @Override
    public String process(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        UserDto user = new UserDto();
        user.setId(Long.parseLong(id));
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleDto(UserDto.RoleDto.valueOf(role));
        log.debug("prepare to update user");
        UserDto updated = userService.update(user);
        log.debug("user updated");
        req.setAttribute("user",updated);
        return "jsp/user.jsp";
    }
}
