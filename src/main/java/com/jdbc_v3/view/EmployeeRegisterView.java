package com.jdbc_v3.view;

import com.jdbc_v3.service.EmployeeService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EmployeeRegisterView extends RegisterView {
	private EmployeeService employeeService;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton submitButton;
	private ButtonEditor buttonEditor;
	private ButtonRender buttonRender;


	public EmployeeRegisterView() {
		
		 submitButton = new JButton("Submit");
	        submitButton.setBounds(150, 200, 100, 30);
	        add(submitButton);
		buttonRender=new ButtonRender();
		buttonEditor=new ButtonEditor(new JButton("Delete"));
		employeeService=new EmployeeService();
		 tableModel = new DefaultTableModel();
		    tableModel.addColumn("Id");
	        tableModel.addColumn("Name");
	        tableModel.addColumn("Email");
	        tableModel.addColumn("Phone Number");
	        tableModel.addColumn("Action");
	        table = new JTable(tableModel);
	        add(new JScrollPane(table)).setBounds(50, 250, 500, 400);
	        table.getColumn("Action").setCellRenderer(buttonRender);
	        table.getColumn("Action").setCellEditor(buttonEditor);
	   }


	public class ButtonRender extends JButton implements TableCellRenderer{
	    	public ButtonRender() {
	    		setOpaque(true);
	    	}

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				setText(value == null ? "Delete": value.toString());
				return this;
			}
	    }
	   public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
	        private JButton button;
	        private int row;
			private int column;

	        public ButtonEditor(JButton button) {
	            this.button = button;
	            this.button.addActionListener(this);
	        }

	        @Override
	        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	            this.row = row;
				this.column = column;
	            button.setText(value == null ? "Delete" : value.toString());
	            return button;
	        }

	        @Override
	        public Object getCellEditorValue() {
	            return button.getText();
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
				System.out.println("Row : Column" + row+":"+column);
				Object id=tableModel.getValueAt((row),0);
				employeeService.deleteEmployee((String)id);
	            tableModel.removeRow(row);
	        }
	    }

		//getter Setter
	    public JButton getSubmitButton() {
	        return submitButton;
	    }

	    public void setSubmitButton(JButton submitButton) {
	        this.submitButton = submitButton;
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
		public ButtonEditor getButtonEditor() {
			return buttonEditor;
		}

		public void setButtonEditor(ButtonEditor buttonEditor) {
			this.buttonEditor = buttonEditor;
		}

		public ButtonRender getButtonRender() {
			return buttonRender;
		}

		public void setButtonRender(ButtonRender buttonRender) {
			this.buttonRender = buttonRender;
		}

}
