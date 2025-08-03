package org.example.repositories;

import org.example.entities.Actor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ActorRepository extends GenericRepository<Actor, Long>{
    private final Session session;

    public ActorRepository(Session session) {
        super(session, Actor.class);
        this.session = session;
    }

    public List<Actor> findByBirthYear(Integer year) {
        String query = "select a from Actor a where a.yearOfBirth > :year";
        Query<Actor> findQuery = session.createQuery(query, Actor.class);
        findQuery.setParameter("year", year);
        return findQuery.getResultList();
    }

    public List<Actor> findByFirstName(String name) {
        String query = "select a from Actor a where a.firstName like :name";
        Query<Actor> findQuery = session.createQuery(query, Actor.class);
        findQuery.setParameter("name", "%" + name);
        return findQuery.getResultList();
    }
}
