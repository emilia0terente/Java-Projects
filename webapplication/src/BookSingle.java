/*
import java.io.Serializable;
 BookSingle.java
 A BookSingle object contains the data for one book.
package org.me.webapps.bookstore;
 Java core packages
*/

public class BookSingle {
    private String ISBN, title, copyright, imageFile;
    private int editionNumber, publisherID;
    private double price;

    public BookSingle(String ISBN, String title, String copyright, String imageFile, int editionNumber, int publisherID, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.copyright = copyright;
        this.imageFile = imageFile;
        this.editionNumber = editionNumber;
        this.publisherID = publisherID;
        this.price = price;
    }

    public BookSingle() {

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
