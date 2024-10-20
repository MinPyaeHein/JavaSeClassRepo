package com.jdbc_v3_lec.controller;

import com.jdbc_v3_lec.model.Teacher;
import com.jdbc_v3_lec.service.TeacherService;
import com.jdbc_v3_lec.view.TeacherRegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;





public class TeacherRegisterController {
    private TeacherRegisterView teacherView;
    private TeacherService teacherService;

    public TeacherRegisterController(TeacherRegisterView teacherView) {
        this.teacherView = teacherView;
        this.teacherService = new TeacherService();
        addTeacherDataToTable(); 
        this.teacherView.getSubmitButton().addActionListener(new ButtonActionListener());
    }

    public class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(teacherView.getSubmitButton())) {
                System.out.println("Register Button Clicked");
                String name = teacherView.getTxtName().getText();
                String phone = teacherView.getTxtPh().getText();
                String address = teacherView.getTxtAddress().getText();
                String department = teacherView.getTxtDepartment().getText(); 
                String position = teacherView.getTxtPosition().getText();

                if (!name.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !department.isEmpty() && !position.isEmpty()) {
                    Teacher teacher = new Teacher(name, phone, address, department,position);
                    teacherService.addTeacher(teacher);
                    addTeacherDataToTable();
                    teacherView.getTxtName().setText("");
                    teacherView.getTxtPh().setText("");
                    teacherView.getTxtAddress().setText("");
                    teacherView.getTxtDepartment().setText("");
                } else {
                    System.out.println("Please fill in all fields!"); 
                }
            }
        }
    }

    public void addTeacherDataToTable() {
        teacherView.getTableModel().setRowCount(0);
        List<Teacher> teachers = teacherService.getTeacher();
        for (Teacher teacher : teachers) {
            String[] data = new String[]{teacher.getName(), teacher.getPhone(), teacher.getAddress(), teacher.getDepartment(),teacher.getPosition()};
            teacherView.getTableModel().addRow(data);
        }
    }
}
