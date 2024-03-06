package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teacher {
    private JButton cancelButton;
    public JPanel TeacherP;
    private JButton addGradeButton;
    public JTextField TEACHName;
    private JButton changePasswordButton;

    public Teacher() {

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherP.setVisible(false);
                UserName UserObject = new UserName();
                StudentGrades.StudentGrading.setContentPane(UserObject.LoginP);
            }
        });

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherP.setVisible(false);
                addGrade addGObject = new addGrade();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(addGObject.addGP);
                addGObject.TName.setText(TEACHName.getText());
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherP.setVisible(false);
                StudentGrades StudentObject = new StudentGrades();
                ChangePassword CPObject = new ChangePassword();
                StudentObject.StudentGrading.setContentPane(CPObject.CPPanel);
                CPObject.CPName.setText(TEACHName.getText());
            }
        });
    }
}