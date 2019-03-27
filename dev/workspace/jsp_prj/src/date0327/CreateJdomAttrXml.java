package date0327;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class CreateJdomAttrXml {
	
	public List<DataVO> data() {
		List<DataVO> list = new ArrayList<DataVO>();
		
		list.add(new DataVO("아반테", "현대", "김정윤", "승용", 1600));
		list.add(new DataVO("솔리드프로", "넥슨", "김희철", "스포츠카", 3000));
		list.add(new DataVO("연습용카트", "넥슨", "공선의", "스포츠카", 800));
		list.add(new DataVO("소렌토", "기아", "이재찬", "SUV", 4800));
		list.add(new DataVO("MAN트럭", "MAN", "노진경", "트럭", 10000));
		
		return list;
	}	
	
	public Document createXML(List<DataVO> carList) { 
		// 1. XML 문서객체 생성
		Document doc = new Document();
		
		// 2. 최상위 부모노드를 생성 
		Element rootNode = new Element("cars");
		
		// 자식노드 선언
		Element carNode = null;
		Element carModelNode = null;
		Element companyNode = null;
		Element ownerNode = null;
		Element ccNode = null;
		
		// 속성 선언
		Attribute carTypeAttr = null;
		
		for(DataVO data: carList) {
			// 3. 자식노드를 생성, 4. 값 설정
			carNode = new Element("car");

			carModelNode = new Element("model");
			carModelNode.setText(data.getCarModel());
			
			companyNode = new Element("company");
			companyNode.setText(data.getCompany());
			
			ownerNode = new Element("owner");
			ownerNode.setText(data.getOwner());
			
			ccNode = new Element("cc");
			ccNode.setText(String.valueOf(data.getCc()));
			
			// 속성 선언
			carTypeAttr = new Attribute("type", data.getCarType());
			// 속성 설정
			carNode.setAttribute(carTypeAttr);
			
			// 5. 값을 가진 자식 노드를 부모 노드에 할당
			// car 노드에 자식노드 추가
			carNode.addContent(carModelNode);
			carNode.addContent(companyNode);
			carNode.addContent(ownerNode);
			carNode.addContent(ccNode);
			
			// 자식 노드를 가진 car노드를 최상위 부모노드에 배치
			rootNode.addContent(carNode);
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
				"C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/xml0327/jdom_car.xml"));
	}
}
