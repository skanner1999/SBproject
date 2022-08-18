package com.example.SBproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SpringBootApplication
public class SBprojectApplication {

	public static void main(String[] args) {
		ButtonOne b1 = new ButtonOne();
		ButtonTwo b2 = new ButtonTwo();

		JFrame frame = new JFrame("First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setVisible(true);

		JButton button1 = new JButton("Button1");
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
		
		frame.getContentPane().add(BorderLayout.WEST,button1);
		frame.getContentPane().add(BorderLayout.EAST,button2);

		SpringApplication.run(SBprojectApplication.class, args);
	}

}
