-- lucky_pack ��Ű�� ���

-- lucky_num �Լ� ���
SELECT lucky_pack.lucky_num
FROM dual;

-- lucky_name ���ν��� ���
VAR name VARCHAR2(30);

EXEC lucky_pack.lucky_name(:name);

PRINT name;

SELECT * FROM user_procedures;


---------------------------------
-- get_ssn ���ν��� ���
VAR ssn CHAR(14);

EXEC lucky_pack.get_ssn('901206', '����', :ssn);

PRINT ssn;
