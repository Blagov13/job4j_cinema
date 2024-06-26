package ru.job4j.cinema.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Tickets;

import java.util.Optional;

@Repository
public class Sql2oTicketsRepository implements TicketsRepository {

    private final Sql2o sql2o;
    private final Logger logger = LoggerFactory.getLogger(Sql2oUserRepository.class);

    public Sql2oTicketsRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Tickets> save(Tickets tickets) {
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO tickets(session_id, row_number, place_number, user_id)
                    VALUES (:session_id, :row_number, :place_number, :user_id)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("session_id", tickets.getSessionId())
                    .addParameter("row_number", tickets.getRowNumber())
                    .addParameter("place_number", tickets.getPlaceNumber())
                    .addParameter("user_id", tickets.getUserId());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            tickets.setId(generatedId);
            return Optional.of(tickets);
        } catch (Exception exception) {
            logger.info(exception.getMessage());
        }
        return Optional.empty();
    }
}
