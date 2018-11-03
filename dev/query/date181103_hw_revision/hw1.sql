
DROP TABLE personal_info;

PURGE RECYCLEBIN;

/*  -------------------------------------------------------------------------
181023 숙제복습

1. 아래와 같은 데이터를 저장할 수 있는 테이블을 생성한다.
번호 - 숫자이며 5자리까지 입력
이름 - 가변길이형이며 한글로 10자까지 입력.
성별 - 고정길이이며 영어로 1자 입력.
주소 - 가변길이형이며 한글로 120자 까지입력.
점수 - 숫자이며 3자까지 입력
입력일 - 데이터가 추가되는 현재 일로 입력.
*/

CREATE TABLE p_info (
	num NUMBER(5),
	name VARCHAR2(30),
	gender CHAR(1),
	addr VARCHAR(360),
	score NUMBER(3),
	i_date DATE
);
/*
2. 위 테이블에 아래와 같은 데이터를 추가한다.
  1, '김준호', 'M', '서울시 강남구 역삼동',64,오늘
  2, '김준현', 'M', '서울시 구로구 개봉동',87,오늘
  3, '오나미', 'F', '서울시 영등포구 여의도동',97,오늘
  4, '황재성', 'M', '서울시 동작구 상도동',100,오늘
  5, '유재석', 'M', '경기도 수원시 영통구',100,오늘
*/

INSERT INTO p_info(num, name, gender, addr, score, i_date)
VALUES(1, '김준호', 'M', '서울시 강남구 역삼동', 64, SYSDATE);

INSERT INTO p_info
VALUES(2, '김준현', 'M', '서울시 구로구 개봉동' ,87, SYSDATE);

INSERT INTO p_info
VALUES(3, '오나미', 'F', '서울시 영등포구 여의도동', 97, SYSDATE);

INSERT INTO p_info
VALUES(4, '황재성', 'M', '서울시 동작구 상도동', 100, SYSDATE);

INSERT INTO p_info
VALUES(5, '유재석', 'M', '경기도 수원시 영통구', 100, SYSDATE);

SELECT * FROM p_info;

/*
3. 위 입력된 데이터 중 에서 번호가 3번이며 점수가 97점인 사람의
    이름을 '테스트'로 성별을 'M'으로 변경한다.
*/
UPDATE p_info
SET name='테스트', gender='M'
WHERE num=3 AND score=97;

COMMIT;


-- 4. 위의 데이터에서 이름이 '유재석'인 사람의성별을 'F'로 변경한다.r
UPDATE p_info
SET gender = 'F'
WHERE name='유재석';

SELECT * FROM p_info;

-- 5. 4번의 작업을 취소한다.
ROLLBACK;


-- 6. 번호가 1번이며 이름이 김준현인 사람의 데이터를 삭제한다.
DELETE FROM p_info
WHERE num=1 AND name='김준현';


-- 7. 모든 데이터를 절삭한다.
TRUNCATE TABLE p_info;
SELECT * FROM p_info;

-- 8. 테이블을 삭제한다.
DROP TABLE p_info;

-- 9. 휴지통을 비운다.
PURGE RECYCLEBIN;

SELECT * FROM p_info;


/* ---------------------------------------------------------------------------
181024 숙제복습

1. 사원 테이블에서 '10' 부서가 아니면서 연봉이 1000이상 3000이하의
모든 사원들의  사원번호,사원명, 입사일,부서번호, 연봉을 조회하세요.
*/

SELECT  empno, ename, hiredate, deptno, sal
FROM	emp
WHERE 	deptno != 10 AND sal BETWEEN 1000 AND 3000;

/*
2. 사원 테이블에서 보너스를 수령하는 사원들의  사원번호,사원명,
    연봉,보너스, 총수령액, 월급을 조회 하세요.
    - 월급은 연봉을 12개월로 나눠 계산할 것.
*/

SELECT empno, ename, sal, NVL(comm, 0), sal+NVL(comm, 0) total, TRUNC(sal/12, 0) m_pay
FROM   emp;


/*
3.  사원 테이블에서 부서번호가 10,30인  사원들의 사원명, 사원번호
    입사일, 연봉을 조회 하세요.
    -단, 출력은  xxxx번 xxxx사원님 xxxx년에 입사하였고 연봉은 xxx$입니다.
        의 형식으로 하고, 컬럼명은 output 으로 설정할것.
*/

SELECt empno||'번 '||ename||' 사원님 '||TO_CHAR(hiredate, 'yyyy')||'년에 입사하였고 연봉은 '
	   ||sal||'$입니다.' output
FROM	emp
WHERE deptno IN (10, 30);


/*
4. 사원 테이블에서 연봉이 3000 미만인 사원들의 사원번호, 사원명,
   입사일, 연봉,직무, 부서번호를 조회 하세요.
   단, 연봉의 오름차순으로 정렬하되 연봉이 같다면 사원명의 내림차순으로
   정렬할것.
*/

SELECT   empno, ename, hiredate, sal, job, deptno
FROM	 emp
WHERE 	 sal < 3000
ORDER BY sal, ename DESC;

/*
5. test_like 테이블에 아래와 같은 데이터를 추가할것.
    7, 기임저엉은,서울시 동작구 상도동,'정기고'
    8, 정대만,서울시 동대문구 동대문1동,'썸타고'
    9, 송태섭,서울시 동대문구 동대문2동,'정기고'
*/

SELECT * FROM test_like;
DELETE FROM test_like;

INSERT INTO test_like(num, name, loc, highschool)
VALUES(7, '기임저엉은', '서울시 동작구 상도동', '정기고');

INSERT INTO test_like(num, name, loc, highschool)
VALUES(8, '정대만', '서울시 동대문구 동대문1동', '썸타고');

INSERT INTO test_like(num, name, loc, highschool)
VALUES(9, '송태섭', '서울시 동대문구 동대문2동', '정기고');

SELECT * FROM test_like;

/*
6. test_like 테이블에서 '서울시'에 거주하는 학생의  번호,학생명,
    주소, 학교정보를 아래와  같은 형식으로 출력하고
     컬럼명은 대소문자 구분하여 Output으로  할것.
    출력형식 :  번호 : x, 이름 : xx, 주소 : xx, 학교 : xx
*/

SELECT '번호 : '||num||', 이름 : '||name||', 주소 : '
	   ||loc||', 학교 : '||highschool output
FROM test_like
WHERE loc LIKE '서울시%';

/*
7. 사원테이블에서 사원명이 4글자이거나 연봉이 3000이상인 사원의
   사원번호, 사원명, 연봉, 입사일, 부서번호, 직무를 조회할것.
   단, 출력 데이터는 연봉의 오름차순으로 정렬하고, 연봉이 같다면
     사원명의 오름 차순으로 정렬할것.
*/

SELECT empno, ename, sal, hiredate, deptno, job
FROM emp
WHERE ename LIKE '____' OR sal >= 3000
ORDER BY sal, ename;

/*
8.  test_like 테이블에서 고등학교명을 출력하고 학교명의 오름
    차순으로 정렬하여 출력할 것.
    단, 고등학교 명이 같다면 하나만 출력하세요.(2가지로 할 것.)
*/

SELECT DISTINCT highschool
FROM test_like
ORDER BY highschool;

SELECT highschool
FROM test_like
GROUP BY highschool
ORDER BY highschool;

/*
9. 사원 테이블에서 사원번호, 사원명, 입사일, 연봉, 내년연봉을
    조회 하세요.
    내년 연봉은 현재 연봉보다 7% 향상된 금액으로 계산하여 출력할것.
*/

SELECT empno, ename, hiredate, sal, sal*1.07 n_sal
FROM emp;

/*
10. 사원 테이블에서 사원명이 5글자이면서 세번째 글자에 'A'가 들어
    간 사원의 사원명, 사원번호, 입사일, 연봉을 조회하세요.
    단, 연봉의 오름차순으로 출력할것.
*/

SELECT ename, empno, hiredate, sal
FROM	emp
WHERE ename LIKE '__A__'
ORDER BY sal;

/*
11. 사원 테이블에서 사원명이 'A'로 시작하면서 연봉이 1600이상인
     사원의 사원명,연봉,직무, 매니저번호, 입사일을 조회 할것.
*/

SELECT ename, sal, job, mgr, hiredate
FROM emp
WHERE ename LIKE'A%' AND sal >= 1600;


/* -----------------------------------------------------------------------------
181025 숙제복습

    1. 사원테이블에서 사원번호, 사원명,직무, 매니저번호,연봉,
    입사일을 조회하세요.
     단, 연봉의 오름차순으로 정렬하되, 연봉이 같다면 사원번호의
    내림차순으로 정렬하세요.
    입사일은 월-일-년의 형식으로 출력하세요.
    연봉은 3자리마다 ,를 넣어 출력하세요.
*/

SELECT empno, ename, job, mgr,
	   TO_CHAR(sal,'999,999') sal, TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate
FROM emp
ORDER BY sal, empno DESC;

/*
    2. 사원테이블에서 3,4분기에 입사한 사원들의  부서별 연봉합,
    연봉평균, 최고연봉, 최저연봉, 사원수를 조회하여 아래와 같이 출력하세요.
    출력예 )  10번부서 사원수는 [x]명, 연봉평균 : [xx],
       최고연봉 [xx], 최저연봉[xx]
*/

SELECT deptno||'번 부서 사원수는 '||COUNT(empno)||'명, 연봉평균 : '||TRUNC(AVG(sal),0)
	   ||', 최고연봉 : '||MAX(sal)||', 최저연봉 : '||MIN(sal) output
FROM emp
WHERE TO_CHAR(hiredate,'q') IN (3, 4)
GROUP BY deptno;

/*
  3. TEST_ORDERBY테이블에서 번호를 출력하세요.
   단, 출력되는 번호는  S_0000000001 형식으로
   10자리의 숫자가 되어야하며, 10자리가 되지 않는 숫자는
  앞에 0을 붙여 10자리로 만들고 'S_' 를 붙여 출력한다.
*/

SELECT * FROM test_orderby;

SELECT 'S_'||LPAD(num,10,'0') output
FROM test_orderby;

/*
    4. 사원테이블에서 부서번호, 부서명, 연봉,보너스,총수령액,
     입사일을 조회하세요.
       단. 총수령액은 '연봉+월급+보너스'를 합산한 금액으로
       조회하세요.  월급은 연봉을 12로 나눈 값을 원단위 절삭하여
       계산하세요.
*/

SELECT deptno, (SELECT dname
 				FROM dept
 				WHERE emp.deptno = dept.deptno) dname,
	   sal, NVL(comm, 0),
	   TRUNC(sal+(sal/12)+NVL(comm,0),0) total
FROM emp;

/*
  5. 사원 테이블에서 부서번호,부서명,연봉, 보너스, 인센티브를
   조회하세요.
   인센티브는  아래표와 같이 부서별로 차등 지급합니다.
   10- 월급에 100%, 20- 월급에 150%, 30 - 월급에 300%
   그외 월급에 50%
*/

SELECT deptno, (SELECT dname
				FROM dept
				WHERE emp.deptno = dept.deptno) dname,
       sal, NVL(comm, 0),
	   DECODE(deptno, 10, sal*1, 20, sal*1.5, 30, sal*3, sal*0.5) incentive
FROM emp;


SELECT deptno, (SELECT dname
				FROM dept
				WHERE emp.deptno = dept.deptno) dname,
       sal, NVL(comm, 0),
       CASE deptno WHEN 10 THEN sal*1
       			   WHEN 20 THEN sal*1.5
       			   WHEN 30 THEN sal*3
       			   ELSE sal*0.5
       			   END incentive
FROM emp;


/*
6. class4_info 테이블에 아래와 같은 데이터를 추가합니다.
   번호 - 10, 이름 - 황재성, 주민번호 - 030101-3234567
   번호 - 12, 이름 - 신세계, 주민번호 - 011201-4234567
   번호 - 13, 이름 - 박나래, 주민번호 - 880101-2234567
   번호 - 14, 이름 - 김신영, 주민번호 - 880101-2234567
*/

DELETE FROM class4_info;
SELECT * FROM class4_info;

INSERT INTO class4_info(num, name, ssn)
VALUES(10, '황재성', '030101-3234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(12, '신세계', '011201-4234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(13, '박나래', '880101-2234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(14, '김신영', '880101-2234567');

SELECT * FROM class4_info;

/*
7. class4_info 테이블에서 번호, 이름 , 주민번호,
   성별을 조회 하세요.
   성별은 주민번호의   8번째 자리로 구한다.
   8번째 자리가 1,3이면 남자, 2,4면 여자 그렇지 않으면 "오류"
   로출력한다.
*/

SELECT num, name, ssn,
	   DECODE(SUBSTR(ssn, INSTR(ssn, '-')+1,1),
	   	1, '남자',
	   	2, '여자',
	   	3, '남자',
	   	4, '여자',
	   	'오류') gender
FROM class4_info;

SELECT num, name, ssn,
	   CASE SUBSTR(ssn, INSTR(ssn, '-')+1, 1)
	   	WHEN '1' THEN '남자'
	   	WHEN '2' THEN '여자'
	   	WHEN '3' THEN '남자'
	   	WHEN '4' THEN '여자'
	   	ELSE '오류'
	   	END gender
FROM class4_info;


/* ---------------------------------------------------------------------------

181026 숙제복습
1. 사원 테이블에서 사원번호,사원명, 연봉, 보너스를 조회
   단, 사원 번호를 내림차순 정렬 했을 때 3~5사이의 레코드만 출력 하고
      연봉은 7자리로 맞춰 출력하고 ,를 넣어 출력한다.
      해당 자리에 값이 없으면 0을 출력한다.
*/

SELECT r, empno, ename, TO_CHAR(LPAD(sal,7,'0'), '0,000,000') sal, comm
FROM (SELECT ROWNUM r, empno, ename, sal, comm
	  FROM (SELECT empno, ename, sal, NVL(comm, 0) comm
	   	    FROM emp))
WHERE r BETWEEN 3 AND 5;

/*
2. class4_info 테이블에서 번호, 이름 , 나이, 태어난 해를 조회 하세요.
   태어난 해는 현재년도-나이+1 로 구합니다.
*/

SELECT * FROM class4_info;

UPDATE class4_info
SET age = 29
WHERE num = 10;

UPDATE class4_info
SET age = 22
WHERE num = 12;

UPDATE class4_info
SET age = 20
WHERE num = 13;

UPDATe class4_info
SET age = 33
WHERE num=14;

SELECT num, name, age, TO_CHAR(SYSDATE,'yyyy')-age+1 yob
FROM class4_info;

/*
3. class4_info 테이블 번호, 이름 나이, 이메일, 이메일의 유효성 여부를
   조회.
   단, 이메일의 유효성은 '@' 이 없으면 '무효', '@'이 존재하면 '유효'를출력
*/

UPDATE class4_info
SET email = 'oo@javs.com'
WHERE num = 10;

UPDATE class4_info
SET email = 'jojo@oracle.com'
WHERE num = 12;

UPDATE class4_info
SET email = 'jpjp.kr'
WHERE num = 13;

UPDATe class4_info
SET email = 'hoho@hohoho.com'
WHERE num=14;

SELECT * FROM class4_info;

SELECT num, name, age, email,
	   DECODE(INSTR(email, '@'), 0, '무효', '유효') v_email
FROM class4_info;

/*
4. car_model 테이블에서 옵션에 'ABS'나 '에어백'이 있는 차량의
    모델명,년식,가격,옵션, 이미지, 제조사를 조회 하세요.
    단, 가격의 오름차순으로 정렬하여 출력할 것.
*/

SELECT * FROM car_model;
SELECT model, car_year, price, car_option, car_img,
	   (SELECT maker
		FROM car_maker
		WHERE car_model.model = car_maker.model) maker
FROM car_model
WHERE car_option LIKE '%ABS%' OR car_option LIKE '%에어백%'
ORDER BY price;

/*
5. car_model 테이블에서 모델명이 '아반테', '소렌토', 'A8'인 차량의
    모델명,모델별 가격 총합과 총계를 조회 하세요.
*/

SELECT model, SUM(price)
FROM car_model
WHERE model IN ('아반테','소렌토','A8')
GROUP BY ROLLUP(model);

/*
6. car_model 테이블에서 차량 가액이 1500~3000 사이인 차량의
   모델명, 년식, 가격, 옵션, 입력일, 가격별 순위를 조회하세요.
   단, 가격별 순위는 중복되지 않는 번호가 출력되어야합니다.
*/

SELECT model, car_year, price, car_option, hiredate,
	   ROW_NUMBER() OVER(ORDER BY price) rank
FROM car_model
WHERE price BETWEEN 1500 AND 3000;

/*
7. 사원 테이블에서 입사년도가 1981년 이상이면서 매니저가 있는  사원의
   사원번호,사원명,연봉,매니저번호, 연봉 순위를 조회 하세요.
   단, 연봉순위는 동일한 연봉일 때 동일한 순위를 보여줍니다.
*/

SELECT empno, ename, sal, mgr,
       RANK() OVER(ORDER BY sal DESC) rank
FROM   emp
WHERE  TO_CHAR(hiredate,'yyyy') >= 1981;

