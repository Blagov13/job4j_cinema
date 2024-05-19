package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.service.FilmsService;

@Controller
@RequestMapping("/filmsMap")
public class FilmsController {
    private final FilmsService filmsService;

    public FilmsController(FilmsService filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("class_active", "filmsMap");
        model.addAttribute("filmsMap", filmsService.findAll());
        return "filmsMap/list";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable int id) {
        var filmOptionalDto = filmsService.findById(id);
        if (filmOptionalDto.isEmpty()) {
            model.addAttribute("message", "Фильма с указанными id не сущестует");
            return "errors/404";
        }
        model.addAttribute("film", filmOptionalDto.get());
        return "filmsMap/one";
    }
}
