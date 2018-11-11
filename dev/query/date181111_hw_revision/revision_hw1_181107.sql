/*               

1. �Ի�⵵�� �Է¹޾� �ټӳ���� 10�� �̻��̸� '���ټ�'
  �׷��� ������ '�ܱ�ټ�'�̶�� �޼����� ��ȯ�ϴ� �Լ� �ۼ�. 
  
*/

CREATE OR REPLACE FUNCTION cal_cs(hiredate DATE)
RETURN CHAR
IS
	re_msg CHAR(12) := '�ܱ�ټ�';
	w_period NUMBER;
BEGIN               

	w_period := TO_CHAR(SYSDATE, 'yyyy') - TO_CHAR(hiredate, 'yyyy');
	
	IF w_period >= 10 THEN
		re_msg := '���ټ�';	
	ENd IF;                
	
	RETURN re_msg;

END;
/
