package survey;

//설문조사-응답자 정보
public class Respondent {

	private int age;
	private String location;
	
	public int getAge() {
		return age;
	}
	public Respondent setAge(int age) {
		this.age = age;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public Respondent setLocation(String location) {
		this.location = location;
		return this;
	}
}
