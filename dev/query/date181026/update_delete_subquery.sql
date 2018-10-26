
-- UPDATE Subquery
-- �ٸ����̺��� ���� �����Ͽ� ���� ���̺��� ���� ������ �� ���
-- �����ຸ�� ������ Subquery�� ������

-- cp_emp3���̺��� �����ȣ�� '1111'�� ����� ������
-- emp���̺��� �����ȣ�� '7788'�� ����� �������� ����

SELECT * FROM cp_emp3;
SELECT * FROM emp;

UPDATE cp_emp3
SET sal=(SELECT sal
		 FROM emp
		 WHERE empno=7788)
WHERE empno=1111;

-- �������� ���� �� �� ���� Error
UPDATE cp_emp3
SET sal=(SELECT sal FROM emp)
WHERE empno=1111;


-- ���߰��� ��� �� �� ���� ERROR
UPDATE cp_emp3
SET sal=(SELECT sal,deptno
 		 FROM emp
 		 WHERE empno=7788)
WHERE empno=1111;

-- ������ ���������� IN�� ����Ͽ� WHERE���� ��밡��
INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(2222, '�׽�Ʈ', 30, 'salesman', 2000);

COMMIT;

SELECT * FROM cp_emp3;

-- cp_emp3���̺��� �μ���ȣ�� 30�� emp���̺���
-- �����ȣ�� ���� ����� ������ 1000���� ����

SELECT empno
FROM   emp
WHERE  deptno=30;

UPDATE cp_emp3
SET    sal=1000
WHERE  empno IN (SELECT empno
				 FROM   emp
 				 WHERE  deptno=30);

SELECT * FROM cp_emp3;

-- DELETE Subquery
-- �ٸ����̺��� ���� �����Ͽ� ���� ���̺� ���ڵ� ����
-- �ܼ��� ��������

UPDATE cp_emp3
SET	   ename='���ī'
WHERE  empno=7698;
COMMIT;

SELECT * FROM cp_emp3;
SELECT * FROM cp_emp;
SELECT * FROM emp;
-- cp_emp3���̺��� ��������� ������ ��
-- �������� : emp���̺��� ������� 'BLAKE'�� �����
--         �����ȣ�� ���� ����� cp_emp3���̺��� ����

DELETE FROM cp_emp3
WHERE empno=(SELECT empno
			 FROM emp
			 WHERE ename='BLAKE');

SELECT * FROM cp_emp3;


-- ������ ��������
-- cp_emp3���̺��� emp���̺��� �μ���ȣ��
-- 30���� ��� ������� �����ȣ�� ���� ����� ����

DELETE FROM cp_emp3
WHERE empno IN (SELECT empno
			    FROM   emp
			    WHERE  deptno=30);

SELECT * FROM cp_emp3;
