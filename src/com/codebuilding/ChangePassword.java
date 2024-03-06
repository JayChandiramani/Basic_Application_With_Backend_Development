package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ChangePassword {
    public JPanel CPPanel;
    public JTextField CPName;
    public JPasswordField CPNewP;
    public JPasswordField CPConfirmP;
    public JButton changeButton;
    public JButton cancelButton;


    public ChangePassword() {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String host = "jdbc:mysql://localhost:3306/sgusers";
                    String uName = "root";
                    String uPass = "JaySDHS#2003";
                    Connection con = DriverManager.getConnection(host, uName, uPass);

                    Statement stmt1 = con.createStatement();
                    String SQL1 = "SELECT * FROM users WHERE Name = '" + CPName.getText() + "'";
                    ResultSet rs1 = stmt1.executeQuery(SQL1);

                    if (rs1.next()) {
                        if (rs1.getString("Role").equals("Student")) {
                            CPPanel.setVisible(false);
                            Student StudentObject = new Student();
                            StudentGrades.StudentGrading.setContentPane(StudentObject.students);
                            StudentObject.SName.setText(rs1.getString("Name"));
                        } else {
                            if (rs1.getString("Role").equals("Teacher")) {
                                CPPanel.setVisible(false);
                                Teacher TeacherObject = new Teacher();
                                StudentGrades.StudentGrading.setContentPane(TeacherObject.TeacherP);
                                TeacherObject.TEACHName.setText(rs1.getString("Name"));
                            } else {
                                if (rs1.getString("Role").equals("Admin")) {
                                    CPPanel.setVisible(false);
                                    Admin AdminObject = new Admin();
                                    StudentGrades.StudentGrading.setContentPane(AdminObject.AdminP);
                                    AdminObject.AName.setText(rs1.getString("Name"));
                                }
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, CPName.getText() + " is not a user.", "Invalid Input", JOptionPane.WARNING_MESSAGE);

                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }
            }
        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CPNewP.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Please fill in a new password.","Invalid Entry",JOptionPane.WARNING_MESSAGE);
                else {
                    if (CPConfirmP.getText().equals(""))
                        JOptionPane.showMessageDialog(null,"Please confirm your password.","Invalid Entry",JOptionPane.WARNING_MESSAGE);
                    else {
                        if (!(CPNewP.getText().equals(CPConfirmP.getText()))) {
                            JOptionPane.showMessageDialog(null, "The entered passwords do not match.", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
                            CPNewP.setText("");
                            CPConfirmP.setText("");
                        }else {
                            try {
                                String host = "jdbc:mysql://localhost:3306/sgusers";
                                String uName = "root";
                                String uPass = "JaySDHS#2003";
                                Connection con = DriverManager.getConnection(host, uName, uPass);

                                Statement stmt1 = con.createStatement();
                                String SQL1 = "UPDATE sgusers.users SET Password='"+CPNewP.getText()+"' WHERE Name='"+CPName.getText()+"';";
                                stmt1.executeUpdate(SQL1);

                                Statement stmt2 = con.createStatement();
                                String SQL2 = "SELECT * FROM sgusers.users WHERE Name='"+CPName.getText()+"';";
                                ResultSet rs2 = stmt2.executeQuery(SQL2);

                                if (rs2.next()) {
                                    if (rs2.getString("Role").equals("Student")){
                                        CPPanel.setVisible(false);
                                        Student StudentObject = new Student();
                                        StudentGrades.StudentGrading.setContentPane(StudentObject.students);
                                        StudentObject.SName.setText(rs2.getString("Name"));
                                    }
                                    else{
                                        if (rs2.getString("Role").equals("Teacher")) {
                                            CPPanel.setVisible(false);
                                            Teacher TeacherObject = new Teacher();
                                            StudentGrades.StudentGrading.setContentPane(TeacherObject.TeacherP);
                                            TeacherObject.TEACHName.setText(rs2.getString("Name"));
                                        }
                                        else {
                                            if (rs2.getString("Role").equals("Admin")) {
                                                CPPanel.setVisible(false);
                                                Admin AdminObject = new Admin();
                                                StudentGrades.StudentGrading.setContentPane(AdminObject.AdminP);
                                                AdminObject.AName.setText(rs2.getString("Name"));
                                            }
                                        }
                                    }
                                }

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
