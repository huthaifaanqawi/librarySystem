package model;

public class BookCopy {

    private int copynumber;
    private boolean available;
    private Book book;    

    public int getCopynumber() {
        return this.copynumber;
    }

    public void setCopynumber(int copynumber) {
        this.copynumber = copynumber;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
