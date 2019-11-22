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
		simpleMailMessage.setTo("knagesh003@gmail.com","kul.akash123@gmail.com","ramankulkarni517@gmail.com","d.chanewad@gmail.com","govindkapure98@gmail.com");
		simpleMailMessage.setSubject("Aamcha Nagu Lai Gunacha Aaahe");
		simpleMailMessage.setText("Hello Aaku/Puru/Datta Bhaiya \n\n Nagesh said don't give him money anymore because he is going to be millionaire in future and then he will give us money(Datta bhaiya's 20k referal amount too).");
		
		javaMailSender.send(simpleMailMessage);
	}
}
