package rca.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> availableBooks;
    private Map<Member, List<Book>> borrowedBooks;

    public Library() {
        this.availableBooks = new ArrayList<>();
        this.borrowedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public boolean borrowBook(Member member, Book book) {
        if (availableBooks.contains(book) && member.borrowBook(book)) {
            availableBooks.remove(book);
            borrowedBooks.computeIfAbsent(member, k -> new ArrayList<>()).add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Member member, Book book) {
        if (borrowedBooks.containsKey(member) && member.returnBook(book)) {
            borrowedBooks.get(member).remove(book);
            availableBooks.add(book);
            return true;
        }
        return false;
    }

    public List<Book> getBorrowedBooksByMember(Member member) {
        return borrowedBooks.getOrDefault(member, new ArrayList<>());
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    public void displayBorrowedBooksByMember(Member member) {
        System.out.println("Books borrowed by " + member.getName() + ":");
        List<Book> books = borrowedBooks.get(member);
        if (books != null) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books borrowed by this member.");
        }
    }
}
