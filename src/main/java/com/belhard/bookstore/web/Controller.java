package com.belhard.bookstore.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
    String process(HttpServletRequest req);
}
