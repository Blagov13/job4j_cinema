package ru.job4j.cinema.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cinema.configuration.DatasourceConfiguration;
import ru.job4j.cinema.model.FilmSession;

import java.sql.Timestamp;
import java.util.List;
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
    void whenFindByIdFilmSessionThenGetFilmSession() {
        FilmSession expectedSession = new FilmSession(1, 1, 2, new Timestamp(13), new Timestamp(15), 100);
        assertThat(sql2oFilmSessionsRepository.findById(1)).usingRecursiveComparison()
                .isEqualTo(expectedSession);
    }

    @Test
    void whenGetAllFilmSessionsThenGetFilmSessionsCollection() {
        FilmSession expectedSession1 = new FilmSession(1, 1, 2, new Timestamp(13), new Timestamp(15), 100);
        FilmSession expectedSession2 = new FilmSession(2, 1, 2, new Timestamp(13), new Timestamp(15), 100);
        assertThat(sql2oFilmSessionsRepository.findAll())
                .isEqualTo(List.of(expectedSession1, expectedSession2));
    }
}