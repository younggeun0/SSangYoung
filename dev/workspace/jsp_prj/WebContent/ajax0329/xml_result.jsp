<%@page import="org.jdom2.output.Format"
%><%@page import="org.jdom2.output.XMLOutputter"
%><%@page import="org.jdom2.Element"
%><%@page import="org.jdom2.Document"
%><%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	String name = request.getParameter("name");
	
	// XML로 응답
	String[] temp = {""};
	if("이봉현".equals(name)) {
		temp="이재찬,정택성,백인재".split(",");
	} else if ("박영민".equals(name)){
		temp="김정윤,노진경,최지우,김희철".split(",");;
	} else if (("오영근").equals(name)) {
		temp="이재현,공선의,박정미,최혜원".split(",");;
	} else {
		temp="김건하,박소영".split(",");;
	}
	
	// 1. XML 문서 객체 생성
	Document xmlDoc = new Document();
	
	// 2. 최상위 노드 생성
	Element rootNode = new Element("names");
	
	// 3. 자식 노드를 생성
	Element nameNode = null;
	for(int i=0; i<temp.length; i++) {
		// 자식 노드 생성
		nameNode = new Element("name");
		// 자식 노드에 값 설정
		nameNode.setText(temp[i]);
		
		// 4. 생성된 자식 노드를 부모노드에 추가
		rootNode.addContent(nameNode);
	}
	// 5. 자식노드를 가진 부모노드를 문서객체에 추가
	xmlDoc.addContent(rootNode);
	
	// 6. 출력
	XMLOutputter x_out = new XMLOutputter(Format.getPrettyFormat());
	x_out.output(xmlDoc, out);
%>