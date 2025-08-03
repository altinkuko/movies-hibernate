package org.example;

import org.example.config.HibernateUtils;
import org.example.entities.Actor;
import org.example.entities.Genre;
import org.example.entities.Movie;
import org.example.repositories.ActorRepository;
import org.example.repositories.GenreRepository;
import org.example.repositories.MovieRepository;
import org.example.services.GenreService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        SessionFactory sessionFactory = hibernateUtils.getSessionFactory();
        SessionFactory sessionFactory2 = hibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        ActorRepository actorRepository = new ActorRepository(session);
        MovieRepository movieRepository = new MovieRepository(session);
        GenreRepository genreRepository = new GenreRepository(session);
        System.out.println(actorRepository.findAll());
        System.out.println(movieRepository.findAll());
//        Genre genre = new Genre();
//        genre.setName("Shqiptar");
//        genreRepository.save(genre);
//        System.out.println(genreRepository.findAll());
//        Movie movie = new Movie();
//        movie.setTitle("Skenderbeu");
//        movie.setYearOfRelease(1965);
//        Genre genre = genreRepository.findById(1L);
//        movie.setGenre(genre);
//        movieRepository.save(movie);
//        Actor actor = new Actor();
//        actor.setFirstName("Naim");
//        actor.setLastName("Frasheri");
//        actor.setYearOfBirth(1938);
//        Movie movie = movieRepository.findById(1L);
//        actor.addMovie(movie);
//        actorRepository.save(actor);
//        Scanner scanner = new Scanner(System.in);
//        GenreService genreService = new GenreService(genreRepository, scanner);
//        Genre genre = genreService.update();
//        System.out.println(genre);
    }
}