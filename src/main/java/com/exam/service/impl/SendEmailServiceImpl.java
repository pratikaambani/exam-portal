package com.exam.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.exam.constant.GlobalConstant;
import com.exam.email.EmailTemplate;
import com.exam.service.SendEmailService;

@Service("SendEmailService")
public class SendEmailServiceImpl implements SendEmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendOtp(Map<String, String> map) {

		EmailTemplate template = new EmailTemplate("otpemail.html");
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", map.get(GlobalConstant.USER_FRIST));
		replacements.put("otp", map.get(GlobalConstant.OTP));
		String content = template.getTemplate(replacements);
		sendHTMLMail(map.get(GlobalConstant.USER_EMAIL), "OTP For Password Reset", content);
	}

	@Override
	public void sendVerificationLink(Map<String, String> map) {
		String link = map.get(GlobalConstant.APPURL)+"/verifiedEmail?email="+map.get(GlobalConstant.USER_EMAIL);
		EmailTemplate template = new EmailTemplate("varificationemail.html");
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", map.get(GlobalConstant.USER_FRIST));
		replacements.put("link",link);
		String content = template.getTemplate(replacements);
		sendHTMLMail(map.get(GlobalConstant.USER_EMAIL), "Email Verification link", content);
	}

	@Override
	public void sendExamNotification(Map<String, String> hashmap) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendExamReportCard(Map<String, String> hashmap) {
		// TODO Auto-generated method stub

	}

	public void sendHTMLMail(String to, String subject, String content) {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, false, "utf-8");
			helper.setTo(to);
			helper.setSubject(subject);
			message.setContent(content, "text/html");
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
