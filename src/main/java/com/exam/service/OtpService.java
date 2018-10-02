package com.exam.service;

public interface OtpService {

	/**
	 * This method is used to push the otp number against Key. Rewrite the OTP
	 * if it exists Using users email address as key
	 * 
	 * @param key
	 *            : Key is user email address
	 * @return
	 */
	public int generateOTP(String key);

	/**
	 * This method is used to return the OTP number against Key
	 * 
	 * @param key
	 *            values is user email address
	 * @return
	 */
	public int getOtp(String key);

	/**
	 * This method is used to clear the OTP catched already
	 * 
	 * @param key
	 */
	public void clearOTP(String key);
}