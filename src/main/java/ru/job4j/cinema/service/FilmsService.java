package ru.job4j.cinema.service;

import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.dto.FilmDto;
import ru.job4j.cinema.model.Films;

import java.util.Collection;
import java.util.Optional;

public interface FilmsService {
    Optional<FilmDto> findById(int id);

    Collection<FilmDto> findAll();
}
