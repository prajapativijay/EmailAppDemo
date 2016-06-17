package com.signet.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signet.mail.MailSender;

/**
 * 
 * Rest controller to send an smpt email
 * URL: http://localhost:8080/email
 */

@RestController
public class EmailController {

	private MailSender mailSender;
	
	@Value("${email.application.delivery.address}")
	private String toAddress;
	
	@Value("${email.application.reply.address}")
	private String replyAddress;
	
	@Value("${email.application.from.address}")
	private String fromAddress;
	
	@Value("${email.application.subject}")
	private String subject;
	
	@Value("${email.application.message}")
	private String message;
	
	@Autowired
	public EmailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping("/email")
	public String sendMail() throws MessagingException {
		
		mailSender.send(toAddress,replyAddress,fromAddress,subject,message);
		
		return "Email sent";
	}
}
