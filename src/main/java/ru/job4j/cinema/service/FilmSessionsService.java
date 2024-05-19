package ru.job4j.cinema.service;

import ru.job4j.cinema.dto.FilmsSessionDto;
import ru.job4j.cinema.model.FilmSession;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionsService {
    Optional<FilmsSessionDto> findById(int id);

    Collection<FilmsSessionDto> findAll();
}
