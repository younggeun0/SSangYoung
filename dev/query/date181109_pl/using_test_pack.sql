SELECT * FROM user_procedures;

-- ��Ű���� ���Ե� �Լ� ȣ��
SELECT	test_pack.get_msg('������')
FROM	dual;

-- ���ν��� ȣ��
VAR age NUMBER;

EXEC test_pack.get_age(1993, :age);

PRINT age;


------------------

-- 1107 hw2 ���ν��� ȣ��
VAR tab_info REFCURSOR;

EXEC test_pack.search_constraints('car_maker', :tab_info);

PRINT tab_info;
