package com.codebuilding;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {
    public JPanel AdminP;
    private JButton cancelButton;
    public JTextField AName;
    private JButton changePasswordButton;
    private JComboBox AdditionChoiceBox;
    private JButton addUserButton;

    public Admin() {

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminP.setVisible(false);
                UserName UNObject = new UserName();
                StudentGrades SGObject = new StudentGrades();
                SGObject.StudentGrading.setContentPane(UNObject.LoginP);
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminP.setVisible(false);
                StudentGrades StudentObject = new StudentGrades();
                ChangePassword CPObject = new ChangePassword();
                StudentObject.StudentGrading.setContentPane(CPObject.CPPanel);
                CPObject.CPName.setText(AName.getText());
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AdditionChoiceBox.getSelectedItem().toString().equals("Select one."))
                    JOptionPane.showMessageDialog(null, "Please select which type of user you wish to add.", "Invalid User Type",JOptionPane.WARNING_MESSAGE);
                else{
                    if (AdditionChoiceBox.getSelectedItem().toString().equals("Student")){
                        AdminP.setVisible(false);
                        addStudent addSObject = new addStudent();
                        StudentGrades SGObject = new StudentGrades();
                        SGObject.StudentGrading.setContentPane(addSObject.addSP);
                    } else {
                        if (AdditionChoiceBox.getSelectedItem().toString().equals("Teacher")){
                            AdminP.setVisible(false);
                            addTeacher addTObject = new addTeacher();
                            StudentGrades SGObject = new StudentGrades();
                            SGObject.StudentGrading.setContentPane(addTObject.addTP);
                        } else {
                            if (AdditionChoiceBox.getSelectedItem().toString().equals("Admin")){
                                AdminP.setVisible(false);
                                addAdmin addAObject = new addAdmin();
                                StudentGrades SGObject = new StudentGrades();
                                SGObject.StudentGrading.setContentPane(addAObject.addAP);
                            }
                        }
                    }
                }
            }
        });
    }
}
