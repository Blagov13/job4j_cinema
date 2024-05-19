package ru.job4j.cinema.service;

import ru.job4j.cinema.model.Tickets;

import java.util.Optional;

public interface TicketsService {
    Optional<Tickets> save(Tickets tickets);
}
