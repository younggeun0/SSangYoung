CREATE OR REPLACE PACKAGE lucky_pack
AS           
	-- 행운의 수(1~45) 중 하나를 얻는 함수         
   FUNCTION lucky_num RETURN NUMBER;  
   
   -- 귀인얻기 프로시저
   PROCEDURE lucky_name(name OUT VARCHAR2); 
   
   -- 생년월일 , 성별을 입력받아 주민번호를 생성하여
   -- out parameter에 설정하는 프로시저를 작성
   PROCEDURE get_ssn(birthdate CHAR, gender VARCHAR2, ssn OUT CHAR);    

/*  181109 숙제
1.lucky_pack 패키지에 태어난해를 입력받으면 띠를 반환하는 
  함수를 추가하세요.
  띠 - 태어난해를 12로 나눈 나머지가 
      11이면 양띠, 10- 말, 9-뱀,8-용,7-토끼,6-호랑이,5-소,4-쥐,3-돼지,
      2-개,1-닭,0-원숭이
*/
	FUNCTION get_chinese_zodiac(birth_year NUMBER) RETURN VARCHAR2;  

/*
2. lucky_pack 패키지에 부서번호를 받아 emp 테이블에서 부서별
   사원의 평균 근속년수를 out_parameter에 설정하는 procedure를
   추가하세요.
*/   
	PROCEDURE get_cs(i_deptno NUMBER, avg_cs OUT NUMBER);   


END;
/
