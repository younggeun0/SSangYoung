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
		
		// 1. Builder(Parser) ����
		SAXBuilder sb = new SAXBuilder();
		
		// 2. XML �б�
		Document doc = sb.build(new URL("http://localhost:8080/jsp_prj/xml0327/attr.xml"));
		
		// 3. �ֻ��� �θ��� ���
		Element peopleNode = doc.getRootElement();
		
		// 4. ó�� �ڽĳ��� ���
		Iterator<Element> personNodes = peopleNode.getChildren().iterator();
		
		Element personNode = null;
		Element personSubNode = null;
		Attribute lastNameAttr = null;
		Attribute cityAttr = null;
		Attribute zipcodeAttr = null;
		String lastNameAttrVal = "";
		AttrVO avo = null;
		
		// 5. �� ��� person ��带 �ݺ� 
		while(personNodes.hasNext()) {
			
			// person ��� ���
			personNode = personNodes.next();
			
			// person�� �ڽ� ���� ���
			Iterator<Element> personSubNodes = personNode.getChildren().iterator();
			
			while(personSubNodes.hasNext()) {
				personSubNode = personSubNodes.next(); // name, address
				
				// 1. name ����
				if ("name".equals(personSubNode.getName())) {
					// lastName �Ӽ����� ���ϰ�
					lastNameAttr = personSubNode.getAttribute("lastName");
					lastNameAttrVal = lastNameAttr.getValue();

					// ���� ������ VO ����
					if (lastName.equals(lastNameAttrVal)) {
						avo = new AttrVO();

						// �̸� set
						avo.setLastName(lastNameAttrVal);
						avo.setFirstName(personSubNode.getText());
					}
				}
				
				// 2. ���� ���ٸ�
				if (lastName.equals(lastNameAttrVal)) {
					// �ּ� ����� �� set
					if ("address".equals(personSubNode.getName())) { 
						
						cityAttr = personSubNode.getAttribute("city");
						zipcodeAttr = personSubNode.getAttribute("zipcode");
						
						// �ּҸ� set
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
