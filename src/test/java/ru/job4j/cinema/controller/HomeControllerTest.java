package ru.job4j.cinema.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.assertj.core.api.Assertions.*;

class HomeControllerTest {
    @Test
    public void whenRequestIndexPageThenGetPage() {
        HomeController homeController = new HomeController();
        var model = new ConcurrentModel();
        var view = homeController.getHome(model);
        assertThat(view).isEqualTo("index");
    }
}