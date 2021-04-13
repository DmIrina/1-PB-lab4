package com.example.lab4.controller;

import com.example.lab4.model.Actor;
import com.example.lab4.model.DataService;

import java.io.*;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "allActorsServlet", value = "/actors")
public class AllActorsServlet extends HttpServlet {
    private DataService dataService;
    private HashSet<Actor> actors;

    public void init() {
        dataService = new DataService();
        dataService.initDB();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actors = dataService.getAllActors();
        request.setAttribute("actors", actors);
        request.getRequestDispatcher("WEB-INF/view/allActors.jsp").forward(request, response);
    }

    public void destroy() {
    }
}