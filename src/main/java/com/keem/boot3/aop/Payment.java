package com.keem.boot3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Payment {
	
	@Around("execution(* com.keem.boot3.aop.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("탑승 전 카드체크");
		
		// obj는 핵심 로직 메서드가 리턴하는 Data
		Object obj=joinPoint.proceed();
		System.out.println("하차 시 card Check");
		
		return obj;
	}

	@AfterReturning("execution(* com.keem.boot3.aop.Transfer.*())")
	public void cardCheck() {
		System.out.println("card Check");
	}
	@Before("execution(* com.keem.boot3.board.BoardService.get*(..))")
	public void before() {
		System.out.println("before");
	}
	
	@After("execution(* com.keem.boot3.board.BoardService.get*(..))")
	public void after() {
		System.out.println("AfterReturning+AfterThrowing");
	}
	
	@AfterReturning("execution(* com.keem.boot3.board.BoardService.get*(..))")
	public void afterReturning() {
		System.out.println("정상적인 종료 후에");
	}
	
	@AfterThrowing("execution(* com.keem.boot3.board.BoardService.get*(..))")
	public void afterThrowing() {
		System.out.println("비정상적인 종료");
	}
//	@Around("execution(* com.keem.boot3.board.BoardService.get*(..))")
//	public void around() {
//		System.out.println("Before+Around");
//	}
}
