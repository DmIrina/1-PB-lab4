package com.example.lab4.controller;

import com.example.lab4.model.Actor;
import com.example.lab4.model.DataService;
import com.example.lab4.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "BestMovieServlet", value = "/bestmovie")
public class BestMovieServlet extends HttpServlet {
    private DataService dataService;
    private HashSet<Movie> movies;

    public void init() {
        dataService = new DataService();
        dataService.initDB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        movies = dataService.maxActorsMovie();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("WEB-INF/view/bestMovies.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void destroy() {
    }
}
