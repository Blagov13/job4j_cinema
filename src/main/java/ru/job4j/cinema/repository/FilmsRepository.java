package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Films;

import java.util.Collection;
import java.util.Optional;

public interface FilmsRepository {

    Optional<Films> findById(int id);

    Collection<Films> findAll();
}
