package com.exam.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.exam.constant.GlobalConstant;
import com.exam.dto.users.EmailDTO;
import com.exam.dto.users.ForgetPasswordDTO;
import com.exam.dto.users.UserDTO;
import com.exam.model.users.User;
import com.exam.service.OtpService;
import com.exam.service.SendEmailService;
import com.exam.service.UserService;

/**
 * 
 * @author Tejas
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private SendEmailService sendEmailService;

	@Autowired
	private OtpService otpService;

	@Autowired
    private ModelMapper modelMapper;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		UserDTO userDTO = new UserDTO();
		modelAndView.addObject("userDTO",userDTO);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid UserDTO userDTO, BindingResult bindingResult,WebRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, String> userInfoMap = new HashMap<String, String>();
		User userExists = userService.findUserByEmail(userDTO.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user","There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userExists = modelMapper.map(userDTO,User.class);
			//TODO :host-name and port should be come dynamically.
			String appUrl ="http://localhost:8080"+request.getContextPath();
			userService.saveUser(userExists);
			userInfoMap.put(GlobalConstant.USER_FRIST, userExists.getFirstName());
			userInfoMap.put(GlobalConstant.USER_EMAIL, userExists.getEmail());
			userInfoMap.put(GlobalConstant.APPURL,appUrl);
			sendEmailService.sendVerificationLink(userInfoMap);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/verifiedEmail", method = RequestMethod.GET)
	public ModelAndView verifiedUserEmail(@Valid EmailDTO emailDTO , BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(emailDTO.getEmail());
		if (userExists == null) {
			bindingResult.rejectValue("email", "error.user","There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("userDTO",new UserDTO());
			modelAndView.setViewName("registration");
		} else {
			userService.updateEmailVerification(emailDTO.getEmail());
			modelAndView.addObject("successMessage", "email varification done successfully");
			modelAndView.setViewName("emailverifiedsuccess");
		}
		return modelAndView;
	}
	
	
	
	
	
	@RequestMapping(value = { "/forgetpassword" }, method = RequestMethod.GET)
	public ModelAndView forgetPassword() {
		ModelAndView modelAndView = new ModelAndView();
		ForgetPasswordDTO forgetPasswordDTO = new ForgetPasswordDTO();
		modelAndView.addObject("forgetPasswordDTO", forgetPasswordDTO);
		modelAndView.setViewName("forgetpassword");
		return modelAndView;
	}

	@RequestMapping(value = { "/forgetpassword" }, method = RequestMethod.POST)
	public ModelAndView sendOtp(@Valid ForgetPasswordDTO forgetPasswordDTO, BindingResult bindingResult) {

		HashMap<String, String> userInfoMap = new HashMap<String, String>();
		ModelAndView modelAndView = new ModelAndView();

		if (forgetPasswordDTO.getEmail() == "") {
			return modelAndView;
		} else {
			User userExists = userService.findUserByEmail(forgetPasswordDTO.getEmail());
			if (userExists == null) {
				bindingResult.rejectValue("email", "error.user", "Email Address is not found.");
			} else {
				userInfoMap.put(GlobalConstant.USER_FRIST, userExists.getFirstName());
				userInfoMap.put(GlobalConstant.USER_EMAIL, userExists.getEmail());
				int otp = otpService.generateOTP(userExists.getEmail());
				logger.info("OTP : " + otp);
				userInfoMap.put(GlobalConstant.OTP,Integer.toString(otp));
				sendEmailService.sendOtp(userInfoMap);
				modelAndView.addObject("forgetPasswordDTO",forgetPasswordDTO);
				modelAndView.addObject("successMessage", "OTP Sent to your register email address");
				modelAndView.setViewName("otpauth");
			}
		}
		return modelAndView;
	}


	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName",
				"Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

}
