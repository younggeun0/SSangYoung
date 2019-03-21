<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.util.ShaUtil"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dvo" class="kr.co.sist.vo.DiaryVO" scope="page" />
<jsp:setProperty name="dvo" property="*"/>
<jsp:setProperty name="dvo" property="ip" value="<%= request.getRemoteAddr() %>"/>
<script type="text/javascript">

$(window).load(function() {
<%
	// 새로고침(F5)로 중복 실행 방지 세션
	Boolean flag = (Boolean)session.getAttribute("writeFlag");
	
	if (flag != null && !flag) {
		dvo.setPass(ShaUtil.shaEncoding(dvo.getPass())); // 암호화
		
		DiaryDAO d_dao = DiaryDAO.getInstance();
		
		try {
			d_dao.insertEvent(dvo);
			session.setAttribute("writeFlag", true);
			%>
			alert("이벤트가 정상적으로 등록 되었습니다.");
			location.href="diary.jsp?param_year=${ param.param_year }&param_month=${ param.param_month }";
			<%
		} catch (SQLException se) { 
			// _jspService에서 컴파일 예외를 처리해주지만 우리가 직접하는게 더 좋다
			se.printStackTrace();
			%>
			alert("이벤트가 정상적으로 등록되지 않았습니다.");
			<%
		}
	}
%>
});

</script>
