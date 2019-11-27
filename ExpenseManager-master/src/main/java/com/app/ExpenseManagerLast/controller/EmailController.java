package com.app.ExpenseManagerLast.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ExpenseManagerLast.service.IExpenseService;


@RestController
@RequestMapping("/mail")
public class EmailController {
	
	@Autowired
	JavaMailSender mailSender ;
	
	@Autowired
	IExpenseService service;

	
	@GetMapping("/sendMail")
	public void sendMail() {
		MimeMessage message = mailSender.createMimeMessage();	
		try {
			MimeMessageHelper msgHelper = new MimeMessageHelper(message,true);
			msgHelper.setTo("pranit.sakunde@mobiliya.com");
			msgHelper.setText(service.sumOfallExpense().toString());
			msgHelper.setSubject("Expense Total");
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
