package ru.job4j.cinema.model;

import java.util.Map;
import java.util.Objects;

public class Halls {
    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "name", "name",
            "row_count", "rowCount",
            "place_count", "placeCount",
            "description", "description"
    );

    private int id;
    private String name;
    private int rowCount;
    private int placeCount;
    private String description;

    public Halls(int id, String name, int placeCount, int rowCount, String description) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.placeCount = placeCount;
        this.rowCount = rowCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Halls halls = (Halls) o;
        return id == halls.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
