package date0326;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JtbcRssParsing {

	private static JtbcRssParsing jrp;
	
	private JtbcRssParsing() {}

	public static JtbcRssParsing getInstance() {
		if (jrp == null) {
			jrp = new JtbcRssParsing();
		}
		
		return jrp;
	}
	
	public List<RssVO> getNews(String rssName) throws IOException, JDOMException {
		List<RssVO> list = new ArrayList<RssVO>();
		
		StringBuilder xmlURL = new StringBuilder();
		xmlURL.append("http://fs.jtbc.joins.com/RSS/").append(rssName).append(".xml");
		
		// 1. Builder 생성
		SAXBuilder sb = new SAXBuilder();
		
		// 2. URL로 외부 서버에서 제공하는 RSS 문서 객체 얻기
		Document doc = sb.build(new URL(xmlURL.toString()));
		
		// 3. 최상위 부모노드 얻기
		Element rootNode = doc.getRootElement(); // rss
		
		System.out.println(rootNode);
		
		// 4. 자식 노드(channel) 얻기
		Element channelNode = rootNode.getChild("channel");
		
		// 5. channel노드의 자식 노드들 얻기
		Iterator<Element> someNodes = channelNode.getChildren().iterator();
		
		Element someNode = null;
		Iterator<Element> itemSubNodes = null;
		Element itemSubNode = null;
		RssVO rvo = null;
		// 채널 노드의 자식 노드들을 순환
		while(someNodes.hasNext()) {
			
			someNode = someNodes.next();
			if("item".equals(someNode.getName())) {
				itemSubNodes = someNode.getChildren().iterator();
				
				rvo = new RssVO();
				while(itemSubNodes.hasNext()) {
					itemSubNode = itemSubNodes.next();
					
					if ("title".equals(itemSubNode.getName())) {
						rvo.setTitle(itemSubNode.getText());
					}
					if ("link".equals(itemSubNode.getName())) {
						rvo.setLink(itemSubNode.getText());
					}
					if ("description".equals(itemSubNode.getName())) {
						rvo.setDescription(itemSubNode.getText());
					}
					if ("pubDate".equals(itemSubNode.getName())) {
						rvo.setPubDate(itemSubNode.getText());
					}
				}
				list.add(rvo);
			}
		}
		
		return list;
	}
}
