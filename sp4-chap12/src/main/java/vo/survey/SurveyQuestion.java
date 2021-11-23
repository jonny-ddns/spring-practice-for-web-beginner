package vo.survey;

import java.util.Arrays;
import java.util.List;

public class SurveyQuestion {	
	private final String title1 = "당신의 역할 : ";
	private final String title2 = "많이 사용하는 IDE : ";
	private final String title3 = "하고 싶은 말 : ";
	
	private final List<String> options1 = Arrays.asList("서버", "프론트", "백엔드", "풀스택");
	private final List<String> options2 = Arrays.asList("Eclipse", "IntelliJ", "sublime");	
	
	public List<Question> getQuestions(){
		Question q1 = new Question(title1, options1);		
		Question q2 = new Question(title2, options2);		
		Question q3 = new Question(title3);		
		return Arrays.asList(q1, q2, q3);
	}
}
