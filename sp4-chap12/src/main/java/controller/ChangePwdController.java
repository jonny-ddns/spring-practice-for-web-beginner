package controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.ChangePwdCommand;
import exception.IdPasswordNotMatchingException;
import service.ChangePasswordService;
import validator.ChangePwdCommandValidator;
import vo.AuthInfo;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	
	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(@ModelAttribute("command") ChangePasswordService changePasswordService) {
		return "edit/changePwdForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") ChangePwdCommand changePwdCommand, Errors errors, HttpSession httpSession) {
		new ChangePwdCommandValidator().validate(changePasswordService, errors);
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		
		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		try {			
			String email = authInfo.getEmail();
			String oldpw = changePwdCommand.getCurrentPassword();
			String newpw = changePwdCommand.getNewPassword();
			changePasswordService.changePassword(email, oldpw, newpw);
			return "edit/changedPwd";
		} catch (IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword", "notMaching");
			return "edit/changePwdForm";
		}
	}	
}
