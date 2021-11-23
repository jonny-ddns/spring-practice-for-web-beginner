package controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.survey.AnsweredData;
import vo.survey.Question;
import vo.survey.SurveyQuestion;

//설문조사 처리
@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	//1) Model 적용
//	@RequestMapping(method = RequestMethod.GET)
//	public String form1(Model model) {
//		List<Question> questions = createQuestions();
//		model.addAttribute("questions", questions);
//		return "survey/surveyForm";
//	}
	
	//2) ModelAndView 적용
	//ModelAndView 객체를 사용하면 동시에 처리가능함
	/*
	 * 모델을 이용해 뷰에 전달할 데이터 설정
	 * 결과를 보여줄 뷰 이름을 리턴하기
	 */
	@RequestMapping(method = RequestMethod.GET)	
	public ModelAndView form2(Model model) {	
		List<Question> questions = new SurveyQuestion().getQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit( @ModelAttribute("answeredData") AnsweredData answeredData ) {
		return "survey/submitted";
	}
}
