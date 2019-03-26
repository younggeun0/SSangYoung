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
 * JDOM Parser 사용
 * @author owner
 */
public class UseJDOMParser {
	
	public UseJDOMParser() throws MalformedURLException, JDOMException, IOException {
		
		// 1. Parser 생성
		SAXBuilder sb = new SAXBuilder();
		
		// 2. XML를 문서객체에 저장
		Document doc = sb.build(new URL("http://localhost:8080/jsp_prj/xml0326/names.xml"));
		
		// 3. 문서객체에서 최상위 부모 노드를 얻기
		Element rootNode = doc.getRootElement();
		
		// 4. 부모노드로부터 자식 노드들 얻기
		Iterator<Element> nameNodes = rootNode.getChildren().iterator();
		
		Element nameNode = null;
		// 5. 자식노드 순환
		while(nameNodes.hasNext()) {
			// 자식 노드 얻기
			nameNode = nameNodes.next();
			System.out.println("노드명 : " + nameNode.getName());
			System.out.println("노드값 : " + nameNode.getValue());
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
