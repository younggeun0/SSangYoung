VAR ssn CHAR(14);

EXEC ssn.create_ssn('880204', '����', '������', :ssn);

PRINT ssn;


SELECT * FROM class4_info;

-- ��ȿ���� ������ ���� �Լ��� �̿��� Ȯ�ΰ���
SELECT name, ssn, valid_ssn_check(ssn)
FROM class4_info;
