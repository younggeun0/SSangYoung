-- lucky_pack ��Ű�� get_chinese_zodiac �Լ� ���
SELECT lucky_pack.get_chinese_zodiac(1999)
FROM dual;


-- lucky_pack ��Ű�� get_cs ���ν��� ���
VAR avg_cs NUMBER;

EXEC lucky_pack.get_cs(30, :avg_cs);

PRINT avg_cs;

