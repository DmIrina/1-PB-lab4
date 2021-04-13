package com.example.lab4.controller;

import com.example.lab4.model.Actor;
import com.example.lab4.model.DataService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

@WebServlet(name = "ColleaguesServlet", value = "/partners")
public class ColleaguesServlet extends HttpServlet {
    private HashMap<Integer, Actor> partners;
    private DataService dataService;

    public void init() {
        dataService = new DataService();
        dataService.initDB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Actor actor = dataService.getActorByName(request.getParameter("name"));
        partners = dataService.moviePartners(actor);
        request.setAttribute("partners", partners);
        request.getRequestDispatcher("WEB-INF/view/partners.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
