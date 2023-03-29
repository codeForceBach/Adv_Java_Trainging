package designPatterns.behaviors.iterator.dzone;

import java.util.Iterator;

public class Library implements Iterable{

    private Book [] libraryBook;

    public Library(Book...libraryBook) {

        this.libraryBook = libraryBook;
    }

    public Book [] getLibraryBook() {

        return libraryBook;
    }

    @Override
    public LibraryIterator iterator() {

        return new LibraryIterator(this);
    }
}
