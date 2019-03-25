package kr.co.sist.vo;

public class ListRangeVO {
	
	private int startNum, endNum;
	
	public ListRangeVO() {
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

	@Override
	public String toString() {
		return "ListRangeVO [startNum=" + startNum + ", endNum=" + endNum + "]";
	}

	public ListRangeVO(int startNum, int endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}
}
