package date0327;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateXML {
	
	public List<String> data() {
		List<String> list = new ArrayList<String>();
		
		list.add("���� �Դ� ��");
		list.add("ȭ���ϰ� �Դ� ��");
		list.add("�������� �Դ� ��");
		list.add("���� ������ �Դ� ��");
		list.add("�ݻ��԰� �� �Դ� ��");
		list.add("���ϸ鼭 �Դ� ��");
		list.add("������ ã�ƴٴϸ� �Դ� ��");
		
		return list;
	}	
	
	public String createXML(List<String> weekMsg) {
		StringBuilder xml = new StringBuilder();
		
		xml.append("<?xml version='1.0' encoding='UTF-8'?>\n");
		xml.append("<week>\n");
		
		for(int i=0; i < weekMsg.size(); i++) {
			xml.append("\t<msg>").append(weekMsg.get(i)).append("</msg>\n");
		}
		
		xml.append("</week>");
		
		return xml.toString();
	}
	
	public void createXMLFile(String xml) throws IOException {
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/xml0327/msg.xml"),"UTF-8"));
			
			bw.write(xml);
			bw.flush();
			
		} finally {
			if (bw != null) { bw.close(); }
		}
	}

	public static void main(String[] args) {
		CreateXML c = new CreateXML();
		
		try {
			c.createXMLFile(c.createXML(c.data()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
