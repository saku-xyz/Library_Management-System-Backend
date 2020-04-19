package lk.geeks.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


public class ItemDTO {


    private
    String itemCode;
    private String itemCategory;
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String bookCatagory;
    private String ISBN;
    private double price;

    private String floor;
    private String cupBoard;
    private String stock;


    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCupBoard() {
        return cupBoard;
    }

    public void setCupBoard(String cupBoard) {
        this.cupBoard = cupBoard;
    }



    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBookCatagory() {
        return bookCatagory;
    }

    public void setBookCatagory(String bookCatagory) {
        this.bookCatagory = bookCatagory;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemDTO(String itemCode, String itemCategory, String title, String author, String publisher, String year, String bookCatagory, String ISBN, double price, String floor, String cupBoard, String stock) {
        this.itemCode = itemCode;
        this.itemCategory = itemCategory;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.bookCatagory = bookCatagory;
        this.ISBN = ISBN;
        this.price = price;
        this.floor = floor;
        this.cupBoard = cupBoard;
        this.stock = stock;
    }

    public ItemDTO() {
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", bookCatagory='" + bookCatagory + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", floor='" + floor + '\'' +
                ", cupBoard='" + cupBoard + '\'' +
                ", stock='" + stock + '\'' +
                '}';
    }
}
