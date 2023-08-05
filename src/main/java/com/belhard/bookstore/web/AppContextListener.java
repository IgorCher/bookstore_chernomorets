package com.belhard.bookstore.web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Servlet Context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ControllerFactory.INSTANCE.close();
        log.info("Servlet Context destroyed");
    }
}
