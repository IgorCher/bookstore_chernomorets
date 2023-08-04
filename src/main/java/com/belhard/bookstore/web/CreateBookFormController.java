package com.belhard.bookstore.web;

import jakarta.servlet.http.HttpServletRequest;

public class CreateBookFormController implements Controller {
    @Override
    public String process(HttpServletRequest req) {
        return "jsp/bookForm.jsp";
    }
}
