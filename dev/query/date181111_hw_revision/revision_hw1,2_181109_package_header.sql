/*
1.lucky_pack ��Ű���� �¾�ظ� �Է¹����� �츦 ��ȯ�ϴ� 
  �Լ��� �߰��ϼ���.
  �� - �¾�ظ� 12�� ���� �������� 
      11�̸� ���, 10- ��, 9-��,8-��,7-�䳢,6-ȣ����,5-��,4-��,3-����,
      2-��,1-��,0-������
*/

/*
2. lucky_pack ��Ű���� �μ���ȣ�� �޾� emp ���̺��� �μ���
   ����� ��� �ټӳ���� out_parameter�� �����ϴ� procedure��
   �߰��ϼ���.
*/

CREATE OR REPLACE PACKAGE lucky_pack
AS
 
	FUNCTION get_cz(birth_year NUMBER) RETURN VARCHAR2;
	
	PROCEDURE get_avgcs(i_deptno NUMBER, avgcs OUT NUMBER);

END;
   