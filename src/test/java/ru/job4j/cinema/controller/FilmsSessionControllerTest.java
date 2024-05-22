package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.cinema.dto.FilmsSessionDto;
import ru.job4j.cinema.service.FilmSessionsService;

import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilmsSessionControllerTest {
    private FilmSessionsService filmSessionsService;

    private FilmsSessionController filmsSessionController;

    @BeforeEach
    public void initServices() {
        filmSessionsService = mock(FilmSessionsService.class);
        filmsSessionController = new FilmsSessionController(filmSessionsService);
    }

    @Test
    public void whenRequestSessionListPageThenGet() {
        var session1 = new FilmsSessionDto()
                .id(1)
                .filmName("test")
                .hallsName("test")
                .startTime(new Timestamp(13))
                .endTime(new Timestamp(15))
                .price(100)
                .rowCount(1)
                .placeCount(1);
        var session2 = new FilmsSessionDto()
                .id(2)
                .filmName("test1")
                .hallsName("test1")
                .startTime(new Timestamp(13))
                .endTime(new Timestamp(15))
                .price(200)
                .rowCount(2)
                .placeCount(2);
        var expectedSessions = List.of(session1, session2);
        when(filmSessionsService.findAll()).thenReturn(expectedSessions);

        var model = new ConcurrentModel();
        var view = filmsSessionController.getAll(model);
        var actualSessions = model.getAttribute("filmSession");

        assertThat(view).isEqualTo("filmSession/list");
        assertThat(actualSessions).isEqualTo(expectedSessions);
    }
}