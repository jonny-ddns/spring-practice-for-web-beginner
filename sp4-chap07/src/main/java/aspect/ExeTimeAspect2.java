package aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//Aspect - 공통기능 수행
//애노테이션 적용

@Aspect
public class ExeTimeAspect2 {

	@Pointcut("execution(public * aopTest..*(..))")
	public void publicTarget() {		
	}
	
	@Around("publicTarget()")
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
