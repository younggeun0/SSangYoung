package kr.co.sist.service;

import kr.co.sist.domain.ItemDomain;

public interface ItemService {
	
	public ItemDomain searchItem(String name);
	public ItemDomain searchData(String name);
	public String getName();
	public String getAddr();
	public int getAge();
}
