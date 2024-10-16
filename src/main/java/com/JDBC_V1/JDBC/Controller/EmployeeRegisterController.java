package com.JDBC_V1.JDBC.Controller;

import com.JDBC_V1.JDBC.Dao.EmployeeDao;
import com.JDBC_V1.JDBC.Model.Employee;
import com.JDBC_V1.JDBC.Service.EmployeeService;
import com.JDBC_V1.JDBC.Views.EmployeeRegisterForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeRegisterController {
    private EmployeeService employeeService;
    private EmployeeRegisterForm employeeRegisterForm;
    public EmployeeRegisterController() {
        this.employeeRegisterForm = new EmployeeRegisterForm();
        this.employeeService = new EmployeeService();
        this.employeeRegisterForm.getRegisterButton().addActionListener(new EmployeeFormActionListener());
    }
    public class EmployeeFormActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == employeeRegisterForm.getRegisterButton()) {
                String name = employeeRegisterForm.getNameField().getText();
                String phone = employeeRegisterForm.getPhoneField().getText();
                String address = employeeRegisterForm.getAddressField().getText();

        // Validate inputs (simple check)

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {

            employeeRegisterForm.getjOptionPane().showMessageDialog(employeeRegisterForm, "Please fill all fields", "Error", employeeRegisterForm.getjOptionPane().ERROR_MESSAGE);
        } else {
            String message = employeeService.addEmployee(new Employee(name, phone, address));
            System.out.println(message);
            // Add new employee data to the table
            Object[] employeeData = {name, phone, address};
            employeeRegisterForm.getTableModel().addRow(employeeData);

            // Clear the input fields
            employeeRegisterForm.getNameField().setText("");
            employeeRegisterForm.getPhoneField().setText("");
            employeeRegisterForm.getAddressField().setText("");
            }
            }
        }
    }
}
