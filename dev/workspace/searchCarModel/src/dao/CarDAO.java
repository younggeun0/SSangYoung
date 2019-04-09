package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.CarDomain;

public class CarDAO {
	
	private static CarDAO c_dao;
	
	public static CarDAO getInstance() {
		if (c_dao == null) {
			c_dao = new CarDAO();
		}
		
		return c_dao;
	}
	
	public SqlSessionFactory getSessionFactory() {
		SqlSessionFactory ssf = null;
		
		try {
			Reader r = Resources.getResourceAsReader("dao/mybatis_config.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(r);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ssf;
	}
	
	public List<String> selectMaker(String country) {
		List<String> makerList = null;
		
		SqlSession ss = CarDAO.getInstance().getSessionFactory().openSession();
		makerList = ss.selectList("selectCarMaker",country);
		
		return makerList;
	}
	
	public List<String> selectModel(String maker) {
		List<String> modelList = null;
		
		SqlSession ss = CarDAO.getInstance().getSessionFactory().openSession();
		modelList = ss.selectList("selectCarModel",maker);
		
		return modelList;
	}
	
	public List<CarDomain> selectCarDetail(String model) {
		List<CarDomain> list = null;
		
		SqlSession ss = CarDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("selectCarDetail",model);
		
		return list;
	}
	
	public static void main(String[] args) {
		CarDAO c_dao = new CarDAO().getInstance();
		System.out.println(c_dao.selectCarDetail("±×·£Àú"));
	}
}
