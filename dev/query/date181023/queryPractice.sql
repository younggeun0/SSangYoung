
-- SELECT ename, hiredate, sal
-- FROM emp
-- WHERE hiredate > '81/01/01'
-- OR sal >= 1300;

-- SELECT empno, ename, sal, comm
-- FROM emp
-- WHERE sal > 1000
-- AND (comm < 1000 OR comm IS NULL);

-- SELECT empno, ename, sal, comm
-- FROM emp
-- WHERE sal > 1000
-- AND comm < 1000 OR comm IS NULL;

-- SELECT empno, ename, sal
-- FROM emp
-- WHERE empno = &empno;

-- SELECT empno, ename
-- FROM &table
-- WHERE sal = 3000;

-- SELECT ename, sal, hiredate
-- FROM emp
-- ORDER BY ename;

-- SELECT deptno, sal, ename
-- FROM emp
-- ORDER BY deptno ASC, sal DESC;

-- SELECT ename, sal, hiredate
-- FROM emp
-- WHERE sal > 1000
-- ORDER BY 2, 1;

-- SELECT tname FROM tab;

