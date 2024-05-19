package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmsSessionDto;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.FilmSessionsRepository;
import ru.job4j.cinema.repository.FilmsRepository;
import ru.job4j.cinema.repository.HallsRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@ThreadSafe
@Service
public class SimpleFilmSessionsService implements FilmSessionsService {
    private final FilmSessionsRepository filmSessionsRepository;

    private final FilmsRepository filmsRepository;

    private final HallsRepository hallsRepository;

    private SimpleFilmSessionsService(FilmSessionsRepository sql2oFilmSessionRepository,
                                      FilmsRepository sql2oFilmsRepository, HallsRepository sql2oHallsRepository) {
        this.filmSessionsRepository = sql2oFilmSessionRepository;
        this.filmsRepository = sql2oFilmsRepository;
        this.hallsRepository = sql2oHallsRepository;
    }

    @Override
    public Optional<FilmsSessionDto> findById(int id) {
        Optional<FilmsSessionDto> filmsSessionDto = Optional.empty();
        for (FilmsSessionDto filmSession: findAll()) {
            if (filmSession.getId() == id) {
                filmsSessionDto = Optional.of(filmSession);
            }
        }
        return filmsSessionDto;
    }

    @Override
    public Collection<FilmsSessionDto> findAll() {
        Collection<FilmsSessionDto> sessionDtoCollection = new ArrayList<>();
        for (FilmSession session:filmSessionsRepository.findAll()) {
            var filmName = filmsRepository.findById(session.getFilmId());
            var hallsName = hallsRepository.findById(session.getHallsId());
            var sessionDto = new FilmsSessionDto(
                    session.getId(),
                    filmName.get().getName(),
                    hallsName.getName(),
                    session.getStartTime(),
                    session.getEndTime(),
                    session.getPrice(),
                    hallsName.getRowCount(),
                    hallsName.getPlaceCount()
            );
            sessionDtoCollection.add(sessionDto);
        }
        return sessionDtoCollection;
    }
}
