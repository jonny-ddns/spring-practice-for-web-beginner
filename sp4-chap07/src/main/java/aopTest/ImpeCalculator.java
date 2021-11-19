package aopTest;

//반복문으로 팩토리얼 구하기
public class ImpeCalculator implements Calculator {
	@Override
	public long factororial(long num) {
		long result = 1;
		for(int i=1 ; i<=num ; i++) {
			result *= i;
		}
		return result;
	}
}
