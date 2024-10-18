package com.jdbc_v2.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TeacherRegisterView extends RegisterView {
    private JLabel departmentLabel;
    private JTextField txtDepartment; 
    private JLabel positionLabel; 
    private JTextField txtPosition; 
    private DefaultTableModel tableModel;
	private JTable table;
	private JButton submitButton;
    
    public TeacherRegisterView() {
      
        
        departmentLabel = new JLabel("Department:");
        txtDepartment = new JTextField(20);
        departmentLabel.setBounds(100, 200, 100, 30);
        txtDepartment.setBounds(200, 200, 200, 30);
        
        positionLabel = new JLabel("Position:"); 
        txtPosition = new JTextField(20); 
        positionLabel.setBounds(100, 250, 100, 30); 
        txtPosition.setBounds(200, 250, 200, 30); 
        
        this.add(departmentLabel);
        this.add(txtDepartment);
        this.add(positionLabel); 
        this.add(txtPosition); 
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 300, 100, 30);
        add(submitButton);
        
    
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("department");
        tableModel.addColumn("Position");
        tableModel.addColumn("Action");
        table = new JTable(tableModel);
        add(new JScrollPane(table)).setBounds(50, 350, 500, 400);

    }
    
    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JTextField getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(JTextField txtDepartment) {
        this.txtDepartment = txtDepartment;
    }

    public JTextField getTxtPosition() { 
        return txtPosition;
    }

    public void setTxtPosition(JTextField txtPosition) { 
        this.txtPosition = txtPosition;
    }
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
