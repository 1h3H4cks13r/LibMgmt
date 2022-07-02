import java.util.HashMap;
import java.util.Scanner;

public class Library {

    Book book;
    String ISBN, Name, Author;
    Scanner in = new Scanner(System.in);
    HashMap<String, Book> booksList = new HashMap<>();

    public void addBook() {
        System.out.print(" Enter ISBN : ");
        ISBN = in.nextLine();

        if(booksList.containsKey(ISBN)) {
            System.out.println("Already in stock, Count increased.");
            booksList.get(ISBN).incCount();
            return;
        }

        System.out.print(" Enter Book Name : ");
        Name = in.nextLine();
        System.out.print(" Enter Author Name : ");
        Author = in.nextLine();

        book = new Book(ISBN, Name, Author);
        booksList.put(book.getISBN(), book);
    }

    public void checkout(String ISBN) {
        if (booksList.containsKey(ISBN)) {
            booksList.get(ISBN).decCount();
        } else
            System.out.println("Invalid ISBN");
    }

    public void returnBook(String ISBN) {
        if (booksList.containsKey(ISBN)) {
            //if (booksList.get(ISBN).getCount())
            booksList.get(ISBN).incCount();
        } else
            System.out.println("Invalid ISBN");
    }

    public void viewBooks() {
        for (Book book : booksList.values()) {
            if (book.getCount() > 0) {
                System.out.println(book.getCount() + "x " +book.getName() + " (" + book.getISBN() + ")");
            }
        }
        in.nextLine();
    }

}
