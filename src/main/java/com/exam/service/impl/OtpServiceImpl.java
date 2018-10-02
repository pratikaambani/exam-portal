package com.exam.service.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.exam.service.OtpService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service("OtpService")
public class OtpServiceImpl implements OtpService {
	// cache based on username and OPT MAX 8

	private static final Integer EXPIRE_MINS = 10;
	private LoadingCache<String, Integer> otpCache;

	public OtpServiceImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	@Override
	public int generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		System.out.println("OTP Cache Size :"+otpCache.toString());
		return otp;
	}

	@Override
	public int getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}
}