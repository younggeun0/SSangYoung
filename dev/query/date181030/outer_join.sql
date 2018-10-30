
SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e
LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- OUTER JOIN : ��� ���� ���̺��� ���ڵ尡 �����ϴ��� ��ȸ
-- ��� �μ��� �μ���ȣ, �μ���, �����ȣ, �����, �Ի��� ��ȸ
-- ANSI
SELECT d.deptno, e.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d
FULL JOIN emp e
 ON e.deptno = d.deptno;

-- ORACLE) �������ǿ� ���ڵ尡 ���� �ʿ� (+)�� ����
SELECT d.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM   dept d, emp e
WHERE  (e.deptno(+) = d.deptno);

-- �����簡 '����', '���'�� ��� ������ ������, ������,
-- �𵨸�, ����, ����, �ɼ��� ��ȸ

SELECT cc.country, cc.maker, cma.model,
       cmo.car_year, cmo.price, cmo.car_option
FROM   car_country cc, car_maker cma, car_model cmo
WHERE  (cma.maker = cc.maker
   AND cmo.model(+) = cma.model)
   AND cc.maker IN ('����', '���');


-- �𵨸��� 'K5','K7','�ҳ�Ÿ','�ƹ���','Cclass','A6'�� ��� ������
-- ������, ������, �𵨸�, ����, ������ ��ȸ
-- ��, ������ ������������ �����Ͽ� ��ȸ�� ��, ������ ���ٸ� ������ ������������ ������ ��

--ANSI
SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price
FROM   car_country cc
INNER JOIN car_maker cma
 ON cma.maker = cc.maker
LEFT OUTER JOIN car_model cmo
 ON cmo.model = cma.model
WHERE cma.model IN ('K5','K7','�ҳ�Ÿ','�ƹ���','Cclass','A6')
ORDER BY cmo.price DESC, cmo.car_year DESC;


-- ORACLE
SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price
FROM car_country cc, car_maker cma, car_model cmo
WHERE cma.maker = cc.maker
	AND cmo.model(+) = cma.model
	AND cma.model IN ('K5','K7','�ҳ�Ÿ','�ƹ���','Cclass','A6')
ORDER BY cmo.price DESC, cmo.car_year DESC;
