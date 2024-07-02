package com.user.service;

import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	// sender fetch from application.properties
	@Value("${spring.mail.username}")
	private String sender;

	public boolean sendEmailNotification(String recipient) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom(sender);
		// recipient mean mail receiver
		simpleMailMessage.setTo(recipient);
		// this is meaasage body part
		simpleMailMessage.setText("Dear " + recipient + ",\n\nThank you for registering at SILICON !");
		// Subject Part
		simpleMailMessage.setSubject("Welcome to YMV Silicon PVT ltd ");
		javaMailSender.send(simpleMailMessage);

		return true;
	}

}
