package org.example.test3.entities;

import java.util.List;

public class Question {

    private int id;

    private String text;

    private List<Option> options;

    private int correctOptionID;

    public Question() {
    }

    public Question(int id, String text, List<Option> options, int correctOptionID) {
        this.id = id;
        this.text = text;
        this.options = options;
        this.correctOptionID = correctOptionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public int getCorrectOptionID() {
        return correctOptionID;
    }

    public void setCorrectOptionID(int correctOptionID) {
        this.correctOptionID = correctOptionID;
    }
}
