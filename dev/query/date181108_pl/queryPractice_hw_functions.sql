-- hw1 revision
SELECT hw1_cal_cs('2018-11-08')
FROM DUAL;

SELECT hw1_cal_cs('2008-11-08')
FROM DUAL;

-- hw2 revision
SELECT hw2_get_gender('000000-1234567') M,
 			 hw2_get_gender('000000-2234567') F,
			 hw2_get_gender('000000-3234567') M,
			 hw2_get_gender('000000-4234567') F
FROM dual;

-- hw3 revision
SELECT hw3_get_ht('000000-0070000'),
			 hw3_get_ht('000000-0120000'),
			 hw3_get_ht('000000-0140000'),
			 hw3_get_ht('000000-0170000'),
			 hw3_get_ht('000000-0280000'),
			 hw3_get_ht('000000-0450000'),
			 hw3_get_ht('000000-0650000'),
			 hw3_get_ht('000000-0770000'),
			 hw3_get_ht('000000-0940000')
FROM dual;               

DROP FUNCTION hw1_cal_cs;
DROP FUNCTION hw2_get_gender;
DROP FUNCTION hw3_get_ht;

