package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.CarDAO;
import kr.co.sist.exam.domain.CarModel;

public class CarService {
	
	private CarDAO c_dao;
	
	public CarService() {
		c_dao = new CarDAO();
	}
	
	public List<String> searchMaker(String country) {
		List<String> list = null;
		list = c_dao.selectMaker(country);
		return list;
	}
	public List<String> searchModel(String maker) {
		List<String> list = null;
		list = c_dao.selectModel(maker);
		return list;
	}
	public List<CarModel> searchDetailModel(String model) {
		List<CarModel> list = null;
		list = c_dao.selectDetailModel(model);
		return list;
	}
}
