import java.util.HashMap;
import java.util.Scanner;

public class Library {

     //implement total count and checked out count
    HashMap<String, Book> booksList = new HashMap<>();
    HashMap<String, Short> booksCount = new HashMap<>();

    public void addNewBook() {
        Scanner in = new Scanner(System.in);
        System.out.print(" Enter ISBN : ");
        String ISBN = in.nextLine();
        if(booksList.containsKey(ISBN)) {
            System.out.println("Already in Database, use 'Add Book Stock' option to increase stocks. Man, you gotta work on your memory more...");
            return;
        }
        System.out.print(" Enter Book Name : ");
        String Name = in.nextLine();
        System.out.print(" Enter Author Name : ");
        String Author = in.nextLine();
        System.out.print(" Enter Total Count : ");
        Short Stock = in.nextShort();
        in.nextLine();
        Book book = new Book(ISBN, Name, Author, Stock);
        booksList.put(book.getISBN(), book);
        booksCount.put(book.getISBN(), Stock);
    }

    public void addBookStock() {
        System.out.print(" Enter the Book's ISBN : ");
        Scanner in = new Scanner(System.in);
        String ISBN = in.nextLine();
        if (booksList.get(ISBN) == null) {
            System.out.println("No such book exists, atleast not yet in our library. Got new donations? Add books using the 'Add New Book' option.");
            return;
        }
        System.out.print("Enter the no. of Additional Stock : ");
        short additionalStock = in.nextShort();
        in.nextLine();
        booksList.get(ISBN).addStock(in.nextShort());
        booksCount.put(ISBN, booksList.get(ISBN).getStock());
    }

    public void displayStock() {
        for (Book book : booksList.values()) {
            short stock = book.getStock();
            short availableCount = booksCount.get(book.getISBN());
            short checkedOutCount = (short) (stock - availableCount);
            System.out.println(book.getName() + "(" + book.getISBN() + ") - Total stock:" + stock + " Available Stock:" + availableCount + " Checked out:" + checkedOutCount);
        }
    }

    public void viewBooks() {
        String stock;
        for (Book book : booksList.values()) {
            if (booksCount.get(book.getISBN()) > 0)
                stock = booksCount.get(book.getISBN()) + "x ";
            else
                stock = "Out of Stock - ";
            System.out.println(stock + book.getName() + " By " + book.getAuthor() + " (" + book.getISBN() + ")");
        }
    }

    public void checkout(String ISBN) {
        if (booksCount.containsKey(ISBN))
            if (booksCount.get(ISBN) == 0) //change to availability count
                System.out.println("Out Of Stock");
            else
                booksCount.put(ISBN, (short) (booksCount.get(ISBN)-1));
        else
            System.out.println("Well....we don't have a book of that ISBN sir. Adios!");
    }

    public void returnBook(String ISBN) {
        if (booksCount.containsKey(ISBN)) {
            if (booksCount.get(ISBN).equals(booksList.get(ISBN).getStock())) //change to availability count
                System.out.println("You got the wrong library man. Not our book... Need any psychiatrist suggestions?");
            else
                booksCount.put(ISBN, (short) (booksCount.get(ISBN)+1));
        } else
            System.out.println("Well....we don't own any book with that ISBN sir. Adios!");
    }
}