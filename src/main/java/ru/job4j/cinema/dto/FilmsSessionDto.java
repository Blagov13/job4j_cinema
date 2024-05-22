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

    public FilmsSessionDto id(int id) {
        this.id = id;
        return this;
    }

    public FilmsSessionDto filmName(String filmName) {
        this.filmName = filmName;
        return this;
    }

    public FilmsSessionDto hallsName(String hallsName) {
        this.hallsName = hallsName;
        return this;
    }

    public FilmsSessionDto startTime(Timestamp startTime) {
        this.startTime = startTime;
        return this;
    }

    public FilmsSessionDto endTime(Timestamp endTime) {
        this.endTime = endTime;
        return this;
    }

    public FilmsSessionDto price(int price) {
        this.price = price;
        return this;
    }

    public FilmsSessionDto rowCount(int rowCount) {
        this.rowCount = rowCount;
        return this;
    }

    public FilmsSessionDto placeCount(int placeCount) {
        this.placeCount = placeCount;
        return this;
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
