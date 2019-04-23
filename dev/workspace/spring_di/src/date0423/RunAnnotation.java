package date0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunAnnotation {
	public static void main(String[] args) {
		// Spring Container 积己
		ApplicationContext ac = new ClassPathXmlApplicationContext("date0423/applicationContext2.xml");
		TestService3 ts3 = ac.getBean(TestService3.class);
		
		System.out.println(ts3);
		System.out.println(ts3.getTestDAO3()); // autowired肺 狼粮己 林涝
	}
}
