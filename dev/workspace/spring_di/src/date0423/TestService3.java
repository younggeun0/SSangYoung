package date0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService3 {
	
	// �������� ���Թ��� ��ü ���� annotation ����
	@Autowired
	private TestDAO3 td3;
	
	public TestDAO3 getTestDAO3() {
		return td3;
	}
}

