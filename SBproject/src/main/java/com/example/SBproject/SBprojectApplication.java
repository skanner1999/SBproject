package com.example.SBproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.*;
import javax.swing.*;

@SpringBootApplication
public class SBprojectApplication {

	public static void main(String[] args) {
		JFrame frame = new JFrame("First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		SpringApplication.run(SBprojectApplication.class, args);
	}

}
