package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends AbstractEntity {
    @Column(name = "name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "year_of_birth")
    private Integer yearOfBirth;
    @ManyToMany
    @JoinTable(name = "actors_to_movies")
    private List<Movie> movies;

    public void addMovie(Movie movie) {
        if (this.getMovies() == null || this.getMovies().isEmpty()) {
            List<Movie> movieList = new ArrayList<>();
            movieList.add(movie);
            this.setMovies(movieList);
        } else {
            this.getMovies().add(movie);
        }
    }
}
