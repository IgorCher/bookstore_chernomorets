package com.belhard.bookstore.web;

import jakarta.servlet.http.HttpServletRequest;

public class CreateUserFormController implements Controller{
    @Override
    public String process(HttpServletRequest req) {
        return "jsp/userForm.jsp";
    }
}
