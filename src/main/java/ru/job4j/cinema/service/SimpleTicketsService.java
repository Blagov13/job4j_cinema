package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Tickets;
import ru.job4j.cinema.repository.TicketsRepository;

import java.util.Optional;

@ThreadSafe
@Service
public class SimpleTicketsService implements TicketsService {
    private final TicketsRepository ticketsRepository;

    private SimpleTicketsService(TicketsRepository sql2oTicketsRepository) {
        this.ticketsRepository = sql2oTicketsRepository;
    }
    @Override
    public Optional<Tickets> save(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }
}
