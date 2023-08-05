package com.belhard.bookstore.web;

import com.belhard.bookstore.data.connection.ConnectionManager;
import com.belhard.bookstore.data.connection.impl.ConnectionManagerImpl;
import com.belhard.bookstore.data.dao.impl.UserDaoImpl;
import com.belhard.bookstore.data.dto.UserDto;
import com.belhard.bookstore.platform.ConfigurationManager;
import com.belhard.bookstore.platform.impl.ConfigurationManagerImpl;
import com.belhard.bookstore.service.UserService;
import com.belhard.bookstore.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@RequiredArgsConstructor
@Log4j2
public class UserController implements Controller{
    private final UserService userService;


    @Override
    public String process(HttpServletRequest req){
            String idRaw = req.getParameter("id");
            Long id = Long.valueOf(idRaw);
            UserDto userDto = userService.getById(id);
            req.setAttribute("user",userDto);
            return "jsp/user.jsp";
    }
}
