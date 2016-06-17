package com.signet.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * This is a SMTP email sender class which is defined as a Component. 
 *
 */

@Component
public class SmtpMailSender implements MailSender {
	
	private static final Log log = LogFactory.getLog(SmtpMailSender.class);

	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}	

	@Override
	@Async
	public void send(String to, String replyTo, String from, String subject, String message) throws MessagingException {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(mimeMessage, true); 
 									  
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(message, true); // true indicates html
		helper.setReplyTo(replyTo);
		helper.setFrom(from);
		
		// we can also use static or dynamic email templates  or attachement 
       		
		javaMailSender.send(mimeMessage);
	}
}
