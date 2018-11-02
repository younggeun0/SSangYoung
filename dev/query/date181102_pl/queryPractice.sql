/*
1. �������� �Է¹޾� �������� Ư¡�� ��� �ϴ� PL/SQL�ۼ�.
   -�������� ��ҹ��� ��� �� ���� �ؾ��Ѵ�.
   -'A' : �������̴�. ���ɽ�����, �����ϴ�
   -'B' : �ڱ��߽����̴�. �����̳� ��Ģ, �ӹ��� ���� �Ⱦ��Ѵ�.
   -'AB' : �ո����̴�. �ո����� �ݵ����� ��ȣ�ϰԵȴ�.
   -'O' :  �Ѱᰰ�� ��°� �������� �ִ�. �����ǽ��� ���ϴ�


SET serveroutput ON
SET verify OFF

ACCEPT input PROMPT '������ : '

DECLARE
	b_type VARCHAR2(2);
	output VARCHAR2(100);
BEGIN
	b_type := '&input';
	b_type := UPPER(b_type); 

	IF b_type IN ('A', 'B', 'AB', 'O') THEN
		IF b_type = 'A' THEN
			output := '�������̴�. ���ɽ�����, �����ϴ�';
		ELSIF b_type = 'B' THEN
			output := '�ڱ��߽����̴�. �����̳� ��Ģ, �ӹ��� ���� �Ⱦ��Ѵ�.';
		ELSIF b_type = 'AB' THEN
			output := '�ո����̴�. �ո����� �ݵ����� ��ȣ�ϰԵȴ�.';
		ELSE
			output := '�Ѱᰰ�� ��°� �������� �ִ�. �����ǽ��� ���ϴ�';
		END IF;
		DBMS_OUTPUT.PUT_LINE(output);
	ELSE
		DBMS_OUTPUT.PUT_LINE('�������� �ƴմϴ�..');
	END IF;
END;
/  

2. ������ �Է¹޾Ƽ�  
    100~90 ���̸� 'A'����
     89~80 ���̸� 'B'
    79~70 ���̸� 'C'
    69~60 ���̸� 'D'
    �׿� ��� '����� ����' �� ����ϴ�  PL/SQL�� �ۼ��ϼ���.

       
SET serveroutput ON
SET verify OFF

ACCEPT score PROMPT '������ �Է��ϼ��� : '

DECLARE
	score NUMBER(3);
	output CHAR(1);
BEGIN               
	score := &score;
	
	IF score BETWEEN 0 AND 100 THEN
		IF score >= 90 THEN 
			output := 'A';
		ELSIF score >= 80 THEN
			output := 'B';
		ELSIF score >= 70 THEN
			output := 'C';
		ELSIF score >= 60 THEN
			output := 'D';
		ELSE
			DBMS_OUTPUT.PUT_LINE('����� ����');
			RETURN; 
		END IF;
		
		DBMS_OUTPUT.PUT_LINE(output||'�����Դϴ�..');
			
	ELSE
		DBMS_OUTPUT.PUT_LINE('������ 0���� �۰ų� 100���� Ů�ϴ�..');
	END IF;

END;
/
  3. �̸��� �Է¹޾� ���� �̸��� ����ϴ�  PL/SQL�� �ϼ���.
    �̸��� ���ڼ��� 3�� ���϶�� '�ܼ�'���� �Ǵ��ϰ� 4�� �̻��̶��
    '����' �̶�� �Ǵ��Ѵ�.
    �ܼ�- ���� �ϳ��� �� (��: ��,��,��,��),  
    ���� - ���� �ΰ��μ� (�� : ������, �簥���� ��)
    �����  ��: ��  �̸� : ��ö
   

SET serveroutput ON
SET verify OFF

ACCEPT name PROMPT '�̸��� �Է��ϼ��� : '

DECLARE
	name VARCHAR(15);
	firstn VARCHAR(6);
	lastn VARCHAR(9);	
BEGIN                
	name := '&name';
	
	IF LENGTH(name) <= 3 THEN
		firstn := SUBSTR(name, 1, 1);
		lastn := SUBSTR(name, 2);	
	ELSE
		firstn := SUBSTR(name, 1, 2);
		lastn := SUBSTR(name, 3);	
	END IF;	                    
	
	DBMS_OUTPUT.PUT_LINE('�� : ' ||firstn||', �̸� : '||lastn);
END;
/

4. ��������� �Է¹޾�, '�ý�','����','����ö' �� ��쿡��
  �Ʒ��� ���� ������� �Ѵ� ����� �����ϼ���.
   �ý� : 3800 -
   ���� : 1200
   ����ö :1250��
   ��� : ����ٿ� ����ϴ� ��������� 'XX'�̰� �⺻ ���: xx ���Դϴ�.
      �պ������ xx���̰�, �Ѵ� 20�� ���� ������ xx�� �Դϴ�.
    �ý�, ����, ����ö�� �ƴ϶��  '���߱����� �ƴմϴ�.' �� ����ϼ���.
*/

SET serveroutput ON
SET verify OFF

ACCEPT method PROMPT '������� : '

DECLARE
	method VARCHAR2(9);
	price NUMBER(4);
BEGIN               
	method := '&method';
	
	IF method NOT IN ('�ý�', '����', '����ö') THEN
		DBMS_OUTPUT.PUT_LINE('���߱����� �ƴմϴ�...');
	ELSE
		IF method = '�ý�' THEN
			price := 3800;
		ELSIF method = '����' THEN
			price := 1200;
		ELSE 
			price := 1250;
		END IF; 	
		DBMS_OUTPUT.PUT_LINE('����ٿ� ���Ǵ� ��������� '||method||'�̰� �⺻��� : '
			||price||'���Դϴ�. �պ������ '||price*2||'���̰�, �Ѵ� 20�� ���� ������ '||
			price*20||'���Դϴ�..');	
	END IF;

END;
/