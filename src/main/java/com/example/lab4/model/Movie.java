package com.example.lab4.model;


import java.util.HashSet;
import java.util.Objects;

public class Movie {

    private String title;
    private HashSet<Actor> actors;

    public Movie(String title){
        this.title = title;
        this.actors = new HashSet<>();
    }

    public void addActor(Actor actor) {
        if(this.getActors().contains(actor)){
            System.out.println("This movie already contains this actor");
            return;
        }
        actors.add(actor);
        if(!actor.getMovies().contains(this)){
            actor.addMovie(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public HashSet<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString(){
        return this.getTitle();
    }

}
