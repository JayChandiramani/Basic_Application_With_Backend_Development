package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class addStudent {
    public JPanel addSP;
    public JTextField addSName;
    public JTextField SAge;
    private JButton mainMenuButton;
    public JButton addButton;
    public JComboBox SGender;
    public JTextField SUN;

    public addStudent() {

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSP.setVisible(false);
                UserName UNObject = new UserName();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(UNObject.LoginP);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addSName.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                else {
                    if (SAge.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    else {
                        if (SGender.getSelectedItem().toString().equals("Select one."))
                            JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        else {
                            if (SUN.getText().equals(""))
                                JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                            else {
                                try {
                                    String host = "jdbc:mysql://localhost:3306/sgusers";
                                    String uName = "root";
                                    String uPass = "JaySDHS#2003";
                                    Connection con = DriverManager.getConnection(host, uName, uPass);

                                    Statement stmt2 = con.createStatement();
                                    String SQL2 = "INSERT INTO sgusers.users (Username,Password,Name,Role) VALUES ('"+SUN.getText()+"','SDHSuser','"+addSName.getText()+"','Student');";
                                    stmt2.executeUpdate(SQL2);

                                    addSP.setVisible(false);
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
