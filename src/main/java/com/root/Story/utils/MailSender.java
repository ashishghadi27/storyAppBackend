package com.root.Story.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {

	public static boolean sendMail(String otp, String email) {

		String content = "<html><head></head><body><div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">\r\n"
				+ "  <div style=\"margin:50px auto;width:70%;padding:20px 0\">\r\n"
				+ "    <div style=\"border-bottom:1px solid #eee\">\r\n"
				+ "      <a href=\"\" style=\"font-size:1.4em;color: #3e69fb;text-decoration:none;font-weight:600\">Story App</a>\r\n"
				+ "    </div>\r\n"
				+ "    <p style=\"font-size:1.1em\">Hi,</p>\r\n"
				+ "    <p>Use the following OTP to reset your password.</p>\r\n"
				+ "    <h2 style=\"background: #3e69fb;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">" + otp + "</h2>\r\n"
				+ "    <p style=\"font-size:0.9em;\">Regards,<br>Story App</p>\r\n"
				+ "    <hr style=\"border:none;border-top:1px solid #eee\">\r\n"
				+ "    <div style=\"float:right;padding:8px 0;color:#aaa;font-size:0.8em;line-height:1;font-weight:300\">\r\n"
				+ "      <p>Story App Inc</p>\r\n"
				+ "      <p>Mumbai</p>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "</div></body></html>";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("your_mail@gmail.com",
						"your_pass");
			}
		});
		// compose message
		try {
			Message message1 = new MimeMessage(session);
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message1.setFrom(new InternetAddress("rootdevs27"));
			message1.setSubject("Password Reset");
			message1.setContent(content, "text/html");
			// send message
			Transport.send(message1);
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}

}
