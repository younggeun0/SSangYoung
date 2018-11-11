/*
1.lucky_pack 패키지에 태어난해를 입력받으면 띠를 반환하는 
  함수를 추가하세요.
  띠 - 태어난해를 12로 나눈 나머지가 
      11이면 양띠, 10- 말, 9-뱀,8-용,7-토끼,6-호랑이,5-소,4-쥐,3-돼지,
      2-개,1-닭,0-원숭이
*/

/*
2. lucky_pack 패키지에 부서번호를 받아 emp 테이블에서 부서별
   사원의 평균 근속년수를 out_parameter에 설정하는 procedure를
   추가하세요.
*/

CREATE OR REPLACE PACKAGE lucky_pack
AS
 
	FUNCTION get_cz(birth_year NUMBER) RETURN VARCHAR2;
	
	PROCEDURE get_avgcs(i_deptno NUMBER, avgcs OUT NUMBER);

END;
   