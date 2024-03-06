package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Student {
    private JButton cancelButton;
    public JTextField SName;
    private JButton viewGradeButton;
    public JPanel students;
    private JButton changePasswordButton;

    public Student() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                students.setVisible(false);
                UserName UserObject = new UserName();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(UserObject.LoginP);
            }
        });

        viewGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String host = "jdbc:mysql://localhost:3306/sgusers";
                    String uName = "root";
                    String uPass = "JaySDHS#2003";
                    Connection con = DriverManager.getConnection(host, uName, uPass);

                    Statement stmt1 = con.createStatement();
                    String SQL1 = "SELECT * FROM grades WHERE Student_Name = '"+SName.getText()+"'";
                    ResultSet rs1 = stmt1.executeQuery(SQL1);

                    Statement stmt2 = con.createStatement();
                    String SQL2 = "SELECT * FROM users WHERE Name = '"+SName.getText()+"'";
                    ResultSet rs2 = stmt2.executeQuery(SQL2);

                    if (rs2.next()) {
                        if (rs1.next()) {
                            students.setVisible(false);
                            StudentGrades SGObject = new StudentGrades();
                            viewGrade viewGObject = new viewGrade();
                            SGObject.StudentGrading.setContentPane(viewGObject.Grade);

                            viewGObject.SName.setText(rs1.getString("Student_Name"));
                            viewGObject.TName.setText(rs1.getString("Teacher_Name"));
                            viewGObject.subject.setText(rs1.getString("Subject"));
                            viewGObject.gradeTextField.setText(rs1.getString("Grade")+"%");
                        }
                        else
                            JOptionPane.showMessageDialog(null,"There is no grade available for this student.","Error",JOptionPane.WARNING_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,SName.getText()+" is not a user.","Error",JOptionPane.WARNING_MESSAGE);

                } catch(SQLException err){
                    System.out.println(err.getMessage());
                }
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                students.setVisible(false);
                StudentGrades StudentObject = new StudentGrades();
                ChangePassword CPObject = new ChangePassword();
                StudentObject.StudentGrading.setContentPane(CPObject.CPPanel);
                CPObject.CPName.setText(SName.getText());
            }
        });
    }
}
