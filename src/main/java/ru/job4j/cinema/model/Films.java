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

    public Films(int id, String name, String description, int durationInMinutes, int fileId, int genre, int minimalAge, int year) {
        this.description = description;
        this.durationInMinutes = durationInMinutes;
        this.fileId = fileId;
        this.genre = genre;
        this.id = id;
        this.minimalAge = minimalAge;
        this.name = name;
        this.year = year;
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
