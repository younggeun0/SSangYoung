package service;

import java.util.List;

import dao.CarDAO;
import domain.CarDomain;

public class CarService {
	
	public List<String> searchCarMaker(String country) {
		List<String> makerList = null;

		CarDAO c_dao = CarDAO.getInstance();
		makerList = c_dao.selectMaker(country);
		
		return makerList;
	}
	
	public List<String> searchCarModel(String maker) {
		List<String> modelList = null;
		
		CarDAO c_dao = CarDAO.getInstance();
		modelList = c_dao.selectModel(maker);
		
		return modelList;
	}
	
	public List<CarDomain> searchCarDetail(String model) {
		List<CarDomain> list = null;
		
		CarDAO c_dao = CarDAO.getInstance();
		list = c_dao.selectCarDetail(model);
		
		return list;
	}
}
