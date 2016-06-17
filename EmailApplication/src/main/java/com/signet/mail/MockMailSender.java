package com.signet.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * This is a Mock Email Sender in case we use localhost in application.properties
 *
 */
public class MockMailSender implements MailSender {
	
	private static final Log log = LogFactory.getLog(MockMailSender.class);

	@Override
	public void send(String to, String replyTo, String from, String subject, String message) {
		log.info("Sending mail to " + to);
		log.info("Reply to: " + replyTo);
		log.info("From: " + from);
		log.info("Subject: " + subject);
		log.info("Body: " + message);
	}
}
