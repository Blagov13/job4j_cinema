package ru.job4j.cinema.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;
import ru.job4j.cinema.configuration.DatasourceConfiguration;
import ru.job4j.cinema.model.Tickets;

import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class Sql2oTicketsRepositoryTest {
    private static Sql2oTicketsRepository sql2oTicketsRepository;

    private static Sql2o sql2o;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oTicketsRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        sql2o = configuration.databaseClient(datasource);

        sql2oTicketsRepository = new Sql2oTicketsRepository(sql2o);
    }

    @AfterEach
    public void clearTicketsTable() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("TRUNCATE TABLE tickets RESTART IDENTITY;");
            query.executeUpdate();
        }
    }

    @Test
    public void whenSaveTicketThenGet() {
        var ticket = sql2oTicketsRepository.save(new Tickets(0, 1, 1, 1, 1));
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * from tickets WHERE id =:id");
            query.addParameter("id", 1);
            var savedTicket = query.setColumnMappings(Tickets.COLUMN_MAPPING).executeAndFetchFirst(Tickets.class);
            assertThat(savedTicket).isEqualTo(ticket.get());
        }
    }

    @Test
    public void whenSaveSeveralThenGetCount() {
        var ticket = sql2oTicketsRepository.save(new Tickets(0, 1, 1, 1, 0));
        var ticket2 = sql2oTicketsRepository.save(new Tickets(1, 2, 2, 2, 0));
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM tickets");
            var rowCount = query.setColumnMappings(Tickets.COLUMN_MAPPING).executeAndFetch(Tickets.class);
            assertThat(rowCount.size()).isEqualTo(2);
        }
    }
}