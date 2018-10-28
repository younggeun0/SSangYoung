--181023 ���� ����

CREATE TABLE personal_info(
	num NUMBER(5),
	name VARCHAR2(30),
	gender CHAR(1),
	address VARCHAR2(360),
	score NUMBER(3),
	i_date DATE
);

RENAME persnoal_info to personal_info;

INSERT INTO personal_info
VALUES(1, '����ȣ', 'M', '����� ������ ���ﵿ', 64, SYSDATE);

INSERT INTO personal_info
VALUES(2, '������', 'M', '����� ���α� ������', 87, SYSDATE);

INSERT INTO personal_info(num, name, gender, address, score, i_date)
VALUES(3, '������', 'F', '����� �������� ���ǵ���', 97, SYSDATE);

INSERT INTO personal_info(num, name, gender, address, score, i_date)
VALUES(4, 'Ȳ�缺', 'M', '����� ���۱� �󵵵�', 100, SYSDATE);

INSERT INTO personal_info(num, name, gender, address, score, i_date)
VALUES(5, '���缮', 'M', '��⵵ ������ ���뱸', 100, SYSDATE);

SELECT * FROM personal_info;

UPDATE	personal_info
SET		name='�׽�Ʈ', gender='M'
WHERE	num=3 AND score=97;

SELECT * FROM personal_info;

COMMIT;

UPDATE	personal_info
SET		gender='F'
WHERE	name='���缮';

SELECT * FROM personal_info;

ROLLBACK;

DELETE FROM personal_info
WHERE		num=1 AND name='������';

SELECT * FROM personal_info;

TRUNCATE TABLE personal_info;

SELECT * FROM personal_info;

DROP TABLE personal_info;

PURGE RECYCLEBIN;

SELECT tname FROM tab;

--181024 ���� ����

SELECT  empno, ename, hiredate, deptno, sal
FROM	emp
WHERE	deptno NOT IN (10) AND sal BETWEEN 1000 AND 3000;

SELECT	empno, ename, sal, comm, sal+NVL(comm,0) total, TRUNC(sal/12,2) monthlypay
FROM	emp
WHERE	comm IS NOT NULL AND comm != 0;

SELECT	empno||'�� '||ename||'����� '||TO_CHAR(hiredate, 'yyyy')||'�� �Ի��Ͽ��� ������ '||sal||'$�Դϴ�.' output
FROM	emp
WHERE	deptno IN (10, 30);

SELECT		empno, ename, hiredate, sal, job, deptno
FROM		emp
WHERE		sal < 3000
ORDER BY	sal ASC, ename DESC;

CREATE TABLE test_like (
	num NUMBER(3),
	name VARCHAR2(15),
	loc VARCHAR2(300),
	highschool VARCHAR2(15)
);

INSERT INTO test_like
VALUES(7, '����������', '����� ���۱� �󵵵�', '�����');

INSERT INTO test_like
VALUES(8, '���븸', '����� ���빮�� ���빮1��', '��Ÿ��');

INSERT INTO test_like
VALUES(9, '���¼�', '����� ���빮�� ���빮2��', '�����');

SELECT * FROM test_like;

SELECT  '��ȣ : '||num||', �̸� : '||name||', �ּ� : '||
		loc||', �б� : '||highschool "Output"
FROM	test_like
WHERE	loc LIKE '�����%';

SELECT		empno, ename, sal, hiredate, deptno, job
FROM		emp
WHERE		LENGTH(ename)=4 OR sal >=3000
ORDER BY	sal, ename;

SELECT DISTINCT highschool
FROM	 	    test_like
ORDER BY 	    highschool;

SELECT   highschool
FROM	 test_like
GROUP BY highschool
ORDER BY highschool;

SELECT empno, ename, hiredate, sal, sal*1.07 nextsal
FROM   emp;

SELECT   ename, empno, hiredate, sal
FROM     emp
WHERE    ename LIKE '__A__'
ORDER BY sal;

SELECT  ename, sal, job, mgr, hiredate
FROM	emp
WHERE   ename LIKE 'A%' AND sal>=1600;

--181025 ���� ����
SELECT  empno, ename, job, mgr,
	    TO_CHAR(sal, '999,999') sal,
	    TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate
FROM	emp
ORDER BY sal, empno DESC;

SELECT	    deptno||'���μ� ������� '||COUNT(empno)
		    ||'��, ������� : '||TRUNC(AVG(sal), 0)
		    ||', �ְ��� : '||MAX(sal)
		    ||', �������� : '||MIN(sal)
FROM		emp
WHERE		TO_CHAR(hiredate, 'q') IN (3, 4)
GROUP BY    deptno;

CREATE TABLE test_pad(
	num NUMBER(10)
);

INSERT INTO test_pad VALUES (1);
INSERT INTO test_pad VALUES (1000);
INSERT INTO test_pad VALUES (201);
INSERT INTO test_pad VALUES (35);
INSERT INTO test_pad VALUES (230);

SELECT * FROM test_pad;

SELECT   'S_'||LPAD(num, 10, '0')
FROM	 test_pad
ORDER BY num;

SELECT deptno, (SELECT dname
			    FROM   dept
			    WHERE  dept.deptno = emp.deptno) dname,
	   sal, NVL(comm,0) comm,
	   sal+NVL(comm,0)+TRUNC((sal/12),1) total, hiredate
FROM   emp;

SELECT empno, ename, sal, NVL(comm, 0) comm, deptno,
       DECODE(deptno, 10, TRUNC(sal/12, 0)*1,
       			      20, TRUNC(sal/12, 0)*1.5,
       			      30, TRUNC(sal/12, 0)*3,
       			      TRUNC(sal/12, 0)*0.5) incentive
FROM   emp;

SELECT empno, ename, sal, NVL(comm, 0) comm, deptno,
	   CASE deptno WHEN 10 THEN TRUNC(sal/12, 0)*1
	   			   WHEN 20 THEN TRUNC(sal/12, 0)*1.5
	   			   WHEN 30 THEN TRUNC(sal/12, 0)*3
	   			   ELSE TRUNC(sal/12, 0)*0.5
	   			   END incentive
FROM   emp;

CREATE TABLE class4_info(
	num NUMBER(3),
	name VARCHAR2(15),
	ssn CHAR(14)
);

INSERT INTO class4_info(num, name, ssn)
VALUES(10, 'Ȳ�缺', '030101-3234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(12, '�ż���', '011201-4234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(13, '�ڳ���', '880101-2234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(14, '��ſ�', '880101-2234567');

SELECT * FROM class4_info;

SELECT num, name, ssn,
	   DECODE(SUBSTR(ssn, INSTR(ssn, '-')+1, 1),
	   	      1, '����',
	   	      2, '����',
	   	      3, '����',
	   	      4, '����',
	   	      '����') gender
FROM   class4_info;

SELECT num, name, ssn,
       CASE SUBSTR(ssn, INSTR(ssn, '-')+1, 1)
       	WHEN '1' THEN '����'
       	WHEN '2' THEN '����'
       	WHEN '3' THEN '����'
       	WHEN '4' THEN '����'
       	ELSE '����'
       	END gender
FROM   class4_info;

--1810266 ���� ����

SELECT  empno, ename, TO_CHAR(sal, '0,000,000') sal,
	    NVL(comm,0)
FROM 	(SELECT ROWNUM r, empno, ename, sal, comm
	  	 FROM (SELECT   empno, ename, sal, comm
	  	       FROM     emp
	  	       ORDER BY empno DESC))
WHERE   r BETWEEN 3 AND 5;


SELECT * FROM class4_info;

ALTER TABLE class4_info ADD (age NUMBER(3));

UPDATE class4_info
SET    age=23
WHERE  num=10;

UPDATE class4_info
SET    age=33
WHERE  num=12;

UPDATE class4_info
SET    age=27
WHERE  num=13;

UPDATE class4_info
SET    age=44
WHERE  num=14;

SELECT num, name,
       TO_CHAR(SYSDATE, 'yyyy')-age+1 yearofbirth
FROM   class4_info;

ALTER TABLE class4_info ADD (mail VARCHAR2(30));

SELECT * FROM class4_info;

-- github �ø��� ���� �������̴� �̸��� �ּ� ����
UPDATE class4_info
SET    mail='hellocom'
WHERE  num=10;

UPDATE class4_info
SET    mail='okkycom'
WHERE  num=12;

UPDATE class4_info
SET    mail='helloworld.kr'
WHERE  num=13;

UPDATe class4_info
SET    mail='dbmsiseasyom'
WHERE  num=14;

SELECT * FROM class4_info;

SELECT num, name, age, mail
FROM   class4_info
WHERE  mail LIKE '%@%' AND
           mail LIKE '%.%';

SELECT * FROM car_model;
SELECT * FROM car_maker;

SELECT model, car_year, price, car_option, car_img,
       (SELECT maker
       	FROM   car_maker
       	WHERE  car_maker.model=car_model.model) maker
FROM   car_model
WHERE  car_option LIKE '%ABS%' OR
	   car_option LIKE '%�����%'
ORDER BY price ASC;

SELECT    model, SUM(price)
FROM      car_model
WHERE	  model IN ('�ƹ���', '�ҷ���', 'A8')
GROUP BY  ROLLUP(model);

SELECT * FROM car_model;

SELECT model, car_year, price, car_option,
	   hiredate, ROW_NUMBER() OVER(ORDER BY price DESC) rank
FROM   car_model
WHERE  price BETWEEN 1500 AND 3000;

SELECT empno, ename, sal, mgr, RANK() OVER(ORDER BY sal DESC) rank
FROM   emp
WHERE  TO_CHAR(hiredate, 'yyyy') >= 1981 AND mgr IS NOT NULL;

-- ���� ��