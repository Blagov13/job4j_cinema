# job4j_cinema

## Описание проекта

**job4j_cinema** - это учебный проект по созданию веб-приложения для бронирования билетов в кинотеатре. Приложение позволяет пользователям просматривать доступные сеансы, выбирать места и бронировать билеты.

## Функциональные возможности

- Регистрация и авторизация пользователей
- Просмотр расписания сеансов
- Выбор и бронирование мест в зале
- Просмотр информации о фильмах
- Управление пользователями и бронированиями для администратора

## Технологии

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- Bootstrap
- H2 Database (для тестирования)
- PostgreSQL (для продакшн)

## Запуск проекта

### Системные требования

- Java 17 и выше
- Maven 3.6 и выше
- PostgreSQL 12 и выше

### Настройка базы данных

1. Создайте базу данных PostgreSQL:
    ```sql
    CREATE DATABASE cinema;
    ```

2. Настройте параметры подключения к базе данных в файле `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/cinema
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

### Сборка и запуск

1. Склонируйте репозиторий:
    ```bash
    git clone https://github.com/Blagov13/job4j_cinema.git
    cd job4j_cinema
    ```

2. Соберите проект с помощью Maven:
    ```bash
    mvn clean install
    ```

3. Запустите приложение:
    ```bash
    mvn spring-boot:run
    ```

### Доступ к приложению

После успешного запуска приложение будет доступно по адресу: [http://localhost:8080](http://localhost:8080)

## Разработка

### Структура проекта

- `src/main/java` - исходный код приложения
- `src/main/resources` - ресурсы приложения
- `src/test` - модульные тесты

## Контакты

Если у вас есть вопросы или предложения, пожалуйста, свяжитесь с нами:

- Автор проекта: [Blagov13](https://github.com/Blagov13)
- Электронная почта: blagov13rus@gmail.com
