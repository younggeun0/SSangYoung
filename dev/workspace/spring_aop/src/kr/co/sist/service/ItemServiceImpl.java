package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.ItemDAO;
import kr.co.sist.domain.ItemDomain;

@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO i_dao;
	
	@Override
	public ItemDomain searchItem(String name) {
		
		ItemDomain id = i_dao.selectItem(name); 
		System.out.println(id.getItemNo()+" / "+id.getItem());
		
		return id;
	}

	@Override
	public String getName() {
		String name = "±èÁ¤À±";
		System.out.println("getName /// "+name);
		return name;
	}

	@Override
	public String getAddr() {
		String addr="¼­¿ï½Ã °­³²±¸ ¿ª»ïµ¿";
		System.out.println("dao /// "+i_dao.getDBName());
		System.out.println("getAddr /// "+ addr);
		
		if (addr instanceof String) {
			System.out.println("¿½");
		}
		
		return addr;
	}
	

	@Override
	public int getAge() {
		int age = 30;
		System.out.println("getAge /// "+age);
		return age;
	}

	@Override
	public ItemDomain searchData(String name) {
		
		return new ItemDomain("IO_O001", name+" ¾Ö¹ú·¹, Å©·±Ä¿..");
	}
}
