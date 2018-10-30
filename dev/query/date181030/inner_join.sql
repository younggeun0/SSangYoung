-- INNER JOIN : 서로 다른 테이블에 같은 값이 있는 경우에만 조회

SELECT * FROM dept;
SELECT * FROM emp;

-- 사원번호, 사원명, 부서번호, 부서명, 부서위치, 연봉 조회
-- ANSI INNER JOIN
SELECT 	   e.empno, e.ename, e.deptno,
		   d.dname, d.loc, e.sal
FROM   	   emp e
INNER JOIN dept d
   	    ON e.deptno = d.deptno;

-- ORACLE INNER JOIN
SELECT e.empno, e.ename, e.deptno,
	   d.dname, d.loc, e.sal
FROM   emp e, dept d
WHERE  e.deptno=d.deptno;

SELECT * FROM car_country;
SELECT * FROM car_maker;
SELECT * FROM car_model;
-- 제조국 테이블에 PK 설정
ALTER TABLE car_country ADD CONSTRAINT pk_car_country PRIMARY KEY(maker);
-- 제조사 테이블에 FK 설정
ALTER TABLE car_maker ADD CONSTRAINT fk_car_maker FOREIGN KEY(maker) REFERENCES car_country(maker);
-- 제조사 테이블에 PK 설정
ALTER TABLE car_maker ADD CONSTRAINT pk_car_maker PRIMARY KEY(model);
-- 모델 테이블에 FK 설정
ALTER TABLE car_model ADD CONSTRAINT fk_car_model FOREIGN KEY(model) REFERENCES car_maker(model);

-- ANSI INNER JOIN
SELECT country.country, country.maker, maker.model, model.car_year,
	   model.price, model.cc, model.car_option, model.car_img, model.hiredate
FROM   car_country country
INNER JOIN car_maker maker
  ON maker.maker = country.maker
INNER JOIN car_model model
  ON model.model = maker.model;

-- ORACLE INNER JOIN
SELECT country.country, country.maker, maker.model, model.car_year,
	   model.price, model.cc, model.car_option, model.car_img, model.hiredate
FROM   car_country country, car_maker maker, car_model model
WHERE  maker.maker=country.maker
  AND  model.model=maker.model;


-- 모델명이 '아반테', '소나타', 'A8'인 차량의 제조국, 제조사,
-- 모델명, 연식, 가격, 이미지명 조회

-- ANSI
SELECT cc.country, cc.maker,
       cma.model, cmo.car_year, cmo.price,
       cmo.car_img
FROM car_country cc
INNER JOIN car_maker cma
 ON cma.maker = cc.maker
INNER JOIN car_model cmo
 ON cmo.model = cma.model
WHERE cma.model IN ('아반테', '소나타', 'A8');

-- ORACLE
SELECT cc.country, cc.maker, cma.model, cmo.car_year,
	   cmo.price, cmo.car_img
FROM car_country cc, car_maker cma, car_model cmo
WHERE (cma.maker = cc.maker
  AND cmo.model=cma.model)
  AND cma.model IN ('아반테', '소나타', 'A8');



-- 사원번호, 사원명, 연봉, 입사일, 부서번호, 부서명, 위치,
-- 우편번호, 시도, 구군, 동, 번지를 조회하세요.
-- dept.deptno는 PK, emp.deptno는 FK
-- (억지로 엮어) 사원테이블의 사원번호와 우편번호 테이블의 seq를 조인조건으로 사용

-- ANSI
SELECT e.empno, e.ename, e.sal, e.hiredate,
	   d.deptno, d.dname, d.loc, z.zipcode,
	   z.sido, z.gugun, z.dong, z.bunji
FROM   emp e
INNER JOIN dept d
 ON e.deptno = d.deptno
INNER JOIN zipcode z
 ON z.seq = e.empno;

-- ORACLE
SELECT e.empno, e.ename, e.sal, e.hiredate,
	   d.deptno, d.dname, d.loc, z.zipcode,
	   z.sido, z.gugun, z.dong, z.bunji
FROM emp e, dept d, zipcode z
WHERE e.deptno = d.deptno AND z.seq = e.empno;

