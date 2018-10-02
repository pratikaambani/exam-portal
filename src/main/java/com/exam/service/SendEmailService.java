package com.exam.service;

import java.util.Map;

public interface SendEmailService {

	public void sendOtp(Map<String, String> hashmap);

	public void sendVerificationLink(Map<String, String> hashmap);

	public void sendExamNotification(Map<String, String> hashmap);

	public void sendExamReportCard(Map<String, String> hashmap);
}
