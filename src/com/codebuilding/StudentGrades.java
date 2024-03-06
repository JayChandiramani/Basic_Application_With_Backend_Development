package com.codebuilding;

import javax.swing.*;

public class StudentGrades {

    public static JFrame StudentGrading;

    public static void main(String[] args) {
        UserName UNObject = new UserName();

        StudentGrading = new JFrame("Student Grading Program");
        StudentGrading.setContentPane(UNObject.LoginP);
        StudentGrading.setVisible(true);
        StudentGrading.pack();
        StudentGrading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StudentGrading.setSize(500, 500);
        StudentGrading.setLocationRelativeTo(null);
    }
}