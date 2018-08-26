package com.example.demo.utility;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	JavaMailSender jms;
	
	public void sendMail(String address, String filePath) {
		
		MimeMessage message = jms.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(address);
            helper.setSubject("Reservation details for your flight");
            helper.setText("Your details are attached");
            helper.addAttachment("Details", new File(filePath));
            jms.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
