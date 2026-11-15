// Book class - Borrow Book System (Tutorial 5a, Q7 e)
public class Book {
    private String title;
    private String author;
    private boolean available = true;   // only ONE copy of each title
    private Student borrower;           // who is holding the book now

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle()      { return title; }
    public String getAuthor()     { return author; }
    public boolean isAvailable()  { return available; }

    // Borrow process. Returns the message shown at the bottom of the Borrow Book GUI.
    public String borrowBy(Student student) {
        if (!available) {
            return "Sorry, the book \"" + title + "\" has already been borrowed by "
                    + borrower.getName() + ".";
        }
        if (student.hasBorrowed()) {
            return student.getName() + " has already borrowed a book. "
                    + "Each student can borrow only one book.";
        }

        available = false;
        borrower = student;
        student.setBorrowedBook(this);

        return student.getName() + " with matric number " + student.getMatric()
                + " has borrow a book with title " + title + ".";
    }

    // Used in the "Books:" list (Figure 5)  ->  Book title : Harry Potter (Author : J K Rowling)
    public String getListInfo() {
        return "Book title : " + title + " (Author : " + author + ")";
    }

    // Used by the combo box (Figure 7)  ->  Harry Potter (J K Rowling)
    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}
