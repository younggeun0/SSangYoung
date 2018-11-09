CREATE OR REPLACE PACKAGE lucky_pack
AS           
	-- ����� ��(1~45) �� �ϳ��� ��� �Լ�         
   FUNCTION lucky_num RETURN NUMBER;  
   
   -- ���ξ�� ���ν���
   PROCEDURE lucky_name(name OUT VARCHAR2); 
   
   -- ������� , ������ �Է¹޾� �ֹι�ȣ�� �����Ͽ�
   -- out parameter�� �����ϴ� ���ν����� �ۼ�
   PROCEDURE get_ssn(birthdate CHAR, gender VARCHAR2, ssn OUT CHAR);    

/*  181109 ����
1.lucky_pack ��Ű���� �¾�ظ� �Է¹����� �츦 ��ȯ�ϴ� 
  �Լ��� �߰��ϼ���.
  �� - �¾�ظ� 12�� ���� �������� 
      11�̸� ���, 10- ��, 9-��,8-��,7-�䳢,6-ȣ����,5-��,4-��,3-����,
      2-��,1-��,0-������
*/
	FUNCTION get_chinese_zodiac(birth_year NUMBER) RETURN VARCHAR2;  

/*
2. lucky_pack ��Ű���� �μ���ȣ�� �޾� emp ���̺��� �μ���
   ����� ��� �ټӳ���� out_parameter�� �����ϴ� procedure��
   �߰��ϼ���.
*/   
	PROCEDURE get_cs(i_deptno NUMBER, avg_cs OUT NUMBER);   


END;
/
