package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "genres")
@Data
@ToString(callSuper = true, exclude = "movies")
public class Genre extends AbstractEntity{

    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;
}
