
DROP TABLE personal_info;

PURGE RECYCLEBIN;

/*  -------------------------------------------------------------------------
181023 ��������

1. �Ʒ��� ���� �����͸� ������ �� �ִ� ���̺��� �����Ѵ�.
��ȣ - �����̸� 5�ڸ����� �Է�
�̸� - �����������̸� �ѱ۷� 10�ڱ��� �Է�.
���� - ���������̸� ����� 1�� �Է�.
�ּ� - �����������̸� �ѱ۷� 120�� �����Է�.
���� - �����̸� 3�ڱ��� �Է�
�Է��� - �����Ͱ� �߰��Ǵ� ���� �Ϸ� �Է�.
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
2. �� ���̺� �Ʒ��� ���� �����͸� �߰��Ѵ�.
  1, '����ȣ', 'M', '����� ������ ���ﵿ',64,����
  2, '������', 'M', '����� ���α� ������',87,����
  3, '������', 'F', '����� �������� ���ǵ���',97,����
  4, 'Ȳ�缺', 'M', '����� ���۱� �󵵵�',100,����
  5, '���缮', 'M', '��⵵ ������ ���뱸',100,����
*/

INSERT INTO p_info(num, name, gender, addr, score, i_date)
VALUES(1, '����ȣ', 'M', '����� ������ ���ﵿ', 64, SYSDATE);

INSERT INTO p_info
VALUES(2, '������', 'M', '����� ���α� ������' ,87, SYSDATE);

INSERT INTO p_info
VALUES(3, '������', 'F', '����� �������� ���ǵ���', 97, SYSDATE);

INSERT INTO p_info
VALUES(4, 'Ȳ�缺', 'M', '����� ���۱� �󵵵�', 100, SYSDATE);

INSERT INTO p_info
VALUES(5, '���缮', 'M', '��⵵ ������ ���뱸', 100, SYSDATE);

SELECT * FROM p_info;

/*
3. �� �Էµ� ������ �� ���� ��ȣ�� 3���̸� ������ 97���� �����
    �̸��� '�׽�Ʈ'�� ������ 'M'���� �����Ѵ�.
*/
UPDATE p_info
SET name='�׽�Ʈ', gender='M'
WHERE num=3 AND score=97;

COMMIT;


-- 4. ���� �����Ϳ��� �̸��� '���缮'�� ����Ǽ����� 'F'�� �����Ѵ�.r
UPDATE p_info
SET gender = 'F'
WHERE name='���缮';

SELECT * FROM p_info;

-- 5. 4���� �۾��� ����Ѵ�.
ROLLBACK;


-- 6. ��ȣ�� 1���̸� �̸��� �������� ����� �����͸� �����Ѵ�.
DELETE FROM p_info
WHERE num=1 AND name='������';


-- 7. ��� �����͸� �����Ѵ�.
TRUNCATE TABLE p_info;
SELECT * FROM p_info;

-- 8. ���̺��� �����Ѵ�.
DROP TABLE p_info;

-- 9. �������� ����.
PURGE RECYCLEBIN;

SELECT * FROM p_info;


/* ---------------------------------------------------------------------------
181024 ��������

1. ��� ���̺��� '10' �μ��� �ƴϸ鼭 ������ 1000�̻� 3000������
��� �������  �����ȣ,�����, �Ի���,�μ���ȣ, ������ ��ȸ�ϼ���.
*/

SELECT  empno, ename, hiredate, deptno, sal
FROM	emp
WHERE 	deptno != 10 AND sal BETWEEN 1000 AND 3000;

/*
2. ��� ���̺��� ���ʽ��� �����ϴ� �������  �����ȣ,�����,
    ����,���ʽ�, �Ѽ��ɾ�, ������ ��ȸ �ϼ���.
    - ������ ������ 12������ ���� ����� ��.
*/

SELECT empno, ename, sal, NVL(comm, 0), sal+NVL(comm, 0) total, TRUNC(sal/12, 0) m_pay
FROM   emp;


/*
3.  ��� ���̺��� �μ���ȣ�� 10,30��  ������� �����, �����ȣ
    �Ի���, ������ ��ȸ �ϼ���.
    -��, �����  xxxx�� xxxx����� xxxx�⿡ �Ի��Ͽ��� ������ xxx$�Դϴ�.
        �� �������� �ϰ�, �÷����� output ���� �����Ұ�.
*/

SELECt empno||'�� '||ename||' ����� '||TO_CHAR(hiredate, 'yyyy')||'�⿡ �Ի��Ͽ��� ������ '
	   ||sal||'$�Դϴ�.' output
FROM	emp
WHERE deptno IN (10, 30);


/*
4. ��� ���̺��� ������ 3000 �̸��� ������� �����ȣ, �����,
   �Ի���, ����,����, �μ���ȣ�� ��ȸ �ϼ���.
   ��, ������ ������������ �����ϵ� ������ ���ٸ� ������� ������������
   �����Ұ�.
*/

SELECT   empno, ename, hiredate, sal, job, deptno
FROM	 emp
WHERE 	 sal < 3000
ORDER BY sal, ename DESC;

/*
5. test_like ���̺� �Ʒ��� ���� �����͸� �߰��Ұ�.
    7, ����������,����� ���۱� �󵵵�,'�����'
    8, ���븸,����� ���빮�� ���빮1��,'��Ÿ��'
    9, ���¼�,����� ���빮�� ���빮2��,'�����'
*/

SELECT * FROM test_like;
DELETE FROM test_like;

INSERT INTO test_like(num, name, loc, highschool)
VALUES(7, '����������', '����� ���۱� �󵵵�', '�����');

INSERT INTO test_like(num, name, loc, highschool)
VALUES(8, '���븸', '����� ���빮�� ���빮1��', '��Ÿ��');

INSERT INTO test_like(num, name, loc, highschool)
VALUES(9, '���¼�', '����� ���빮�� ���빮2��', '�����');

SELECT * FROM test_like;

/*
6. test_like ���̺��� '�����'�� �����ϴ� �л���  ��ȣ,�л���,
    �ּ�, �б������� �Ʒ���  ���� �������� ����ϰ�
     �÷����� ��ҹ��� �����Ͽ� Output����  �Ұ�.
    ������� :  ��ȣ : x, �̸� : xx, �ּ� : xx, �б� : xx
*/

SELECT '��ȣ : '||num||', �̸� : '||name||', �ּ� : '
	   ||loc||', �б� : '||highschool output
FROM test_like
WHERE loc LIKE '�����%';

/*
7. ������̺��� ������� 4�����̰ų� ������ 3000�̻��� �����
   �����ȣ, �����, ����, �Ի���, �μ���ȣ, ������ ��ȸ�Ұ�.
   ��, ��� �����ʹ� ������ ������������ �����ϰ�, ������ ���ٸ�
     ������� ���� �������� �����Ұ�.
*/

SELECT empno, ename, sal, hiredate, deptno, job
FROM emp
WHERE ename LIKE '____' OR sal >= 3000
ORDER BY sal, ename;

/*
8.  test_like ���̺��� ����б����� ����ϰ� �б����� ����
    �������� �����Ͽ� ����� ��.
    ��, ����б� ���� ���ٸ� �ϳ��� ����ϼ���.(2������ �� ��.)
*/

SELECT DISTINCT highschool
FROM test_like
ORDER BY highschool;

SELECT highschool
FROM test_like
GROUP BY highschool
ORDER BY highschool;

/*
9. ��� ���̺��� �����ȣ, �����, �Ի���, ����, ���⿬����
    ��ȸ �ϼ���.
    ���� ������ ���� �������� 7% ���� �ݾ����� ����Ͽ� ����Ұ�.
*/

SELECT empno, ename, hiredate, sal, sal*1.07 n_sal
FROM emp;

/*
10. ��� ���̺��� ������� 5�����̸鼭 ����° ���ڿ� 'A'�� ���
    �� ����� �����, �����ȣ, �Ի���, ������ ��ȸ�ϼ���.
    ��, ������ ������������ ����Ұ�.
*/

SELECT ename, empno, hiredate, sal
FROM	emp
WHERE ename LIKE '__A__'
ORDER BY sal;

/*
11. ��� ���̺��� ������� 'A'�� �����ϸ鼭 ������ 1600�̻���
     ����� �����,����,����, �Ŵ�����ȣ, �Ի����� ��ȸ �Ұ�.
*/

SELECT ename, sal, job, mgr, hiredate
FROM emp
WHERE ename LIKE'A%' AND sal >= 1600;


/* -----------------------------------------------------------------------------
181025 ��������

    1. ������̺��� �����ȣ, �����,����, �Ŵ�����ȣ,����,
    �Ի����� ��ȸ�ϼ���.
     ��, ������ ������������ �����ϵ�, ������ ���ٸ� �����ȣ��
    ������������ �����ϼ���.
    �Ի����� ��-��-���� �������� ����ϼ���.
    ������ 3�ڸ����� ,�� �־� ����ϼ���.
*/

SELECT empno, ename, job, mgr,
	   TO_CHAR(sal,'999,999') sal, TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate
FROM emp
ORDER BY sal, empno DESC;

/*
    2. ������̺��� 3,4�б⿡ �Ի��� �������  �μ��� ������,
    �������, �ְ���, ��������, ������� ��ȸ�Ͽ� �Ʒ��� ���� ����ϼ���.
    ��¿� )  10���μ� ������� [x]��, ������� : [xx],
       �ְ��� [xx], ��������[xx]
*/

SELECT deptno||'�� �μ� ������� '||COUNT(empno)||'��, ������� : '||TRUNC(AVG(sal),0)
	   ||', �ְ��� : '||MAX(sal)||', �������� : '||MIN(sal) output
FROM emp
WHERE TO_CHAR(hiredate,'q') IN (3, 4)
GROUP BY deptno;

/*
  3. TEST_ORDERBY���̺��� ��ȣ�� ����ϼ���.
   ��, ��µǴ� ��ȣ��  S_0000000001 ��������
   10�ڸ��� ���ڰ� �Ǿ���ϸ�, 10�ڸ��� ���� �ʴ� ���ڴ�
  �տ� 0�� �ٿ� 10�ڸ��� ����� 'S_' �� �ٿ� ����Ѵ�.
*/

SELECT * FROM test_orderby;

SELECT 'S_'||LPAD(num,10,'0') output
FROM test_orderby;

/*
    4. ������̺��� �μ���ȣ, �μ���, ����,���ʽ�,�Ѽ��ɾ�,
     �Ի����� ��ȸ�ϼ���.
       ��. �Ѽ��ɾ��� '����+����+���ʽ�'�� �ջ��� �ݾ�����
       ��ȸ�ϼ���.  ������ ������ 12�� ���� ���� ������ �����Ͽ�
       ����ϼ���.
*/

SELECT deptno, (SELECT dname
 				FROM dept
 				WHERE emp.deptno = dept.deptno) dname,
	   sal, NVL(comm, 0),
	   TRUNC(sal+(sal/12)+NVL(comm,0),0) total
FROM emp;

/*
  5. ��� ���̺��� �μ���ȣ,�μ���,����, ���ʽ�, �μ�Ƽ�긦
   ��ȸ�ϼ���.
   �μ�Ƽ���  �Ʒ�ǥ�� ���� �μ����� ���� �����մϴ�.
   10- ���޿� 100%, 20- ���޿� 150%, 30 - ���޿� 300%
   �׿� ���޿� 50%
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
6. class4_info ���̺� �Ʒ��� ���� �����͸� �߰��մϴ�.
   ��ȣ - 10, �̸� - Ȳ�缺, �ֹι�ȣ - 030101-3234567
   ��ȣ - 12, �̸� - �ż���, �ֹι�ȣ - 011201-4234567
   ��ȣ - 13, �̸� - �ڳ���, �ֹι�ȣ - 880101-2234567
   ��ȣ - 14, �̸� - ��ſ�, �ֹι�ȣ - 880101-2234567
*/

DELETE FROM class4_info;
SELECT * FROM class4_info;

INSERT INTO class4_info(num, name, ssn)
VALUES(10, 'Ȳ�缺', '030101-3234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(12, '�ż���', '011201-4234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(13, '�ڳ���', '880101-2234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(14, '��ſ�', '880101-2234567');

SELECT * FROM class4_info;

/*
7. class4_info ���̺��� ��ȣ, �̸� , �ֹι�ȣ,
   ������ ��ȸ �ϼ���.
   ������ �ֹι�ȣ��   8��° �ڸ��� ���Ѵ�.
   8��° �ڸ��� 1,3�̸� ����, 2,4�� ���� �׷��� ������ "����"
   ������Ѵ�.
*/

SELECT num, name, ssn,
	   DECODE(SUBSTR(ssn, INSTR(ssn, '-')+1,1),
	   	1, '����',
	   	2, '����',
	   	3, '����',
	   	4, '����',
	   	'����') gender
FROM class4_info;

SELECT num, name, ssn,
	   CASE SUBSTR(ssn, INSTR(ssn, '-')+1, 1)
	   	WHEN '1' THEN '����'
	   	WHEN '2' THEN '����'
	   	WHEN '3' THEN '����'
	   	WHEN '4' THEN '����'
	   	ELSE '����'
	   	END gender
FROM class4_info;


/* ---------------------------------------------------------------------------

181026 ��������
1. ��� ���̺��� �����ȣ,�����, ����, ���ʽ��� ��ȸ
   ��, ��� ��ȣ�� �������� ���� ���� �� 3~5������ ���ڵ常 ��� �ϰ�
      ������ 7�ڸ��� ���� ����ϰ� ,�� �־� ����Ѵ�.
      �ش� �ڸ��� ���� ������ 0�� ����Ѵ�.
*/

SELECT r, empno, ename, TO_CHAR(LPAD(sal,7,'0'), '0,000,000') sal, comm
FROM (SELECT ROWNUM r, empno, ename, sal, comm
	  FROM (SELECT empno, ename, sal, NVL(comm, 0) comm
	   	    FROM emp))
WHERE r BETWEEN 3 AND 5;

/*
2. class4_info ���̺��� ��ȣ, �̸� , ����, �¾ �ظ� ��ȸ �ϼ���.
   �¾ �ش� ����⵵-����+1 �� ���մϴ�.
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
3. class4_info ���̺� ��ȣ, �̸� ����, �̸���, �̸����� ��ȿ�� ���θ�
   ��ȸ.
   ��, �̸����� ��ȿ���� '@' �� ������ '��ȿ', '@'�� �����ϸ� '��ȿ'�����
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
	   DECODE(INSTR(email, '@'), 0, '��ȿ', '��ȿ') v_email
FROM class4_info;

/*
4. car_model ���̺��� �ɼǿ� 'ABS'�� '�����'�� �ִ� ������
    �𵨸�,���,����,�ɼ�, �̹���, �����縦 ��ȸ �ϼ���.
    ��, ������ ������������ �����Ͽ� ����� ��.
*/

SELECT * FROM car_model;
SELECT model, car_year, price, car_option, car_img,
	   (SELECT maker
		FROM car_maker
		WHERE car_model.model = car_maker.model) maker
FROM car_model
WHERE car_option LIKE '%ABS%' OR car_option LIKE '%�����%'
ORDER BY price;

/*
5. car_model ���̺��� �𵨸��� '�ƹ���', '�ҷ���', 'A8'�� ������
    �𵨸�,�𵨺� ���� ���հ� �Ѱ踦 ��ȸ �ϼ���.
*/

SELECT model, SUM(price)
FROM car_model
WHERE model IN ('�ƹ���','�ҷ���','A8')
GROUP BY ROLLUP(model);

/*
6. car_model ���̺��� ���� ������ 1500~3000 ������ ������
   �𵨸�, ���, ����, �ɼ�, �Է���, ���ݺ� ������ ��ȸ�ϼ���.
   ��, ���ݺ� ������ �ߺ����� �ʴ� ��ȣ�� ��µǾ���մϴ�.
*/

SELECT model, car_year, price, car_option, hiredate,
	   ROW_NUMBER() OVER(ORDER BY price) rank
FROM car_model
WHERE price BETWEEN 1500 AND 3000;

/*
7. ��� ���̺��� �Ի�⵵�� 1981�� �̻��̸鼭 �Ŵ����� �ִ�  �����
   �����ȣ,�����,����,�Ŵ�����ȣ, ���� ������ ��ȸ �ϼ���.
   ��, ���������� ������ ������ �� ������ ������ �����ݴϴ�.
*/

SELECT empno, ename, sal, mgr,
       RANK() OVER(ORDER BY sal DESC) rank
FROM   emp
WHERE  TO_CHAR(hiredate,'yyyy') >= 1981;

