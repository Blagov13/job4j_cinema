package ru.job4j.cinema.model;

import java.util.Map;
import java.util.Objects;

public class Films {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "name", "name",
            "description", "description",
            "year", "year",
            "genre_id", "genre",
            "minimal_age", "minimalAge",
            "duration_in_minutes", "durationInMinutes",
            "file_id", "fileId"
    );

    private int id;
    private String name;
    private String description;
    private int year;
    private int genre;
    private int minimalAge;
    private int durationInMinutes;
    private int fileId;

    public Films id(int id) {
        this.id = id;
        return this;
    }

    public Films name(String name) {
        this.name = name;
        return this;
    }

    public Films description(String description) {
        this.description = description;
        return this;
    }

    public Films year(int year) {
        this.year = year;
        return this;
    }

    public Films genre(int genre) {
        this.genre = genre;
        return this;
    }

    public Films minimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
        return this;
    }

    public Films durationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
        return this;
    }

    public Films fileId(int fileId) {
        this.fileId = fileId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Films films = (Films) o;
        return id == films.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
