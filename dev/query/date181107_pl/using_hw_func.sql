
-- hw1 function cal_cs
SELECT cal_cs('2010-11-07') eightyearsago,
       cal_cs('2009-11-07') nineyearsago,
       cal_cs('2008-11-07') tenyearsago,
       cal_cs('2007-11-07') elevenyearsago
FROM dual;

-- hw2 function get_gender
SELECT get_gender('990101-1234567') M,
	     get_gender('990102-2234567') F,
	     get_gender('050103-3234567') M,
	     get_gender('050104-4234567') F,
	     get_gender('990105-5234567') M,
	     get_gender('990106-6234567') F,
	     get_gender('050107-7234567') M,
	     get_gender('050108-8234567') F
FROM dual;

SELECT name, ssn, get_gender(ssn) gender
FROM class4_info;

-- hw3 function
INSERT INTO class4_info(num, name, ssn)
VALUES(16, '±Ù¿µ¿À', '120405-1932345');

UPDATE class4_info
SET ssn = '770202-1141234'
WHERE num = 5;

UPDATE class4_info
SET ssn = '990107-9564567'
WHERE num = 10;

UPDATE class4_info
SET ssn = '880101-2104567'
WHERE num = 14;
                            
SELECT num, name, ssn, get_hometown(ssn) ht
FROM class4_info;




