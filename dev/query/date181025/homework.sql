/*
	1. ������̺��� �����ȣ, �����,����, �Ŵ�����ȣ,����,
    �Ի����� ��ȸ�ϼ���.
 	��, ������ ������������ �����ϵ�, ������ ���ٸ� �����ȣ��
    ������������ �����ϼ���.
    �Ի����� ��-��-���� �������� ����ϼ���.
    ������ 3�ڸ����� ,�� �־� ����ϼ���.
*/

SELECT empno, ename, job, mgr,
	   TO_CHAR(sal, '999,999') sal, TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate
FROM emp
ORDER BY sal, empno DESC;

/*
	2. ������̺��� 3,4�б⿡ �Ի��� �������  �μ��� ������,
    �������, �ְ���, ��������, ������� ��ȸ�Ͽ� �Ʒ��� ���� ����ϼ���.
    ��¿� )  10���μ� ������� [x]��, ������� : [xx],
	   �ְ��� [xx], ��������[xx]
*/

SELECT deptno||'���μ� ������� ['||COUNT(empno)||']��, ������� : ['||TRUNC(AVG(sal),0)
	   ||'], �ְ��� : ['||MAX(sal)||'], �������� : ['||MIN(sal)||']' output
FROM emp
WHERE TO_CHAR(hiredate, 'q') IN (3, 4)
GROUP BY deptno;

/*
  3. TEST_ORDERBY���̺��� ��ȣ�� ����ϼ���.
   ��, ��µǴ� ��ȣ��  S_0000000001 ��������
   10�ڸ��� ���ڰ� �Ǿ���ϸ�, 10�ڸ��� ���� �ʴ� ���ڴ�
  �տ� 0�� �ٿ� 10�ڸ��� ����� 'S_' �� �ٿ� ����Ѵ�.
*/

SELECT 'S_'||LPAD(num, 10, '0') output
FROM TEST_ORDERBY
ORDER BY LPAD(num, 10, '0');
                
-- LPAD ������ �ùٸ� Ǯ�̹��
-- TO_CHAR�� ���̸� S_�� TO_CHAR�� ������� ���ڿ� ���̿� ���� �ϳ��� ����
SELECT 'S_'||TO_CHAR(num, '0000000000') output
FROM TEST_ORDERBY
ORDER BY TO_CHAR(num, '0000000000');

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
	   sal, comm bonus, sal+NVL(comm, 0)+TRUNC(sal/12, -1) total
FROM emp;

/*
  5. ��� ���̺��� �μ���ȣ,�μ���,����, ���ʽ�, �μ�Ƽ�긦
   ��ȸ�ϼ���.
   �μ�Ƽ���  �Ʒ�ǥ�� ���� �μ����� ���� �����մϴ�.
   10- ���޿� 100%, 20- ���޿� 150%, 30 - ���޿� 300%
   �׿� ���޿� 50%
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
6. class4_info ���̺� �Ʒ��� ���� �����͸� �߰��մϴ�.
   ��ȣ - 10, �̸� - Ȳ�缺, �ֹι�ȣ - 030101-3234567
   ��ȣ - 12, �̸� - �ż���, �ֹι�ȣ - 011201-4234567
   ��ȣ - 13, �̸� - �ڳ���, �ֹι�ȣ - 880101-2234567
   ��ȣ - 14, �̸� - ��ſ�, �ֹι�ȣ - 880101-2234567
*/

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
       DECODE(SUBSTR(ssn, INSTR(ssn, '-')+1, 1),
       				1, '����',
       				2, '����',
       				3, '����',
       				4, '����',
       				'����') gender
FROM class4_info;
