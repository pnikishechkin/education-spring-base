package ru.nikishechkin.spring_start_here.ch4_ex1_abstraction;

public class Comment {
    private String author;

    private String text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
