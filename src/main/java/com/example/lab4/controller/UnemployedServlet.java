package com.example.lab4.controller;

import com.example.lab4.model.Actor;
import com.example.lab4.model.DataService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "UnemployedServlet", value = "/unemployed")
public class UnemployedServlet extends HttpServlet {
    private DataService dataService;
    private HashSet<Actor> unemployed;
    private boolean isUnemployed;

    public void init() {
        dataService = new DataService();
        dataService.initDB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        unemployed = dataService.getActorsWithoutMovie();
        isUnemployed = dataService.isActorWithoutMovie();
        request.setAttribute("unemployed", unemployed);
        request.setAttribute("isUnemployed", isUnemployed);
        request.getRequestDispatcher("WEB-INF/view/unemployedActors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void destroy() {
    }
}
