package com.signet.mail;

import javax.mail.MessagingException;

public interface MailSender {

	void send(String to, String replyTo, String from, String subject, String message) throws MessagingException;
}
