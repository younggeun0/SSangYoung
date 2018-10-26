-- INSERT Subquery
-- �ܼ���
-- cp_emp3�� �Ʒ��� ���� ���ڵ带 �߰��ϼ���
-- �����ȣ : 1111, ����� : ����ö, �μ���ȣ : 10
-- ���� : ���, ���� : emp���̺��� �����ȣ�� 7566�� �����
-- ������ ���� ����

INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1111, '����ö', 10, '���',(SELECT sal
	    						FROM emp
	   							WHERE empno=7566));

SELECT * FROM cp_emp3;


-- �ܼ��� Subquery�� �����ϴ� ������ ������ Subquery�� ���Ǹ� ������ �߻�
 INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1111, '����ö', 10, '���',(SELECT sal FROM emp));

-- �÷��ϳ��� ���� �־�� �ϴ� ���� �÷� ������ ��ȸ�Ǹ�
-- �߰��ϴ� ���� ������ ���� �����Ƿ� �����߻�
 INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1111, '����ö', 10, '���',(SELECT sal, deptno FROM emp));


-- ������(������) ��������
-- emp���̺��� �μ���ȣ�� 30���� �μ���
-- �����ȣ, �����, �μ���ȣ, ����, ������ ��ȸ�Ͽ�
-- cp_emp3���̺� �Ѳ����� �߰�

INSERT INTO cp_emp3
(SELECT empno, ename, deptno, job, sal
 FROM emp
 WHERE deptno=30);

SELECT * FROM cp_emp3;


CREATE TABLE test(
	job VARCHAR2(9),
	sal number(7,2),
	hiredate VARCHAR2(7),
	input_date DATE
);

-- ���̺� ����
-- ALTER TABLE test ADD input_date DATE;
-- ALTER TABLE test MODIFY hiredate VARCHAR2(8);

-- ������̺��� 1981-02�� �Ի��� ����� ����, ����,
-- �Ի��-��, �Է����� test���̺� �Է�
INSERT INTO test(job, sal, hiredate, input_date)
(SELECT job, sal, TO_CHAR(hiredate, 'yyyy-mm'), SYSDATE
 FROM emp
 WHERE TO_CHAR(hiredate, 'yyyy-mm')='1981-02');

SELECT * FROM test;
             
/* �ùٸ��� ���� ����..
	INSERT INTO test
	(SELECT job, sum(sal), TO_CHAR(hiredate, 'yyyy-mm') hiredate, SYSDATE
	 FROM emp
	 WHERE TO_CHAR(hiredate, 'yyyy-mm')='1981-02'
	 GROUP BY job, hiredate);
 */
 
