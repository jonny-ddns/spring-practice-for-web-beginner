package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vo.RegisterRequest;

//커맨드 객체의 값이 올바른지 확인하기 위해 인터페이스 Validator를 사용한다
//이메일 및 비밀번호 적합성 확인
public class RegisterRequestValidator implements Validator{
	
	public static final String emailRegExp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
											+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;

	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}

	//supports ; 검증할 수 있는 타입인지 확인
	//전달받은 clazz가 RegisterRequest 객체로 변환가능한가
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	/*
	 * target ; 검증할 대상
	 * errors ; 검증 결과
	 * 올바르지 않은 경우 .rejectValue() 메서드 사용
	 */
	@Override
	public void validate(Object target, Errors errors) {
		RegisterRequest regReq = (RegisterRequest) target;
		if(regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		else {
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
			
			//ValidationUtils : 검증코드 작성클래스
//			String name = regReq.getName();
//			if(name == null || name.trim().isEmpty()) {
//				errors.rejectValue("name", "required");
//			}
			
			//ValidationUtils을 사용해 좀더 간결하게 작성한 검증코드
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
			
			if(!regReq.getPassword().isEmpty()) {
				if(!regReq.isPwEqualToConfirmPw()) {
					errors.rejectValue("confirmPassword", "nomatch");
				}
			}
		}
	}
}
