/*
3. �ֹι�ȣ�� �Է¹޾� ��������� ��ȯ�ϴ� �Լ� �ۼ�
   ���������  880101-1xx1111 ���� xx ���ڸ� �̰�
   �Ʒ��� ǥ�� ����.
    ����� : 00~08
    �λ�� : 09~12
    ��õ�� : 13~15
    ��⵵ : 16~25
    ������ : 26~34
    ��û�� : 35~47
    ���� : 48~66
    ��� : 67~92
    ���ֵ� : 93~95
*/

CREATE OR REPLACE FUNCTION hw3_get_ht(ssn CHAR)
RETURN CHAR
IS

	re_msg CHAR(9);
	h_code NUMBER(2);

BEGIN

	h_code := SUBSTR(ssn, 9, 2);

	IF h_code BETWEEN 0 AND 8 THEN
		re_msg := '�����';
	ELSIF h_code BETWEEN 9 AND 12 THEN
		re_msg := '�λ��';
	ELSIF h_code BETWEEN 13 AND 15 THEN
		re_msg := '��õ��';
	ELSIF h_code BETWEEN 16 ANd 25 THEN
		re_msg := '��⵵';
	ELSIF h_code BETWEEN 26 AND 34 THEN
		re_msg := '������';
	ELSIF h_code BETWEEN 35 AND 47 THEN
		re_msg := '��û��';
	ELSIF h_code BETWEEN 48 AND 66 THEN
		re_msg := '����';
	ELSIF h_code BETWEEN 67 AND 92 THEN
		re_msg := '���';
	ELSIF h_code BETWEEN 93 AND 95 THEN
		re_msg := '���ֵ�';
	ELSE
		re_msg := '�����';
	END IF;

	RETURN re_msg;

END;
/
