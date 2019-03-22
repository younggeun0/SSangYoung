<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="kr.co.sist.vo.DiaryUpdateVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="drvo" class="kr.co.sist.vo.DiaryRemoveVO" scope="page"></jsp:useBean>
<jsp:setProperty name="drvo" property="*"/>
<div id="readFrm">
<%
	drvo.setPass(ShaUtil.shaEncoding(drvo.getPass())); // 암호화

	DiaryDAO d_dao = DiaryDAO.getInstance();
	String img = "", msg = "";
	try {
		int cnt = d_dao.deleteEvent(drvo);
		
		if (cnt == 0) { // 변경된 행이 없음 : 글번호 조작 | 비밀번호 틀린 경우
			img = "pass_fail.png";
			msg = "비밀번호를 확인해주세요.";
		} else {
			img = "success_update.png";
			msg = "이벤트를 삭제 하였습니다.";
		}
	} catch(SQLException se) {
		img = "construction.png";
		msg = "죄송합니다. 장애처리에 최선을 다하고 있습니다.";
	}
%>
<img src="images/<%= img %>"/><br/>
	<%= msg %>		
<a href="#void" id="btnCloseFrm">닫기</a>
</div>
