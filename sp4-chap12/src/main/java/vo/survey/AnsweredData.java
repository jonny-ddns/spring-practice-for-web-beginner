package vo.survey;

import java.util.List;

//설문조사-답변내용
public class AnsweredData {
	
	private List<String> responses;
	private Respondent respondent;
	
	public List<String> getResponses() {
		return responses;
	}
	public void setResponses(List<String> responses) {
		this.responses = responses;
	}
	public Respondent getRespondent() {
		return respondent;
	}
	public void setRespondent(Respondent respondent) {
		this.respondent = respondent;
	}
}
