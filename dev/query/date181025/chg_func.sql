-- 변환함수
-- 문자열이 아닌 값(숫자, 날짜)을 문자열로 변환 : TO_CHAR(숫자, pattern)
-- 숫자 -> 지정한 자리에 ,나 .을 출력

SELECT TO_CHAR(20181025, '0,000,000,000'),
	   TO_CHAR(20181025, '9,999,999,999')
FROM DUAL;

SELECT TO_CHAR(2018.1025, '999999.999')
FROM DUAL;

-- 사원테이블에서 사원번호, 사원명, 입사일, 연봉을 조회
-- 단, 연봉은 데이터가 있는 것까지만 ,를 넣어 출력

SELECT empno, ename, hiredate, TO_CHAR(sal, '999,999') sal
FROM emp;

-- Error! TO_CHAR함수로 반환되는 결과는 문자열이므로 산술연산이 되지 않음
SELECT TO_CHAR(sal, '9,999')+100
FROM emp;

-- 날짜를 문자열로 변환 : TO_CHAR(날짜, pattern)
SELECT TO_CHAR(SYSDATE, 'y'), TO_CHAR(SYSDATE, 'yy'),
	   TO_CHAR(SYSDATE, 'yyy'), TO_CHAR(SYSDATE, 'yyyy'),
	   TO_CHAR(SYSDATE, 'yyyyy')
FROM DUAL;

-- 월과 일은 mm, dd처럼 두개 꼭 두개 이상 써야 한다
-- 내가 보고싶은 형태로 패턴을 만듦
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd'), TO_CHAR(SYSDATE, 'mm-dd-yyyy')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24)')
FROM DUAL;

-- 날짜형이 시간형태로 입력이 되면 시간정보는 없음, 날짜 정보만 있음
-- SYSDATE만 시간정보 갖는다
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24):mi:ss')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24):mi:ss day dy q')
FROM DUAL;

-- perttern이 특수문자가 아닌 문자열 사용할때에는 "로 묶는다
SELECT TO_CHAR(SYSDATE, 'yyyy"년" mm"월" dd"일"')
FROM DUAL;

-- perttern을 너무 길게 사용하면 Error 발생!
SELECT TO_CHAR(SYSDATE, 'yyyy " 년 " mm " 월 " dd " 일 " hh24 " 시 " mi " 분 " ss " 초 "')
FROM DUAL;

-- 이럴경우 잘라서 ||로 붙이는 방법을 사용
SELECT TO_CHAR(SYSDATE, 'yyyy " 년 " mm " 월 " dd " 일 "') ||
       TO_CHAR(' hh24 " 시 " mi " 분 " ss " 초 "')
FROM DUAL;

-- 사원테이블에서 사원번호, 사원명, 입사일을 조회
-- 단, 입사일은 년-월-일 요일의 형식으로 출력할 것
SELECT empno, ename, hiredate, TO_CHAR(hiredate, 'yyyy-mm-dd day hh:mi:ss')
FROM emp;

-- 사원테이블에서 입사년도가 '1981'년인 사원들의
-- 사원번호, 사원명, 입사일, 연봉을 조회

SELECT empno 사원번호, ename 사원명, sal 연봉, TO_CHAR(hiredate, 'mm"월 "dd"일"') 입사일
FROM emp
WHERE TO_CHAR(hiredate, 'yyyy')=1981;

-- 현재 날짜가 아닌 날짜를 추가할 때
-- 날짜 형식의 문자열을 추가하면 됨
INSERT INTO class4_info(num, name, input_date)
VALUES(8, '양세찬', '2018-10-21');

INSERT INTO class4_info(num, name, input_date)
VALUES(9, '양세형', TO_DATE('2018-10-22', 'yyyy-mm-dd'));

SELECT * FROM class4_info
WHERE name LIKE '양%';

SELECT TO_CHAR(input_date, 'yyyy-mm')
FROM class4_info;

-- TO_CHAR는 날짜나 숫자를 입력받아야함.(함수의 값(인자)은 데이터형을 구분한다.)
SELECT TO_CHAR('2018-10-25', 'mm')
FROM DUAL;

SELECT TO_CHAR(TO_DATE('2018-10-25', 'yyyy-mm-dd'), 'mm')
FROM DUAL;

-- 숫자 변환 : TO_NUMBER(숫자형식의문자열)

SELECT '25'-'10'
FROM DUAL;

SELECT TO_NUMBER('25') - TO_NUMBER('10')
FROM DUAL;
                 
-- 문자열이 숫자형식을 갖을 경우에만 TO_NUMBER 사용 가능
-- 숫자가 아닌 다른 형식은 TO_NUMBER가 숫자로 바꿀 수 없음
SELECT TO_NUMBER('월요일')
FROM DUAL;
