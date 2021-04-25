package uzz.bookerstore.bean;

import java.io.PrintWriter;
import java.util.Locale;

/**
 * @version v-1.8.0_131.
 * @auther Jack hou  Email:256595662@qq.com
 * @data 2021/4/25/16:15
 * @Description:
 **/
public class Book {
   private int ISBN,Count,CategoryId,Special,SpecialBook;
   private String BookName,Author,Decription,Image,Entrytime;
   private  double Price;

    public Book(int ISBN, int count, int categoryId, int special,
                int specialBook, String bookName, String author,
                String decription, String image, String entrytime, double price) {
        this.ISBN = ISBN;
        Count = count;
        CategoryId = categoryId;
        Special = special;
        SpecialBook = specialBook;
        BookName = bookName;
        Author = author;
        Decription = decription;
        Image = image;
        Entrytime = entrytime;
        Price = price;
    }
    public Book(){

    }
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getSpecial() {
        return Special;
    }

    public void setSpecial(int special) {
        Special = special;
    }

    public int getSpecialBook() {
        return SpecialBook;
    }

    public void setSpecialBook(int specialBook) {
        SpecialBook = specialBook;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String decription) {
        Decription = decription;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getEntrytime() {
        return Entrytime;
    }

    public void setEntrytime(String entrytime) {
        Entrytime = entrytime;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
