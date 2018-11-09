-- lucky_pack 패키지 get_chinese_zodiac 함수 사용
SELECT lucky_pack.get_chinese_zodiac(1999)
FROM dual;


-- lucky_pack 패키지 get_cs 프로시저 사용
VAR avg_cs NUMBER;

EXEC lucky_pack.get_cs(30, :avg_cs);

PRINT avg_cs;

