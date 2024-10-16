package com.JDBC_V1.JDBC.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeRegisterForm extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JButton registerButton;
    private JScrollPane tableScrollPane;
    private JOptionPane jOptionPane;

    public EmployeeRegisterForm() {
        // Set frame properties
        setTitle("Employee Register Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panel for form inputs
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add form components
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        formPanel.add(addressField);

        registerButton = new JButton("Register");
        formPanel.add(registerButton);

        // Add a placeholder for layout purposes
        formPanel.add(new JLabel(""));

        // Add form panel to the top of the frame
        add(formPanel, BorderLayout.NORTH);

        // Create table model with column names
        String[] columnNames = {"Name", "Phone", "Address"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);

        // Add table to a scroll pane
        tableScrollPane = new JScrollPane(employeeTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Add ActionListener for the register button
//        registerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                registerEmployee();
//            }
//        });

        setVisible(true);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public void setPhoneField(JTextField phoneField) {
        this.phoneField = phoneField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public void setAddressField(JTextField addressField) {
        this.addressField = addressField;
    }

    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public void setEmployeeTable(JTable employeeTable) {
        this.employeeTable = employeeTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public JScrollPane getTableScrollPane() {
        return tableScrollPane;
    }

    public void setTableScrollPane(JScrollPane tableScrollPane) {
        this.tableScrollPane = tableScrollPane;
    }

    public JOptionPane getjOptionPane() {
        return jOptionPane;
    }

    public void setjOptionPane(JOptionPane jOptionPane) {
        this.jOptionPane = jOptionPane;
    }

    // Method to register the employee and add the data to the table
//    private void registerEmployee() {
//        String name = nameField.getText();
//        String phone = phoneField.getText();
//        String address = addressField.getText();
//
//        // Validate inputs (simple check)
//        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
//        } else {
//            // Add new employee data to the table
//            Object[] employeeData = {name, phone, address};
//            tableModel.addRow(employeeData);
//
//            // Clear the input fields
//            nameField.setText("");
//            phoneField.setText("");
//            addressField.setText("");
//        }
//    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new EmployeeRegisterForm();
//            }
//        });
//    }
}
