package date181208;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
/* 1206 숙제
1. 아래의 데이터를 처리하는 프로그램을 작성하세요.
  백인재,이봉현,이재찬,정택성,이재현,김정운 의 데이터가 존재하고,
점수는 0~100점 사이로 발생할수있습니다.

프로그램이 실행되면 위의 사람중에 2명이상 성적처리 대상자 이고
n명의 이름과 점수를 저장하여 출력하는 일을 하는 프로그램 작성.
중복이름은 들어갈 수 없다.

출력 예 )
이재찬 89
정택성 77
김정운 90
  총점   xx점
*/
public class DataProcess {

	public DataProcess() {	}
	
	public List<DataVO> getData() {
		String data = "백인재,이봉현,이재찬,정택성,이재현,김정운";
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
		// data size는 6, -1하면 0~4의 수가 나오고 +2를 하면 
		// 2~6이 나옴
		
		DataVO[] arrName = new DataVO[ppl];
		
		for(int i= 0; i<arrName.length; i++) {
			name.add(data.get(i));
		}
		
		name.toArray(arrName);
		
		for(int i=0; i<arrName.length; i++) {
			System.out.println(arrName[i].getName()+" "+arrName[i].getScore());
			sumOfScore += arrName[i].getScore();
		}
		
		System.out.println(" 총점 "+sumOfScore);
	}
}

















