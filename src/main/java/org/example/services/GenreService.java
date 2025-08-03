package org.example.services;

import org.example.entities.Genre;
import org.example.repositories.GenreRepository;

import java.util.Scanner;

public class GenreService {
    private final GenreRepository genreRepository;
    private final Scanner scanner;

    public GenreService(GenreRepository genreRepository,
                        Scanner scanner) {
        this.genreRepository = genreRepository;
        this.scanner = scanner;
    }

    public Genre create() {
        System.out.println("Please input a name");
        String name = scanner.nextLine();
        Genre genre = new Genre();
        genre.setName(name);
        return genreRepository.save(genre);
    }

    public Genre update() {
        System.out.println(genreRepository.findAll());
        System.out.println("Please input an Id:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Genre genre = genreRepository.findById(id);
        if (genre == null) {
            System.out.println("Genre not found");
            return null;
        } else {
            System.out.println("Please input a new name:");
            String name = scanner.nextLine();
            genre.setName(name);
            return genreRepository.save(genre);
        }
    }
}
