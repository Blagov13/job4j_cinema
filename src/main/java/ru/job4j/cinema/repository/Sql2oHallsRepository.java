package ru.job4j.cinema.repository;

import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Halls;

@Repository
public class Sql2oHallsRepository implements HallsRepository {
    private final Sql2o sql2o;

    public Sql2oHallsRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Halls findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls WHERE id = :id");
            query.addParameter("id", id);
            return query.setColumnMappings(Halls.COLUMN_MAPPING).executeAndFetchFirst(Halls.class);
        }
    }
}
