package com.GUIProject.StudentRegister;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegisterController {
    private RegisterView registerView;
    private StudentService studentService;
    public RegisterController(RegisterView registerView){
        this.registerView = registerView;
        this.studentService = new StudentService();
        addStudentDataToTable();
        this.registerView.getSubmitButton().addActionListener(new ButtonActionListener());
    }

    public class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(registerView.getSubmitButton())){
                System.out.println("Register Button Clicked");
                String name=registerView.getTxtName().getText();
                String email=registerView.getTxtEmail().getText();
                String ph=registerView.getTxtPh().getText();
                if (!name.isEmpty() && !email.isEmpty() && !ph.isEmpty()) {
                    Student student=new Student(name, email, ph);
                    StudentService.addStudent(student);
                    addStudentDataToTable();
                }
                registerView.getTxtName().setText("");
                registerView.getTxtEmail().setText("");
                registerView.getTxtPh().setText("");
            }
            }

        }
    public void addStudentDataToTable( ) {
        registerView.getTableModel().setRowCount(0); //Clear table before adding new data
       System.out.println("Clearing table");
       List<Student> students=StudentService.getStudents();
       System.out.println("Adding students");
       for(Student student:students){
           String[] data = new String[] {student.getName(), student.getEmail(), student.getPhone()};
           registerView.getTableModel().addRow(data);


       }
    }

}
