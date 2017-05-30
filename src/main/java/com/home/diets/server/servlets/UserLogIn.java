package com.home.diets.server.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.home.diets.db.models.User;
import com.home.diets.db.services.UserService;
import com.home.diets.db.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by user on 28.05.2017.
 */
public class UserLogIn extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        login(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        login(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImpl();
        User user = userService.logIn(login, password);

        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        out.write(gson.toJson(user));
        out.flush();
    }
}
