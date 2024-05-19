package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.cinema.model.Tickets;
import ru.job4j.cinema.service.TicketsService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketsService ticketsService;

    public TicketController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @PostMapping("/result")
    public String create(@ModelAttribute Tickets ticket, Model model) {
        var optionalTicket = ticketsService.save(ticket);
        if (optionalTicket.isEmpty()) {
            model.addAttribute("message", "Места заняты");
            return "tickets/error";
        }
        return "tickets/success";
    }
}
