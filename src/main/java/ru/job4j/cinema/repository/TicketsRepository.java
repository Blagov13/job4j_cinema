package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Tickets;

import java.util.Optional;

public interface TicketsRepository {
    Optional<Tickets> save(Tickets tickets);
}
