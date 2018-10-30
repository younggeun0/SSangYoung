
SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e
LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- OUTER JOIN : 어느 한쪽 테이블에만 레코드가 존재하더라도 조회
-- 모든 부서의 부서번호, 부서명, 사원번호, 사원명, 입사일 조회
-- ANSI
SELECT d.deptno, e.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d
FULL JOIN emp e
 ON e.deptno = d.deptno;

-- ORACLE) 조인조건에 레코드가 없는 쪽에 (+)를 붙임
SELECT d.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM   dept d, emp e
WHERE  (e.deptno(+) = d.deptno);

-- 제조사가 '현대', '기아'인 모든 차량의 제조국, 제조사,
-- 모델명, 연식, 가격, 옵션을 조회

SELECT cc.country, cc.maker, cma.model,
       cmo.car_year, cmo.price, cmo.car_option
FROM   car_country cc, car_maker cma, car_model cmo
WHERE  (cma.maker = cc.maker
   AND cmo.model(+) = cma.model)
   AND cc.maker IN ('현대', '기아');


-- 모델명이 'K5','K7','소나타','아반테','Cclass','A6'인 모든 차량의
-- 제조국, 제조사, 모델명, 연식, 가격을 조회
-- 단, 가격의 내림차순으로 정렬하여 조회할 것, 가격이 같다면 연식의 내림차순으로 정렬할 것

--ANSI
SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price
FROM   car_country cc
INNER JOIN car_maker cma
 ON cma.maker = cc.maker
LEFT OUTER JOIN car_model cmo
 ON cmo.model = cma.model
WHERE cma.model IN ('K5','K7','소나타','아반테','Cclass','A6')
ORDER BY cmo.price DESC, cmo.car_year DESC;


-- ORACLE
SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price
FROM car_country cc, car_maker cma, car_model cmo
WHERE cma.maker = cc.maker
	AND cmo.model(+) = cma.model
	AND cma.model IN ('K5','K7','소나타','아반테','Cclass','A6')
ORDER BY cmo.price DESC, cmo.car_year DESC;
