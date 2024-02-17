package edu.psu.sweng888.practiceii;

import java.io.Serializable;

// Define serializable data model class "Book"
public class Book implements Serializable{
    private Integer place; // Place on NYT Best Sellers List
    private String title; // Title of Book
    private String author; // Author of Book
    private String description; // Summary of Book from NYT


    public Book(Integer place, String title, String author, String description) {
        // Setters
        this.place = place;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    //Getters
    public Integer getPlace(){
        return place;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getDescription() {
        return description;
    }

}

