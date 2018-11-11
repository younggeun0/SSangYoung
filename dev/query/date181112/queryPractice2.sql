/*
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
	method VARCHAR2(15);
	price NUMBER(5);
BEGIN             
	method := '&method';
	
	IF method NOT IN ('택시', '버스', '지하철') THEN
		DBMS_OUTPUT.PUT_LINE('대중교통이 아닙니다.');
	ELSE                                        
		IF method = '택시' THEN
			price := 3800;
		ELSIF method = '버스' THEN
			price := 1200;
		ELSE
		  price := 1250;
		END IF;         
		DBMS_OUTPUT.PUT_LINE('출퇴근 교통수단은 '||method
			||'이고 기본 요금 : '||price||' 원 입니다. 왕복요금은 '
			||price*2||'원이고 한달 20일 기준 교통비는 '||price*20||
			'원 입니다.');
	
	END IF;


END;
/