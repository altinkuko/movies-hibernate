package org.example.repositories;

import org.example.entities.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MovieRepository extends GenericRepository<Movie, Long>{
    private final Session session;

    public MovieRepository(Session session) {
        super(session, Movie.class);
        this.session = session;
    }

    public List<Movie> findByTitle(String title) {
        String query = "select m from Movie m where m.title like :title";
        Query<Movie> findQuery = session.createQuery(query, Movie.class);
        findQuery.setParameter("title", "%"+title+"%");
        return findQuery.getResultList();
    }

    public List<Movie> findByActor(Long actorId) {
        String query = "select a.movies from Actor a where a.id = :id";
        Query<Movie> findQuery = session.createQuery(query, Movie.class);
        findQuery.setParameter("id", actorId);
        return findQuery.getResultList();
    }
}
