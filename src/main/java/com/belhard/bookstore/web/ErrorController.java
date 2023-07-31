package com.belhard.bookstore.web;

import jakarta.servlet.http.HttpServletRequest;

public class ErrorController implements Controller{
    @Override
    public String process(HttpServletRequest req) {
        return "jsp/error.jsp";
    }
}
