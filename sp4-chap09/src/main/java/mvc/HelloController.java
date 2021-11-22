package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller : 컨트롤러 지정
//@RequestMapping : 요청 처리 경로 지정
//Model : 컨트롤러 처리결과를 뷰에 전달할 때 사용
//@RequestParam : http 요청 파라미터 값을 메서드의 파라미터로 전달하기 위한 목적
//value = "name" : name 요청 파라미터 값을 name 파라미터에 전달
//greeting = : 해당 모델 속성에 값을 설정하기
//return "hello"; : 컨트롤러의 처리결과를 보여줄 뷰 이름

@Controller
public class HelloController {
	//요청 처리 경로 지정
	@RequestMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
		model.addAttribute("greeting", "hello [" + name + "]");
		return "hello";
	}	
}
