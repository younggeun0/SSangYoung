package date0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		// Spring Container ����
		ApplicationContext ac 
			= new ClassPathXmlApplicationContext("date0423/applicationContext.xml");
		
		// Bean ã��
		/*System.out.println("---------------- ������ ������ ���� -------------------");
		TestService ts = ac.getBean("ts",TestService.class);
		System.out.println(ts);
		
		System.out.println("---------------- method ������ ���� -------------------");
		TestService ts1 = ac.getBean("ts1",TestService.class);
		System.out.println(ts1.getTd());
		
		System.out.println("---------------- �������� �Ű������� �������� �� ������ ���� -------------------");
		TestService2 ts2 = ac.getBean(TestService2.class);
		System.out.println(ts2);
		
		System.out.println("---- �����ڿ� �⺻�� ��������, ���ڿ� �������� ������ ���� ---");
		PrimitiveTypeInjection pti = ac.getBean(PrimitiveTypeInjection.class);
		System.out.println(pti);
		
		System.out.println("---- Set ������ ���� ---");
		JCFInjection ji = ac.getBean("jiSet",JCFInjection.class);
		System.out.println(ji.getSet());
		
		
		System.out.println("---- List VO ������ ���� ---");
		JCFInjection ji = ac.getBean("jiVoList",JCFInjection.class);
		System.out.println(ji.getVoList());*/
		
		System.out.println("---- Map ������ ���� ---");
		JCFInjection ji = ac.getBean("jiMap",JCFInjection.class);
		System.out.println(ji.getMap());
	}
}
