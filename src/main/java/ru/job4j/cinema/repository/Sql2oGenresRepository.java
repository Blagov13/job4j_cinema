package ru.job4j.cinema.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Genres;

@Repository
public class Sql2oGenresRepository implements GenresRepository {
    private final Sql2o sql2o;

    public Sql2oGenresRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Genres findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres where id = :id");
            return query.addParameter("id", id).executeAndFetchFirst(Genres.class);
        }
    }
}
