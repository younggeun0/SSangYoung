package date181208;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
/* 1206 ����
1. �Ʒ��� �����͸� ó���ϴ� ���α׷��� �ۼ��ϼ���.
  ������,�̺���,������,���ü�,������,������ �� �����Ͱ� �����ϰ�,
������ 0~100�� ���̷� �߻��Ҽ��ֽ��ϴ�.

���α׷��� ����Ǹ� ���� ����߿� 2���̻� ����ó�� ����� �̰�
n���� �̸��� ������ �����Ͽ� ����ϴ� ���� �ϴ� ���α׷� �ۼ�.
�ߺ��̸��� �� �� ����.

��� �� )
������ 89
���ü� 77
������ 90
  ����   xx��
*/
public class DataProcess {

	public DataProcess() {	}
	
	public List<DataVO> getData() {
		String data = "������,�̺���,������,���ü�,������,������";
		String[] name = data.split(",");
		
		List<DataVO> nameList = new ArrayList<>();
		Random r = new Random();
		
		for(int i=0; i<name.length; i++) {
			nameList.add(new DataVO(name[i], r.nextInt(101)));
		}
		return nameList;
	}
	
	public void printData(List<DataVO> data) {
		
		Random r = new Random();
		Set<DataVO> name = new HashSet<>();
		int sumOfScore = 0;		
		
		int ppl = r.nextInt(data.size()-1)+2;
		// data size�� 6, -1�ϸ� 0~4�� ���� ������ +2�� �ϸ� 
		// 2~6�� ����
		
		DataVO[] arrName = new DataVO[ppl];
		
		for(int i= 0; i<arrName.length; i++) {
			name.add(data.get(i));
		}
		
		name.toArray(arrName);
		
		for(int i=0; i<arrName.length; i++) {
			System.out.println(arrName[i].getName()+" "+arrName[i].getScore());
			sumOfScore += arrName[i].getScore();
		}
		
		System.out.println(" ���� "+sumOfScore);
	}
}

















