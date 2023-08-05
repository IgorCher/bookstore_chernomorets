package com.belhard.bookstore.web;

import com.belhard.bookstore.data.dto.UserDto;
import com.belhard.bookstore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeleteUserController implements Controller {
    public final UserService userService;

    @Override
    public String process(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        userService.delete(id);
        List<UserDto> users = userService.getAll();
        req.setAttribute("users", users);
        return "jsp/users.jsp";
    }
}
