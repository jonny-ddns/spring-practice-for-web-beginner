package survey;

import java.util.List;

//설문조사-답변내용
public class AnsweredData {
	
	private List<String> responses;
	private Respondent res;
	
	public List<String> getResponses() {
		return responses;
	}
	public AnsweredData setResponses(List<String> responses) {
		this.responses = responses;
		return this;
	}
	public Respondent getRes() {
		return res;
	}
	public AnsweredData setRes(Respondent res) {
		this.res = res;
		return this;
	}
}
