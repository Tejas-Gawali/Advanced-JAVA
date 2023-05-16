import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class StudentManagementSystem2 extends JFrame implements ActionListener {
    private JTextField idField, nameField, addressField, phoneField, emailField, gradeField, marksField, genderField, ageField;
    private JButton addButton, updateButton, deleteButton, searchButton, clearButton;
    private JLabel idLabel, nameLabel, addressLabel, phoneLabel, emailLabel, gradeLabel, marksLabel, genderLabel, ageLabel;
    private JPanel panel;
    private Connection conn;

    public StudentManagementSystem2() {
        super("Student Management System");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(13, 2, 10, 9));

        idLabel = new JLabel("ID:");
        panel.add(idLabel);
        idField = new JTextField(10);
        panel.add(idField);

        nameLabel = new JLabel("Name:");
        panel.add(nameLabel);
        nameField = new JTextField(20);
        panel.add(nameField);

        addressLabel = new JLabel("Address:");
        panel.add(addressLabel);
        addressField = new JTextField(30);
        panel.add(addressField);

        phoneLabel = new JLabel("Phone:");
        panel.add(phoneLabel);
        phoneField = new JTextField(10);
        panel.add(phoneField);

        emailLabel = new JLabel("Email:");
        panel.add(emailLabel);
        emailField = new JTextField(20);
        panel.add(emailField);

        gradeLabel = new JLabel("Grades:");
        panel.add(gradeLabel);
        gradeField = new JTextField(3);
        panel.add(gradeField);

        marksLabel = new JLabel("Marks:");
        panel.add(marksLabel);
        marksField = new JTextField(3);
        panel.add(marksField);

        genderLabel = new JLabel("Gender:");
        panel.add(genderLabel);
        genderField = new JTextField(3);
        panel.add(genderField);

        ageLabel = new JLabel("Age:");
        panel.add(ageLabel);
        ageField = new JTextField(3);
        panel.add(ageField);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        panel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        panel.add(deleteButton);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        panel.add(searchButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        panel.add(clearButton);

        add(panel);
        setVisible(true);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/students_db";
            conn = DriverManager.getConnection(url, "root", "password");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            System.exit(1);
            // error message and exit
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            System.exit(1);
        }
    }




    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
                addStudent();
            } else if (e.getSource() == updateButton) {
                updateStudent();
            } else if (e.getSource() == deleteButton) {
                deleteStudent();
            } else if (e.getSource() == searchButton) {
                searchStudent();
            } else if (e.getSource() == clearButton) {
                clearFields();
            }
    }

    private void addStudent() {
        try {
            // Get student data from input fields
            String name = nameField.getText();
            String address = addressField.getText();
            int phone = Integer.parseInt(phoneField.getText());
            String email = emailField.getText();
            String grade = gradeField.getText();
            int marks = Integer.parseInt(marksField.getText());
            String gender= genderField.getText();
            int age = Integer.parseInt(ageField.getText());
            int id = Integer.parseInt(idField.getText());

            // Insert student data into database
            String sql = "INSERT INTO students (name, address, phone, email, grade, marks, gender, age , id) VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, phone);
            statement.setString(4, email);
            statement.setString(5, grade);
            statement.setInt(6, marks);
            statement.setString(7, gender);
            statement.setInt(8, age);
            statement.setInt(9, id);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Student added successfully");
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error adding student: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid grade: " + ex.getMessage());
        }
    }

    private void updateStudent() {
        try {
            // Get student data from input fields
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String address = addressField.getText();
            int phone = Integer.parseInt(phoneField.getText());
            String email = emailField.getText();
            String grade = gradeField.getText();
            int marks = Integer.parseInt(marksField.getText());
            String gender= genderField.getText();
            int age = Integer.parseInt(ageField.getText());

            // Update student data in database
            String sql = "UPDATE students SET name=?, address=?, phone=?, email=?, grade=?, marks=?, gender=?, age=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, phone);
            statement.setString(4, email);
            statement.setString(5, grade);
            statement.setInt(6, marks);
            statement.setString(7, gender);
            statement.setInt(8, age);
            statement.setInt(9, id);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Student updated successfully");
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating student: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid grade: " + ex.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            // Get student ID from input field
            int id = Integer.parseInt(idField.getText());
            // Delete student from database
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int result = statement.executeUpdate();

            if (result == 0) {
                JOptionPane.showMessageDialog(this, "No student found with ID " + id);
            } else {
                JOptionPane.showMessageDialog(this, "Student deleted successfully");
                clearFields();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting student: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid student ID: " + ex.getMessage());
        }
    }

    private void searchStudent() {
        try {
            // Get student ID from input field
            int id = Integer.parseInt(idField.getText());

            // Search for student in database
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                // Display student data in input fields
                nameField.setText(result.getString("name"));
                addressField.setText(result.getString("address"));
                phoneField.setText(Integer.toString(result.getInt("phone")));
                emailField.setText(result.getString("email"));
                gradeField.setText(result.getString("grade"));
                marksField.setText(Integer.toString(result.getInt("marks")));
                genderField.setText(result.getString("gender"));
                ageField.setText(Integer.toString(result.getInt("age")));
            } else {
                JOptionPane.showMessageDialog(this, "No student found with ID " + id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error searching for student: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid student ID: " + ex.getMessage());
        }
    }

    private void clearFields() {
        // Clear all input fields
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
        phoneField.setText("");
        emailField.setText("");
        gradeField.setText("");
        marksField.setText("");
        genderField.setText("");
        ageField.setText("");
    }
}


public class demo {
    public static void main(String[] args) {
        StudentManagementSystem2 as = new StudentManagementSystem2();
    }
}

