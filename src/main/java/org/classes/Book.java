package org.classes;
import org.enums.Category;

public class Book {

    private String name;
    private String author;
    private Category category;

    // Book two args Constructor
    public Book (String name, String author) {
        this(name, author, null);
    }

    //Book three args Constructor
    public Book(String name, String author, Category category) {

        this.name = name == null || name.isEmpty() ? "Nome Padrão" : name;
        this.author = author == null || author.isEmpty() ? "Autor Padrão" : author;
        this.category = category == null ? Category.NON_FICTION : category;
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

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {

        //validação de name
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nome do livro inválido");
        }

        this.name = name;
    }

    public void setAuthor(String author) {

        //validação de author
        if(author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Nome do autor inválido");
        }

        this.author = author;
    }

    public void setCategory(Category category) {

        //validação de category
        if(category == null) {
            throw new IllegalArgumentException("Categoria Inválida");
        }

        this.category = category;
    }
}
