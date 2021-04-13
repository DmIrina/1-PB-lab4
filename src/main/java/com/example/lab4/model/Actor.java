package com.example.lab4.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class Actor implements Serializable {

    private String name;
    private HashSet<Movie> movies;

    public Actor(){
        this.name = "name";
        this.movies = new HashSet<>();
    }

    public Actor(String name){
        this.name = name;
        this.movies = new HashSet<>();
    }

    public void addMovie (Movie movie){
        if(this.getMovies().contains(movie)){
            System.out.println("This movie is already in this actor");
            return;
        }
        movies.add(movie);
        if(!movie.getActors().contains(this)){
            movie.addActor(this);
        }
    }

    public String getName() {
        return name;
    }

    public HashSet<Movie> getMovies() {
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
