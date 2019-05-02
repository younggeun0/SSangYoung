package kr.co.sist.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ItemAop {
	
	@Around("execution(* searchItem(String))")
	public void after() {
		System.out.println("around advice");
	}
}
