-- �μ���ȣ �Է��Ͽ� �μ��� ������� ��ȸ
VAR cur_emp REFCURSOR;

-- �μ���ȣ : 10~19 : 10, 20~29 : 20, �׿� : 30
EXEC select_emp(29,:cur_emp);


PRINT cur_emp;
