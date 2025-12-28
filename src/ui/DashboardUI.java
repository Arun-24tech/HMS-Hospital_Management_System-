package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {

    public DashboardUI() {
        setTitle("Hospital Management System");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // Header
        JLabel header = new JLabel("Hospital Management System", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        mainPanel.add(header, BorderLayout.NORTH);

        // Center panel with buttons
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        centerPanel.setBackground(new Color(245, 247, 250));

        JButton patientBtn = createButton("Patients");
        JButton doctorBtn = createButton("Doctors");
        JButton billingBtn = createButton("Billing");

        centerPanel.add(patientBtn);
        centerPanel.add(doctorBtn);
        centerPanel.add(billingBtn);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Button actions
        billingBtn.addActionListener(e -> {
            new BillingUI().setVisible(true);
            dispose();
        });

        patientBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this,
                "Patient module coming soon",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
            )
        );

        doctorBtn.addActionListener(e ->
            JOptionPane.showMessageDialog(
                this,
                "Doctor module coming soon",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
            )
        );

        add(mainPanel);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(52, 152, 219));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        return btn;
    }
}
