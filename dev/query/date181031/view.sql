
CREATE VIEW test_view
AS (SELECT *
	FROM emp);

-- VIEW�� �����Ϸ��� �����ڱ����� ���� ������ VIEW ���������� �ο��ؾ� ��
-- GRANT CREATE VIEW TO ������

DROP VIEW test_view;

-- �ܼ� VIEW ���� (���̺� �ϳ��� ������ VIEW)
SELECT * FROM cp_emp3;

CREATE VIEW emp_view
AS (SELECT *
	FROM cp_emp3);

SELECT * FROM user_views;

SELECT * FROM emp_view;
SELECT * FROM cp_emp3;

-- �ܼ� VIEW DML
INSERT INTO emp_view(empno, ename, deptno, job, sal)
VALUES(1234, '������', 20, '����', 4000);

SELECT * FROM emp_view;

UPDATE emp_view
SET    job='����', sal=4100
WHERE  empno=1234;

DELETE FROM emp_view
WHERE empno=1234;

COMMIT;

-- VIEW ����
DROP VIEW emp_view;

SELECT * FROM user_views;

-- �ܼ� VIEW(�ϳ��� ���̺� ��� �÷����� view ����)
-- cp_emp3���̺��� �����ȣ, �����, ����, �������� VIEW ����
CREATE VIEW emp_view
AS (SELECT empno, ename, job, sal
	FROM cp_emp3);
DELETE FROM emp
WHERE empno=1234;
SELECT * FROM emp_view;

DROP VIEW emp_view;
-- �� ��� ��)������ ����� �� ����� ���� ������ �����ڰ� ���� ������ �ٸ� ��
-- ���(����, ����ȣ, ��ȭ��ȣ) �� �� �� �ִٸ� �� �÷��� ���� �並 �����ϸ� ��
-- ������(����, ����ȣ, ��ȭ��ȣ, �ֹι�ȣ, ī���ȣ ..) �̷��� �並 ����� ������ ���
-- ��ó�� ���� �������� ���޿� ���� �����ϴ� ������ �ٸ��� �� �� �ִ�

SELECT * FROM user_views;

-- VIEW�� ���Ե��� ���� �÷��� INSERT�� �����ϸ� NULL�� �Էµȴ�
INSERT INTO emp_view(empno, ename, job, sal)
VALUES (1234, '������', '����', 4100);

SELECT * FROM cp_emp3;
SELECT * FROM emp_view;

-- ���� VIEW : ���̺� �������� ����Ͽ� ������ VIEW �Ǵ�
-- ��ȸ�� �� �Լ��� ����Ͽ� ��ȸ�� ����� ������ VIEW
-- ���� VIEW�� INSERT, UPDATE, DELETE�� ������� �ʴ´�.
-- �������� ���̺��� ������ �ܼ� SELECT�� ����Ͽ� ��ȸ�� �� ���

CREATE VIEW car_view
AS (SELECT cma.maker, cma.model, cmo.car_year, cmo.price,
	       cmo.cc, cmo.car_option
	FROM car_maker cma, car_model cmo
	WHERE cmo.model = cma.model);

SELECT * FROM user_views;
SELECT * FROM car_View;

-- VIEW�� ����ϸ� JOIN�� ����� �ܼ������� ���� �� �ִ�
SELECT  maker, model, car_year, price, cc, car_option
FROM	car_view
WHERE	maker='����';

-- ���� VIEW�� INSERT, UPDATE, DELETE�� �� �� ����
INSERT INTO car_view(maker, model, car_year, price, cc, car_option)
VALUES('����', '���ν���', 2017, 3000, 1999, '��¦3��,ABS');

-- �ܼ� VIEW�� INSERT, UPDATE, DELETE�� ���� ���ؼ�
-- VIEW ���� �� WITH READ ONLY��� �ɼ��� �ָ� �ȴ�
CREATE VIEW read_emp
AS (SELECT *
	FROM cp_emp2)
WITH READ ONLY;

SELECT view_name,read_only FROM user_views
WHERE view_name='READ_EMP';

SELECT * FROM read_emp;

-- WITH READ ONLY �ɼ��� ����� VIEW�� DML(�߰�, ����, ����)�� �� �� ����.
INSERT INTO read_emp(empno, ename, hiredate, sal)
VALUES(1234, '������', SYSDATE, 5000);
                                       