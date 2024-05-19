package ru.job4j.cinema.dto;

import java.sql.Timestamp;
import java.util.Objects;

public class FilmsSessionDto {
    private int id;
    private String filmName;
    private String hallsName;
    private Timestamp startTime;
    private Timestamp endTime;
    private int price;
    private int rowCount;
    private int placeCount;

    public FilmsSessionDto(int id, String filmName, String hallsName,
                     Timestamp startTime, Timestamp endTime, int price, int rowCount, int placeCount) {
        this.id = id;
        this.filmName = filmName;
        this.hallsName = hallsName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.rowCount = rowCount;
        this.placeCount = placeCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getHallsName() {
        return hallsName;
    }

    public void setHallsName(String hallsName) {
        this.hallsName = hallsName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmsSessionDto that = (FilmsSessionDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
