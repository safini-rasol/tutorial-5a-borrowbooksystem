import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

// (d) Borrow Book GUI - Figures 6, 7 and 8
public class BorrowBook extends JFrame implements ActionListener {
    private JLabel lblStudent, lblBook, lblInfoTitle, lblInfo;
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;

    public BorrowBook() {
        lblStudent = new JLabel("Student Name & Matric:");
        lblBook = new JLabel("Book Title & Author:");
        lblInfoTitle = new JLabel("Borrow Information :");
        lblInfo = new JLabel(" ");
        btnBorrow = new JButton("Borrow");

        // The combo boxes hold the real objects. They show toString() of each object.
        cmbStudent = new JComboBox<Student>();
        for (Student s : LibraryData.students) cmbStudent.addItem(s);
        cmbBook = new JComboBox<Book>();
        for (Book b : LibraryData.books) cmbBook.addItem(b);

        JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
        form.add(lblStudent);
        form.add(cmbStudent);
        form.add(lblBook);
        form.add(cmbBook);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnBorrow);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.NORTH);
        top.add(buttonPanel, BorderLayout.CENTER);

        JPanel info = new JPanel(new GridLayout(2, 1));
        info.add(lblInfoTitle);
        info.add(lblInfo);

        JPanel main = new JPanel(new BorderLayout(0, 5));
        main.setBorder(new EmptyBorder(8, 8, 8, 8));
        main.add(top, BorderLayout.NORTH);
        main.add(info, BorderLayout.SOUTH);
        setContentPane(main);

        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Student student = (Student) cmbStudent.getSelectedItem();
        Book book = (Book) cmbBook.getSelectedItem();

        if (student == null || book == null) {
            JOptionPane.showMessageDialog(this, "Please add at least one student and one book first.",
                    "Nothing to borrow", JOptionPane.WARNING_MESSAGE);
            return;
        }
        lblInfo.setText(book.borrowBy(student));      // show the result at the bottom
    }

    public static void main(String[] args) {
        BorrowBook frame = new BorrowBook();
        frame.setTitle("Borrow Book");
        frame.setSize(640, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // standalone run
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
