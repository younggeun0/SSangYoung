package kr.co.sist.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import kr.co.sist.domain.ItemDomain;

@Component
public class ItemDAOImpl implements ItemDAO {

	@Override
	public ItemDomain selectItem(String name) throws NumberFormatException {
		return new ItemDomain("IT_T01", name+"�� �ڽŰ��ִ� �µ�, �ع��� ��������, ������");
	}
}

