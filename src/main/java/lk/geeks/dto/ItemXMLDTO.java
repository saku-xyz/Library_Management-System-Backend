package lk.geeks.dto;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "ItemDTO")
@XmlAccessorType
public class ItemXMLDTO implements Serializable {

    @javax.xml.bind.annotation.XmlAttribute
    private String itemCode;
    @XmlElement
    private String itemCategory;
    @XmlElement
    private String title;
    @XmlElement
    private String author;
    @XmlElement
    private String publisher;
    @XmlElement
    private String year;
    @XmlElement
    private String bookCatagory;
    @XmlElement
    private String ISBN;
    @XmlElement
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ItemXMLDTO(String itemCode, String itemCategory, String title, String author, String publisher, String year, String bookCatagory, String ISBN, String price) {
        this.itemCode = itemCode;
        this.itemCategory = itemCategory;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.bookCatagory = bookCatagory;
        this.ISBN = ISBN;
        this.price = price;
    }

    public ItemXMLDTO() {
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
                '}';
    }


}
