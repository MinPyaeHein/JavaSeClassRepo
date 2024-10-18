package com.jdbc_v2.view;

import java.awt.Adjustable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class RegisterView extends JPanel{
	private JLabel name,phone,address;
	private JTextField txtName, txtPhone, txtAddress;
	

	
	public RegisterView() {
        this.setLayout(null);

        name = new JLabel("Name:");
        phone = new JLabel("Phone:");
        address = new JLabel("Address:");

        txtName = new JTextField(20);
        txtPhone = new JTextField(20);
        txtAddress = new JTextField(20);

        name.setBounds(100, 50, 100, 30);
        txtName.setBounds(200, 50, 200, 30);

        phone.setBounds(100, 100, 100, 30);
        txtPhone.setBounds(200, 100, 200, 30);

        address.setBounds(100, 150, 100, 30);
        txtAddress.setBounds(200, 150, 200, 30);

        this.add(name);
        this.add(txtName);
        this.add(phone);
        this.add(txtPhone);
        this.add(address);
        this.add(txtAddress);
        
       


       
		
		this.setVisible(true);
		

		
	}
	
	    public JTextField getTxtName() {
	        return txtName;
	    }

	    public void setTxtName(JTextField txtName) {
	        this.txtName = txtName;
	    }

	    public JTextField getTxtPh() {
	        return txtPhone;
	    }

	    public void setTxtPh(JTextField txtPh) {
	        this.txtPhone = txtPh;
	    }
	    
	    public JTextField getTxtAddress() {
	    	return txtAddress;
	    }
	    
	    public void setTxtAddress(JTextField txtAddress) {
	    	this.txtAddress = txtAddress;
	    }
	 

	
	

}
