package aopTest;

//재귀방식으로 팩토리얼 구하기
public class RecCalculator implements Calculator {
	@Override
	public long factororial(long num) {
		if(num == 0) {
			return 1;
		} else {
			return num * factororial(num - 1);
		}
	}
}
