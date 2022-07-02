import java.util.Scanner;

public class Main {

    static Library lib = new Library();
    static Scanner in = new Scanner(System.in);

    static boolean displayMenu(Boolean isLibrarian) {
        if (isLibrarian) {
            System.out.print("Librarian Operations \n 1: Add Book\n 2: View All Books\n 3: Logout\n\n Select Operation : ");
            switch(in.nextInt()) {
                case 1:
                    lib.addBook();
                    break;
                case 2:
                    lib.viewBooks();
                    break;
                case 3:
                    return false;
                default:
                    System.out.println("Wrong choice!");
            }
        } else {
            System.out.print("Student Operations \n 1: View All Books\n 2: Checkout Book\n 3: Return Book\n 4: Logout\n\n Select Operation : ");
            switch(in.nextInt()) {
                case 1:
                    lib.viewBooks();
                    break;
                case 2:
                    in.nextLine();
                    System.out.print(" Enter ISBN of the book you want: ");
                    lib.checkout(in.nextLine());
                    break;
                case 3:
                    in.nextLine();
                    System.out.print(" Enter ISBN of the book being returned: ");
                    lib.returnBook(in.nextLine());
                    break;
                case 4:
                    return false;
                default:
                    System.out.println("Wrong choice!");
            }
        }
        return true;
    }
    public static void main(String[] args) {

        while(true) {
            System.out.print(" Welcome to Library! Please login!!\n 1: Librarian\n 2: Student\n 3: Exit\n\n Choice? ");
            int choice = in.nextInt();
            boolean bool = false;
            do {
                if (choice == 1)
                    bool = true;
                else if (choice == 2)
                    bool = false;
                else if (choice == 3) {
                    System.out.println("Thanks For visiting!");
                    return;
                }
            } while (displayMenu(bool));
        }
    }
}