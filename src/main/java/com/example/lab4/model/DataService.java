package com.example.lab4.model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DataService {
    DataBase dataBase = new DataBase();
    Actor john = new Actor("John");
    Actor bella = new Actor("Bella");
    Actor igor = new Actor("Igor");
    Actor mary = new Actor("Mary");
    Actor kate = new Actor("Kate");

    Movie predator = new Movie("Predator");
    Movie madmax = new Movie("MadMax");

    public void initDB(){
        dataBase.addActor(john);
        dataBase.addActor(bella);
        dataBase.addActor(igor);
        dataBase.addActor(mary);
        dataBase.addActor(kate);

        dataBase.addMovie(predator);
        dataBase.addMovie(madmax);

        predator.addActor(john);
        predator.addActor(bella);

        bella.addMovie(madmax);
        igor.addMovie(madmax);
    }

    public boolean isActorWithoutMovie (DataBase dataBase){
        if(dataBase == null) {
            throw new IllegalArgumentException("DataBase must not be null");
        }
        Iterator<Actor> actorIterator = dataBase.getActors().iterator();
        while (actorIterator.hasNext()){
            if (actorIterator.next().getMovies().isEmpty()) return true;
        }
        return  false;
    }

    public HashSet<Actor> getActorsWithoutMovie (DataBase dataBase){
        if(dataBase == null) {
            throw new IllegalArgumentException("DataBase must not be null");
        }
        HashSet <Actor> unemployed = new HashSet<>();

        Iterator<Actor> actorIterator = dataBase.getActors().iterator();
        while (actorIterator.hasNext()){
            Actor actor = actorIterator.next();
            if (actor.getMovies().isEmpty()){
                unemployed.add(actor);
            }
        }
        return unemployed;
    }

    public HashMap<Integer, Actor> moviePartners (Actor actor){
        if (actor == null) {
            throw new IllegalArgumentException("Actor must not be null");
        }
        HashMap<Integer, Actor> partners = new HashMap<>();
        for (Movie actorsMovie : actor.getMovies()) {
            for (Actor partner : actorsMovie.getActors()) {
                if (!partner.equals(actor)) {
                    partners.put(partner.hashCode(), partner);
                }
            }
        }
        return partners;
    }

    public HashSet<Movie> maxActorsMovie(DataBase dataBase){
        HashSet<Movie> movies = new HashSet<>();
        if (dataBase == null) {
            throw new IllegalArgumentException("DataBase must not be null");
        }
        int maxActors = 0;

        for (Iterator<Movie> i = dataBase.getMovies().iterator(); i.hasNext(); ) {
            Movie movie = i.next();
            if (movie.getActors().size() > maxActors) {
                maxActors = movie.getActors().size();
                movies.clear();
            }
            if(movie.getActors().size() == maxActors){
                movies.add(movie);
            }
        }
        return movies;
    }
}
