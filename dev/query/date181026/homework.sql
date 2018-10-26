/*
1. ��� ���̺��� �����ȣ,�����, ����, ���ʽ��� ��ȸ
   ��, ��� ��ȣ�� �������� ���� ���� �� 3~5������ ���ڵ常 ��� �ϰ�
      ������ 7�ڸ��� ���� ����ϰ� ,�� �־� ����Ѵ�.
      �ش� �ڸ��� ���� ������ 0�� ����Ѵ�.
*/

SELECT ROWNUM, rn, empno, ename,
	   TO_CHAR(LPAD(sal, 7, '0'), '0,000,000') sal, NVL(comm, 0)
FROM  (SELECT ROWNUM rn, empno, ename, sal, comm
	   FROM (SELECT empno, ename, sal, comm
		     FROM   emp
		     ORDER BY empno DESC))
WHERE  rn BETWEEN 3 AND 5;

/*
	���� empno ������������ �����߰�, ROWNUM���� 3~5���� ���ڵ带 �������� ���������� �ΰ�
	ROWNUM�� WHERE���� �ٷ� �� ���ϱ� �̰� alias�� �ΰ� �� ���������� �����
	alias�� BETWEEN�� �̿��� 3~5 ���̿� �ִ� ���ڵ带 ��ȸ
	���������� ������ LPAD�Լ��� �̿� 7�ڸ��� 0�� ä������� TO_CHAR �������� ','�� ����
*/

/*
2. class4_info ���̺��� ��ȣ, �̸� , ����, �¾ �ظ� ��ȸ �ϼ���.
   �¾ �ش� ����⵵-����+1 �� ���մϴ�.
*/

SELECT  num, name,
	    TO_CHAR(SYSDATE, 'yyyy')-age+1 yearofbirth
FROM	class4_info;

/*
  �¾ �ظ� ���ϱ� ���� ���糯¥(SYSDATE)�� TO_CHAR�Լ� �������� yyyy�� ���� ��ȯ��Ŵ
  �׸��� �� ��ȯ�� ���� ���̸� ���� +1�� ���� �¾ �ظ� ����
*/


/*
3. class4_info ���̺� ��ȣ, �̸� ����, �̸���, �̸����� ��ȿ�� ���θ� ��ȸ.
   ��, �̸����� ��ȿ���� '@' �� ������ '��ȿ', '@'�� �����ϸ� '��ȿ'�����
*/

SELECT  num, name, age, email,
		DECODE(INSTR(email, '@'), 0, '��ȿ', '��ȿ')
FROM	class4_info
WHERE   email IS NOT NULL;

/*
  �ϴ� WHERE���� email�� NULL�� �ƴ� ���ڵ常 ������ ������ �ɰ�
  INSTR�Լ��� '@'�� email ���� �����ϴ��� Ȯ���ϰ� �̸� DECODE�� �񱳰����� �ΰ�
  ���� ������(INSTR�Լ��� ��ȯ���� 0�̸�) '��ȿ'�� ��ȯ�ϰ� �� ��(������)�� '��ȿ'�� ��ȯ��Ų��.
*/

/*
4. car_model ���̺��� �ɼǿ� 'ABS'�� '�����'�� �ִ� ������
    �𵨸�,���,����,�ɼ�, �̹���, �����縦 ��ȸ �ϼ���.
    ��, ������ ������������ �����Ͽ� ����� ��.
*/

SELECT   model, car_year, price, car_img, car_option
FROM     car_model
WHERE    INSTR(car_option, 'ABS')!=0
	     OR INSTR(car_option, '�����')!=0
ORDER BY price ASC;

SELECT   model, car_year, price, car_img, car_option
FROM     car_model
WHERE    car_option LIKE '%ABS%'
         OR car_option LIKE '%�����%'
ORDER BY price;

/*
  'ABS'�� '�����'�� �ִ��� INSTR�Լ��� �̿��ؼ� ã�Ҵ�(0�̸� ����)
  �� �� �ϳ��� ������ �ǹǷ� OR�� ���� ����
  ������ ������������ ����ؾ� �ϹǷ� ASC �Ǵ� ����

  �Ǵ� LIKE �����ڷ� ABS�� ������� ���ϵ�ī��� ã�Ƽ� �ִ� ���ڵ常 ��ȸ
*/


/*
5. car_model ���̺��� �𵨸��� '�ƹ���', '�ҷ���', 'A8'�� ������
    �𵨸�,�𵨺� ���� ���հ� �Ѱ踦 ��ȸ �ϼ���.
*/

SELECT   model, SUM(price)
FROM     car_model
WHERE    model IN ('�ƹ���', '�ҷ���', 'A8')
GROUP BY ROLLUP(model);  

/*
  WHERE���� IN���� �ش� ���� ���� ���� ���ڵ常 ��ȸ�ϵ��� ������ �ɾ���
  �𵨺� ������ ��ȸ�ϱ� ���� model�� GROUP BY�� ������
  �׸��� �𵨺� ������ ���ϱ� ���� ROLLUP �м��Լ��� ���
*/

/*
6. car_model ���̺��� ���� ������ 1500~3000 ������ ������
   �𵨸�, ���, ����, �ɼ�, �Է���, ���ݺ� ������ ��ȸ�ϼ���.
   ��, ���ݺ� ������ �ߺ����� �ʴ� ��ȣ�� ��µǾ���մϴ�.
*/

SELECT model, car_year, price, car_option, hiredate,
       ROW_NUMBER() OVER(ORDER BY price DESC) rank
FROM   car_model
WHERE  price BETWEEN 1500 AND 3000; 

/*
  BETWEEN���� 1500~3000���� ������ ���� ���ڵ��� ��ȸ����� �߸���
  �ߺ����� �ʴ� ��ũ�� ����ϱ� ���� ROW_NUMBER() OVER()�Լ��� ���
  ������������ ���ݺ� ������ �����ֱ� ���� ORDER BY price DESC �ɼ��� �ο�
*/

/*
7. ��� ���̺��� �Ի�⵵�� 1981�� �̻��̸鼭 �Ŵ����� �ִ� �����
   �����ȣ,�����,����,�Ŵ�����ȣ, ���� ������ ��ȸ �ϼ���.
   ��, ���������� ������ ������ �� ������ ������ �����ݴϴ�.
*/

SELECT  empno, ename, sal, mgr, hiredate,
	    RANK() OVER(ORDER BY sal DESC) rank
FROM    emp
WHERE   mgr IS NOT NULL
	    AND TO_CHAR(hiredate, 'yyyy') >= 1981;
                                                
/*
  �Ŵ����� �ִ� ����� ���� �߸� IS NOT NULL ���
  �Ի�⵵�� 1981�� �̻��� ã������ TO_CHAR�Լ� ��� hiredate �÷� �����κ��� 'yyyy'���� ��ȯ �� �� ��
  ���������� ������ ������ �����ֱ� ���� RANK() OVER()�Լ� ���
  ORDER BY sal DESC�� ������ �������� ����� ���
*/
