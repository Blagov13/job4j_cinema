package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Genres;

import java.util.Collection;

public interface GenresRepository {
    Genres findById(int id);
}
