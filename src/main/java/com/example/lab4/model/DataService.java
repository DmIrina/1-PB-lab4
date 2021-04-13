package com.example.lab4.model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class DataService {
    DataBase dataBase = new DataBase();
    Actor john = new Actor("John");
    Actor bella = new Actor("Bella");
    Actor igor = new Actor("Igor");
    Actor jack = new Actor("Jack");
    Actor levi = new Actor("Levi");
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
        dataBase.addActor(jack);
        dataBase.addActor(levi);

        dataBase.addMovie(predator);
        dataBase.addMovie(madmax);

        predator.addActor(john);
        predator.addActor(bella);
        predator.addActor(levi);

        bella.addMovie(madmax);
        igor.addMovie(madmax);
    }

    public HashSet<Actor> getAllActors (){
        return dataBase.getActors();
    }

    public boolean isActorWithoutMovie (){
        Iterator<Actor> actorIterator = dataBase.getActors().iterator();
        while (actorIterator.hasNext()){
            if (actorIterator.next().getMovies().isEmpty()) return true;
        }
        return false;
    }

    public HashSet<Actor> getActorsWithoutMovie (){
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

    public HashSet<Movie> maxActorsMovie(){
        HashSet<Movie> movies = new HashSet<>();
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

    public Actor getActorByName(String name){
        Actor actor = new Actor();
        HashSet<Actor> actors = dataBase.getActors();

        for (Iterator<Actor> it = actors.iterator(); it.hasNext(); ) {
            Actor a = it.next();
            if (a.getName().equalsIgnoreCase(name))
                actor = a;
        }
        return actor;
    }
}
