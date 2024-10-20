package com.jdbc_v3_lec.controller;


import com.jdbc_v3_lec.model.Employee;
import com.jdbc_v3_lec.service.EmployeeService;
import com.jdbc_v3_lec.view.EmployeeRegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class EmployeeRegisterController {
    private EmployeeRegisterView registerView;
    private EmployeeService employeeService;

    public EmployeeRegisterController(EmployeeRegisterView registerView) {
        this.registerView = registerView;
        this.employeeService = new EmployeeService();
        addEmployeeDataToTable();
        this.registerView.getSubmitButton().addActionListener(new ButtonActionListener());

    }


    public class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(registerView.getSubmitButton())) {
                System.out.println("Register Button Clicked");


                String name = registerView.getTxtName().getText();
                String phone = registerView.getTxtPh().getText();
                String address = registerView.getTxtAddress().getText();


                if (!name.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {

                    Employee employee = new Employee(name, phone, address);

                    employeeService.addEmployee(employee);

                    addEmployeeDataToTable();


                    registerView.getTxtName().setText("");
                    registerView.getTxtPh().setText("");
                    registerView.getTxtAddress().setText("");
                } else {
                    System.out.println("Please fill in all fields!");
                }
            }
        }
    }


    public void addEmployeeDataToTable() {

        registerView.getTableModel().setRowCount(0);

        List<Employee> employees = employeeService.getEmployees();


        for (Employee employee : employees) {
            String[] data = new String[]{employee.getId()+"",employee.getName(), employee.getPhone(), employee.getAddress()};
            registerView.getTableModel().addRow(data);
        }
    }



}