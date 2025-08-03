package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "movies")
@Data
@ToString(callSuper = true, exclude = "actors")
public class Movie extends AbstractEntity {
    private String title;
    @Column(name = "year_of_release")
    private Integer yearOfRelease;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
}
