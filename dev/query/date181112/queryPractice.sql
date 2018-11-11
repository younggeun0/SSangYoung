/*  181029 ��������
1. �Ʒ��� ���ǿ� �´� ���̺��� �����ϰ� ������ ��������� �ο��� ��
    ��� �������ǿ� �����ϴ� ���� ������ ��쿡 ���� �����ϴ� ���
    �������� �ۼ��ϼ���.

    �μ���ȣ, �����, ����, �̸���, ��ȭ��ȣ, ����, �ּ�, �Ի���, �����ȣ��
    �����ϴ� ���̺��� ����

    �������
    - �μ���ȣ�� ���� ���ڸ��̸� dept���̺��� deptno�� �Է��� �� �ִ�
    - ������� �����������̰� �ѱ۷� 10���ڱ��� �Է� �����ϸ� �ݵ�� �Է��ؾ��Ѵ�.
    - ������ �����̰� ������� �Է��� ����, �Է°��� ������ 2400~8000���� �Է°���
    - �̸��ϰ� ��ȭ��ȣ�� ���� ���� ������ �ִٸ� ������
    - ������ ���� �Ǵ� ���ڸ� �Է°���
    - �ּҴ� ���� ���� �ִ�
    - �Ի����� ��¥�����̸� �߰��� �� �Ի����� null�̶�� ���糯¥�� �Էµ�
    - �����ȣ�� ���� 4�ڸ��̸� null�� ������� �ʰ� �����͸� �ߺ������͸� ������ �� ����
*/

CREATE TABLE some_tab (
  deptno NUMBER(2) CONSTRAINT fk_st REFERENCES dept(deptno),
  ename VARCHAR2(30) NOT NULL,
  sal NUMBER(9) CONSTRAINT c_sal CHECK(sal BETWEEN 2400 AND 8000),
  email VARCHAR2(30) CONSTRAINT uk_email2 UNIQUE,
  tel VARCHAR2(12) CONSTRAINT uk_tel2 UNIQUE,
  gender CHAR(6) CONSTRAINT c_gender CHECK(gender IN ('����', '����')),
  addr VARCHAR2(100),
  hiredate DATE DEFAULT SYSDATE,
  empno NUMBER(4) CONSTRAINT pk_st PRIMARY KEY
);

SELECT * FROM some_tab;

DROP TABLE some_tab;

CREATE TABLE some_tab(
	deptno NUMBER(2),
	ename VARCHAR2(30) NOT NULL,
	sal NUMBER(9),
	email VARCHAR2(30),
	tel VARCHAR2(12),
	gender CHAR(6),
	addr VARCHAR2(100),
	hiredate DATE DEFAULT SYSDATE,
	empno NUMBER(4),
	CONSTRAINT fk_st FOREIGN KEY(deptno) REFERENCES dept(deptno),
	CONSTRAINT c_sal2 CHECK(sal BETWEEN 2400 AND 8000),
	CONSTRAINT uk_e2 UNIQUE(email),
	CONSTRAINT uk_t2 UNIQUE(tel),
	CONSTRAINT c_gender2 CHECK(gender IN ('����', '����')),
	CONSTRAINT pk_st PRIMARY KEY(empno)
);

SELECT * FROM some_tab;

DROP TABLE some_tab;


/*
  1. ��ⷮ�� 1500~3000������ ������ ������, ������,
       �𵨸�, ����, ����, �̹���, �Է���, ��ⷮ, �ɼ��� ��ȸ
       ��, ����� ��ⷮ�� �������� �������� �� 3~6��° ���ڵ常 ��ȸ�ϰ�,
       �ɼ��� ó�� ',' ������ ����� ��.
       ���ݰ� ������ 3�ڸ����� ','�� �־� ����ϰ�
       �Է����� ��-��-���� �������� ����� ��
*/
SELECT * FROM car_model;

SELECT r, country, maker, model, car_year, TO_CHAR(price,'9,999'), car_img,
		   TO_CHAR(hiredate,'mm-dd-yyyy') hiredate,
	     TO_CHAR(cc,'9,999') cc,
		   SUBSTR(car_option,1,INSTR(car_option, ',')-1) car_option
FROM (SELECT ROWNUM r, country, maker, model, car_year, price, car_img, hiredate, cc, car_option
			FROM(SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price,
							     cmo.car_img, cmo.hiredate, cmo.cc, cmo.car_option
						FROM car_country cc, car_maker cma, car_model cmo
						WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
						 AND cmo.cc BETWEEN 1500 AND 3000))
WHERE r BETWEEN 3 AND 6;

/*
  6. ������� 'S'�� �����ų� �̸��� 5���̸鼭 ����° ���ڰ� 'A'��
     ����� �����ȣ, �����, �Ի���, ����, ����, �Ǽ��ɾ�, �����λ��
     �μ���ȣ, �μ���, ��ġ, �����ȣ, �õ�, ����, ��, ������ ��ȸ
     ��, �Ǽ��ɾ��� ����+������(�Ѵ�ġ)+���ʽ�-����(���� 3.3%)�� ���
      �����λ���� �μ���ȣ�� ���� ���� �λ�
      10 - ���� 7% �λ�
      20 - ���� 4% �λ�
      30 - ����+���ʽ� 10% �λ�
      �׿ܴ� ���� 3% �λ����� ����Ͽ� 3�ڸ����� ','�� �־� ���
      ��� ����� �ҹ��ڷ� ����� ��.
*/

SELECT e.empno, LOWER(e.ename), e.hiredate, e.sal, e.sal*0.033 tax,
	     TRUNC(e.sal+(e.sal/12)+NVL(e.comm, 0)) total,
	     DECODE(d.deptno, 10, e.sal*1.07, 20, e.sal*1.04, 30, (e.sal+NVL(e.comm, 0))*1.1,
	     		    e.sal*1.03) i_sal, d.deptno, LOWER(d.dname), LOWER(d.loc)
FROM emp e, dept d, zipcode z
WHERE (e.deptno = d.deptno AND z.seq = e.empno)
 AND (e.ename LIKE '%S' OR e.ename LIKE '__A__');















