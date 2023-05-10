package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobApplicationForm2 extends JFrame implements ActionListener {

    private JLabel nameLabel, emailLabel, phoneLabel, educationLabel, genderLabel, programmingLabel;
    private JTextField nameField, emailField, phoneField;
    private JButton submitButton;
    private JCheckBox tenCheckBox, tweCheckBox, ugCheckBox;
    private JRadioButton maleRadioButton ,femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private JCheckBox javaCheckBox, pythonCheckBox, cSharpCheckBox, rubyCheckBox;

    public JobApplicationForm2() {
        setTitle("Job Application Form");
        setSize(500, 400);

        nameLabel = new JLabel("Name: ");
        emailLabel = new JLabel("Email: ");
        phoneLabel = new JLabel("Phone: ");
        educationLabel = new JLabel("Education: ");
        genderLabel = new JLabel("Gender");
        programmingLabel = new JLabel("Programming Languages: ");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);


        tenCheckBox = new JCheckBox("10");
        tweCheckBox = new JCheckBox("12");
        ugCheckBox = new JCheckBox("UG");

        maleRadioButton = new JRadioButton("male");
        femaleRadioButton = new JRadioButton("female");

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);


        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        cSharpCheckBox = new JCheckBox("C++");
        rubyCheckBox = new JCheckBox("Js");

        JPanel formPanel = new JPanel(new GridLayout(10, 5));
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        
        formPanel.add(educationLabel);
        formPanel.add(tenCheckBox);
        formPanel.add(tweCheckBox);
        formPanel.add(ugCheckBox);
        
        formPanel.add(genderLabel);
        formPanel.add(maleRadioButton);
        formPanel.add(femaleRadioButton);
        
        formPanel.add(programmingLabel);
        formPanel.add(javaCheckBox);
        formPanel.add(pythonCheckBox);
        formPanel.add(cSharpCheckBox);
        formPanel.add(rubyCheckBox);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            
            String education = "Education: ";
            if (tenCheckBox.isSelected()) {
                education += "10 ";
            }
            if (tweCheckBox.isSelected()) {
                education += " 12 ";
            }
            if (ugCheckBox.isSelected()) {
                education += " UG";
            }
            
            
            String gender = "Gender: ";
            if (maleRadioButton.isSelected()) {
                gender += " male ";
            }
            if (femaleRadioButton.isSelected()) {
                gender += " female ";
            }
            
            
            String lang = "Language: ";
            if (javaCheckBox.isSelected()) {
            	lang += "Java ";
            }
            if (pythonCheckBox.isSelected()) {
            	lang += " Python ";
            }
            if (cSharpCheckBox.isSelected()) {
            	lang += " C++ ";
            }
            if (rubyCheckBox.isSelected()) {
            	lang += " JS";
            }
            
            String message = "Name: " +name + "\nEmail: " + email + "\nPhone: " + phone + "\n" + education + "\n" + gender + "\n" + lang ;
            JOptionPane.showMessageDialog(null, message );
        }
    }
    
    public static void main(String[] args) {
        new JobApplicationForm2();
    }
}

