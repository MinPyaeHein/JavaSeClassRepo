package com.GUIProject.StudentRegister;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RegisterView extends JFrame {
   private Button submitButton,deleteButton,updateButton;
   private TextField txtName, txtEmail, txtPh;
   private DefaultTableModel tableModel;
   private JTable table;
    public RegisterView() {
        setTitle("Register Form");
        setLayout(null);
        Label headerLabel = new Label("User Registration Form", Label.CENTER);
        headerLabel.setBounds(100, 40, 200, 30);
        add(headerLabel);

        Panel labelPanel = new Panel();
        labelPanel.setLayout(null);
        labelPanel.setBounds(50, 90, 100, 100);

        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(0, 0, 80, 25);
        labelPanel.add(nameLabel);

        Label emailLabel = new Label("Email:");
        emailLabel.setBounds(0, 30, 80, 25);
        labelPanel.add(emailLabel);

        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setBounds(0, 60, 80, 25);
        labelPanel.add(phoneLabel);
        add(labelPanel);

        Panel fieldPanel = new Panel();
        fieldPanel.setLayout(null);
        fieldPanel.setBounds(150, 90, 200, 100);

        txtName = new TextField(15);
        txtName.setBounds(0, 0, 150, 25);
        fieldPanel.add(txtName);

        txtEmail = new TextField(15);
        txtEmail.setBounds(0, 30, 150, 25);
        fieldPanel.add(txtEmail);

        txtPh = new TextField(15);
        txtPh.setBounds(0, 60, 150, 25);
        fieldPanel.add(txtPh);
        add(fieldPanel);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Action");
        table = new JTable(tableModel);
        add(new JScrollPane(table)).setBounds(50, 240, 300, 100);


        submitButton = new Button("Submit");
        submitButton.setBounds(150, 200, 100, 30);
        add(submitButton);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public TextField getTxtPh() {
        return txtPh;
    }

    public void setTxtPh(TextField txtPh) {
        this.txtPh = txtPh;
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

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }
}
