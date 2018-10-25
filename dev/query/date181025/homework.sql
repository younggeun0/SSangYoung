/*
	1. 사원테이블에서 사원번호, 사원명,직무, 매니저번호,연봉,
    입사일을 조회하세요.
 	단, 연봉의 오름차순으로 정렬하되, 연봉이 같다면 사원번호의
    내림차순으로 정렬하세요.
    입사일은 월-일-년의 형식으로 출력하세요.
    연봉은 3자리마다 ,를 넣어 출력하세요.
*/

SELECT empno, ename, job, mgr,
	   TO_CHAR(sal, '999,999') sal, TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate
FROM emp
ORDER BY sal, empno DESC;

/*
	2. 사원테이블에서 3,4분기에 입사한 사원들의  부서별 연봉합,
    연봉평균, 최고연봉, 최저연봉, 사원수를 조회하여 아래와 같이 출력하세요.
    출력예 )  10번부서 사원수는 [x]명, 연봉평균 : [xx],
	   최고연봉 [xx], 최저연봉[xx]
*/

SELECT deptno||'번부서 사원수는 ['||COUNT(empno)||']명, 연봉평균 : ['||TRUNC(AVG(sal),0)
	   ||'], 최고연봉 : ['||MAX(sal)||'], 최저연봉 : ['||MIN(sal)||']' output
FROM emp
WHERE TO_CHAR(hiredate, 'q') IN (3, 4)
GROUP BY deptno;

/*
  3. TEST_ORDERBY테이블에서 번호를 출력하세요.
   단, 출력되는 번호는  S_0000000001 형식으로
   10자리의 숫자가 되어야하며, 10자리가 되지 않는 숫자는
  앞에 0을 붙여 10자리로 만들고 'S_' 를 붙여 출력한다.
*/

SELECT 'S_'||LPAD(num, 10, '0') output
FROM TEST_ORDERBY
ORDER BY LPAD(num, 10, '0');
                
-- LPAD 구현이 올바른 풀이방법
-- TO_CHAR로 붙이면 S_와 TO_CHAR로 만들어진 문자열 사이에 공백 하나가 생김
SELECT 'S_'||TO_CHAR(num, '0000000000') output
FROM TEST_ORDERBY
ORDER BY TO_CHAR(num, '0000000000');

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
	   sal, comm bonus, sal+NVL(comm, 0)+TRUNC(sal/12, -1) total
FROM emp;

/*
  5. 사원 테이블에서 부서번호,부서명,연봉, 보너스, 인센티브를
   조회하세요.
   인센티브는  아래표와 같이 부서별로 차등 지급합니다.
   10- 월급에 100%, 20- 월급에 150%, 30 - 월급에 300%
   그외 월급에 50%
*/

SELECT deptno, empno, sal, comm,
	   DECODE(deptno, 10, TRUNC((sal/12)*1, 0),
	                  20, TRUNC((sal/12)*1.5, 0),
	                  30, TRUNC((sal/12)*3,0),
	                  TRUNC((sal/12)*0.5, 0)) incentive
FROM emp;

SELECT deptno, empno, sal, comm,
       CASE deptno WHEN 10 THEN TRUNC((sal/12)*1, 0)
       			   WHEN 20 THEN TRUNC((sal/12)*1.5, 0)
       			   WHEN 30 THEN TRUNC((sal/12)*3, 0)
       			   ELSE TRUNC((sal/12)*0.5, 0)
       			   END incentive
FROM emp;


/*
6. class4_info 테이블에 아래와 같은 데이터를 추가합니다.
   번호 - 10, 이름 - 황재성, 주민번호 - 030101-3234567
   번호 - 12, 이름 - 신세계, 주민번호 - 011201-4234567
   번호 - 13, 이름 - 박나래, 주민번호 - 880101-2234567
   번호 - 14, 이름 - 김신영, 주민번호 - 880101-2234567
*/

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
       DECODE(SUBSTR(ssn, INSTR(ssn, '-')+1, 1),
       				1, '남자',
       				2, '여자',
       				3, '남자',
       				4, '여자',
       				'오류') gender
FROM class4_info;
