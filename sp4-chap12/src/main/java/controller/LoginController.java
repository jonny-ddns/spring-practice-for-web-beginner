package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;
import exception.IdPasswordNotMatchingException;
import service.AuthService;
import validator.LoginCommandValidator;
import vo.AuthInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false) Cookie cookie) {
		//로그인한 상태
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue())
						.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		try {
			String email = loginCommand.getEmail();
			String password = loginCommand.getPassword();
			AuthInfo authInfo = authService.authenticate(email, password);
//			authService.authenticate(email, password);
			
			//로그인 성공시 세션(인증정보 객체) 생성			
			session.setAttribute("authInfo", authInfo);
			
			//쿠키 설정
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			
			int expiry;
			if(loginCommand.isRememberEmail()) {
				expiry = 60 * 60 * 24 * 30;
			} else {
				expiry = 0;
			}
			rememberCookie.setMaxAge(expiry);
			response.addCookie(rememberCookie);
			
			return "login/loginSuccess";
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("IdPasswordNotMatching");
			return "login/loginForm"; 
		}
	}	
}
