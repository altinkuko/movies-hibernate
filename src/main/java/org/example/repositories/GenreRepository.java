package org.example.repositories;

import org.example.entities.Genre;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class GenreRepository extends GenericRepository<Genre, Long> {
    private final Session session;

    public GenreRepository(Session session) {
        super(session, Genre.class);
        this.session = session;
    }

    public Genre findByName(String name) {
        String query = "select g from Genre g where g.name = :name";
        Query<Genre> findQuery = session.createQuery(query, Genre.class);
        findQuery.setParameter("name", name);
        return findQuery.getSingleResultOrNull();
    }

    public Genre save(Genre genre) {
        if (this.findByName(genre.getName()) == null) {
            return super.save(genre);
        } else {
            throw new RuntimeException(
                    String.format("Genre with name %s exists", genre.getName())
            );
        }
    }


}
