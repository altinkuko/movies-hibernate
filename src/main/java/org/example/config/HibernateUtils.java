package org.example.config;

import org.example.entities.Actor;
import org.example.entities.Genre;
import org.example.entities.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Actor.class);
            configuration.addAnnotatedClass(Movie.class);
            configuration.addAnnotatedClass(Genre.class);
            return configuration.buildSessionFactory();
        } else {
            return this.sessionFactory;
        }
    }
}
