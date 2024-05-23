package ru.job4j.cinema.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cinema.configuration.DatasourceConfiguration;

import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class Sql2oFilmSessionsRepositoryTest {
    private static Sql2oFilmSessionsRepository sql2oFilmSessionsRepository;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oFilmSessionsRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oFilmSessionsRepository = new Sql2oFilmSessionsRepository(sql2o);
    }

    /*
    Тестовая база данных была заполнена sql-скриптом с помощью Liquibase.
     */

    @Test
    public void whenFindAllSessionsThenGet() {
        var filmCollection = sql2oFilmSessionsRepository.findAll();
        assertThat(filmCollection).hasSize(5);
    }

    @Test
    public void whenFindSessionByIdThenGet() {
        var session = sql2oFilmSessionsRepository.findById(2).get();
        assertThat(session.getHallsId()).isEqualTo(2);
        assertThat(session.getFilmId()).isEqualTo(2);
    }
}