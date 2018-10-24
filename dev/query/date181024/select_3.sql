
-- ORDER BY�� ����� ����

SELECT * FROM emp;

-- ��� ���̺��� �����ȣ, �����, ����, �Ի����� ��ȸ
-- ��, ������ ������������ �����Ͽ� ����� ��
SELECT		empno, ename, sal, hiredate
FROM		emp
ORDER BY	sal DESC;

-- ������ ���ٸ� �Ի����� ������������ �����Ͽ� ����� ��
SELECT		empno, ename, sal, hiredate
FROM		emp
ORDER BY	sal DESC, hiredate DESC;

-- ��� ���̺��� �Ŵ�����ȣ, �����ȣ, �����, ������ ��ȸ
-- ��, �Ŵ�����ȣ�� ������������ �����ϵ�, �Ŵ�����ȣ�� ���ٸ�
-- ������� ������������ ����
SELECT		mgr, empno, ename, sal
FROM		emp
ORDER BY	mgr DESC, ename;


-- ���ڿ��� ����� ���ڿ� ���� ����
CREATE TABLE test_orderby (
	num VARCHAR2(10)
);

INSERT INTO test_orderby(num)VALUES('1000');
INSERT INTO test_orderby(num)VALUES('1');
INSERT INTO test_orderby(num)VALUES('204');
INSERT INTO test_orderby(num)VALUES('21');
INSERT INTO test_orderby(num)VALUES('191');
INSERT INTO test_orderby(num)VALUES('300');
INSERT INTO test_orderby(num)VALUES('20001');

SELECT * FROM test_orderby;

-- ��ȣ �������� ����
-- ���ڿ��� ������ �ڸ����� ����
SELECT * FROM test_orderby ORDER BY num;

COMMIT;









