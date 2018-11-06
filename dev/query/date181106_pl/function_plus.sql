CREATE OR REPLACE FUNCTION plus(num1 NUMBER, num2 NUMBER)
RETURN NUMBER
IS
	result NUMBER;
BEGIN                     
                      
	result := NVL(num1,0) + NVL(num2,0);
	RETURN result;

END;
/
