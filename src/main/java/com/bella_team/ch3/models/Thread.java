package com.bella_team.ch3.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, fullText, name;
    private LocalDate date;
    private LocalTime time;

    public LocalDate getDate() {
        return date;
    }

    public Thread(String title, String name, String fullText) {
        this.title = title;
        this.fullText = fullText;
        this.name = name;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Thread() {
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
