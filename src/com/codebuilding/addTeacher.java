package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addTeacher {
    public JPanel addTP;
    public JTextField TName;
    public JTextField TSubject;
    private JButton mainMenuButton;
    public JTextField TAge;
    public JComboBox TGender;
    public JButton addButton;
    public JTextField TUN;

    public addTeacher() {

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTP.setVisible(false);
                UserName UNObject = new UserName();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(UNObject.LoginP);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TName.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                else {
                    if (TSubject.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    else {
                        if (TAge.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        else {
                            if (TGender.getSelectedItem().toString().equals("Select one."))
                                JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                            else {
                                try {
                                    String host = "jdbc:mysql://localhost:3306/sgusers";
                                    String uName = "root";
                                    String uPass = "JaySDHS#2003";
                                    Connection con = DriverManager.getConnection(host, uName, uPass);

                                    Statement stmt2 = con.createStatement();
                                    String SQL2 = "INSERT INTO sgusers.users (Username,Password,Name,Role) VALUES ('"+TUN.getText()+"','SDHSuser','"+TName.getText()+"','Teacher');";
                                    stmt2.executeUpdate(SQL2);

                                    addTP.setVisible(false);
                                    UserName UNObject = new UserName();
                                    StudentGrades SGObject = new StudentGrades();
                                    SGObject.StudentGrading.setContentPane(UNObject.LoginP);

                                } catch (SQLException err) {
                                    System.out.println(err.getMessage());
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
