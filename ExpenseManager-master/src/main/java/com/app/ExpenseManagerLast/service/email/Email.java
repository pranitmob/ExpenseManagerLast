package com.app.ExpenseManagerLast.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email 
{
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail()
	{
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("pranit.sakunde@mobiliya.com");
		simpleMailMessage.setSubject("Tests email for spring boot application");
		simpleMailMessage.setText("Test message for spring boot application");
		
		javaMailSender.send(simpleMailMessage);
	}
}
