package ru.job4j.cinema.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmDto;
import ru.job4j.cinema.model.Films;
import ru.job4j.cinema.repository.FileRepository;
import ru.job4j.cinema.repository.FilmsRepository;
import ru.job4j.cinema.repository.GenresRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class SimpleFilmsService implements FilmsService {
    private final FilmsRepository filmsRepository;

    private final FileRepository fileRepository;

    private final GenresRepository genresRepository;

    private SimpleFilmsService(FilmsRepository sql2oFilmsRepository, FileRepository sql2oFileRepository, GenresRepository sql2oGenresRepositiry) {
        this.filmsRepository = sql2oFilmsRepository;
        this.fileRepository = sql2oFileRepository;
        this.genresRepository = sql2oGenresRepositiry;
    }

    @Override
    public Optional<FilmDto> findById(int id) {
        Optional<FilmDto> filmDto = Optional.empty();
        for(FilmDto film: findAll()) {
            if(film.getId() == id) {
                filmDto = Optional.of(film);
                break;
            }
        }
        return filmDto;
    }

    @Override
    public Collection<FilmDto> findAll() {
        Collection<FilmDto> filmDtos = new ArrayList<>();
        for(Films films:filmsRepository.findAll()) {
            var genres = genresRepository.findById(films.getGenre());
            var files = fileRepository.findById(films.getFileId());
            var filmDto = new FilmDto(
                    films.getId(),
                    films.getName(),
                    films.getDescription(),
                    films.getYear(),
                    films.getMinimalAge(),
                    films.getDurationInMinutes(),
                    genres.getName(),
                    films.getFileId());
                    filmDtos.add(filmDto);
        }
        return filmDtos;
    }
}
