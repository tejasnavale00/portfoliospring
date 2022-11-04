package com.tejasnavale.mail;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mail {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public void contactotp(String name, String email, int otp) {

		
		SimpleMailMessage message = new SimpleMailMessage();

		String body = "Hello "+name+" your otp is: "+otp;
		String subject ="OTP for form submission from Tejas Navale";

		message.setFrom("tejasnavale00@gmail.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Was Send");
	}
	
	
public void contactsubmit(String name, String email, String subject2, String message2) {

		
		SimpleMailMessage message = new SimpleMailMessage();

		String body = name+" with email: "+email+" and subject: "+subject2+" sent you message: "+message2;
		String subject ="Message from user Tejas Navale";

		message.setFrom("tejasnavale00@gmail.com");
		message.setTo("tejas@tejasnavale.com");
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail Was Send");
	}
	
	

}
