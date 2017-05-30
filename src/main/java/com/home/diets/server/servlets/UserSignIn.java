package com.home.diets.server.servlets;

import com.google.gson.Gson;
import com.home.diets.db.models.User;
import com.home.diets.db.services.UserService;
import com.home.diets.db.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 28.05.2017.
 */
public class UserSignIn extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        super.doGet(req, resp);

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImpl();
        userService.signIn(login, password);
    }
}
