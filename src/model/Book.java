package model;

import java.util.List;

public class Book {
    
    private String title;
    private String isbn;  //it used as id  
    private List<Author> authors;
    private List<Book> copies;//book copies

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Book> getCopies() {
        return copies;
    }

    public void setCopies(List<Book> copies) {
        this.copies = copies;
    }
}
