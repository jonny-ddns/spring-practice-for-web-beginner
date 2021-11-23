package vo.survey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
	private String title;
	private List<String> options;
	
	public Question() {
		this("test", Collections.<String>emptyList());
	}
	
	public Question(String title) {
		this(title, new ArrayList<String>());
	}
	
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	
	public String getTitle() {
		return title;
	}
	public List<String> getOptions() {
		return options;
	}
	
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
