package com.jdbc_v2.controller;

import com.jdbc_v2.view.EmployeeRegisterView;
import com.jdbc_v2.view.MainFrame;
import com.jdbc_v2.view.TeacherRegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrameController {
	private MainFrame mainFrame;
	private EmployeeRegisterView employeeRegisterView;
	private TeacherRegisterView teacherRegisterView;
	
	public MainFrameController() {
		mainFrame = new MainFrame();
		this.mainFrame.getEmployeeItem().addActionListener(new menuItemListener());
		this.mainFrame.getTeacherItem().addActionListener(new menuItemListener());
		
		
	}
	
	public class menuItemListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame.getContentPane().removeAll();
			if(e.getSource().equals(mainFrame.getEmployeeItem())) {
				employeeRegisterView = new EmployeeRegisterView();
				EmployeeRegisterController controller=new EmployeeRegisterController(employeeRegisterView);
				mainFrame.getContentPane().add(employeeRegisterView);				
			}else if(e.getSource().equals(mainFrame.getTeacherItem())) {
				teacherRegisterView =new TeacherRegisterView();
				TeacherRegisterController teacherController = new TeacherRegisterController(teacherRegisterView);
				mainFrame.getContentPane().add(teacherRegisterView);
				
				
			}
			mainFrame.revalidate();  
	          mainFrame.repaint();
			}
			
		}


}
