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
		
		// ī �ɼ��� 25�� �̻��̶�� 24���� �����ְ� �������� '...'���� ó��
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
	
	////////////////////// �Խ����� ����Ʈ /////////////////////////////////
	public int totalCount() {
		int cnt = 0;
		
		MyBatisDAO1 mb_dao = new MyBatisDAO1();
		cnt = mb_dao.diaryTotalCount();
		
		return cnt;
	}
	
	// �� ȭ�鿡 ������ �Խù��� ����
	public int pageScale() {
		return 10;
	}
	
	// �� ������ ��
	public int totalPage(int totalCnt, int pageScale) {
		int totalPage = 0;
		
		totalPage = totalCnt/pageScale;
		
		if (totalCnt%pageScale != 0) {
			totalPage += 1;
		}
		
		return totalPage;
	}
	
	// ���۹�ȣ
	public int startNum(String currentPage, int pageScale) {
		int startNum = 1;
		
		if (currentPage != null) {
			int tempPage = Integer.parseInt(currentPage);
			startNum = tempPage*pageScale - pageScale + 1;
		}
		
		return startNum;
	}
	
	// ����ȣ
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
		
		if (sal < 0) { // ������ ���밪 ó��
			sal = Math.abs(sal);
			// �Ǵ� sal = -sal;
		}
		
		MyBatisDAO1 mb_dao1 = new MyBatisDAO1();
		list = mb_dao1.lessThan(sal);
		
		return list;
	}
	
	public List<Emp> greaterThan(int sal) {
		List<Emp> list = null;
		
		if (sal < 0) { // ������ ���밪 ó��
			sal = Math.abs(sal);
			// �Ǵ� sal = -sal;
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
