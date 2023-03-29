package designPatterns.behaviors.iterator.dzone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookLibrary {
    private List<Book> books;

    public BookLibrary() {
        books = new ArrayList<Book>();
    }

    public boolean addBook (String title, String language,  String author, long ISBN, double price){
        Book aBook = new Book(title, language, author, ISBN, price);
        return books.add(aBook);
    }
    public boolean addBook (Book book){
        return books.add(book);

    }

    public List<Book> getBooks() {

        return books;
    }

    public Iterator <Book> iterator(){

        return books.iterator();
    }
}
