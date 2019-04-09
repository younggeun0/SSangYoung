package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO1;
import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicEmp;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.DeptNo;
import kr.co.sist.exam.vo.DiaryListParam;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TableName;

public class MyBatisService1 {
	
	public List<DynamicIf> dynamicIf(DeptNo deptno) {
		List<DynamicIf> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.dynamicIf(deptno);
		
		return list;
	}
	
	public List<DynamicEmp> dynamicTable(TableName tname) {
		List<DynamicEmp> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.dynamicTable(tname);
		
		return list;
	}
	
	public List<Car> joinSubquery() {
		List<Car> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.joinSubquery();
		
		// 카 옵션이 25자 이상이라면 24까지 보여주고 나머지는 '...'으로 처리
		for(Car car : list) {
			if(car.getCarOption().length() > 26) {
				car.setCarOption(car.getCarOption().substring(0, 24)+"...");
			}
		}
		
		return list;
	}
	
	public List<EmpJoin> join(int mgr) {
		List<EmpJoin> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.join(mgr);
		
		return list;
	}
	
	public List<Union> union() {
		List<Union> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.union();
		
		return list;
	}
	
	////////////////////// 게시판의 리스트 /////////////////////////////////
	public int totalCount() {
		int cnt = 0;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		cnt = mb_dao.diaryTotalCount();
		
		return cnt;
	}
	
	// 한 화면에 보여줄 게시물의 갯수
	public int pageScale() {
		return 10;
	}
	
	// 총 페이지 수
	public int totalPage(int totalCnt, int pageScale) {
		int totalPage = 0;
		
		totalPage = totalCnt/pageScale;
		
		if (totalCnt%pageScale != 0) {
			totalPage += 1;
		}
		
		return totalPage;
	}
	
	// 시작번호
	public int startNum(String currentPage, int pageScale) {
		int startNum = 1;
		
		if (currentPage != null) {
			int tempPage = Integer.parseInt(currentPage);
			startNum = tempPage*pageScale - pageScale + 1;
		}
		
		return startNum;
	}
	
	// 끝번호
	public int endNum(int startNum, int pageScale) {
		return startNum + pageScale - 1;
	}
	
	public List<Emp> multiParam(EmpVO ev) {
		List<Emp> list = null;
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.multiParam(ev);
		
		return list;
	}
	
	public List<DiaryList> diaryList(DiaryListParam dlpvo) {
		List<DiaryList> list = null;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		list = mb_dao.subquery(dlpvo);
		
		return list;
	}
	
	public List<Emp> lessThan(int sal) {
		List<Emp> list = null;
		
		if (sal < 0) { // 음수는 절대값 처리
			sal = Math.abs(sal);
			// 또는 sal = -sal;
		}
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.lessThan(sal);
		
		return list;
	}
	
	public List<Emp> greaterThan(int sal) {
		List<Emp> list = null;
		
		if (sal < 0) { // 음수는 절대값 처리
			sal = Math.abs(sal);
			// 또는 sal = -sal;
		}
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.greaterThan(sal);
		
		return list;
	}
	
	public List<Zipcode> like(String dong) {
		List<Zipcode> list = null;
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.like(dong);
		
		return list;
	}
}
