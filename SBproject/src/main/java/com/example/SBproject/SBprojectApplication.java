package com.example.SBproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import java.sql.*;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBprojectApplication {

    public static void main(String[] args) throws SQLException {
        Database db = new Database();    
        //db.CreateDB();
        JPanel panelHeaderLabel = new JPanel();
        JLabel panelHeader = new JLabel("Employee Management System");    
        panelHeader.setFont(new Font("Verdana", Font.PLAIN, 18));    
        panelHeaderLabel.add(panelHeader);
        //Username
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel userlabel = new JLabel("Username");
        panel.add(userlabel);
        JTextField field = new JTextField(10);
        userlabel.setLabelFor(field);
        panel.add(field);
        //First name
        JLabel firstlabel = new JLabel("First name");
        panel.add(firstlabel);
        JTextField field2 = new JTextField(10);
        userlabel.setLabelFor(field2);
        panel.add(field2);
        //Last name
        JLabel lastlabel = new JLabel("Last name");
        panel.add(lastlabel);
        JTextField field3 = new JTextField(10);
        userlabel.setLabelFor(field3);
        panel.add(field3);
        //Add button
        JButton button1 = new JButton("Submit");
        panel.add(button1);
		JPanel border1AddPnl = new JPanel(new BorderLayout());
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Add Employee");        
        titlePanel.add(title);
        border1AddPnl.add(panelHeaderLabel, BorderLayout.NORTH);
        border1AddPnl.add(titlePanel, BorderLayout.CENTER);
        border1AddPnl.add(panel, BorderLayout.SOUTH);
        JPanel titleListPanel = new JPanel();
        JLabel userListlabel = new JLabel("Employee List");
        titleListPanel.add(userListlabel);
        JPanel gb = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 1.0;

        //Displays all users
        List<String[]> users = db.getUsers();
        for(int i = 0; i < users.size(); i++){
            String[] user = (users.get(i));
            String userString = "Username: " + user[0] + " Full Name: " + user[1] + " " +user[2];
            JLabel label = new JLabel(userString);
            System.out.println(userString);            
            //userPanel.add(label);
            gb.add(label, gbc);
        }
        JPanel border1ListPnl = new JPanel(new BorderLayout());
        border1ListPnl.add(titleListPanel, BorderLayout.NORTH);
        border1ListPnl.add(gb, BorderLayout.CENTER);
        //User List Layout
        JPanel borderPnl = new JPanel(new BorderLayout());
        borderPnl.add(border1AddPnl, BorderLayout.NORTH);
        borderPnl.add(border1ListPnl, BorderLayout.CENTER);
		//Edit User Panels
        JPanel Editpanel = new JPanel();
        Editpanel.setLayout(new FlowLayout());
        JLabel userEditlabel = new JLabel("Employee username to edit");
        Editpanel.add(userEditlabel);
        JTextField fieldEdit = new JTextField(10);
        userlabel.setLabelFor(fieldEdit);
        Editpanel.add(fieldEdit);
        JLabel userEditlabel2 = new JLabel("New Employee Username");
        Editpanel.add(userEditlabel2);
        JTextField fieldEdit2 = new JTextField(10);
        userlabel.setLabelFor(fieldEdit2);
        Editpanel.add(fieldEdit2);
        JPanel border1EditPnl = new JPanel(new BorderLayout());
        JPanel titleEditPanel = new JPanel();
        JLabel titleEdit = new JLabel("Edit an Employee");
        
        //Add button
        JButton button2 = new JButton("Submit");
        Editpanel.add(button2);        
        titleEditPanel.add(titleEdit);
        border1EditPnl.add(titleEditPanel, BorderLayout.NORTH);
        border1EditPnl.add(Editpanel, BorderLayout.CENTER);

        //Drop User Panels
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        userlabel = new JLabel("Employee username to delete");
        panel.add(userlabel);
        JTextField fieldDrop = new JTextField(10);
        userlabel.setLabelFor(userlabel);
        panel.add(fieldDrop);
        JPanel titleDropPanel = new JPanel();
        JLabel titleDrop = new JLabel("Delete an Employee");
        //Add button
        JButton button3 = new JButton("Submit");
        panel.add(button3);        
        titleDropPanel.add(titleDrop);
        //panel for remove
        JPanel border1DropPnl = new JPanel(new BorderLayout());
        border1DropPnl.add(titleDropPanel, BorderLayout.NORTH);
        border1DropPnl.add(panel, BorderLayout.CENTER);
        //panel for edit and remove
        JPanel border1DropEditPnl = new JPanel(new BorderLayout());
        border1DropEditPnl.add(border1EditPnl, BorderLayout.NORTH);
        border1DropEditPnl.add(border1DropPnl, BorderLayout.CENTER);
        // Main panel for entire page
        borderPnl.add(border1DropEditPnl, BorderLayout.SOUTH);
		// Title and Frame initialization
        JFrame frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setMinimumSize(new Dimension(500, 600));
        frame.setVisible(true);
        //Set up the content pane.
        panel.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(borderPnl);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        // Button Section
        //event gets the values of the input fields as string when clicked submit
        // Button 1 = Add Employee Button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userValue = field.getText();
                String firstnameValue = field2.getText();
                String lastnameValue = field3.getText();
                try {
                    db.Insert(userValue, firstnameValue, lastnameValue);
                    JPanel gb = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 1.0;

        //Displays all users
        List<String[]> users = db.getUsers();
        for(int i = 0; i < users.size(); i++){
            String[] user = (users.get(i));
            String userString = "Username: " + user[0] + " Full Name: " + user[1] + " " +user[2];
            JLabel label = new JLabel(userString);
            System.out.println(userString);            
            //userPanel.add(label);
            gb.add(label, gbc);
        }
        JPanel border1ListPnl = new JPanel(new BorderLayout());
        border1ListPnl.add(titleListPanel, BorderLayout.NORTH);
        border1ListPnl.add(gb, BorderLayout.CENTER);
        //User List Layout
        JPanel borderPnl = new JPanel(new BorderLayout());
        borderPnl.add(border1AddPnl, BorderLayout.NORTH);
        borderPnl.add(border1ListPnl, BorderLayout.CENTER);
        borderPnl.add(border1DropEditPnl, BorderLayout.SOUTH);

                    frame.setContentPane(borderPnl);
                    //Display the window.
        frame.pack();
        frame.setVisible(true);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("Failed");
                }
                
            }
        });
		// Button 2 = Edit button
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userValue = fieldEdit.getText();
                String userValue2 = fieldEdit2.getText();
                try {
                    db.ChangeUsername(userValue2, userValue);
                    JPanel gb = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 1.0;

        //Displays all users
        List<String[]> users = db.getUsers();
        for(int i = 0; i < users.size(); i++){
            String[] user = (users.get(i));
            String userString = "Username: " + user[0] + " Full Name: " + user[1] + " " +user[2];
            JLabel label = new JLabel(userString);
            System.out.println(userString);            
            //userPanel.add(label);
            gb.add(label, gbc);
        }
        JPanel border1ListPnl = new JPanel(new BorderLayout());
        border1ListPnl.add(titleListPanel, BorderLayout.NORTH);
        border1ListPnl.add(gb, BorderLayout.CENTER);
        //User List Layout
        JPanel borderPnl = new JPanel(new BorderLayout());
        borderPnl.add(border1AddPnl, BorderLayout.NORTH);
        borderPnl.add(border1ListPnl, BorderLayout.CENTER);
        borderPnl.add(border1DropEditPnl, BorderLayout.SOUTH);

                    frame.setContentPane(borderPnl);
                    //Display the window.
        frame.pack();
        frame.setVisible(true);

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    System.out.println("Failed");
                }
            }
        });
        // Button 3 = Drop button
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userValue = fieldDrop.getText();
				try {
					db.DeleteEmployee(userValue);
                    JPanel gb = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 1.0;

        //Displays all users
        List<String[]> users = db.getUsers();
        for(int i = 0; i < users.size(); i++){
            String[] user = (users.get(i));
            String userString = "Username: " + user[0] + " Full Name: " + user[1] + " " +user[2];
            JLabel label = new JLabel(userString);
            System.out.println(userString);            
            //userPanel.add(label);
            gb.add(label, gbc);
        }
        JPanel border1ListPnl = new JPanel(new BorderLayout());
        border1ListPnl.add(titleListPanel, BorderLayout.NORTH);
        border1ListPnl.add(gb, BorderLayout.CENTER);
        //User List Layout
        JPanel borderPnl = new JPanel(new BorderLayout());
        borderPnl.add(border1AddPnl, BorderLayout.NORTH);
        borderPnl.add(border1ListPnl, BorderLayout.CENTER);
        borderPnl.add(border1DropEditPnl, BorderLayout.SOUTH);

                    frame.setContentPane(borderPnl);
                    //Display the window.
        frame.pack();
        frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Failed");
				}
                
            }
        });
        
        SpringApplication.run(SBprojectApplication.class, args);
    }
   
}
