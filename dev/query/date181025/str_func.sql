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
	   INSTR('�ѱ۵���ã�ƿ�','ã')
FROM DUAL;

SELECT * FROM class4_info;

INSERT INTO class4_info(num, name, email)
VALUES(6, '�׽�Ʈ','test@kr');

INSERT INTO class4_info(num, name, email)
VALUES(7, '�׽�Ʈ1','test.kr');

COMMIT;

-- class4_info���̺��� ��ȣ, �̸�, �̸���, �̸����� ��ȿ���� ��ȸ
-- �̸����� ��ȿ���� INSTR�� @�� .�� ���η� Ȯ�ΰ���
SELECT num, name, email, INSTR(email, '@'), INSTR(email, '.')
FROM class4_info;

-- ���ڿ� �ڸ��� : SUBSTR(���ڿ�, �����ε���, �ڸ����ڼ�)
-- �ڸ� ���ڼ��� ���ٸ� �����ε������� ���ε������� �ڸ�
-- 'Abcdefg'���ڿ����� 'def'�� �ڸ��� �ʹٸ�
SELECT SUBSTR('Abcdefg', 4,3), SUBSTR('Abcdefg', 2,5),
	   SUBSTR('Abcdefg', 1)
FROM DUAL;

-- class4_info ���̺��� ��ȣ, �̸�, email �÷��� '���� �ּ�'�� ��ȸ
-- �����ּ�@�������ּ�
SELECT num, name, email, SUBSTR(email, 1, INSTR(email, '@')-1)
FROM class4_info
WHERE INSTR(email, '@')!=0 AND INSTR(email, '.')!=0;

-- �������ּҸ� ��ȸ
SELECT email, SUBSTR(email, INSTR(email, '@')+1)
FROM class4_info
WHERE INSTR(email, '@')!=0 AND INSTR(email, '.')!=0;

-- �յڰ������� : TRIM(���ڿ�)
SELECT '['||TRIM('   ABC   ')||']'
FROM DUAL;

-- �հ������� : LTRIM(���ڿ�)
SELECT '['||LTRIM('   ABC   ')||']'
FROM DUAL;

-- �ް������� : RTRIM(���ڿ�)
SELECT '['||RTRIM('   ABC   ')||']'
FROM DUAL;

SELECT TRIM('a' FROM 'aaaaaaOracleaaaaaa')
FROM DUAL;

SELECT TRIM('-' FROM '-----Oracle------')
FROM DUAL;

-- ù���ڸ� �빮�ڷ� : INITCAP(���ڿ�)

SELECT INITCAP('oracle') FROM DUAL;
SELECT INITCAP('java jsp jQuery') FROM DUAL;
SELECT INITCAP('SCOTT') FROM DUAL;

SELECT INITCAP(ename)
FROM emp;

-- ���ڿ� ���̱� : CONCAT(���ڿ�, ���Ϲ��ڿ�)
SELECT CONCAT('ABC', 'DEF') FROM DUAL;
SELECT 'ABC'||'DEF' FROM DUAL;

SELECT CONCAT(CONCAT('ABC', 'DEF'), 'GHI')
FROM DUAL;

-- ���� ���ڿ��� ������ ���� ||���ӿ����� ����� �ξ� ����
SELECT 'ABC'||'DEF'||'GHI'
FROM DUAL;


-- ���ڿ� ä���
-- �������� ä��� : LPAD(���ڿ�, ���ڸ���, ä�﹮�ڿ�)
SELECT LPAD('ABCDE', 7,'$'), LPAD('ABCDEFG', 10, 0)
FROM DUAL;

-- ����Ŭ�� �ڵ�����ȯ�� �� �Ǿ�����
SELECT LPAD('ABCDE', 10, 0)
FROM DUAL;

-- ���������� ä��� : RPAD(���ڿ�, ���ڸ���, ä�﹮�ڿ�)
SELECT RPAD('ABCDEF', 10,'��'), RPAD('ABC', 10, '#')
FROM DUAL;
