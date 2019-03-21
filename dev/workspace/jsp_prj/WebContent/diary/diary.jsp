<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Arrays"%>
<%@page import="kr.co.sist.vo.MonthVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

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
	#diaryTab {	margin: 0px auto; border-spacing: 0px; border:1px solid #CECECE; }
	
	#diaryContent {
		position: relative;
	}
	
	#diaryJob {
		position: absolute; top: 10px; left: 160px; 
	}
	
	.sunTitle { 
		width: 80px; 
		height:25px;
		border:1px solid #CECECE; 
		background-color: #e84118; 
		font-weight:bold; 
		color: white;	
		text-align: center; 
	}
	.weekTitle { 
		width: 80px; 
		height:25px; 
		border:1px solid #CECECE; 
		text-align: center; 
	}
	.satTitle {
		width: 80px; 
		height:25px; 
		border:1px solid #CECECE; 
		background-color: #273c75;
		color: white;
		text-align: center;
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
	
	#writeFrm {
		background-color: #FFFFFF;
		border:1px solid #333;
		box-shadow: 5px 5px 5px #333; 
		padding:10px;
	}
	
	
	jQuery tooltip 플러그인
	.ui-tooltip, .arrow:after {
	  background: black;
	  border: 2px solid white;
	}
	.ui-tooltip {
	  padding: 10px 20px;
	  color: black;
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
<!-- summernote 관련 library 시작 -->
<link href="../common/summernote/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../common/summernote/bootstrap.js"></script> 

<link href="../common/summernote/summernote-lite.css" rel="stylesheet">
<script src="../common/summernote/summernote-lite.js"></script>
<!-- include summernote-ko-KR -->
<script src="../common/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	  $('#summernote').summernote({
      placeholder: '이벤트를 작성해주세요',
      tabsize: 2,
      height: 100,
      width: 380,
      lang: 'ko-KR'
    });
	});
</script>
<!-- summernote 관련 library 끝 -->
<!-- tooltip 시작1 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="../common/js/jquery-ui.js"></script>
<script>
$( function() {
  $( document ).tooltip1({
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
	function moveMonth(month,year) {
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnCloseFrm").click(function() {
			moveMonth("${ param.param_month }","${ param.param_year }");
			
		});
		$("#btnWriteClose").click(function() {
			moveMonth("${ param.param_month }", "${ param.param_year }");
		});
		
		// 글 작성 처리
		$("#btnWrite").click(function() {
			if($("#subject").val() == "") {
				alert("이벤트 제목은 필수입력 항목입니다.")
				$("#subject").focus();
				return;
			}
			
			if($("#summernote").val() == "") {
				alert("이벤트 내용은 필수입력 항목입니다.");
				return;
			}
			
			if($("#writer").val() == "") {
				alert("작성자는 필수입력 항목입니다.");
				$("#writer").focus();
				return;
			}

			if($("#pass").val() == "") {
				alert("비밀번호는 필수입력 항목입니다.");
				$("#pass").focus();
				return;
			}
			
			$("[name='writeFrm']").submit();	
		});
	});
	
	function writeEvt(year, month, date, pageFlag, evtCnt) {
		
		if(evtCnt > 4) {
			alert("하루에 작성 가능한 이벤트의 수는 5개 입니다.");
			return;
		}

		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='param_date']").val(date);
		$("[name='pageFlag']").val(pageFlag);
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

	StringBuilder toDate = new StringBuilder();
	// 오늘을 저장
	toDate.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH)+1)
	.append(cal.get(Calendar.DAY_OF_MONTH));
	
/*Calendar todayCal = Calendar.getInstance();
	 int currYear = todayCal.get(Calendar.YEAR);
	int currMon = todayCal.get(Calendar.MONTH);
	int currDay = todayCal.get(Calendar.DAY_OF_MONTH); */
	
	int nowYear = 0;
	int nowMonth = 0;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);

	String paramMon = request.getParameter("param_month");
	// 요청했을 때 해당 달에 없는 일이 존재한다면
	// 다음 달 1일로 설정되기 때문에 모든 달에 존재하는 날짜로 일을 설정
	cal.set(Calendar.DAY_OF_MONTH, 1); 
	if (paramMon != null && !"".equals(paramMon)) { // 파라미터 월이 존재한다면 현재 켈린더 객체의 월을 변경
		cal.set(Calendar.MONTH, Integer.parseInt(paramMon)-1);
	} 
	
	String paramYear = request.getParameter("param_year");
	if (paramYear != null && !"".equals(paramYear)) {
		cal.set(Calendar.YEAR, Integer.parseInt(paramYear));
	}
	
	nowYear = cal.get(Calendar.YEAR);
	nowMonth = cal.get(Calendar.MONTH)+1;
	
	boolean todayFlag = false; // 오늘인지 비교하는 불린변수
	StringBuilder nowDate = new StringBuilder();
	nowDate.append(nowYear).append(nowMonth).append(nowDay);
	
	if (toDate.toString().equals(nowDate.toString())) { 
		todayFlag = true;
	}
	
	pageContext.setAttribute("nowYear", nowYear);
	pageContext.setAttribute("nowMonth", nowMonth);
	pageContext.setAttribute("nowDay", nowDay);
	
%>
<form action="diary.jsp" name="diaryFrm" method="post" >
	<input type="hidden" name="param_month"/>
	<input type="hidden" name="param_year"/>
	<input type="hidden" name="param_date"/>
	<input type="hidden" name="pageFlag"/>
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
	String todayClass=""; // 요일별 색
	
	// 요청되는 년,월의 모든 이벤트를 조회
	DiaryDAO d_dao = DiaryDAO.getInstance();
	
	try {
				
				MonthVO[][] monthEvtData = d_dao.selectMonthEvent(
						String.valueOf(nowYear), String.valueOf(nowMonth));
				
				MonthVO[] dayEvt = null; // 해당 일에 글이 존재한다면 저장할 배열
		
				String tempSubject = ""; // 20자 이상인 글을 잘라 ...을 붙이기 위해
				int evtCnt = 0; // 이벤트 건수를 제한하기 위한 변수
		
				int lastDay=0;
			
				// 매월마다 끝나는 날짜가 다르기 때문에 
				for(int tempDay = 1; ;tempDay++) {
					cal.set(Calendar.DAY_OF_MONTH, tempDay);	// 임시일자를 설정
					
					if (cal.get(Calendar.DAY_OF_MONTH) != tempDay) { 
						// 설정된 날짜가 현재일자가 아니라면 다음달 1일이므로 반복문을 빠져나간다.
	
						// 마지막일이 토요일이면  
						// 마지막 날 토요일이면 탈출~ 
						/* if (lastDay == Calendar.SATURDAY) {
							break;
						} */
						
						// 설정된 날짜가 현재 일자가 아니라면 다음달 1일이므로 공백을 출력한 후 
						// 반복문을 빠져나간다.
						int week = cal.get(Calendar.DAY_OF_WEEK);
						int nextMonth = cal.get(Calendar.MONTH)+1;
						if (week!= Calendar.SUNDAY) { // 마지막일이 일요일이 아니면 출력
							int nextDay = 1;
							for(int blankTd=week; blankTd<8; blankTd++) {
							%>
								<td class='blankTd'>
								<div><%= nextMonth == 13 ? 1 : nextMonth %>/<%= nextDay%></div>
								</td>
							<%
								nextDay++;
							}
							break;
						}
						break;
					}
					
					// 1일을 출력하기 전 공백 출력
					switch(tempDay) {
					case START_DAY:
						Calendar prevCal = Calendar.getInstance();
						prevCal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); // 지난달로 설정
						
						// 전달의 마지막
						cal.set(Calendar.MONTH, nowMonth-2);
						int prevMonth = cal.get(Calendar.MONTH)+1; // 이전 월
						int prevLastDay = cal.getActualMaximum(Calendar.DATE); // 이전 월 마지막 일
						cal.set(Calendar.MONTH, nowMonth-1); // 다시 현재월로 변경
						// 1일에 맞는 공백을 출력
						int week = cal.get(Calendar.DAY_OF_WEEK);
						log(String.valueOf(week)); // 6(요일, 금)
						for(int blankTd=1; blankTd<cal.get(Calendar.DAY_OF_WEEK); blankTd++) {
							%>
							<td class="blankTd"><%=prevMonth %>/<%=prevLastDay-week+blankTd+1%></td>
							<%
						}
					}
						/* int prevLastDay = 0;
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
					}*/
	
					
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
					
					/* if(currYear == cal.get(Calendar.YEAR) && currMon == cal.get(Calendar.MONTH) && currDay == tempDay) {
						todayClass = "today";
					} else {
						todayClass = "";
					} */
					
					todayClass = "";
					if(todayFlag) { // 요청한 년월일과 오늘의 년월일이 같다면
						if (nowDay == tempDay) { // 오늘일자에만 다른 CSS를 적용한다
							todayClass = "today";
						}
					}
					
					pageContext.setAttribute("todayClass", todayClass);
					pageContext.setAttribute("dayClass", dayClass);
			%>
			<td class="diaryTd ${ todayClass }">
				<%
					dayEvt = monthEvtData[tempDay-1];
					evtCnt = 0;
					if(dayEvt != null) { // 해당 일자의 이벤트 건수를 저장
						evtCnt = dayEvt.length; // 그날의 이벤트 수
						
					}
				%>
				<div><a href="#void" onclick="writeEvt(${ nowYear },${ nowMonth },<%= tempDay %>,'write_form',<%=evtCnt%>)"><span class="${ dayClass }">
					<%= tempDay %></span>
				</a>
				</div>
				<div>
				<%
					if (dayEvt != null) {
						for(int i=0; i<dayEvt.length; i++) {
							tempSubject = dayEvt[i].getSubject();
							if (tempSubject.length() > 21) {
								tempSubject = tempSubject.substring(0,20)+"...";
							}
						%>
							<img src="images/evtflag.png" title="<%=tempSubject%>"/>
						<%
						}
					}
				%>
				</div>
			</td>
			<%
					switch (cal.get(Calendar.DAY_OF_WEEK)) {
					case Calendar.SATURDAY :
						out.println("</tr><tr>");
					}
			
					//lastDay = cal.get(Calendar.DAY_OF_WEEK);
				}
			} catch (SQLException se) {
				se.printStackTrace();
		%>
		<tr>
			<td colspan="7" style="text-align:center; height:400px;">
				<img src="images/construction.jpg" title="죄송합니다."/>
			</td>
		</tr>
		<% 
			}
		%>
	</tr>
</table>
<div id="diaryJob">
	<c:if test="${ not empty param.pageFlag }">
		<c:import url="${ param.pageFlag }.jsp"></c:import>
	</c:if>
</div>
</div>
</div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>