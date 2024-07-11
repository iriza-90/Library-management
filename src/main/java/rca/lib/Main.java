package rca.lib;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new Book("001", "Mixed Blessings ", "Danielle Steel", 2001);
        Book book2 = new Book("002", "Jump", "Steve Harvey", 2009);
        Book book3 = new Book("003", "TFIS", "Collins", 2019);
        Book book4 = new Book("004", "Do not accept to die", "Dimitri sis", 2019);
        Book book5 = new Book("005", "Left to tell", "Imacullee", 2019);
        Book book6 = new Book("006", "Desire of Ages", "White Ellen", 1998);

        // Add books to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        // Create member
        Member iriza = new Member("M001", "Iriza Joella");
        Member nganji = new Member("M001", "Nganji Elton");
        Member bella = new Member("M001", "Ineza Bella");

        // Display available books
        library.displayAvailableBooks();

        // Joella orrows books
        library.borrowBook(iriza, book1);
        library.borrowBook(iriza, book5);
        library.borrowBook(iriza, book3);
        library.borrowBook(iriza, book6);


        // Display borrowed books by Joella
        library.displayBorrowedBooksByMember(iriza);

        // Joella returns a book
        library.returnBook(iriza, book1);

        // Display available books after returning a book
        library.displayAvailableBooks();

        // Display borrowed books by Joella after returning a book
        library.displayBorrowedBooksByMember(iriza);

        // Nganji borrows books
        library.borrowBook(nganji, book1);

        // Display borrowed books by Nganji
        library.displayBorrowedBooksByMember(nganji);


    }
}

