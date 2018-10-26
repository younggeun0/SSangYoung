-- 25�� ���� ����
/*
    1. ������̺��� �����ȣ, �����,����, �Ŵ�����ȣ,����,
    �Ի����� ��ȸ�ϼ���.
     ��, ������ ������������ �����ϵ�, ������ ���ٸ� �����ȣ��
    ������������ �����ϼ���.
    �Ի����� ��-��-���� �������� ����ϼ���.
    ������ 3�ڸ����� ,�� �־� ����ϼ���.
*/

SELECT empno, ename, job, mgr,
	   TO_CHAR(sal, '999,999') sal,
	   TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate
FROM emp
ORDER BY sal ASC, empno DESC;

/*
    2. ������̺��� 3,4�б⿡ �Ի��� �������  �μ��� ������,
    �������, �ְ���, ��������, ������� ��ȸ�Ͽ� �Ʒ��� ���� ����ϼ���.
    ��¿� )  10���μ� ������� [x]��, ������� : [xx],
       �ְ��� [xx], ��������[xx]
*/

SELECT deptno||'���μ� ������� '||COUNT(empno)||'��, ������� : '
	   ||TRUNC(AVG(sal), 0)||', �ְ��� : '||MAX(sal)||', �������� :'
	   ||MIN(sal)
FROM emp
WHERE TO_CHAR(hiredate, 'q') IN (3, 4)
GROUP BY deptno;

/*
  3. TEST_ORDERBY���̺��� ��ȣ�� ����ϼ���.
   ��, ��µǴ� ��ȣ��  S_0000000001 ��������
   10�ڸ��� ���ڰ� �Ǿ���ϸ�, 10�ڸ��� ���� �ʴ� ���ڴ�
  �տ� 0�� �ٿ� 10�ڸ��� ����� 'S_' �� �ٿ� ����Ѵ�.
*/

SELECT 'S_'||LPAD(num, 10, '0')
FROM TEST_ORDERBY
ORDER BY LPAD(num, 10, '0');

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
	   sal, comm,
	   sal+NVL(comm,0)+TRUNC(sal/12, -1) total,
	   hiredate
FROM   emp;


/*
  5. ��� ���̺��� �μ���ȣ,�μ���,����, ���ʽ�, �μ�Ƽ�긦
   ��ȸ�ϼ���.
   �μ�Ƽ���  �Ʒ�ǥ�� ���� �μ����� ���� �����մϴ�.
   10- ���޿� 100%, 20- ���޿� 150%, 30 - ���޿� 300%
   �׿� ���޿� 50%
*/

SELECT empno, (SELECT dname
			   FROM dept
			   WHERE emp.deptno = dept.deptno) dname,
	   sal, NVL(comm, 0),
	   DECODE(deptno, 10, sal*1,
	   				  20, sal*1.5,
	   				  30, sal*3,
	   				  sal*0.5) incentive
FROM emp;

SELECT empno, (SELECT dname
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
DELETE FROM class4_info
WHERE num IN (10, 12, 13, 14);

SELECT * FROM class4_info;

INSERT INTO class4_info(num, name, ssn)
VALUES(10, 'Ȳ�缺', '030101-3234567');
INSERT INTO class4_info(num, name, ssn)
VALUES(12, '�ż���', '011201-4234567');
INSERT INTO class4_info(num, name, ssn)
VALUES(13, '�ڳ���', '880101-2234567');
INSERT INTO class4_info(num, name, ssn)
VALUES(14, '��ſ�', '880101-2234567');

/*
7. class4_info ���̺��� ��ȣ, �̸� , �ֹι�ȣ,
   ������ ��ȸ �ϼ���.
   ������ �ֹι�ȣ��   8��° �ڸ��� ���Ѵ�.
   8��° �ڸ��� 1,3�̸� ����, 2,4�� ���� �׷��� ������ "����"
   ������Ѵ�.
*/

SELECT num, name, ssn,
       DECODE(SUBSTR(ssn, INSTR(ssn, '-')+1, 1),
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

