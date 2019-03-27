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
		
		list.add(new DataVO("�ƹ���", "����", "������", "�¿�", 1600));
		list.add(new DataVO("�ָ�������", "�ؽ�", "����ö", "������ī", 3000));
		list.add(new DataVO("������īƮ", "�ؽ�", "������", "������ī", 800));
		list.add(new DataVO("�ҷ���", "���", "������", "SUV", 4800));
		list.add(new DataVO("MANƮ��", "MAN", "������", "Ʈ��", 10000));
		
		return list;
	}	
	
	public Document createXML(List<DataVO> carList) { 
		// 1. XML ������ü ����
		Document doc = new Document();
		
		// 2. �ֻ��� �θ��带 ���� 
		Element rootNode = new Element("cars");
		
		// �ڽĳ�� ����
		Element carNode = null;
		Element carModelNode = null;
		Element companyNode = null;
		Element ownerNode = null;
		Element ccNode = null;
		
		// �Ӽ� ����
		Attribute carTypeAttr = null;
		
		for(DataVO data: carList) {
			// 3. �ڽĳ�带 ����, 4. �� ����
			carNode = new Element("car");

			carModelNode = new Element("model");
			carModelNode.setText(data.getCarModel());
			
			companyNode = new Element("company");
			companyNode.setText(data.getCompany());
			
			ownerNode = new Element("owner");
			ownerNode.setText(data.getOwner());
			
			ccNode = new Element("cc");
			ccNode.setText(String.valueOf(data.getCc()));
			
			// �Ӽ� ����
			carTypeAttr = new Attribute("type", data.getCarType());
			// �Ӽ� ����
			carNode.setAttribute(carTypeAttr);
			
			// 5. ���� ���� �ڽ� ��带 �θ� ��忡 �Ҵ�
			// car ��忡 �ڽĳ�� �߰�
			carNode.addContent(carModelNode);
			carNode.addContent(companyNode);
			carNode.addContent(ownerNode);
			carNode.addContent(ccNode);
			
			// �ڽ� ��带 ���� car��带 �ֻ��� �θ��忡 ��ġ
			rootNode.addContent(carNode);
		}
		
		// 6. �ڽĳ�带 ���� �θ��带 XML ������ü�� �߰� 
		doc.addContent(rootNode);
		
		return doc;
	}
	
	public void createXMLFile(Document doc) throws IOException {

		// 7. ��� ��ü ����, compact, raw format�� ���ٷ� ���
		XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
		
		// 8. XML ������ü�� ��½�Ʈ���� ����Ͽ� ���
		// xout.output(doc, System.out);
		xout.output(doc, new FileOutputStream(
				"C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/xml0327/jdom_car.xml"));
	}
}
