package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.CarModel;

public class CarDAO {
	
	public List<String> selectMaker(String country) {
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarContury", country); 
		ss.close();
		
		return list;
	}
	
	public List<String> selectModel(String maker) {
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarMaker", maker); 
		ss.close();
		
		return list;
	}
	
	public List<CarModel> selectDetailModel(String model) {
		List<CarModel> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarModel", model); 
		ss.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		
		CarDAO c_dao = new CarDAO();
		System.out.println(c_dao.selectMaker("국산"));
		System.out.println(c_dao.selectModel("현대"));
		System.out.println(c_dao.selectDetailModel("그랜저"));
	}
}
