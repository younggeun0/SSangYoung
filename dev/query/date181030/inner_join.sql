-- INNER JOIN : ���� �ٸ� ���̺� ���� ���� �ִ� ��쿡�� ��ȸ

SELECT * FROM dept;
SELECT * FROM emp;

-- �����ȣ, �����, �μ���ȣ, �μ���, �μ���ġ, ���� ��ȸ
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
-- ������ ���̺� PK ����
ALTER TABLE car_country ADD CONSTRAINT pk_car_country PRIMARY KEY(maker);
-- ������ ���̺� FK ����
ALTER TABLE car_maker ADD CONSTRAINT fk_car_maker FOREIGN KEY(maker) REFERENCES car_country(maker);
-- ������ ���̺� PK ����
ALTER TABLE car_maker ADD CONSTRAINT pk_car_maker PRIMARY KEY(model);
-- �� ���̺� FK ����
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


-- �𵨸��� '�ƹ���', '�ҳ�Ÿ', 'A8'�� ������ ������, ������,
-- �𵨸�, ����, ����, �̹����� ��ȸ

-- ANSI
SELECT cc.country, cc.maker,
       cma.model, cmo.car_year, cmo.price,
       cmo.car_img
FROM car_country cc
INNER JOIN car_maker cma
 ON cma.maker = cc.maker
INNER JOIN car_model cmo
 ON cmo.model = cma.model
WHERE cma.model IN ('�ƹ���', '�ҳ�Ÿ', 'A8');

-- ORACLE
SELECT cc.country, cc.maker, cma.model, cmo.car_year,
	   cmo.price, cmo.car_img
FROM car_country cc, car_maker cma, car_model cmo
WHERE (cma.maker = cc.maker
  AND cmo.model=cma.model)
  AND cma.model IN ('�ƹ���', '�ҳ�Ÿ', 'A8');



-- �����ȣ, �����, ����, �Ի���, �μ���ȣ, �μ���, ��ġ,
-- �����ȣ, �õ�, ����, ��, ������ ��ȸ�ϼ���.
-- dept.deptno�� PK, emp.deptno�� FK
-- (������ ����) ������̺��� �����ȣ�� �����ȣ ���̺��� seq�� ������������ ���

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

