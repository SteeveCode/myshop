package com.myshop;

import java.util.Properties;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.myshop.setting.EmailSettingBag;

public class Utility {
	public static String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		
		return siteURL.replace(request.getServletPath(), "");
	}
	
	public static JavaMailSenderImpl prepareMailSender(EmailSettingBag settings) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(settings.getHost());
		mailSender.setPort(settings.getPort());
		mailSender.setUsername(settings.getUsername());
		mailSender.setPassword(settings.getPassword());
		
		Properties mailProperties = new Properties();
		mailProperties.setProperty("mail.smtp.auth", settings.getSmtpAuth());
		mailProperties.setProperty("mail.smtp.starttls.enable", settings.getSmtpSecured());
		//the line of code below (line 30)was not in the course. It was a solution to email error suggested by a student
		// MAIL_PORT was also changed from 587 in the course to 465 suggested by student
		mailProperties.setProperty("mail.smtp.ssl.enable", "true");
		
		mailSender.setJavaMailProperties(mailProperties);
		
		return mailSender;
	}
}
