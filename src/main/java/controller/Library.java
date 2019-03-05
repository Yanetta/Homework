package controller;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private int id;
    public Library(List<Book> books, int id) {
        this.books = books;
        this.id = id;
    }
    public Library() {
    }

    public List<Book> getBooks() {
        return books;
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Library libraryExampleCreator() {
        Library library = new Library();
        library.setId(1000);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Zakhar Berkut", 300));
        books.add(new Book("Kobzar", 500));
        books.add(new Book("Kolobok", 10));
        library.setBooks(books);
        return library;
    }
}


