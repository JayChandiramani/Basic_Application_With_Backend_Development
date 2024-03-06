package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addGrade {
    public JPanel addGP;
    public JTextField SName;
    public JTextField TSubject;
    public JTextField Grade;
    private JButton cancelButton;
    private JButton viewGradeButton;
    public JTextField TName;

    public addGrade() {

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGP.setVisible(false);
                UserName UserObject = new UserName();
                StudentGrades.StudentGrading.setContentPane(UserObject.LoginP);
            }
        });

        viewGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SName.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                else{
                    if (TSubject.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    else{
                        if (Grade.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        else{
                            try {
                                String host = "jdbc:mysql://localhost:3306/sgusers";
                                String uName = "root";
                                String uPass = "JaySDHS#2003";
                                Connection con = DriverManager.getConnection(host, uName, uPass);

                                Statement stmt2 = con.createStatement();
                                String SQL2 = "INSERT INTO sgusers.grades (Student_Name,Teacher_Name,Subject,Grade) VALUES ('"+SName.getText()+"','"+TName.getText()+"','"+TSubject.getText()+"','"+Grade.getText()+"');";
                                stmt2.executeUpdate(SQL2);

                                addGP.setVisible(false);
                                viewGrade vGObject = new viewGrade();
                                StudentGrades SGObject = new StudentGrades();
                                SGObject.StudentGrading.setContentPane(vGObject.Grade);

                                vGObject.SName.setText(SName.getText());
                                vGObject.TName.setText(TName.getText());
                                vGObject.subject.setText(TSubject.getText());
                                vGObject.gradeTextField.setText(Grade.getText()+"%");

                            } catch (SQLException err) {
                                System.out.println(err.getMessage());
                            }
                        }
                    }
                }
            }
        });
    }
}
