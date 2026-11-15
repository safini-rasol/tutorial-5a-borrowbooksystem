import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

// (a) Main Menu GUI - Figure 1. Start the whole system from here.
public class MainMenu extends JFrame implements ActionListener {
    private JLabel title;
    private JButton btnStudent, btnBook, btnBorrow;

    public MainMenu() {
        title = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(new EmptyBorder(10, 20, 15, 20));
        panel.add(title);
        panel.add(btnStudent);
        panel.add(btnBook);
        panel.add(btnBorrow);
        setContentPane(panel);

        btnStudent.addActionListener(this);
        btnBook.addActionListener(this);
        btnBorrow.addActionListener(this);
    }

    // Each button opens the form that matches it
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent)
            new AddStudentInfo().setVisible(true);
        else if (e.getSource() == btnBook)
            new AddBookInfo().setVisible(true);
        else if (e.getSource() == btnBorrow)
            new BorrowBook().setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
