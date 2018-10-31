-- 30�� ���� ����
/*
  1. ��ⷮ�� 1500~3000������ ������ ������, ������,
       �𵨸�, ����, ����, �̹���, �Է���, ��ⷮ, �ɼ��� ��ȸ
       ��, ����� ��ⷮ�� �������� �������� �� 3~6��° ���ڵ常 ��ȸ�ϰ�,
       �ɼ��� ó�� ',' ������ ����� ��.
       ���ݰ� ������ 3�ڸ����� ','�� �־� ����ϰ�
       �Է����� ��-��-���� �������� ����� ��
*/

SELECT r, country, maker ,model, car_year,
	   TO_CHAR(price, '999,999') price, car_img,
	   TO_CHAR(hiredate,'mm-dd-yyyy') hiredate, TO_CHAR(cc,'999,999') cc,
	   SUBSTR(car_option, 1, INSTR(car_option, ',')-1) car_option
FROM  (SELECT ROWNUM r, country, maker, model, car_year, price, car_img,
      	      hiredate, cc, car_option
	   FROM(SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price,
			 	    cmo.car_img, cmo.hiredate, cmo.cc, cmo.car_option
		    FROM car_country cc, car_maker cma, car_model cmo
		 	WHERE cma.maker = cc.maker AND cmo.model = cma.model
		    ORDER BY cmo.cc DESC))
WHERE r BETWEEN 3 AND 6;

/*
  2. �μ���ȣ�� 10�� 30�� 40���� ��� �μ��� �����ȣ, �����, �Ի���, ����,
     ��������, �μ���, �μ���ȣ, ��ġ, �����ȣ, �õ�, ����, ��, ������ ��ȸ�� ��.
     (������) zipcode���̺��� �����ȣ�� seq�� ���ٴ� �������� ������ ��
       ��, ����� �����ȣ�� ������������ �������� ��, 2~5��° ���ڵ常 ����� ��
     ���������� 2~5��° ���ڵ��� ����
     �����ȣ�� '-'�ں��� ������ ���, ������ ���ٸ� '��������'���� ��ü�Ͽ� ���,
     �Ի����� ��-��-�� ���ϱ��� ���
*/
SELECT r, empno, ename, TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate,
	   sal, RANK() OVER(ORDER BY sal) rank,
	   dname, deptno,
	   loc, SUBSTR(zipcode,INSTR(zipcode,'-')+1) zipcode,
	   sido, gugun, dong, NVL(bunji, '��������')
FROM(SELECT ROWNUM r, empno, ename, hiredate, sal, dname, deptno,
		    loc, zipcode, sido, gugun, dong, bunji
	 FROM (SELECT e.empno, e.ename, e.hiredate, e.sal, d.dname, d.deptno,
				 d.loc, z.zipcode, z.sido, z.gugun, z.dong, z.bunji
		   FROM   emp e, dept d, zipcode z
	       WHERE (e.deptno(+) = d.deptno AND z.seq(+) = e.empno)
	       	 AND e.deptno IN (10,30, 40)
	       ORDER BY empno ASC))
WHERE r BETWEEN 2 AND 5;

/*
  3. ������ �����簡 '����','���',�Ｚ','BMW','AUDI'�̰� �ɼǿ� 'ABS','TCS'�� �ִ� ������
     ������, ������, �𵨸�, ����, ����, �ɼ�, �̹���, ��ⷮ ��ȸ
     ��, ���� �������� ����, ������ ������ ������ ������������ �����Ͽ� ����� ��
     �̹����� �̹������ Ȯ���ڸ� �����Ͽ� ���.('.'��, ��)
     ��������� ������ Bmw, Audi�� �������� ���
*/

SELECT cc.country, cc.maker, cma.model, cmo.car_year,
	   cmo.price, cmo.car_option,
	   SUBSTR(cmo.car_img,1,INSTR(cmo.car_img,'.')-1) img_name,
	   SUBSTR(cmo.car_img,INSTR(cmo.car_img,'.')+1) file_extension, cmo.cc
FROM  car_country cc, car_maker cma, car_model cmo
WHERE (cma.maker(+) = cc.maker AND cmo.model(+) = cma.model)
	AND cc.maker IN ('����','���','�Ｚ','BMW','AUDI')
	AND cmo.car_option LIKE '%ABS%'
	AND cmo.car_option LIKe '%TCS%'
ORDER BY cmo.car_year DESC, cmo.price DESC;

/*
  4. �𵨸��� 'K5','�ƹ���','�ҷ���','A8','SM3'�� ������ �𵨸�, ������, ������,
     ����, ���� �Ʒ��� ���� ������ �������� ���
     ��, ����� ������ ������������ �������� �� 2~7��° ������ ���ڵ常 ���
     [�𵨸�] ������ ������ [xxxx]�̰�, �������� [����|����]�̸�, [xx]�� �������Դϴ�.
     ������ [0,000,000]���Դϴ�.
*/
SELECT r, model||' ������ ������ '||car_year||'�̰�, �������� '||country||'�̸�, '||
	   maker||'�� �������Դϴ�. ������ '||TO_CHAR(price,'0,000,000')||'���Դϴ�.' output
FROM  (SELECT ROWNUM r, model, country, maker, price, car_year
	   FROM(SELECT cmo.model, cc.country, cc.maker, cmo.price, cmo.car_year
		    FROM car_country cc, car_maker cma, car_model cmo
            WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
			   AND cma.model IN ('K5','�ƹ���','�ҷ���','A8','SM3')
		    ORDER BY price ASC))
WHERE r BETWEEN 2 AND 7;

/*
  5. �����簡 '����'�� ������ ����, �𵨸�, ���ĺ� �� ������ ��ȸ
*/

SELECT   cmo.car_year, cmo.model, SUM(price)
FROM     car_maker cma, car_model cmo
WHERE    (cmo.model = cma.model)
  AND    cma.maker = '����'
GROUP BY ROLLUP(cmo.model, cmo.car_year);

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

SELECT e.empno, e.ename, e.hiredate, e.sal,
	   sal*0.033 tax, TRUNC(sal+(sal/12)+NVL(comm,0)-(sal*0.033),0) total,
	   TO_CHAR(DECODE(d.deptno, 10, sal*0.07,
	                            20, sal*0.04,
	   				  	        30, (sal+NVL(comm,0))*0.1,
	   				  	        sal*0.03), '999,999') s_inc,
	   d.deptno, d.dname, d.loc, z.zipcode, z.sido, z.gugun, z.dong, z.bunji
FROM   (SELECT *
		FROM emp
		WHERE ename LIKE '%S' OR ename LIKE '__A__') e,
		dept d, zipcode z
WHERE  (e.deptno = d.deptno AND z.seq = e.empno);

--------------------------------------------------------------------------------

/* ���� Ǯ�� ����
����.
1. ��ⷮ�� 1500~3000 ������ ������ ������,������,�𵨸�,���,����,
    �̹���,�Է���,��ⷮ, �ɼ��� ��ȸ
   ��. ����� ��ⷮ�� �������� ���������� 3~6��° ���ڵ常 ��ȸ�ϰ�,
     �ɼ��� ó�� ',' ������ ��� �Ұ�. ���ݰ� ������ 3�ڸ����� ,�� �־����,
     �Է����� ��-��-�� �� �������� ��� �Ұ�.
*/
SELECT r, country, maker, model, TO_CHAR(car_year,'999,999') car_year,
	   TO_CHAR(price, '999,999') price, car_img,
	   TO_CHAR(hiredate,'mm-dd-yyyy') hiredate, cc,
	   SUBSTR(car_option, 1, INSTR(car_option, ',')-1) car_option
FROM (SELECT ROWNUM r, country, maker, model, car_year, price, car_img,
	         hiredate, cc, car_option
	  FROM(SELECT cc.country, cc.maker, cma.model, cmo.car_year,
		    cmo.price, cmo.car_img, cmo.hiredate, cmo.cc, cmo.car_option
	       FROM car_country cc, car_maker cma, car_model cmo
	       WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
	       	AND cmo.cc BETWEEN 1500 AND 3000
	       ORDER BY cmo.cc DESC))
WHERE r BETWEEN 3 AND 6;
/*
3. ������ �����簡 '����','���','�Ｚ','BMW','AUDI'�̰� �ɼǿ� 'ABS'�Ǵ� 'TCS'��
 �ִ� ������  ������, ������,�𵨸�, ����,����, �ɼ�, �̹���, ��ⷮ ��ȸ
  --��, ������ �������� �����ϰ�, ������ ���ٸ� ������ ������������ ����
   �Ͽ� ���, �̹����� �̹������ Ȯ���ڸ� �����Ͽ� ����Ұ�,
   ��������� ������ Bmw, Audi �� �������� ��� .
*/

SELECT cc.country, INITCAP(cc.maker) maker, cmo.car_year,
	   cmo.price, cmo.car_option,
	   SUBSTR(cmo.car_img,1,INSTR(cmo.car_img, '.')-1) i_name,
	   SUBSTR(cmo.car_img,INSTR(cmo.car_img, '.')+1) f_ext,
	   cmo.cc
FROM	car_country cc, car_maker cma, car_model cmo
WHERE	(cma.maker = cc.maker AND cmo.model = cma.model)
  AND   cc.maker IN ('����','���','�Ｚ','BMW','AUDI')
  AND   (cmo.car_option LIKE '%ABS%'
   OR   cmo.car_option LIKE '%TCS%')
ORDER BY cmo.car_year DESC, cmo.price DESC;

/*
4. �𵨸��� 'K5','�ƹ���', '�ҷ���','A8','SM3' �� ������ �𵨸�, ������,
  ������,����,������ �Ʒ��� ���� ������ �������� ���.
  ��, ��� ������ ���������� �������� �� 2~7 ������ ���ڵ常 ���,
   [�𵨸�] ������ ������ [ xxxx ]�̰�, �������� [����|����]�̸�,
   [XX]�簡 �������Դϴ�. ������ [0,000,000]�� �Դϴ�.
*/

SELECT r, model||' ������ ������ '||car_year||'�̰�, �������� '||country||
	   '�̸�, '||maker||'�� �������Դϴ�. ������ '||TO_CHAR(price, '0,000,000')||
	   '�� �Դϴ�.' output
FROM(SELECT ROWNUM r, model, country, maker, price, car_year
	 FROM(SELECT cma.model, cc.country, cc.maker, cmo.price, cmo.car_year
	 	  FROM   car_country cc, car_maker cma, car_model cmo
		  WHERE  (cma.maker = cc.maker AND cmo.model = cma.model)
			 AND cma.model IN ('K5', '�ƹ���', '�ҷ���', 'A8', 'SM3')
		  ORDER BY cmo.price ASC))
WHERE  r BETWEEN 2 AND 7;
/*
6. ������� 'S'�� �����ų� �̸�5���̸鼭 ����° ���ڰ� 'A'��
   �����  �����ȣ, �����, �Ի���,����,����, �Ǽ��ɾ�, �����λ��,
   �μ���ȣ,�μ���,��ġ,�����ȣ,�õ�, ����,��,���� �� ��ȸ
   ��,�Ǽ��ɾ��� ����+������+���ʽ�-����(���� 3.3) �� ���
     �����λ���� �μ���ȣ�� ���� ���� �λ�
     10- ��� 7%, 20- ��� 4%, 30- ���+���ʽ� 10%, �׿� 3%��
     ����Ͽ� 3�ڸ����� ,�� �־� ���.
     ��� ����� �ҹ��ڷ� ���.
*/

SELECT e.empno, LOWER(e.ename), e.hiredate, e.sal,
	   e.sal*0.033 tax,
	   TRUNC(e.sal+(e.sal/12)+NVL(e.comm,0)-(e.sal*0.33), 0) total,
	   TO_CHAR(DECODE(e.deptno, 10, e.sal*0.07,
	                  20, e.sal*0.04,
	                  30, (e.sal+NVL(e.comm,0))*0.1,
	                  e.sal*0.03), '999,999') s_inc,
       d.deptno, LOWER(d.dname), LOWER(d.loc),
       z.zipcode, z.sido, z.gugun, z.dong, z.bunji
FROM   emp e, dept d, zipcode z
WHERE  (e.deptno = d.deptno AND z.seq = e.empno)
   AND (ename LIKE '%S' OR ename LIKE '__A__');

-- �������� �Ⱦ��� Ǯ �� ����(���������� �Ϻκ��� �����͸� ������ �� ���!)