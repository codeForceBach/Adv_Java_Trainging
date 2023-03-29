package designPatterns.behaviors.iterator.dzone;

import java.util.Iterator;

public class LibraryIterator implements Iterator<Book> {

    private Library library;
    private int index;

    public LibraryIterator(Library libraryBook) {
        this.library = libraryBook;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        Book [] libraryBook = library.getLibraryBook();
        if (libraryBook.length > index && libraryBook[index] != null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    //increment index of the collection and return library
    public Book next() {
        Book [] libraryBook =library.getLibraryBook();
        if (hasNext()){
            return libraryBook[index++];
            /*
            Book libBook = libraryBook[index++];
            if (libBook.getPrice() > 10.00 && libraryBook[index] != null){
                //index++;
                return libBook;
            } else {
                return next();
            }
            */

        } else {
            return next();
            //return null;
        }

    }

}
