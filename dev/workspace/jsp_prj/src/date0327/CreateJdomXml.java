package date0327;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateJdomXml {
	
	public List<String> data() {
		List<String> list = new ArrayList<String>();
		
		list.add("월래 먹는 날");
		list.add("화끈하게 먹는 날");
		list.add("수도없이 먹는 날");
		list.add("목이 터지게 먹는 날");
		list.add("금새먹고 또 먹는 날");
		list.add("토하면서 먹는 날");
		list.add("일일이 찾아다니며 먹는 날");
		
		return list;
	}	
	
	public Document createXML(List<String> weekMsg) { 
		// 1. XML 문서객체 생성
		Document doc = new Document();
		
		// 2. 최상위 부모 노드를 생성
		Element rootNode = new Element("week");
		
		Element msgNode = null;
		for(String data : weekMsg) {
			// 3. 자식노드를 생성
			msgNode = new Element("msg");
			// 4. 자식 노드에 들어갈 값 설정
			msgNode.setText(data);
			
			// 5. 값을 가진 자식 노드를 부모 노드에 할당
			rootNode.addContent(msgNode);
		}
		
		// 6. 자식노드를 가진 부모노드를 XML 문서객체에 추가 
		doc.addContent(rootNode);
		
		return doc;
	}
	
	public void createXMLFile(Document doc) throws IOException {

		// 7. 출력 객체 생성, compact, raw format은 한줄로 출력
		XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
		
		// 8. XML 문서객체와 출력스트림을 사용하여 출력
		// xout.output(doc, System.out);
		xout.output(doc, new FileOutputStream(
				"C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/xml0327/jdom.xml"));
	}

	public static void main(String[] args) {
		CreateJdomXml c = new CreateJdomXml();
		
		try {
			c.createXMLFile(c.createXML(c.data()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
