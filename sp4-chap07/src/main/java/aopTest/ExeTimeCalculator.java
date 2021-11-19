package aopTest;

//프록시 객체
/*
 * 프록시 객체 -> 부가적인 기능 제공
 * 대상 객체 -> 핵심 기능 제공
 */
/*
 * 프록시 객체를 사용하면 코드 중복을 줄일 수 있다
 * 예를 들어 공통으로 시간을 계산하는 과정이 필요한 경우에 사용
 * 
 * 구현방법
 * 메서드를 직접구현하기 보다는 다른 객체에 메서드를 위임한다
 * 
 * 결론
 * 공통기능과 핵심기능을 분리하기
 * 핵심기능에 공통기능을 삽입하기
 * 
 */
public class ExeTimeCalculator implements Calculator {
	private Calculator calculator;
	
	//생성자를 통해 다른 Calculator 객체 주입받아 필드에 할당하기	
	public ExeTimeCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public long factororial(long num) {
		//팩토리얼을 구하는 코드는 다른 코드에 위임하고
		//시간 구하는 코드만 구현한다
		long start = System.nanoTime();

		long result = calculator.factororial(num);
		long end = System.nanoTime();
		
		//출력
		System.out.printf("클래스[%s], num[%d], result[%d], 걸린시간[%d]\n", calculator.getClass().getSimpleName(), num, result, (end - start));
		return result;
	}
}
