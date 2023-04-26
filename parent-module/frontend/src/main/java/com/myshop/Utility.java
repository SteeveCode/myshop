package com.myshop;

import java.util.Properties;

import com.myshop.security.oauth.CustomerOAuth2User;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.myshop.setting.EmailSettingBag;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

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
	public static String getEmailOfAuthenticatedCustomer(HttpServletRequest request) {
		Object principal = request.getUserPrincipal();
		if (principal == null) return null;

		String customerEmail = null;

		if (principal instanceof UsernamePasswordAuthenticationToken
				|| principal instanceof RememberMeAuthenticationToken) {
			customerEmail = request.getUserPrincipal().getName();
		} else if (principal instanceof OAuth2AuthenticationToken) {
			OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) principal;
			CustomerOAuth2User oauth2User = (CustomerOAuth2User) oauth2Token.getPrincipal();
			customerEmail = oauth2User.getEmail();
		}

		return customerEmail;
	}
}
