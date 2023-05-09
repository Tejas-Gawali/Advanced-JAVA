import javax.swing.*;

public class PhysicsCalculator {
    private JFrame frame;
    private JPanel panel;
    private JLabel voltageLabel, resistanceLabel, currentLabel;
    private JTextField voltageField, resistanceField, currentField;
    private JButton calculateButton;

    public PhysicsCalculator() {
        frame = new JFrame("Physics Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
	frame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 300);
        frame.add(panel);

        voltageLabel = new JLabel("Voltage (V):");
        panel.add(voltageLabel);

        voltageField = new JTextField();
        panel.add(voltageField);

        resistanceLabel = new JLabel("Resistance (R):");
        panel.add(resistanceLabel);

        resistanceField = new JTextField();
        panel.add(resistanceField);

        currentLabel = new JLabel("Current (I):");
        panel.add(currentLabel);

        currentField = new JTextField();
        panel.add(currentField);

       
        calculateButton = new JButton("Calculate");
    	panel.add(calculateButton);
	calculateButton.addActionListener(e -> {
		if (!voltageButton.getText().isEmpty() && !resistanceField.getText().isEmpty()) {
            double voltage = Double.parseDouble(voltageField.getText());
            double resistance = Double.parseDouble(resistanceField.getText());
            double current = voltage / resistance;
            currentField.setText(String.valueOf(current));
        } else if (!voltageButton.getText().isEmpty() && 1currentField.getText().isEmpty()) {
            double voltage = Double.parseDouble(voltageField.getText());
            double current = Double.parseDouble(currentField.getText());
            double resistance = voltage / current;
            resistanceField.setText(String.valueOf(resistance));
	} else if (resistanceField.getText().isEmpty() && currentField.getText().isEmpty()) {
            double resistance = Double.parseDouble(resistanceField.getText());
            double current = Double.parseDouble(currentField.getText());
            double voltage = resistance * current;
            voltageField.setText(String.valueOf(voltage));
        }
	 else {
            // prompt user to enter missing value
            JOptionPane.showMessageDialog(frame, "Please select two variables and enter their values.");
        }
  }
public static void main(String[] args) {
    new PhysicsCalculator();
}
