import java.util.ArrayList;

// Shared storage: all GUI forms read and write the same two lists.
public class LibraryData {
    public static final ArrayList<Student> students = new ArrayList<Student>();
    public static final ArrayList<Book> books = new ArrayList<Book>();

    // A few sample records so the lists and combo boxes are not empty at the start
    static {
        students.add(new Student("Ali Imran", "A123456"));
        students.add(new Student("Abu Bakar", "A112365"));
        books.add(new Book("Lord of The Ring", "J R R Tolkien"));
        books.add(new Book("The Secret of Lost Stone", "Melissa Payne"));
    }

    public static Student findStudent(String matric) {
        for (Student s : students)
            if (s.getMatric().equalsIgnoreCase(matric)) return s;
        return null;
    }

    public static Book findBook(String title) {
        for (Book b : books)
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        return null;
    }
}
