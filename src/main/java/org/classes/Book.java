package org.classes;

public class Book {

    private String name;
    private String author;
    private String category;

    // Book two args Constructor
    public Book (String name, String author) {
        this(name, author, null);
    }

    //Book three args Constructor
    public Book(String name, String author, String category) {
        this.name = name;
        this.author = author;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Livro: " + this.name + ", escrito por: " + this.author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
