package com.mycompany.springwebapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springwebapp.dto.Ch08Member;
import com.mycompany.springwebapp.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch08LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		log.info("실행");
		
		//요청 처리 메소드에 @Auth가 붙어있는지 확인
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Login login = handlerMethod.getMethodAnnotation(Login.class);
		
		//@Login가 붙어있는 경우
		if(login != null) {
			HttpSession session = request.getSession();
			Ch08Member member = (Ch08Member) session.getAttribute("login");
			
			//로그인이 된 상태라면
			if(member != null) {
				return true;
			}else {
				response.sendRedirect(request.getContextPath() + "/ch08/content");
				return false;
			}
		//@Login이 붙어있지 않은경우
		} else {
			return true;
		}
	}
}
