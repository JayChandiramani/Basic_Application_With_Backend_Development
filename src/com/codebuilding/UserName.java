package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserName {
    public JPanel LoginP;
    public JTextField UserName;
    private JButton cancelButton;
    private JButton loginButton;
    private JPasswordField LoginPassword;

    public UserName() {

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (UserName.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please enter a valid username.", "Invalid Username", JOptionPane.WARNING_MESSAGE);
                else {
                    if (LoginPassword.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please enter a valid password.", "Invalid Password", JOptionPane.WARNING_MESSAGE);
                    else {
                        try {
                        String host = "jdbc:mysql://localhost:3306/sgusers";
                        String uName = "root";
                        String uPass = "JaySDHS#2003";
                        Connection con = DriverManager.getConnection(host, uName, uPass);

                        Statement stmt1 = con.createStatement();
                        String SQL1 = "SELECT * FROM users WHERE Username = '"+UserName.getText()+"'";
                        ResultSet rs1 = stmt1.executeQuery(SQL1);

                        if (rs1.next()) {
                            if (LoginPassword.getText().equals(rs1.getString("Password"))) {
                                if (rs1.getString("Role").equals("Student")){
                                    LoginP.setVisible(false);
                                    Student StudentObject = new Student();
                                    StudentGrades.StudentGrading.setContentPane(StudentObject.students);
                                    StudentObject.SName.setText(rs1.getString("Name"));
                                }
                                else{
                                    if (rs1.getString("Role").equals("Teacher")) {
                                        LoginP.setVisible(false);
                                        Teacher TeacherObject = new Teacher();
                                        StudentGrades.StudentGrading.setContentPane(TeacherObject.TeacherP);
                                        TeacherObject.TEACHName.setText(rs1.getString("Name"));
                                    }
                                    else {
                                        if (rs1.getString("Role").equals("Admin")) {
                                            LoginP.setVisible(false);
                                            Admin AdminObject = new Admin();
                                            StudentGrades.StudentGrading.setContentPane(AdminObject.AdminP);
                                            AdminObject.AName.setText(rs1.getString("Name"));
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect Password Entered", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                                LoginPassword.setText("");
                            }
                        } else
                            JOptionPane.showMessageDialog(null,UserName.getText()+" is not a user.","Invalid Input",JOptionPane.WARNING_MESSAGE);

                        } catch(SQLException err) {
                            System.out.println(err.getMessage());
                        }
                    }
                }
            }
        });
    }
}
