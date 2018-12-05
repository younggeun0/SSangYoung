package date181130;

public class Young extends Person {
	
	public Young() {
		this.setName("오영근");
	}
	
	public String coding() {
		return "코딩합니다..";
	}
	
	public String idle() {
		return "멍때립니다..";
	}
	
	public String beAsked(int questionNum) {
		String msg;
		if (questionNum >= 7) {
			msg = "질문이 조금 많군요..~(_-_)~";
		} else if (questionNum >= 4) {
			msg = "질문이 많군요";
		} else if (questionNum <= 4 && questionNum > 0) {
			msg = "질문이 조금 있군요";
		} else {
			msg = "질문이 없어요^.^";
		}
		return msg;
	}
	
	@Override
	public String eat() {
		//오영근이(가) 집에서 밥을 먹는다.
		return getName()+"이(가) 한독빌딩 지하에 가서 밥을 먹는다.";
	}

}
