<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
	
	
	
	/* 달력 설정 */
	#diaryTab {	margin: 0px auto; border-spacing: 0px; border:1px solid #CECECE;	}
	
	.sunTitle { 
		width: 80px; 
		height:25px; 
		border:1px solid #CECECE; 
		background-color: #e84118; 
		font-weight:bold; 
		color: white;	
	}
	.weekTitle { width: 80px; height:25px; border:1px solid #CECECE; }
	.satTitle {
		width: 80px; 
		height:25px; 
		border:1px solid #CECECE; 
		background-color: #273c75;
		color: white;
	}
	
	#diaryTitle {
		text-align: center;
		margin-bottom: 10px;
		margin-tom: 20px;
	}
	
	#diaryToday { 
		width:100px;
		font-family: 고딕체;
		font-size:24px;
		font-weight: bold;
		vertical-align: bottom;
	}
	
	.diaryTd {
		width: 100px;
		height: 60px;
		border: 1px solid #CECECE;
		text-align: right;
		vertical-align: top;
		font-size: 14px;
		font-weight: bold;
		padding-right: 10px;
	}
	
	.blankTd {
		width: 100px;
		height: 60px;
		border: 1px solid #CCCCCC;
		text-align: right;
		vertical-align: top;
		font-size: 14px;
		font-weight: bold;
		padding-right: 10px;
		color: #CECECE;
	}
	
	.sunColor {
		color: #e84118;
		font-size:15px;
	}
	
	.satColor {
		color: #273c75;
	}
	
	.weekColor {
		color: #333;
	}
	
	.today {
		background-color: #FFFA99; 
	}
	
	
	
	
	
	
	
	
	
	
	
	/* jQuery tooltip 플러그인 */
	.ui-tooltip, .arrow:after {
	  background: black;
	  border: 2px solid white;
	}
	.ui-tooltip {
	  padding: 10px 20px;
	  color: white;
	  border-radius: 20px;
	  font: bold 14px "Helvetica Neue", Sans-Serif;
	  text-transform: uppercase;
	  box-shadow: 0 0 7px black;
	}
	.arrow {
	  width: 70px;
	  height: 16px;
	  overflow: hidden;
	  position: absolute;
	  left: 50%;
	  margin-left: -35px;
	  bottom: -16px;
	}
	.arrow.top {
	  top: -16px;
	  bottom: auto;
	}
	.arrow.left {
	  left: 20%;
	}
	.arrow:after {
	  content: "";
	  position: absolute;
	  left: 20px;
	  top: -20px;
	  width: 25px;
	  height: 25px;
	  box-shadow: 6px 5px 9px -9px black;
	  -webkit-transform: rotate(45deg);
	  -ms-transform: rotate(45deg);
	  transform: rotate(45deg);
	}
	.arrow.top:after {
	  bottom: -20px;
	  top: auto;
	}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  $( document ).tooltip({
    position: {
      my: "center bottom-20",
      at: "center top",
      using: function( position, feedback ) {
        $( this ).css( position );
        $( "<div>" )
          .addClass( "arrow" )
          .addClass( feedback.vertical )
          .addClass( feedback.horizontal )
          .appendTo( this );
      }
    }
  });
} );
</script>
<script type="text/javascript">
	function moveMonth(month,year,currYear,currMonth) {
		// location.href="diary.jsp?param_month="+month+"&param_yaer="+year;
		/* var obj = document.diaryFrm;
		obj.param_month.value = month;
		obj.param_year.value = year;
		obj.submit(); */
		
		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='diaryFrm']").submit();
	}
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br/><br/>
	
	
	



<div id="diaryWrap">
<%!
	public static final int START_DAY = 1;
%>
<%
	Calendar cal = Calendar.getInstance();
	Calendar todayCal = Calendar.getInstance();

	int currYear = todayCal.get(Calendar.YEAR);
	int currMon = todayCal.get(Calendar.MONTH);
	int currDay = todayCal.get(Calendar.DAY_OF_MONTH);
	
	int nowYear = 0;
	int nowMonth = 0;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);

	String paramMon = request.getParameter("param_month");
	if (paramMon != null && !"".equals(paramMon)) { // 파라미터 월이 존재한다면 현재 켈린더 객체의 월을 변경
		cal.set(Calendar.MONTH, Integer.parseInt(paramMon)-1);
	} 
	
	String paramYear = request.getParameter("param_year");
	if (paramYear != null && !"".equals(paramYear)) {
		cal.set(Calendar.YEAR, Integer.parseInt(paramYear));
	}
	
	nowYear = cal.get(Calendar.YEAR);
	nowMonth = cal.get(Calendar.MONTH)+1;
	
	pageContext.setAttribute("nowYear", nowYear);
	pageContext.setAttribute("nowMonth", nowMonth);
	pageContext.setAttribute("nowDay", nowDay);
	
%>
<form action="diary.jsp" name="diaryFrm" method="post">
	<input type="hidden" name="param_month"/>
	<input type="hidden" name="param_year"/>
</form>

<div id="diaryTitle">
	<a href="#void" onclick="moveMonth(${ nowMonth-1 eq 0 ?12:nowMonth-1},${ nowMonth-1 eq 0 ?nowYear-1:nowYear})"><img src="images/btn_prev.png" title="이전 월"/></a>
	<%-- <a href="diary.jsp?param_month=${ nowMonth-1 eq 0 ? 12 : nowMonth-1 }&param_year=${ nowMonth-1 eq 0 ? nowYear-1 : nowYear }"><img src="images/btn_prev.png" title="이전 월"/></a> --%>
	<span id="diaryToday" title="${ nowYear }년 ${ nowMonth }월">
		<c:out value="${ nowYear }"/>
		.<c:out value="${ nowMonth }"/></span>
	<a href="#void" onclick="moveMonth(${ nowMonth == 13 ? 1 : nowMonth+1 },${ nowMonth == 13 ? nowYear+1 : nowYear })"><img src="images/btn_next.png" title="다음 월"/></a>
	<a href="#void" onclick="moveMonth('','')"><img src="images/btn_today.png" title="오늘"/></a>
	<!-- <a href="diary.jsp"><img src="images/btn_today.png" title="오늘"/></a> -->
	
</div>
<div id="diaryContent">
	<table id="diaryTab">
		<tr>
			<th class="sunTitle">일</th> 
			<th class="weekTitle">월</th> 
			<th class="weekTitle">화</th> 
			<th class="weekTitle">수</th> 
			<th class="weekTitle">목</th> 
			<th class="weekTitle">금</th> 
			<th class="satTitle">토</th> 
		</tr>
	<tr>
		<%
			String dayClass="";
			String todayClass="";
			int lastDay=0;
		
			// 매월마다 끝나는 날짜가 다르기 때문에 
			for(int tempDay = 1; ;tempDay++) {
				cal.set(Calendar.DAY_OF_MONTH, tempDay);	// 임시일자를 설정

				if (cal.get(Calendar.DAY_OF_MONTH) != tempDay) { 
					// 설정된 날짜가 현재일자가 아니라면 다음달 1일이므로 반복문을 빠져나간다.

					// 마지막 날 토요일이면 탈출~ 
					int nextCnt = 1;
					for(int blankTd=cal.get(Calendar.DAY_OF_WEEK); blankTd<8; blankTd++) {
						if (lastDay == Calendar.SATURDAY) {
							break;
						}
						out.print("<td class='blankTd'>");
						out.print(nextCnt);
						out.println("</td>");
						nextCnt++;
					}
					break;
				}
				
				// 1일을 출력하기 전 공백 출력
				switch(tempDay) {
				case START_DAY:
					Calendar prevCal = Calendar.getInstance();
					prevCal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); // 지난달로 설정
					
					int prevLastDay = 0;
					for(int temp = 1; ;temp++) {
						prevCal.set(Calendar.DAY_OF_MONTH, temp); 
						if(prevCal.get(Calendar.DAY_OF_MONTH) != temp) { // 다음달로 바뀔 때까지 반복
							break;
						}
						prevLastDay = prevCal.get(Calendar.DATE); // 마지막날까지 날짜 저장
					}
					
					int cnt = -1;
					for(int blankTd=1; blankTd<cal.get(Calendar.DAY_OF_WEEK); blankTd++) {
						cnt++;
					}					
					
					for(int blankTd=1; blankTd<cal.get(Calendar.DAY_OF_WEEK); blankTd++) {
						out.print("<td class='blankTd'>");
						out.print(prevLastDay - cnt);
						out.println("</td>");
						cnt--;
					}
				}
				
				// 요일별 색 설정
				switch(cal.get(Calendar.DAY_OF_WEEK)) {
				case Calendar.SUNDAY:
					dayClass="sunColor";
					break;
				case Calendar.SATURDAY:
					dayClass="satColor";
					break;
				default:
					dayClass="weekColor";
				}
				
				if(currYear == cal.get(Calendar.YEAR) && currMon == cal.get(Calendar.MONTH) && currDay == tempDay) {
					todayClass = "today";
				} else {
					todayClass = "";
				}
				
				pageContext.setAttribute("todayClass", todayClass);
				pageContext.setAttribute("dayClass", dayClass);
		%>
		<td class="diaryTd ${ todayClass }"><span class="${ dayClass }"><%= tempDay %></span></td>
		<%
				
				switch (cal.get(Calendar.DAY_OF_WEEK)) {
				case Calendar.SATURDAY :
					out.println("</tr><tr>");
				}
		
				lastDay = cal.get(Calendar.DAY_OF_WEEK);
			}
		%>
	</tr>
</table>
</div>
</div>




	
	
	
	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>