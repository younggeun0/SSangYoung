package date0327;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AttrParsing {
	
	public List<AttrVO> personDataParsing(String lastName) throws MalformedURLException, JDOMException, IOException {
		List<AttrVO> list = new ArrayList<AttrVO>();
		
		// 1. Builder(Parser) 생성
		SAXBuilder sb = new SAXBuilder();
		
		// 2. XML 읽기
		Document doc = sb.build(new URL("http://localhost:8080/jsp_prj/xml0327/attr.xml"));
		
		// 3. 최상위 부모노드 얻기
		Element peopleNode = doc.getRootElement();
		
		// 4. 처음 자식노드들 얻기
		Iterator<Element> personNodes = peopleNode.getChildren().iterator();
		
		Element personNode = null;
		Element personSubNode = null;
		Attribute lastNameAttr = null;
		Attribute cityAttr = null;
		Attribute zipcodeAttr = null;
		String lastNameAttrVal = "";
		AttrVO avo = null;
		
		// 5. 얻어낸 모든 person 노드를 반복 
		while(personNodes.hasNext()) {
			
			// person 노드 얻기
			personNode = personNodes.next();
			
			// person의 자식 노드들 얻기
			Iterator<Element> personSubNodes = personNode.getChildren().iterator();
			
			while(personSubNodes.hasNext()) {
				personSubNode = personSubNodes.next(); // name, address
				
				// 1. name 노드면
				if ("name".equals(personSubNode.getName())) {
					// lastName 속성값을 구하고
					lastNameAttr = personSubNode.getAttribute("lastName");
					lastNameAttrVal = lastNameAttr.getValue();

					// 성이 같으면 VO 생성
					if (lastName.equals(lastNameAttrVal)) {
						avo = new AttrVO();

						// 이름 set
						avo.setLastName(lastNameAttrVal);
						avo.setFirstName(personSubNode.getText());
					}
				}
				
				// 2. 성이 같다면
				if (lastName.equals(lastNameAttrVal)) {
					// 주소 노드의 값 set
					if ("address".equals(personSubNode.getName())) { 
						
						cityAttr = personSubNode.getAttribute("city");
						zipcodeAttr = personSubNode.getAttribute("zipcode");
						
						// 주소를 set
						avo.setCity(cityAttr.getValue());
						avo.setZipcode(zipcodeAttr.getValue());
						avo.setAddress(personSubNode.getText());

						list.add(avo);
					}
				}
			}
		}
		
		System.out.println(list);
		return list;
	}
}
