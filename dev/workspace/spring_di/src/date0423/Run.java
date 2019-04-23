package date0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		// Spring Container 생성
		ApplicationContext ac 
			= new ClassPathXmlApplicationContext("date0423/applicationContext.xml");
		
		// Bean 찾기
		/*System.out.println("---------------- 생성자 의존성 주입 -------------------");
		TestService ts = ac.getBean("ts",TestService.class);
		System.out.println(ts);
		
		System.out.println("---------------- method 의존성 주입 -------------------");
		TestService ts1 = ac.getBean("ts1",TestService.class);
		System.out.println(ts1.getTd());
		
		System.out.println("---------------- 생성자의 매개변수가 여러개일 때 의존성 주입 -------------------");
		TestService2 ts2 = ac.getBean(TestService2.class);
		System.out.println(ts2);
		
		System.out.println("---- 생성자에 기본형 데이터형, 문자열 데이터형 의존성 주입 ---");
		PrimitiveTypeInjection pti = ac.getBean(PrimitiveTypeInjection.class);
		System.out.println(pti);
		
		System.out.println("---- Set 의존성 주입 ---");
		JCFInjection ji = ac.getBean("jiSet",JCFInjection.class);
		System.out.println(ji.getSet());
		
		
		System.out.println("---- List VO 의존성 주입 ---");
		JCFInjection ji = ac.getBean("jiVoList",JCFInjection.class);
		System.out.println(ji.getVoList());*/
		
		System.out.println("---- Map 의존성 주입 ---");
		JCFInjection ji = ac.getBean("jiMap",JCFInjection.class);
		System.out.println(ji.getMap());
	}
}
