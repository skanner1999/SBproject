package com.example.SBproject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SBprojectApplication {

	public static void main(String[] args) {
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
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b1.getInfo();
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
		frame.setVisible(true);
		//Set up the content pane.
        panel.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

		SpringApplication.run(SBprojectApplication.class, args);
	}

}