package kr.co.sist.dao;

import kr.co.sist.domain.ItemDomain;

public interface ItemDAO {
	
	public ItemDomain selectItem(String name) throws NumberFormatException;
	public String getDBName();
}
