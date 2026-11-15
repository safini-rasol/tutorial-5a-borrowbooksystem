// Student class - Borrow Book System (Tutorial 5a, Q7 e)
public class Student {
    private String name;
    private String matric;
    private Book borrowedBook;          // null means: has not borrowed any book

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }

    public String getName()          { return name; }
    public String getMatric()        { return matric; }
    public Book getBorrowedBook()    { return borrowedBook; }
    public boolean hasBorrowed()     { return borrowedBook != null; }
    public void setBorrowedBook(Book book) { this.borrowedBook = book; }

    // Used in the "Students:" list (Figure 3)  ->  Name : Ali Imran (A123456)
    public String getListInfo() {
        return "Name : " + name + " (" + matric + ")";
    }

    // Used by the combo box (Figure 6)  ->  Ali Imran (A123456)
    @Override
    public String toString() {
        return name + " (" + matric + ")";
    }
}
