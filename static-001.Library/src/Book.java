public class Book {
    private String bookTitle;
    private String publisherName;
    private int publishingYear;

    public Book(String bookTitle, String publisherName, int publishingYear) {
        this.bookTitle = bookTitle;
        this.publisherName = publisherName;
        this.publishingYear = publishingYear;
    }

    public String title() {
        return this.bookTitle;
    }

    public String publisher() {
        return this.publisherName;
    }

    public int year() {
        return this.publishingYear;
    }

    public String toString() {
      return this.title() + ", " + this.publisherName + ", " + this.publishingYear;

        }
    }


