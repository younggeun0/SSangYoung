-- hw1 function ���

SELECT lucky_pack.get_cz(1990)
FROM dual;

-- hw2 procedure ���
VAR avgcs NUMBER;

EXEC lucky_pack.get_avgcs(10, :avgcs);

PRINT avgcs;

EXEC lucky_pack.get_avgcs(20, :avgcs);

PRINT avgcs;

EXEC lucky_pack.get_avgcs(30, :avgcs);

PRINT avgcs;


