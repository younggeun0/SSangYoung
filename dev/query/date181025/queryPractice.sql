SELECT empno, ename, hiredate, deptno, sal
FROM emp
WHERE deptno!=10 AND sal>=1000 AND sal<=3000;

SELECT empno, ename, sal, comm, sal+comm total, ROUND(sal/12,2) monthlypay
FROM emp
WHERE comm IS NOT NULL AND comm != 0;

SELECT empno||'�� '||ename||'����� 19'||SUBSTR(hiredate,1,2)||'�⿡ �Ի��Ͽ��� ������ '||sal||'$�Դϴ�.' output
FROM emp
WHERE deptno IN (10, 30);

SELECT empno, ename, hiredate, sal, job, deptno
FROM emp
WHERE sal < 3000
ORDER BY sal, ename DESC;

SELECT * FROM test_like;

SELECT '��ȣ : '||num||', �̸� : '||name||', �ּ� : '||loc||', �б� : '||highschool
FROM test_like
WHERE loc LIKE '�����%';

SELECT empno, ename, sal, hiredate, deptno, job
FROM emp
WHERE ename LIKE '____' OR sal >= 3000
ORDER BY sal, ename;

SELECT DISTINCT highschool
FROM test_like
ORDER BY highschool;

SELECT highschool
FROM test_like
GROUP BY highschool
ORDER BY highschool;

SELECT empno, ename, hiredate, sal, sal*1.07 nextyearsal
FROM emp;

SELECT ename, empno, hiredate, sal
FROM emp
WHERE ename LIKE '__A__'
ORDER BY sal;

SELECT ename, sal, job, mgr, hiredate
FROM emp
WHERE ename LIKE 'A%' AND sal>=1600;

-- 24�� ���� ����









