/*
숙제.

1. 혈액형을 입력받아 혈액형별 특징을 출력 하는 PL/SQL작성.
   -혈액형은 대소문자 모두 비교 가능 해야한다.
   -'A' : 내향적이다. 조심스럽고, 세심하다
   -'B' : 자기중심적이다. 규율이나 규칙, 속박을 극히 싫어한다.
   -'AB' : 합리적이다. 합리적인 반듯함을 선호하게된다. 
   -'O' :  한결같은 노력과 추진력이 있다. 동료의식이 강하다 
*/                                                          

  
SET serveroutput ON
SET verify OFF

ACCEPT blood_type PROMPT '혈액형을 입력해주세요 : '

DECLARE
	btype VARCHAR2(2);
	output VARCHAR2(100);
BEGIN
	btype := '&blood_type';
	btype := UPPER(btype);
	
	IF btype NOT IN ('A', 'B', 'AB', 'O') THEN
		output := '혈액형이 아닙니다..';
	ELSE
	    IF btype = 'A' THEN
	    	output := '내향적이다. 조심스럽고, 세심하다';
	    ELSIF btype = 'B' THEN
	    	output := '자기중심적이다. 규율이나 규칙, 속박을 극히 싫어한다';
	    ELSIF btype = 'AB' THEN
	    	output := '합리적이다. 합리적인 반듯함을 선호하게된다.';
	    ELSE
	    	output :=  '한결같은 노력과 추진력이 있다. 동료의식이 강하다 '; 
	    END IF;
	END IF;	

	DBMS_OUTPUT.PUT_LINE(output);	

END;
/
