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

    public SimpleFilmsService(FilmsRepository sql2oFilmsRepository, FileRepository sql2oFileRepository, GenresRepository sql2oGenresRepositiry) {
        this.filmsRepository = sql2oFilmsRepository;
        this.fileRepository = sql2oFileRepository;
        this.genresRepository = sql2oGenresRepositiry;
    }

    @Override
    public Optional<FilmDto> findById(int id) {
        Optional<FilmDto> filmDto = Optional.empty();
        for (FilmDto film : findAll()) {
            if (film.getId() == id) {
                filmDto = Optional.of(film);
                break;
            }
        }
        return filmDto;
    }

    @Override
    public Collection<FilmDto> findAll() {
        Collection<FilmDto> filmDtos = new ArrayList<>();
        for (Films film : filmsRepository.findAll()) {
            var genres = genresRepository.findById(film.getGenre());
            var files = fileRepository.findById(film.getFileId());
            var filmDto = new FilmDto()
                    .id(film.getId())
                    .name(film.getName())
                    .description(film.getDescription())
                    .year(film.getYear())
                    .minimalAge(film.getMinimalAge())
                    .durationInMinutes(film.getDurationInMinutes())
                    .genre(genres.getName())
                    .fileId(film.getFileId());
            filmDtos.add(filmDto);
        }
        return filmDtos;
    }
}
