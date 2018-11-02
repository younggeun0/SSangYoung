/*
1. 혈액형을 입력받아 혈액형별 특징을 출력 하는 PL/SQL작성.
   -혈액형은 대소문자 모두 비교 가능 해야한다.
   -'A' : 내향적이다. 조심스럽고, 세심하다
   -'B' : 자기중심적이다. 규율이나 규칙, 속박을 극히 싫어한다.
   -'AB' : 합리적이다. 합리적인 반듯함을 선호하게된다.
   -'O' :  한결같은 노력과 추진력이 있다. 동료의식이 강하다


SET serveroutput ON
SET verify OFF

ACCEPT input PROMPT '혈액형 : '

DECLARE
	b_type VARCHAR2(2);
	output VARCHAR2(100);
BEGIN
	b_type := '&input';
	b_type := UPPER(b_type); 

	IF b_type IN ('A', 'B', 'AB', 'O') THEN
		IF b_type = 'A' THEN
			output := '내향적이다. 조심스럽고, 세심하다';
		ELSIF b_type = 'B' THEN
			output := '자기중심적이다. 규율이나 규칙, 속박을 극히 싫어한다.';
		ELSIF b_type = 'AB' THEN
			output := '합리적이다. 합리적인 반듯함을 선호하게된다.';
		ELSE
			output := '한결같은 노력과 추진력이 있다. 동료의식이 강하다';
		END IF;
		DBMS_OUTPUT.PUT_LINE(output);
	ELSE
		DBMS_OUTPUT.PUT_LINE('혈액형이 아닙니다..');
	END IF;
END;
/  

2. 점수를 입력받아서  
    100~90 사이면 'A'학점
     89~80 사이면 'B'
    79~70 사이면 'C'
    69~60 사이면 'D'
    그외 라면 '노력을 요함' 을 출력하는  PL/SQL을 작성하세요.

       
SET serveroutput ON
SET verify OFF

ACCEPT score PROMPT '점수를 입력하세요 : '

DECLARE
	score NUMBER(3);
	output CHAR(1);
BEGIN               
	score := &score;
	
	IF score BETWEEN 0 AND 100 THEN
		IF score >= 90 THEN 
			output := 'A';
		ELSIF score >= 80 THEN
			output := 'B';
		ELSIF score >= 70 THEN
			output := 'C';
		ELSIF score >= 60 THEN
			output := 'D';
		ELSE
			DBMS_OUTPUT.PUT_LINE('노력을 요함');
			RETURN; 
		END IF;
		
		DBMS_OUTPUT.PUT_LINE(output||'학점입니다..');
			
	ELSE
		DBMS_OUTPUT.PUT_LINE('점수가 0보다 작거나 100보다 큽니다..');
	END IF;

END;
/
  3. 이름을 입력받아 성과 이름을 출력하는  PL/SQL을 하세요.
    이름의 글자수가 3자 이하라면 '단성'으로 판단하고 4자 이상이라면
    '복성' 이라고 판단한다.
    단성- 성이 하나인 성 (예: 김,이,오,박),  
    복성 - 성이 두개인성 (예 : 선우용녀, 재갈공명 등)
    출력은  성: 김  이름 : 희철
   

SET serveroutput ON
SET verify OFF

ACCEPT name PROMPT '이름을 입력하세요 : '

DECLARE
	name VARCHAR(15);
	firstn VARCHAR(6);
	lastn VARCHAR(9);	
BEGIN                
	name := '&name';
	
	IF LENGTH(name) <= 3 THEN
		firstn := SUBSTR(name, 1, 1);
		lastn := SUBSTR(name, 2);	
	ELSE
		firstn := SUBSTR(name, 1, 2);
		lastn := SUBSTR(name, 3);	
	END IF;	                    
	
	DBMS_OUTPUT.PUT_LINE('성 : ' ||firstn||', 이름 : '||lastn);
END;
/

4. 교통수단을 입력받아, '택시','버스','지하철' 인 경우에만
  아래와 같은 요금으로 한달 교통비를 산정하세요.
   택시 : 3800 -
   버스 : 1200
   지하철 :1250원
   출력 : 출퇴근에 사용하는 교통수단은 'XX'이고 기본 요금: xx 원입니다.
      왕복요금은 xx원이고, 한달 20일 기준 교통비는 xx원 입니다.
    택시, 버스, 지하철이 아니라면  '대중교통이 아닙니다.' 를 출력하세요.
*/

SET serveroutput ON
SET verify OFF

ACCEPT method PROMPT '교통수단 : '

DECLARE
	method VARCHAR2(9);
	price NUMBER(4);
BEGIN               
	method := '&method';
	
	IF method NOT IN ('택시', '버스', '지하철') THEN
		DBMS_OUTPUT.PUT_LINE('대중교통이 아닙니다...');
	ELSE
		IF method = '택시' THEN
			price := 3800;
		ELSIF method = '버스' THEN
			price := 1200;
		ELSE 
			price := 1250;
		END IF; 	
		DBMS_OUTPUT.PUT_LINE('출퇴근에 사용되는 교통수단은 '||method||'이고 기본요금 : '
			||price||'원입니다. 왕복요금은 '||price*2||'원이고, 한달 20일 기준 교통비는 '||
			price*20||'원입니다..');	
	END IF;

END;
/