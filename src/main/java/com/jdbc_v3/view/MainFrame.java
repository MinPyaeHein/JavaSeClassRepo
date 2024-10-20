package com.jdbc_v3.view;

import javax.swing.*;

public class MainFrame extends JFrame{
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu registerMenu;
	private JMenuItem employeeItem, teacherItem;
	
	
	public MainFrame() {
		
		menuBar = new JMenuBar();
		registerMenu = new JMenu("Register");
		employeeItem = new JMenuItem("Employee Register");
		teacherItem = new JMenuItem("Teacher Register");
		registerMenu.add(employeeItem);
		registerMenu.add(teacherItem);
		menuBar.add(registerMenu);
		
		desktopPane = new JDesktopPane();
		
		this.setJMenuBar(menuBar);
		this.add(desktopPane);
		
		
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	public JMenuItem getEmployeeItem() {
		return employeeItem;
	}
	
	public JMenuItem getTeacherItem() {
		return teacherItem;
	}

}
