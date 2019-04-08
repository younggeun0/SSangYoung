package kr.co.sist.exam.vo;

public class DiaryListParam {
	
	private int startNum, endNum;
	
	public DiaryListParam(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}
	
	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
}
