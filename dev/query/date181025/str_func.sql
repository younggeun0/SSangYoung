-- ���ڿ� �Լ�
-- ���� : LENGTH(���ڿ�)

SELECT 'oracle���̴� '||LENGTH('oracle')||'��' temp_col
FROM DUAL;

SELECT LENGTH('�׽�Ʈ') temp_col
FROM DUAL;

-- ������̺��� �����, ������� ���ڼ��� ��ȸ
SELECT ename, LENGTH(ename) lengthofname
FROM emp;

-- ������̺��� ������� 4���� ����� ������� ��ȸ
SELECT ename
FROM emp
WHERE ename LIKE '____';

-- LENGTH �Լ��� ����ϸ� ���迬���� ���, �� �����ϰ� ��ȸ ����
SELECT ename
FROM emp
WHERE LENGTH(ename)=4;

-- 4�� �̻��� ���
SELECT ename
FROM emp
WHERE LENGTH(ename)>4;

-- �빮�� : UPPER(���ڿ�)
-- ��� �����
SELECT UPPER('hello world!') temp_col, UPPER('�ѱ�english') temp_col2
FROM DUAL;

-- �ҹ��� : LOWER(���ڿ�)
SELECT LOWER('HELLO WORLD') temp_col
FROM DUAL;

-- ������̺��� ������� 'scott'�� ����� �����ȣ, �����,
-- �Ի���, ������ ��ȸ

SELECT empno, ename, hiredate, sal
FROM emp
WHERE LOWER(ename)='scott';

SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename=upper('scott');

-- ������̺��� ������� ��� �ҹ��ڷ� ��ȸ
SELECT LOWER(ename)
FROM emp;

-- INITCAP()�� ���� ���ڿ��� ù ���ڸ� �빮�ڷ� ������ ���ڸ� �ҹ��ڷ� ��ȯ�� ��ȯ
-- ������̺��� ������� ù ���ڸ� �빮�ڷ� �ٲ� ��ȸ
SELECT INITCAP(ename)
FROM emp;

-- �ε��� ��� : INSTR(���ڿ�, ã�����ڿ�)
-- �ش� ���ڿ��� �� ã���� 0�� ��ȯ
SELECT INSTR('AbcdeF', 'A'), INSTR('AbcdeF', 'F'),
	   INSTR('AbcdeF', 'c'), INSTR('AbcdeF', 'a')
FROM DUAL;

SELECT INSTR('�ѱ۵���ã�ƿ�','��'),         
	   INSTR('�ѱ۵���ã�ƿ�','')
FROM DUAL;


