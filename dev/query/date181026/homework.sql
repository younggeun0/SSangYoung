/*
1. 사원 테이블에서 사원번호,사원명, 연봉, 보너스를 조회
   단, 사원 번호를 내림차순 정렬 했을 때 3~5사이의 레코드만 출력 하고
      연봉은 7자리로 맞춰 출력하고 ,를 넣어 출력한다.
      해당 자리에 값이 없으면 0을 출력한다.
*/

SELECT ROWNUM, rn, empno, ename,
	   TO_CHAR(LPAD(sal, 7, '0'), '0,000,000') sal, NVL(comm, 0)
FROM  (SELECT ROWNUM rn, empno, ename, sal, comm
	   FROM (SELECT empno, ename, sal, comm
		     FROM   emp
		     ORDER BY empno DESC))
WHERE  rn BETWEEN 3 AND 5;

/*
	먼저 empno 내림차순으로 정렬했고, ROWNUM으로 3~5사이 레코드를 빼기위해 서브쿼리로 두고
	ROWNUM은 WHERE절에 바로 못 쓰니까 이걸 alias로 두고 또 서브쿼리로 만들고
	alias랑 BETWEEN을 이용해 3~5 사이에 있는 레코드를 조회
	마지막으로 연봉을 LPAD함수를 이용 7자리로 0을 채워만들고 TO_CHAR 패턴으로 ','을 찍음
*/

/*
2. class4_info 테이블에서 번호, 이름 , 나이, 태어난 해를 조회 하세요.
   태어난 해는 현재년도-나이+1 로 구합니다.
*/

SELECT  num, name,
	    TO_CHAR(SYSDATE, 'yyyy')-age+1 yearofbirth
FROM	class4_info;

/*
  태어난 해를 구하기 위해 현재날짜(SYSDATE)를 TO_CHAR함수 패턴으로 yyyy로 년을 반환시킴
  그리고 그 반환한 값에 나이를 빼고 +1을 더해 태어난 해를 구함
*/


/*
3. class4_info 테이블 번호, 이름 나이, 이메일, 이메일의 유효성 여부를 조회.
   단, 이메일의 유효성은 '@' 이 없으면 '무효', '@'이 존재하면 '유효'를출력
*/

SELECT  num, name, age, email,
		DECODE(INSTR(email, '@'), 0, '무효', '유효')
FROM	class4_info
WHERE   email IS NOT NULL;

/*
  일단 WHERE절에 email이 NULL이 아닌 레코드만 보도록 조건을 걸고
  INSTR함수로 '@'가 email 값에 존재하는지 확인하고 이를 DECODE의 비교값으로 두고
  만약 없으면(INSTR함수의 반환값이 0이면) '무효'를 반환하고 그 외(있으면)는 '유효'를 반환시킨다.
*/

/*
4. car_model 테이블에서 옵션에 'ABS'나 '에어백'이 있는 차량의
    모델명,년식,가격,옵션, 이미지, 제조사를 조회 하세요.
    단, 가격의 오름차순으로 정렬하여 출력할 것.
*/

SELECT   model, car_year, price, car_img, car_option
FROM     car_model
WHERE    INSTR(car_option, 'ABS')!=0
	     OR INSTR(car_option, '에어백')!=0
ORDER BY price ASC;

SELECT   model, car_year, price, car_img, car_option
FROM     car_model
WHERE    car_option LIKE '%ABS%'
         OR car_option LIKE '%에어백%'
ORDER BY price;

/*
  'ABS'나 '에어백'이 있는지 INSTR함수를 이용해서 찾았다(0이면 없음)
  둘 중 하나만 있으면 되므로 OR로 조건 연결
  가격의 오름차순으로 출력해야 하므로 ASC 또는 생략

  또는 LIKE 연산자로 ABS나 에어백을 와일드카드로 찾아서 있는 레코드만 조회
*/


/*
5. car_model 테이블에서 모델명이 '아반테', '소렌토', 'A8'인 차량의
    모델명,모델별 가격 총합과 총계를 조회 하세요.
*/

SELECT   model, SUM(price)
FROM     car_model
WHERE    model IN ('아반테', '소렌토', 'A8')
GROUP BY ROLLUP(model);  

/*
  WHERE절에 IN으로 해당 여러 값을 갖는 레코드만 조회하도록 조건을 걸었고
  모델병 가격을 조회하기 위해 model을 GROUP BY로 묶었음
  그리고 모델별 총합을 구하기 위해 ROLLUP 분석함수를 사용
*/

/*
6. car_model 테이블에서 차량 가액이 1500~3000 사이인 차량의
   모델명, 년식, 가격, 옵션, 입력일, 가격별 순위를 조회하세요.
   단, 가격별 순위는 중복되지 않는 번호가 출력되어야합니다.
*/

SELECT model, car_year, price, car_option, hiredate,
       ROW_NUMBER() OVER(ORDER BY price DESC) rank
FROM   car_model
WHERE  price BETWEEN 1500 AND 3000; 

/*
  BETWEEN으로 1500~3000사이 가격을 갖는 레코드들로 조회결과를 추리고
  중복되지 않는 랭크를 출력하기 위해 ROW_NUMBER() OVER()함수를 사용
  내림차순으로 가격별 순위를 보여주기 위해 ORDER BY price DESC 옵션을 부여
*/

/*
7. 사원 테이블에서 입사년도가 1981년 이상이면서 매니저가 있는 사원의
   사원번호,사원명,연봉,매니저번호, 연봉 순위를 조회 하세요.
   단, 연봉순위는 동일한 연봉일 때 동일한 순위를 보여줍니다.
*/

SELECT  empno, ename, sal, mgr, hiredate,
	    RANK() OVER(ORDER BY sal DESC) rank
FROM    emp
WHERE   mgr IS NOT NULL
	    AND TO_CHAR(hiredate, 'yyyy') >= 1981;
                                                
/*
  매니저가 있는 사원만 먼저 추림 IS NOT NULL 사용
  입사년도가 1981년 이상을 찾기위해 TO_CHAR함수 사용 hiredate 컬럼 값으로부터 'yyyy'값을 반환 후 값 비교
  마지막으로 동일한 순위를 보여주기 위해 RANK() OVER()함수 사용
  ORDER BY sal DESC로 연봉별 내림차순 결과를 출력
*/
