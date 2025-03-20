package org.classes.testes;

import org.classes.Book;
import org.enums.Category;

public class BookTest {
    public static void main(String[] args) {

        String name = null;
        Book livro1 = new Book("Senhor dos Anéis", "Tolkien", Category.FANTASY);


        try {
            livro1.setName(name);
        }catch(IllegalArgumentException e) {
            System.out.println("Erro ao definir o nome do livro para '" + name + "' : " + e.getMessage());
        }

        System.out.println(livro1);
    }
}
