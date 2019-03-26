package date0326;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * JDOM Parser ���
 * @author owner
 */
public class UseJDOMParser {
	
	public UseJDOMParser() throws MalformedURLException, JDOMException, IOException {
		
		// 1. Parser ����
		SAXBuilder sb = new SAXBuilder();
		
		// 2. XML�� ������ü�� ����
		Document doc = sb.build(new URL("http://localhost:8080/jsp_prj/xml0326/names.xml"));
		
		// 3. ������ü���� �ֻ��� �θ� ��带 ���
		Element rootNode = doc.getRootElement();
		
		// 4. �θ���κ��� �ڽ� ���� ���
		Iterator<Element> nameNodes = rootNode.getChildren().iterator();
		
		Element nameNode = null;
		// 5. �ڽĳ�� ��ȯ
		while(nameNodes.hasNext()) {
			// �ڽ� ��� ���
			nameNode = nameNodes.next();
			System.out.println("���� : " + nameNode.getName());
			System.out.println("��尪 : " + nameNode.getValue());
		}
	}
	
	public static void main(String[] args) {
		try {
			new UseJDOMParser();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
