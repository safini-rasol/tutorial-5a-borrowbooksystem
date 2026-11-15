import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

// (b) Add Student Info GUI - Figures 2 and 3
public class AddStudentInfo extends JFrame implements ActionListener {
    private JLabel lblName, lblMatric, lblStudents;
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea areaStudents;

    public AddStudentInfo() {
        lblName = new JLabel("Name:");
        lblMatric = new JLabel("Matric:");
        lblStudents = new JLabel("Students:");
        txtName = new JTextField(20);
        txtMatric = new JTextField(20);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        areaStudents = new JTextArea(6, 30);
        areaStudents.setEditable(false);

        // Top: form (2 rows x 2 columns) + the two buttons
        JPanel form = new JPanel(new GridLayout(2, 2, 5, 3));
        form.add(lblName);
        form.add(txtName);
        form.add(lblMatric);
        form.add(txtMatric);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 5));
        buttons.add(btnAdd);
        buttons.add(btnList);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.NORTH);
        top.add(buttons, BorderLayout.CENTER);

        // Bottom: the list area
        JPanel bottom = new JPanel(new BorderLayout(0, 3));
        bottom.add(lblStudents, BorderLayout.NORTH);
        bottom.add(new JScrollPane(areaStudents,
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
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim().toUpperCase();

            if (name.isEmpty() || matric.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in both name and matric number.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (LibraryData.findStudent(matric) != null) {
                JOptionPane.showMessageDialog(this, "A student with matric " + matric + " is already registered.",
                        "Duplicate Matric", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Generate a Student object and save it for the borrowing process
            LibraryData.students.add(new Student(name, matric));
            txtName.setText("");
            txtMatric.setText("");
            JOptionPane.showMessageDialog(this, "Student added successfully.");

        } else if (e.getSource() == btnList) {
            StringBuilder sb = new StringBuilder();
            for (Student s : LibraryData.students)
                sb.append(s.getListInfo()).append("\n");
            areaStudents.setText(sb.length() == 0 ? "No student registered yet." : sb.toString());
        }
    }

    public static void main(String[] args) {
        AddStudentInfo frame = new AddStudentInfo();
        frame.setTitle("Add Student Info");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // standalone run
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
