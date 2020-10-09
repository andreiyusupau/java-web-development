package com.andreiyusupau.library.model;

public class Book {

    private final long id;
    private final String title;
    private final String authors;
    private final int numberOfPages;
    private final String publisher;

    public Book(long id, String title, String authors, int numberOfPages, String publisher) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (numberOfPages != book.numberOfPages) return false;
        if (!title.equals(book.title)) return false;
        if (!authors.equals(book.authors)) return false;
        return publisher.equals(book.publisher);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + numberOfPages;
        result = 31 * result + publisher.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", authors='").append(authors).append('\'');
        sb.append(", numberOfPages=").append(numberOfPages);
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
