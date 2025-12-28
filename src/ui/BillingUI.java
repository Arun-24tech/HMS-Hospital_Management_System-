package ui;

import dao.BillingDAO;

import javax.swing.*;
import java.awt.*;

public class BillingUI extends JFrame {

    private JTextField patientIdField;
    private JTextField amountField;

    public BillingUI() {
        setTitle("Billing System");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Components
        panel.add(new JLabel("Patient ID:"));
        patientIdField = new JTextField();
        panel.add(patientIdField);

        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        JButton generateBtn = new JButton("Generate Bill");
        panel.add(new JLabel()); // empty cell
        panel.add(generateBtn);

        add(panel);

        // Button Action
        generateBtn.addActionListener(e -> generateBill());
    }

    private void generateBill() {
        try {
            int patientId = Integer.parseInt(patientIdField.getText());
            double amount = Double.parseDouble(amountField.getText());

            BillingDAO dao = new BillingDAO();
            boolean success = dao.generateBill(patientId, amount);

            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Bill generated successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Billing failed",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter valid numbers",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
