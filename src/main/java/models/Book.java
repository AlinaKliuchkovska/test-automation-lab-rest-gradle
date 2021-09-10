package models;

public class Book {
    private Long bookId;
    private String bookName;
    private String bookLanguage;
    private String bookDescription;
    private Additional additional;
    private Integer publicationYear;

    public Book() {
    }

    public Book(Long bookId, String bookName, String bookLanguage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.publicationYear = 1995;
        this.additional = new Additional(100);
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Additional getAdditional() {
        return additional;
    }

    public void setAdditional(Additional additional) {
        this.additional = additional;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}
