
SELECT * FROM cp_emp3;
SELECT * FROM cp_emp2;

INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1112, '������', 10, '�븮', 3500);
INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1113, '������', 20, '����', 7500);
INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1114, '���ü�', 20, '�˹�', 1500);

COMMIT;

-- emp : �̱�����, cp_emp3 : �ѱ������ �������� ��
/*
DELETE FROM cp_emp3
WHERE ename IN (SELECT ename FROM emp);
*/
-- �̱������ �ѱ����� ������ 2000������ ����޿���
-- �÷��ְ� �;� 2000������ ����� �����ȣ, �����, ����, ������ ��ȸ

-- UNION : �ߺ������Ͱ� ��ȸ���� ����
SELECT empno, ename, sal, job
FROM   emp
WHERE  sal <= 2000
UNION
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;

-- cp_emp3�� emp���̺��� 30�� �μ� ��������� ��� �߰�
INSERT INTO cp_emp3(empno, ename, deptno, sal, job)
(SELECT empno, ename, deptno, sal, job
 FROM   emp
 WHERE  deptno=30);

SELECT * FROM cp_emp3;

COMMIT;

-- UNION ALL : �ߺ������Ͱ� ��ȸ��
SELECT empno, ename, sal, job
FROM   emp
WHERE  sal <= 2000
UNION ALL
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;

-- �÷��� ������ ��ġ���� �ʰų� ���������� ��ġ���� ������ �����߻�
SELECT empno, ename, sal
FROM   emp
WHERE  sal <= 2000
UNION
SELECT empno, ename
FROM   cp_emp3
WHERE  sal <= 2000;

SELECT empno, ename, sal
FROM   emp
WHERE  sal <= 2000
UNION ALL
SELECT empno, ename, job
FROM   cp_emp3
WHERE  sal <=2000;


-- INTERSECT
-- �̱������� ��������� �ѱ������� ������� �� ��ġ�ϴ� ������ ��ȸ
SELECT empno, ename, sal, job
FROM   emp
WHERE  sal <= 2000
INTERSECT
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;

-- MINUS : ���� SELECT���� ��ȸ�� ������� ���� SELECT���� ��ȸ��
-- 	       ����� �� �������� ��ȸ��
SELECT empno, ename, sal, job
FROM   emp
MINUS
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;
