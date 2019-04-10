package kr.co.sist.exam.vo;

import java.util.List;

public class CarVO {
	
	private List<String> makerList;

	public CarVO(List<String> makerList) {
		this.makerList = makerList;
	}

	public List<String> getMakerList() {
		return makerList;
	}
}
