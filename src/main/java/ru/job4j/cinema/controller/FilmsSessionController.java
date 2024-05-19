package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.FilmSessionsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/filmSession")
public class FilmsSessionController {
    private final FilmSessionsService filmSessionsService;

    public FilmsSessionController(FilmSessionsService filmSessionsService) {
        this.filmSessionsService = filmSessionsService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("class_active", "filmSession");
        model.addAttribute("filmSession", filmSessionsService.findAll());
        return "filmSession/list";
    }

    @GetMapping("/create/{id}")
    public String getById(Model model, @PathVariable int id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null || "Гость".equals(user.getFullName())) {
            return "users/login";
        }
        var sessionDtoOptional = filmSessionsService.findById(id);
        if (sessionDtoOptional.isEmpty()) {
            model.addAttribute("error", "Такого сеанса нет");
            return "errors/404";
        }
        var row = sessionDtoOptional.get().getRowCount();
        Collection<Integer> rows = IntStream.rangeClosed(1, row).boxed().toList();
        var place = sessionDtoOptional.get().getPlaceCount();
        Collection<Integer> places = IntStream.rangeClosed(1, place).boxed().toList();
        model.addAttribute("sessions", filmSessionsService.findById(id).get());
        model.addAttribute("rows", rows);
        model.addAttribute("places", places);
        return "tickets/buy";
    }
}
