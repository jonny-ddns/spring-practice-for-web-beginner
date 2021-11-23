package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import survey.AnsweredData;
import survey.Question;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@RequestMapping(method = RequestMethod.GET)	
//	public String form(Model model) {
	public ModelAndView form(Model model) {
//		List<Question> questions = createQuestions();
//		model.addAttribute("questions", questions);
//		return "survey/surveyForm";
		
		//ModelAndView 객체를 사용하면 동시에 처리가능함
		/*
		 * 모델을 이용해 뷰에 전달할 데이터 설정
		 * 결과를 보여줄 뷰 이름을 리턴하기
		 */
		List<Question> questions = createQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		return mav;
	}
	
	private List<Question> createQuestions(){
		String title;
		List<String> options;
		
		title = "당신의 역할 : ";
		options = Arrays.asList("서버", "프론트", "백엔드", "풀스택");		
		Question q1 = new Question(title, options);
		
		title = "많이 사용하는 IDE : ";
		options = Arrays.asList("Eclipse", "IntelliJ", "sublime");		
		Question q2 = new Question(title, options);
		
		title = "하고 싶은 말 : ";
		options = Arrays.asList("서버", "프론트", "백엔드", "풀스택");
		Question q3 = new Question(title);
		
		return Arrays.asList(q1, q2, q3);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("ansData") AnsweredData answeredData) {
		return "survey/submitted";
	}
}
