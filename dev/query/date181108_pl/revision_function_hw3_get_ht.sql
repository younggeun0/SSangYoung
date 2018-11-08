/*
3. 주민번호를 입력받아 출생지역을 반환하는 함수 작성
   출생지역은  880101-1xx1111 에서 xx 두자리 이고
   아래의 표와 같다.
    서울시 : 00~08
    부산시 : 09~12
    인천시 : 13~15
    경기도 : 16~25
    강원도 : 26~34
    충청도 : 35~47
    전라도 : 48~66
    경상도 : 67~92
    제주도 : 93~95
*/

CREATE OR REPLACE FUNCTION hw3_get_ht(ssn CHAR)
RETURN CHAR
IS

	re_msg CHAR(9);
	h_code NUMBER(2);

BEGIN

	h_code := SUBSTR(ssn, 9, 2);

	IF h_code BETWEEN 0 AND 8 THEN
		re_msg := '서울시';
	ELSIF h_code BETWEEN 9 AND 12 THEN
		re_msg := '부산시';
	ELSIF h_code BETWEEN 13 AND 15 THEN
		re_msg := '인천시';
	ELSIF h_code BETWEEN 16 ANd 25 THEN
		re_msg := '경기도';
	ELSIF h_code BETWEEN 26 AND 34 THEN
		re_msg := '강원도';
	ELSIF h_code BETWEEN 35 AND 47 THEN
		re_msg := '충청도';
	ELSIF h_code BETWEEN 48 AND 66 THEN
		re_msg := '전라도';
	ELSIF h_code BETWEEN 67 AND 92 THEN
		re_msg := '경상도';
	ELSIF h_code BETWEEN 93 AND 95 THEN
		re_msg := '제주도';
	ELSE
		re_msg := '없어요';
	END IF;

	RETURN re_msg;

END;
/
