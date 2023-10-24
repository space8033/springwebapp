package com.mycompany.springwebapp.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Ch14Aspect7Around {
	@Around("@annotation(com.mycompany.springwebapp.aspect.RuntimeCheck)")
	public Object runtimeCheckAdvice (ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		
		Object result = joinPoint.proceed();
		
		long end = System.nanoTime();
		long howLong = end - start;
		
		//@RuntimeCheck가 붙어있는 메소드 이름 얻기
		String methodName = joinPoint.getSignature().toShortString();
		log.info(methodName + "실행  시간: " + howLong + "ns");
		
		//실행 시간을 세션에 저장
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("howLong", howLong);
		session.setAttribute("methodName", methodName);
		
		return result;
	}
}
