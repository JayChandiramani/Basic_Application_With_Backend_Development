package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addAdmin {
    public JPanel addAP;
    public JTextField AName;
    public JTextField AAge;
    public JComboBox AGender;
    public JButton mainMenuButton;
    public JButton addButton;
    private JTextField AUN;

    public addAdmin() {
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAP.setVisible(false);
                UserName UNObject = new UserName();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(UNObject.LoginP);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AName.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                else {
                    if (AAge.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    else {
                        if (AGender.getSelectedItem().toString().equals("Select one."))
                            JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        else {
                            if (AUN.getText().equals(""))
                                JOptionPane.showMessageDialog(null, "Please fill in all of the fields.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                            else {
                                try {
                                String host = "jdbc:mysql://localhost:3306/sgusers";
                                String uName = "root";
                                String uPass = "JaySDHS#2003";
                                Connection con = DriverManager.getConnection(host, uName, uPass);

                                Statement stmt2 = con.createStatement();
                                String SQL2 = "INSERT INTO sgusers.users (Username,Password,Name,Role) VALUES ('"+AUN.getText()+"','SDHSuser','"+AName.getText()+"','Admin');";
                                stmt2.executeUpdate(SQL2);

                                addAP.setVisible(false);
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
