/*
1. ��� ���̺��� '10' �μ��� �ƴϸ鼭 ������ 1000�̻� 3000������
��� �������  �����ȣ,�����, �Ի���,�μ���ȣ, ������ ��ȸ�ϼ���.
*/

SELECT	empno, ename, hiredate, deptno, sal
FROM	emp
WHERE	deptno!=10 AND sal BETWEEN 1000 AND 3000;


/*
2. ��� ���̺��� ���ʽ��� �����ϴ� �������  �����ȣ,�����,
    ����,���ʽ�, �Ѽ��ɾ�, ������ ��ȸ �ϼ���.
    - ������ ������ 12������ ���� ����� ��.
*/

SELECT	empno, ename, sal, comm, sal+comm total, ROUND(sal/12,2) MONTHLYPAY
FROM	emp
WHERE	comm IS NOT NULL AND comm != 0;


/*
3.  ��� ���̺��� �μ���ȣ�� 10,30��  ������� �����, �����ȣ
    �Ի���, ������ ��ȸ �ϼ���.
    -��, �����  xxxx�� xxxx����� xxxx�⿡ �Ի��Ͽ��� ������ xxx$�Դϴ�.
        �� �������� �ϰ�, �÷����� output ���� �����Ұ�.
*/

SELECT	empno||'�� '||ename||'����� 19'||SUBSTR(hiredate,0,2)
		||'�⿡ �Ի��Ͽ��� ������ '||sal||'�����Դϴ�.' output
FROM	emp
WHERE	deptno IN (10, 30);


/*
4. ��� ���̺��� ������ 3000 �̸��� ������� �����ȣ, �����,
   �Ի���, ����,����, �μ���ȣ�� ��ȸ �ϼ���.
   ��, ������ ������������ �����ϵ� ������ ���ٸ� ������� ������������
   �����Ұ�.
*/

SELECT		empno, ename, hiredate, sal, job, deptno
FROM		emp
WHERE		sal < 3000
ORDER BY	sal, ename DESC;

/*
5. test_like ���̺� �Ʒ��� ���� �����͸� �߰��Ұ�.
    7, ����������,����� ���۱� �󵵵�,'�����'
    8, ���븸,����� ���빮�� ���빮1��,'��Ÿ��'
    9, ���¼�,����� ���빮�� ���빮2��,'�����'
*/

INSERT INTO test_like(num, name, loc, highschool)
VALUES (7, '����������', '����� ���۱� �󵵵�', '�����');

INSERT INTO test_like(num, name, loc, highschool)
VALUES (8, '���븸', '����� ���빮�� ���빮1��', '��Ÿ��');

INSERT INTO test_like(num, name, loc, highschool)
VALUES (9, '���¼�', '����� ���빮�� ���빮2��', '�����');

SELECT * FROM test_like;

/*
6. test_like ���̺��� '�����'�� �����ϴ� �л���  ��ȣ,�л���,
    �ּ�, �б������� �Ʒ���  ���� �������� ����ϰ�
     �÷����� ��ҹ��� �����Ͽ� Output����  �Ұ�.
    ������� :  ��ȣ : x, �̸� : xx, �ּ� : xx, �б� : xx
*/

SELECT  '��ȣ : '||num||', �̸� : '||name||', �ּ� : '||loc||', �б� : '||highschool output
FROM	test_like
WHERE	loc LIKE '�����%';

/*
7. ������̺��� ������� 4�����̰ų� ������ 3000�̻��� �����
   �����ȣ, �����, ����, �Ի���, �μ���ȣ, ������ ��ȸ�Ұ�.
   ��, ��� �����ʹ� ������ ������������ �����ϰ�, ������ ���ٸ�
     ������� ���� �������� �����Ұ�.
*/

SELECT		empno, ename, sal, hiredate, deptno, job
FROM		emp
WHERE		ename LIKE '____' OR sal>=3000
ORDER BY	sal, ename;

/*
8.  test_like ���̺��� ����б����� ����ϰ� �б����� ����
    �������� �����Ͽ� ����� ��.
    ��, ����б� ���� ���ٸ� �ϳ��� ����ϼ���.(2������ �� ��.)
*/
SELECT * FROM test_like;

SELECT DISTINCT	highschool
FROM			test_like
ORDER BY		highschool;

SELECT		highschool
FROM		test_like
GROUP BY	highschool
ORDER BY	highschool;

/*
9. ��� ���̺��� �����ȣ, �����, �Ի���, ����, ���⿬����
    ��ȸ �ϼ���.
    ���� ������ ���� �������� 7% ���� �ݾ����� ����Ͽ� ����Ұ�.
*/

SELECT	empno, ename, hiredate, sal, sal*1.07 n_sal
FROM	emp;

/*
10. ��� ���̺��� ������� 5�����̸鼭 ����° ���ڿ� 'A'�� ���
    �� ����� �����, �����ȣ, �Ի���, ������ ��ȸ�ϼ���.
    ��, ������ ������������ ����Ұ�.
*/
SELECT		ename, empno, hiredate, sal
FROM		emp
WHERE		ename LIKE '__A__'
ORDER BY	sal;

/*
11. ��� ���̺��� ������� 'A'�� �����ϸ鼭 ������ 1600�̻���
     ����� �����,����,����, �Ŵ�����ȣ, �Ի����� ��ȸ �Ұ�.
*/

SELECT	ename, sal, job, mgr, hiredate
FROM	emp
WHERE	ename LIKE 'A%' AND sal>=1600;
