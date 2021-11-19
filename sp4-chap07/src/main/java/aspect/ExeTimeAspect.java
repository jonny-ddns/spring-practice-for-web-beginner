package aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

//Aspect - 공통기능 수행
//메서드 실행 전후로 사용할 공통 기능 구현
//파라미터 - 대상 객체의 메서드를 호출할 목적으로 사용
public class ExeTimeAspect {

	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object measure = joinPoint.proceed();
			return measure;
		} finally {
			long finish = System.nanoTime();
			Signature signature = joinPoint.getSignature();
			System.out.printf("클래스[%s], 메서드[%s], 요청%s, 걸린시간[%d]\n"
				, joinPoint.getTarget().getClass().getSimpleName()
				, signature.getName()
				, Arrays.toString(joinPoint.getArgs())
				, (finish - start));
		}
	}
}
