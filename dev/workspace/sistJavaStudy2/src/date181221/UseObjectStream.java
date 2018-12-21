package date181221;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * UserData를 객체로 생성하여 출력스트림을 통해 파일로 내보내고
 * 읽어 들이는 일.
 * @author owner
 */
public class UseObjectStream {

	public void useObjectOutputStream() throws IOException {
		ObjectOutputStream oos = null;
		
		try {
			File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/obj_data.dat");
			// 객체(JVM)를 직렬화하여 목적지 (HDD File)로 내보내는 스트림
			oos = new ObjectOutputStream(new FileOutputStream(file));
			// 객체는 직렬화가 되지 않으면 스트림으로 내보낼 수 없다.
			UserData ud = new UserData(26,70.1,"이재현");
			oos.writeObject(ud); // 객체를 직렬화하여 스트림에 쓴다.
			oos.flush(); // 스트림에 기록된 내용을 목적지로 분출한다.
			System.out.println("객체를 파일로 기록!");
		} finally {
			if (oos != null) { oos.close(); }
		}
	}
	
	public void useObjectInputStream() throws IOException, ClassNotFoundException {
		// 객체를 읽기위한 스트림 열기
		ObjectInputStream ois = null;
		
		try {
			File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/temp/obj_data.dat");
			
			// File에 저장된 객체를 읽기위한 스트림 열기
			ois = new ObjectInputStream(new FileInputStream(file));
			// 스트림을 통해서 직렬화된 객체를 얻어 재조립
			UserData ud = (UserData)ois.readObject();
			System.out.println("읽어들인 객체의 값 이름 : "+ud.getName()
			+" / 나이 : "+ud.getAge()+" / 몸무게 : "+ud.getWeight());
		} finally {
			if (ois != null) ois.close();
		}
	}
	
	public static void main(String[] args) {
	
		UseObjectStream uos = new UseObjectStream();
		
		/*try {
			uos.useObjectOutputStream();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		*/System.out.println("=================================================");
		try {
			uos.useObjectInputStream();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
