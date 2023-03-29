package designPatterns.behaviors.iterator.dzone;

public class Book {

    private String title;
    private String language;
    private String author;
    private long ISBN;
    private double price;

    public Book(String title, String language, String author, long ISBN, double price) {
        this.title = title;
        this.language = language;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAuthour() {
        return author;
    }

    public void setAuthour(String authour) {
        this.author = authour;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        StringBuilder bookString = new StringBuilder();
        bookString.append("Book [language = ").append(language).append(", title= ").append(title).append(", author = ")
                .append(author).append(", ISBN = ").append(ISBN).append(", Price = ").append(price).append("]");
        return bookString.toString();
    }
}
