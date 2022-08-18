package com.example.SBproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBprojectApplication {

	public static void main(String[] args) throws SQLException {
		ButtonOne b1 = new ButtonOne();
		ButtonTwo b2 = new ButtonTwo();

		Database db = new Database();	
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

		//event gets the values of the input fields as string when clicked submit
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userValue = field.getText();
				String firstnameValue = field2.getText();
				String lastnameValue = field3.getText();
				try {
					db.Insert(userValue, firstnameValue, lastnameValue);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Failed");
				}
			}
		});

		JButton button2 = new JButton("Button2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b2.getInfo();
			}
		});
		
		panel.add(button1);
		//frame.getContentPane().add(BorderLayout.EAST,button2);

		//db.Test();
		JFrame frame = new JFrame("First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setVisible(true);
		//Set up the content pane.
        panel.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

		db.getName();
		//db.testInsert();
		SpringApplication.run(SBprojectApplication.class, args);
	}

}