package kr.co.sist.lunch.admin.run;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.file.FileServer;
import kr.co.sist.lunch.admin.view.LunchLoginView;

public class LunchAdminMain {
	
	public static List<String> lunchImageList;
	
	public LunchAdminMain() {
		lunchImageList = new ArrayList<String>();
		// 서버에 존재하는 이미지 중 큰 이미지만 입력
		
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img");
		
		for(String tempName : file.list()) {
			if (!tempName.startsWith("s_")) {
				lunchImageList.add(tempName);
			}
		}
	}

	public static void main(String[] args) {
		new LunchAdminMain();
		FileServer fs = new FileServer();
		fs.start();
		new LunchLoginView();
	}
}
