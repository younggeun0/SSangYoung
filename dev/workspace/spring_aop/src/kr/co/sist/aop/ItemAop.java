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
	
	
@Around("execution(* searchData(..))") // ".."�� ��� �Ű�����
public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
	
	pjp.getArgs(); // target�� �Ķ���� ó������
	pjp.getSignature(); // target method �������
	
	// target�� �������� �޾ƿͼ� ������ ����
	ItemDomain id = (ItemDomain)pjp.proceed(); // target method�� ������ �� 
	if (id != null) {
		id.setItem(id.getItem()+"s('.^)V");
	}
	
	return id;
}
	
/*	@Around("execution(* searchData(..))") // ".."�� ��� �Ű�����
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		// target�� �������� �޾ƿͼ� ������ ����
		Object o = pjp.proceed(); // target method�� ������ �� �� 
		
		return o;
	}
*/		
	
	@Before("execution(* searchItem(String))")
	public void beforeItem(JoinPoint jp) {
		
		System.out.println("before advice");
		// target method�� �Ű����� ó��(JoinPoint�� ����Ͽ�)
		
		Object[] params = jp.getArgs();
		// target method�� method����(�Ű�����, method��)
		Signature s = jp.getSignature();
		
		System.out.println("target method�� : "+s.getName());
System.out.println("target method ���������� : "
		+Modifier.toString(s.getModifiers()));
		
		
		if (params != null) {
			System.out.println("�Ű����� ���� : "+params.length);
			
			for(Object param : params) {
				System.out.println("�Ű����� �� : "+param);
			}
		}
	}
	
//	@Before("execution(* get*())") // ��� Bean�� getter ȣ��
//	@Before("execution(* kr.co.sist.service.ItemServiceImpl.get*())") // ItemServiceImpl�� getter ȣ��
	/*@Before("execution(String kr.co.sist.service.ItemServiceImpl.get*())") // ItemServiceImpl�� ��ȯ���� String�� getter ȣ��
	public void getter() {
		System.out.println("getter before advice");
	}*/
}
