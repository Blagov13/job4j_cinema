package ru.job4j.cinema.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.cinema.configuration.DatasourceConfiguration;

import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class Sql2oHallsRepositoryTest {
    private static Sql2oHallsRepository sql2oHallsRepository;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oHallsRepositoryTest.class.getClassLoader().getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oHallsRepository = new Sql2oHallsRepository(sql2o);
    }

    @Test
    public void whenFindHallByIdThenGet() {
        var hall = sql2oHallsRepository.findById(1);
        assertThat(hall.getName()).isEqualTo("Hall #1");
    }
}