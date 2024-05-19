package ru.job4j.cinema.service;

import ru.job4j.cinema.model.Genres;

import java.util.Collection;

public interface GenresService {
    Collection<Genres> findAll();
}
