package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 인터셉터를 사용
 * 	인터셉터 ; 다수의 컨트롤러에 동일한 기능을 적용하기
 * 
 * 적용시점 3가지
 * 	.컨트롤러 실행전
 * 	.컨트롤러 실행 후, 아직 뷰를 실행하기 전
 * 	.뷰를 실행한 후
 */
/*
 * preHandle 
 * 	컨트롤러를 실행되기 전
 * 	로그인해야 컨트롤러 실행되도록 적용하는데 사용
 * 
 * postHandle
 * 	컨트롤러를 실행된 후
 * 
 * afterCompletion
 * 	컨트롤러 실행 후, 뷰가 클라이언트에 응답을 전송한 후
 * 	로그 남기기 등에 사용
 */
/*
 * Object handler ;
 * 	웹 요청을 처리할 컨트롤러/핸들러 객체
 */
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//로그인 됨
		HttpSession session = request.getSession();
		if(session != null) {
			//authInfo 속성이 존재하는지 검증
			Object obj = session.getAttribute("authInfo");
			if(obj != null) {
				return true;
			}
		}
		//로그인 안함
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
}
