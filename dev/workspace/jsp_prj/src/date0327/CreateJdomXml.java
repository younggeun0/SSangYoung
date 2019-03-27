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
		
		list.add("���� �Դ� ��");
		list.add("ȭ���ϰ� �Դ� ��");
		list.add("�������� �Դ� ��");
		list.add("���� ������ �Դ� ��");
		list.add("�ݻ��԰� �� �Դ� ��");
		list.add("���ϸ鼭 �Դ� ��");
		list.add("������ ã�ƴٴϸ� �Դ� ��");
		
		return list;
	}	
	
	public Document createXML(List<String> weekMsg) { 
		// 1. XML ������ü ����
		Document doc = new Document();
		
		// 2. �ֻ��� �θ� ��带 ����
		Element rootNode = new Element("week");
		
		Element msgNode = null;
		for(String data : weekMsg) {
			// 3. �ڽĳ�带 ����
			msgNode = new Element("msg");
			// 4. �ڽ� ��忡 �� �� ����
			msgNode.setText(data);
			
			// 5. ���� ���� �ڽ� ��带 �θ� ��忡 �Ҵ�
			rootNode.addContent(msgNode);
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
