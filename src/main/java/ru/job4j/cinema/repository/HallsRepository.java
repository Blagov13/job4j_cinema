package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Halls;

public interface HallsRepository {
    Halls findById(int id);
}
