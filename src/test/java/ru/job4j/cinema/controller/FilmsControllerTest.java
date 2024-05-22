package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.cinema.dto.FilmDto;
import ru.job4j.cinema.service.FilmsService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class FilmsControllerTest {

    private FilmsService filmsService;

    private FilmsController filmsController;

    @BeforeEach
    public void initServices() {
        filmsService = mock(FilmsService.class);
        filmsController = new FilmsController(filmsService);
    }

    @Test
    public void whenRequestFilmListPageThenGet() {
        var film1 = new FilmDto()
                .id(1)
                .name("test")
                .description("test")
                .year(2000)
                .minimalAge(1)
                .durationInMinutes(12)
                .genre("genre")
                .fileId(1);
        var film2 = new FilmDto()
                .id(2)
                .name("test")
                .description("test")
                .year(2000)
                .minimalAge(2)
                .durationInMinutes(13)
                .genre("genre1")
                .fileId(2);
        var expectedFilms = List.of(film1, film2);
        when(filmsService.findAll()).thenReturn(expectedFilms);

        var model = new ConcurrentModel();
        var view = filmsController.getAll(model);
        var actualFilms = model.getAttribute("filmsMap");

        assertThat(view).isEqualTo("filmsMap/list");
        assertThat(actualFilms).isEqualTo(expectedFilms);
    }

    @Test
    public void whenRequestFilmPageByIdAndThenGetPage() {
        int id = 5;
        var candidate = new FilmDto()
                .id(1)
                .name("test")
                .description("test")
                .year(2000)
                .minimalAge(1)
                .durationInMinutes(12)
                .genre("genre")
                .fileId(1);
        var idArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        when(filmsService.findById(idArgumentCaptor.capture())).thenReturn(Optional.of(candidate));

        var model = new ConcurrentModel();
        var view = filmsController.getById(model, id);
        var actualId = idArgumentCaptor.getValue();

        assertThat(view).isEqualTo("filmsMap/one");
        assertThat(actualId).isEqualTo(id);
    }

    @Test
    public void whenSomeErrorWhileGetByIdThenGetErrorPageWithMessage() {
        when(filmsService.findById(anyInt())).thenReturn(Optional.empty());

        var model = new ConcurrentModel();
        var view = filmsController.getById(model, 0);
        var message = model.getAttribute("message");

        assertThat(view).isEqualTo("errors/404");
        assertThat(message).isEqualTo("Фильма с указанными id не сущестует");
    }
}