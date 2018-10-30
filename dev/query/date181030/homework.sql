/*
  1. ��ⷮ�� 1500~3000������ ������ ������, ������,
  	 �𵨸�, ����, ����, �̹���, �Է���, ��ⷮ, �ɼ��� ��ȸ
  	 ��, ����� ��ⷮ�� �������� �������� �� 3~6��° ���ڵ常 ��ȸ�ϰ�,
  	 �ɼ��� ó�� ',' ������ ����� ��.
  	 ���ݰ� ������ 3�ڸ����� ','�� �־� ����ϰ�
  	 �Է����� ��-��-���� �������� ����� ��
*/

SELECT r, country,  maker, model, car_year, TO_CHAR(price,'999,999') price,
       car_img, TO_CHAR(hiredate,'mm-dd-yyyy') hiredate,
       TO_CHAR(cc,'999,999') cc,
       SUBSTR(car_option, 1, INSTR(car_option, ',')-1) c_option
FROM (SELECT ROWNUM r, country, maker, model, car_year, price,
      		 car_img, hiredate, cc, car_option
	  FROM (SELECT cc.country, cc.maker, cma.model, cmo.car_year,
      		       cmo.price, cmo.car_img, cmo.hiredate,
      		       cmo.cc, cmo.car_option
      	    FROM   car_country cc, car_maker cma, car_model cmo
	        WHERE  (cma.maker = cc.maker
		      AND cmo.model = cma.model)
		      AND cmo.cc BETWEEN 1500 AND 3000
		    ORDER BY cmo.cc DESC))
WHERE r BETWEEN 3 AND 6;

SELECT * FROM car_model;
                        
/*
  2. �μ���ȣ�� 10�� 30�� 40���� ��� �μ��� �����ȣ, �����, �Ի���, ����,
     ��������, �μ���, �μ���ȣ, ��ġ, �����ȣ, �õ�, ����, ��, ������ ��ȸ�� ��.
     (������) zipcode���̺��� �����ȣ�� seq�� ���ٴ� �������� ������ ��
  	 ��, ����� �����ȣ�� ������������ �������� ��, 2~5��° ���ڵ常 ����� ��
     ���������� 2~5��° ���ڵ��� ����
     �����ȣ�� '-'�ں��� ������ ���, ������ ���ٸ� '��������'���� ��ü�Ͽ� ���,
     �Ի����� ��-��-�� ���ϱ��� ���
*/

SELECT r, empno, ename, TO_CHAR(hiredate,'mm-dd-yyyy day') hiredate,
	   sal, RANK() OVER(ORDER BY sal DESC) rank,
	   dname, deptno, loc,
	   SUBSTR(zipcode,INSTR(zipcode,'-')+1) zipcode, sido,
       gugun, dong, NVL(bunji, '��������')
FROM(SELECT ROWNUM r, empno, ename, hiredate, sal, dname,
	 	    deptno, loc, zipcode, sido, gugun, dong, bunji
	 FROM(SELECT   e.empno, e.ename, e.hiredate, e.sal, d.dname,
	 	           d.deptno, d.loc, z.zipcode, z.sido, z.gugun, z.dong,
	     	 	   z.bunji
	 	  FROM     emp e, dept d, zipcode z
	 	  WHERE    (e.deptno(+) = d.deptno AND z.seq(+) = e.empno)
   			 AND   e.deptno IN (10,30,40)
	 	  ORDER BY empno ASC))
WHERE r BETWEEN 2 AND 5;
          
/*
  3. ������ �����簡 '����','���',�Ｚ','BMW','AUDI'�̰� �ɼǿ� 'ABS','TCS'�� �ִ� ������
     ������, ������, �𵨸�, ����, ����, �ɼ�, �̹���, ��ⷮ ��ȸ
     ��, ���� �������� ����, ������ ������ ������ ������������ �����Ͽ� ����� ��
     �̹����� �̹������ Ȯ���ڸ� �����Ͽ� ���.('.'��, ��)
     ��������� ������ Bmw, Audi�� �������� ���
*/

SELECT INITCAP(cc.maker) maker, cc.maker, cma.model, cmo.car_year,
       cmo.price, cmo.car_option, SUBSTR(cmo.car_img, 1, INSTR(cmo.car_img,'.')-1) img_name,
       SUBSTR(cmo.car_img, INSTR(cmo.car_img, '.')+1) file_extension, cmo.cc
FROM car_country cc, car_maker cma, car_model cmo
WHERE (cma.maker(+)=cc.maker
	AND cmo.model = cma.model)
	AND cc.maker IN ('����','���','�Ｚ','BMW','AUDI')
	AND cmo.car_option LIKE '%ABS%'
	AND cmo.car_option LIKE '%TCS%'
ORDER BY cmo.car_year DESC, cmo.price DESC;

/*
  4. �𵨸��� 'K5','�ƹ���','�ҷ���','A8','SM3'�� ������ �𵨸�, ������, ������,
     ����, ���� �Ʒ��� ���� ������ �������� ���
     ��, ����� ������ ������������ �������� �� 2~7��° ������ ���ڵ常 ���
     [�𵨸�] ������ ������ [xxxx]�̰�, �������� [����|����]�̸�, [xx]�� �������Դϴ�.
     ������ [0,000,000]���Դϴ�.
*/

SELECT r, model||' ������ ������ '||car_year||'�̰�, �������� '||country||'�̸�, '||
	   maker||'�� �������Դϴ�. ������ '||TO_CHAR(price, '0,000,000')||'���Դϴ�.' output
FROM   (SELECT ROWNUM r, model, country, maker, price, car_year
		FROM(SELECT cmo.model, cc.country, cc.maker, cmo.price, cmo.car_year
			 FROM car_country cc, car_maker cma, car_model cmo
			 WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
			   AND cma.model IN ('K5','�ƹ���','�ҷ���','A8','SM3')
			 ORDER BY cmo.price DESC))
WHERE  r BETWEEN 2 AND 7;

/*
  5. �����簡 '����'�� ������ ����, �𵨸�, ���ĺ� �� ������ ��ȸ
*/

SELECT   cmo.car_year, cmo.model, SUM(price) sum_of_price
FROM     car_maker cma, car_model cmo
WHERE    (cmo.model = cma.model)
   AND   cma.maker='����'
GROUP BY cmo.car_year, cmo.model
ORDER BY cmo.car_year;

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

SELECT  e.empno, LOWER(e.ename) ename, e.hiredate, e.sal, sal*0.033 tax,
        sal+TRUNC(sal/12, 0)+NVL(comm,0)-(sal*0.033) total,
        TO_CHAR(DECODE(e.deptno,
        			10, sal*1.07 - sal,
        			20, sal*1.04 - sal,
        			30, (sal+NVL(comm,0))*1.1 - sal,
        			sal*1.03 - sal), '999,999') sal_inc, d.deptno,
        LOWER(d.dname) dname, LOWER(d.loc) loc, z.zipcode, z.sido,
        z.gugun, z.dong, z.bunji
FROM	(SELECT *
         FROM   emp
         WHERE  emp.ename LIKE '%S' OR emp.ename LIKE '__A__') e,
         dept d, zipcode z
WHERE   (e.deptno = d.deptno AND z.seq = e.empno);
