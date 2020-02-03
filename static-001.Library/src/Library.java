import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class Library {
private ArrayList<Book> books = new ArrayList<Book>();

    public Library() {
    //Default constructor
    }

    //Start of methods
    public void addBook(Book newBook){
    books.add(newBook);
    }

    public void printBooks() {
        for(Book b : books) {
            System.out.println(b);
        }
    }

    public ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> found = new ArrayList<Book>();
      for(Book b : books) {
          b.title().trim();
          if(b.title().contains(title.toLowerCase())){
              found.add(b);
          }
      }
      return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher){
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book b : books) {
            b.title().trim();
            if(b.publisher().contains(publisher.toLowerCase())) {
                found.add(b);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByYear(int year){
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book b : books) {
            if(b.year() == year) {
                found.add(b);
            }
        }
        return found;
    }
 }

