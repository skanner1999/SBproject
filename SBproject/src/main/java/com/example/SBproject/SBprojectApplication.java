package com.example.SBproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.*;
import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class SBprojectApplication {

	public static void main(String[] args) {
		JFrame frame = new JFrame("First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setVisible(true);
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		frame.getContentPane().add(BorderLayout.WEST,button1);
		frame.getContentPane().add(BorderLayout.EAST,button2);
		SpringApplication.run(SBprojectApplication.class, args);
	}

}
