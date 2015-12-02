package model;

import java.util.Date;

public class CheckoutEntry {

    private int id;//same as database id
    private Date checkoutDate;
    private Date dueDate;
    private BookCopy bookCopy;
    private CheckoutRecord checkoutRecord;//TODO: maybe it is not needed

    
    public Date getCheckoutDate() {
        return this.checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }
    
    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }


}
