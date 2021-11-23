package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exception.AlreadyExistingMemberException;
import service.MemberRegisterService;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import validator.RegisterRequestValidator;
import vo.RegisterRequest;

@Controller
public class RegisterController {
	/*
	 * 매핑 : 요청받은 주소
	 * 리턴 : 보여줄 페이지
	 */	
	private MemberRegisterService memberRegisterService;
		
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	//요청주소와 뷰 페이지 매핑하기
	@RequestMapping("/register/step1")
	public String hello() {
		return "register/step1";
	}	
	
	//약관 동의받아서 뷰 페이지 연동하기
	//post 방식으로 들어온 요청의 경우에만 매핑하도록 설정
	@RequestMapping(value = "/register/step2", method = RequestMethod.POST)
	/*
	 * value ; 요청 파라미터 이름
	 * defaultValue ; 요청 파라미터가 없는 경우 사용할 기본 문자열 값
	 * required ; 필수여부
	 */
	
	//Model 코드를 추가 -> 커맨드 객체를 모델에 담기
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		if(!agree) {
			return "register/step1";
		}		
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	
	//get 방식으로 접근한 경우 리다이렉트
	@RequestMapping(value = "/register/step2", method = RequestMethod.GET)
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	//폼에서 입력한 값 가져오기
	@RequestMapping(value = "/register/step3", method = RequestMethod.POST )
	//메서드 호출시 커낸드 객체와 연결된 Errors 객체를 생성해 파라미터로 전달
	public String handleStep3(RegisterRequest regReq, Errors errors) {
		//폼 입력 검증
		//Validator 객체 생성 + .validate() 메서드 실행
		//검증결과가 Errors 객체에 담긴다
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			return "register/step2";
		}
		
		try {
			memberRegisterService.register(regReq);
			return "register/step3";
		} catch (AlreadyExistingMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2"; 
		}
	}
}

