package date0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService3 {
	
	// 의존성을 주입받을 객체 위에 annotation 선언
	@Autowired
	private TestDAO3 td3;
	
	public TestDAO3 getTestDAO3() {
		return td3;
	}
}

