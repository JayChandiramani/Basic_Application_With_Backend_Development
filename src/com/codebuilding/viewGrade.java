package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewGrade {
    public JPanel Grade;
    public JTextField SName;
    public JTextField TName;
    public JTextField subject;
    public JTextField gradeTextField;
    public JButton mainMenuButton;

    public viewGrade() {

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grade.setVisible(false);
                UserName UNObject = new UserName();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(UNObject.LoginP);
            }
        });
    }
}