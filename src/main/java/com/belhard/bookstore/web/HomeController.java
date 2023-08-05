package com.belhard.bookstore.web;

import jakarta.servlet.http.HttpServletRequest;

public class HomeController implements Controller{
    @Override
    public String process(HttpServletRequest req) {
        return "jsp/home.jsp";
    }
}
