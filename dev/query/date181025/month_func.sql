
SELECT ADDMONTH(hiredate, 3)
FROM emp;

-- ��¥�Լ�
-- ��¥�� +�� ����ϸ� ���� ����
SELECT SYSDATE+5
FROM DUAL;

SELECT ADD_MONTHS(SYSDATE,6)
FROM DUAL;
          
-- ����(2018-10-25)���� 2019-05-25������ ������ ���̸� ���Ѵ�
SELECT MONTHS_BETWEEN('2019-05-25', SYSDATE)
FROM DUAL;
