import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

// (c) Add Book Info GUI - Figures 4 and 5
public class AddBookInfo extends JFrame implements ActionListener {
    private JLabel lblTitle, lblAuthor, lblBooks;
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea areaBooks;

    public AddBookInfo() {
        lblTitle = new JLabel("Book Title:");
        lblAuthor = new JLabel("Author:");
        lblBooks = new JLabel("Books:");
        txtTitle = new JTextField(20);
        txtAuthor = new JTextField(20);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        areaBooks = new JTextArea(6, 30);
        areaBooks.setEditable(false);

        JPanel form = new JPanel(new GridLayout(2, 2, 5, 3));
        form.add(lblTitle);
        form.add(txtTitle);
        form.add(lblAuthor);
        form.add(txtAuthor);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        buttons.add(btnAdd);
        buttons.add(btnList);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.NORTH);
        top.add(buttons, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout(0, 3));
        bottom.add(lblBooks, BorderLayout.NORTH);
        bottom.add(new JScrollPane(areaBooks,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);

        JPanel main = new JPanel(new BorderLayout(0, 5));
        main.setBorder(new EmptyBorder(8, 8, 8, 8));
        main.add(top, BorderLayout.NORTH);
        main.add(bottom, BorderLayout.CENTER);
        setContentPane(main);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();

            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in both book title and author.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (LibraryData.findBook(title) != null) {       // only one copy of each title
                JOptionPane.showMessageDialog(this, "The book \"" + title + "\" is already registered.",
                        "Duplicate Book", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Generate a Book object and save it for the borrowing process
            LibraryData.books.add(new Book(title, author));
            txtTitle.setText("");
            txtAuthor.setText("");
            JOptionPane.showMessageDialog(this, "Book added successfully.");

        } else if (e.getSource() == btnList) {
            StringBuilder sb = new StringBuilder();
            for (Book b : LibraryData.books)
                sb.append(b.getListInfo()).append("\n");
            areaBooks.setText(sb.length() == 0 ? "No book registered yet." : sb.toString());
        }
    }

    public static void main(String[] args) {
        AddBookInfo frame = new AddBookInfo();
        frame.setTitle("Add Book Info");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // standalone run
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
