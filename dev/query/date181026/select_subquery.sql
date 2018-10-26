

-- SELECT
-- �ܼ��� ��������
-- Scalar Subquery, SELECT ��ȸ�ϴ� �÷��� ���������� ���� ��
-- emp���̺��� �����ȣ, �����, �μ���ȣ, �μ��� ��ȸ
-- �μ����� dept���̺� ����
-- ���� �̸��� �÷��� �����ϸ� � ���̺��� �����ϴ� �÷����� �����Ͽ� ����ؾ� ��
-- (���̺��.�÷���)
SELECT empno, ename, deptno, (SELECT dname
							  FROM   dept
							  WHERE  dept.deptno=emp.deptno)
FROM   emp;

SELECT * FROM cp_emp3;

INSERT INTO cp_emp3
(SELECT empno, ename, deptno, job, sal
 FROM emp
 WHERE deptno IN (10, 30));

-- ������̺��� �����ȣ�� '7698'�� ����� �μ���ȣ��
-- ���� �μ��� cp_emp3���̺��� ��ȸ
-- ��ȸ �÷��� �����ȣ, �����, �μ���ȣ, ������ ��ȸ

SELECT deptno
FROM emp
WHERE empno=7698;

SELECT empno, ename, deptno, job
FROM	cp_emp3
WHERE  deptno=(SELECT deptno
		       FROM emp
		       WHERE empno=7698);


-- �÷����� ������ ���������� �� ���� IN, ANY, ALL, EXISTS

-- ������̺��� �����ȣ�� '7698', '7782'�� ����� �μ���ȣ��
-- ���� �μ��� cp_emp3���̺��� ��ȸ
-- ��ȸ �÷��� �����ȣ, �����, �μ���ȣ, ������ ��ȸ
SELECT	empno, ename, deptno, job
FROM	cp_emp3
WHERE	deptno IN(SELECT deptno
			      FROM   emp
			 	  WHERE  empno IN (7698, 7782));

-- �ܺΰ� �Է¹ޱ�
-- �������� &������ - �Է�â�� ���� : �Է�â�� �Է��� ���� ��������
-- &�������� �������� �״�� ���ԵǹǷ� ���ڿ��� �Է��� ��� ''�� ���� ����ؾ� ��
SELECT *
FROM emp
WHERE deptno=&d_no;

SELECT *
FROM emp
WHERE ename=&ename;
-- KING�� �Է��ϸ� Error, ename=KING �̷��� ���Ƿ� ''�� ����� ��ȸ��

-- EXISTS : ���������� ���� �����Ѵٸ� �ٱ������� ����
-- ��� ���̺��� �ԷµǴ� �μ���ȣ�� �����Ѵٸ�
-- �����ȣ, �����, �Ի���, �μ���ȣ�� ��ȸ

SELECT  empno, ename, hiredate, deptno
FROM	emp
WHERE 	EXISTS (SELECT deptno
				FROM   emp
				WHERE  deptno=&no);

-- ALL : AND - ���������� ��ȸ�� �� �� ���� ���������� �񱳿��� ����(<)

SELECT * FROM emp WHERE deptno=10;

-- ���� sal�� 1300���� ���� ����� ��ȸ��
SELECT empno, ename, sal, deptno
FROM   emp
WHERE  sal < ALL (SELECT sal
			      FROM emp
			      WHERE deptno=10);

-- �Էµ� �μ����� ���� ������ ���� �������, ������ ���� ����� ��ȸ
SELECT empno, ename, sal, deptno
FROM   emp
WHERE  sal >= ALL (SELECT sal
  				  FROM   emp
  				  WHERE  deptno = &no);


-- ANY : OR - ���������� ��ȸ�� �� �� ���� ū ������ �񱳿��� ����(<)
SELECT empno, ename, sal, deptno
FROM   emp
WHERE  sal < ANY(SELECT sal
				 FROM   emp
  				 WHERE  deptno = 10);


-- ROWNUM
-- ��ȸ�� ����� �������� ��ȣ�� ���̴� �����÷�

-- ��ȣ, �����ȣ, �����, �Ի����� ��ȸ
-- ��, ��ȣ�� ��ȸ����� 1������ ���������� ���;� ��
SELECT ROWNUM, empno, ename, hiredate
FROM   emp
WHERE  deptno IN (10, 20);

-- ORDER BY�� ���� ���Ǹ� ��ȣ�� ����(���� �����ϱ� ����)
SELECT   ROWNUM, empno, ename
FROM     emp
ORDER BY ename;

-- ROWNUM�� WHER������ ����ϸ� 1�����ʹ� ��ȸ�� �ǳ�
-- 1���� �ƴ� ��ȣ�� ��ȸ���� �ʴ´�
-- ������̺��� �����ȣ, �����, �Ի���, ������ ��ȸ
-- ��, ����� ��ȸ ����  1~5������ ���
SELECT ROWNUM, empno, ename, hiredate, sal
FROM   emp
WHERE  ROWNUM BETWEEN 1 AND 5;

-- 1���� �ƴ� ��ȣ�� ������ �ϸ� ��ȸ�� �ȵ�
SELECT ROWNUM, empno, ename, hiredate, sal
FROM   emp
WHERE  ROWNUM BETWEEN 2 AND 5;

-- ������ ��������
-- ��ȸ���(INLINE VIEW)�� ������ ����ȸ�� ��
/*
	SELECT �÷���, ...
	FROM (SELECT ... )
*/

SELECT ROWNUM, empno, ename, sal, hiredate
FROM (SELECT   ROWNUM,empno, ename, sal, hiredate
	  FROM     emp
	  ORDER BY sal);

-- ������̺��� ���� �������� �Ի��� ������� 5���� ��ȸ
-- ��ȸ�÷��� �����ȣ, �����, �Ի����� ��ȸ
SELECT ROWNUM, empno, ename, hiredate
FROM   (SELECT   empno, ename, hiredate
	    FROM	 emp
	    ORDER BY hiredate DESC)
WHERE  ROWNUM BETWEEN 1 AND 5;

-- ������̺��� ���� �������� �Ի��� ���� ���(1987-04-19)���� 5�� ��ȸ
-- ��ȸ �÷��� �����ȣ, �����, �Ի����� ��ȸ
SELECT ROWNUM, rn, empno, ename
FROM   (SELECT   ROWNUM rn, empno, ename, hiredate
	    FROM	 (SELECT   empno, ename, hiredate
	    		  FROM	   emp
	    		  ORDER BY hiredate DESC))
WHERE  rn BETWEEN 2 AND 6;


SELECT * FROM user_constraints;
