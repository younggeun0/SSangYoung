package kr.co.sist.aop;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.ItemDomain;

@Aspect
@Component
public class ItemAop {
	
	
@Around("execution(* searchData(..))") // ".."은 모든 매개변수
public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
	
	pjp.getArgs(); // target의 파라미터 처리가능
	pjp.getSignature(); // target method 정보사용
	
	// target의 리턴형을 받아와서 리턴을 만듦
	ItemDomain id = (ItemDomain)pjp.proceed(); // target method가 유일할 때 
	if (id != null) {
		id.setItem(id.getItem()+"s('.^)V");
	}
	
	return id;
}
	
/*	@Around("execution(* searchData(..))") // ".."은 모든 매개변수
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		// target의 리턴형을 받아와서 리턴을 만듦
		Object o = pjp.proceed(); // target method가 여러개 일 때 
		
		return o;
	}
*/		
	
	@Before("execution(* searchItem(String))")
	public void beforeItem(JoinPoint jp) {
		
		System.out.println("before advice");
		// target method의 매개변수 처리(JoinPoint를 사용하여)
		
		Object[] params = jp.getArgs();
		// target method의 method정보(매개변수, method명)
		Signature s = jp.getSignature();
		
		System.out.println("target method명 : "+s.getName());
System.out.println("target method 접근지정자 : "
		+Modifier.toString(s.getModifiers()));
		
		
		if (params != null) {
			System.out.println("매개변수 갯수 : "+params.length);
			
			for(Object param : params) {
				System.out.println("매개변수 값 : "+param);
			}
		}
	}
	
//	@Before("execution(* get*())") // 모든 Bean의 getter 호출
//	@Before("execution(* kr.co.sist.service.ItemServiceImpl.get*())") // ItemServiceImpl의 getter 호출
	/*@Before("execution(String kr.co.sist.service.ItemServiceImpl.get*())") // ItemServiceImpl의 반환형이 String인 getter 호출
	public void getter() {
		System.out.println("getter before advice");
	}*/
}
