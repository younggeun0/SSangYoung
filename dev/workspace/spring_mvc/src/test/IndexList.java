package test;

public class IndexList {
	// 현재 게시판의 페이지 인덱스 설정
	public static String indexList(int current_page, int total_page) {
		int pagenumber; // 화면에 보여질 페이지 인덱스 수
		
		int startpage; // 화면에 보여질 시작페이지 번호
		int endpage; // 화면에 보여질 마지막페이지 번호
		int curpage; // 이동하고자 하는 페이지 번호
		String strList = ""; // 리턴될 페이지 인덱스 리스트
		
		pagenumber = 10; // 한 화면의 페이지 인덱스 수

		// 시작 페이지번호 구하기
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

		// 마지막 페이지번호 구하기
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

		// 총 페이지 수가 계산된 마지막페이지 번호보다 작을경우
		// 총 페이지 수가 마지막페이지 번호가 됨
		if (total_page <= endpage) {
			endpage = total_page;
		}

		// 첫번째 페이지 인덱스 화면이 아닌경우
		if (current_page > pagenumber) {
			curpage = startpage - 1; // 시작페이지 번호보다 1 적은 페이지로 이동
			strList = strList + "[<<]";
		} else {
			strList = strList + "[<<]";
		}
		strList = strList + " ... ";
		
		// 시작페이지 번호부터 마지막페이지 번호까지 화면에 표시
		curpage = startpage;
		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "[" + current_page + "]";
			} else {
				strList = strList + "[" + curpage + "]";
			}
			curpage++;
		}

		strList = strList + " ... ";
		// 뒤에 페이지가 더 있는경우
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "[>>]";
		} else {
			strList = strList + "[>>]";
		}

		return strList;
	}
	
	public static void main(String[] args) {
		System.out.println(indexList(1, 55));
	}
}
