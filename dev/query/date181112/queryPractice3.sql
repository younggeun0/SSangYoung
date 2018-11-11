/*
2. �л����� ������ ó���ϴ� PL/SQL�ۼ�.
   ��ȣ, �̸�, ����Ŭ����,�ڹ�����,����,��� �� ������ ���ִ� record��
   ����� �Ʒ��� �����͸� �Է��� ��
   �ݺ����� ����Ͽ�  ����,����� ó���ϴ� PL/SQL �ۼ�
  1, ������, 80,81
  2, ����ö, 94,80
  3, ������, 97,96
  4, �ڿ���, 86,92
  5, ���ü�, 76,99

���
   ��ȣ, �̸�, ����Ŭ����,�ڹ�����,����,���
  .
  .
  .
  �ڹ��ְ����� [xx] ����Ŭ �ְ����� [xxx]

*/
SET serveroutput ON

DECLARE

	TYPE stu_rec IS RECORD(
		num NUMBER,
		name VARCHAR2(15),
		o_score NUMBER(3),
		j_score NUMBER(3),
		sum_s NUMBER(3),
		avg_s NUMBER(3,1)
	);

	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;

	class4 stu_tab;

	j_top NUMBER(3) := 0;
	o_top NUMBER(3) := 0;

BEGIN
    class4(1).num := 1;
    class4(1).name := '������';
    class4(1).o_score := 80;
    class4(1).j_score := 81;

    class4(2).num := 2;
    class4(2).name := '����ö';
    class4(2).o_score := 94;
    class4(2).j_score := 80;

    class4(3).num := 3;
    class4(3).name := '������';
    class4(3).o_score := 97;
    class4(3).j_score := 96;

    class4(4).num := 4;
    class4(4).name := '�ڿ���';
    class4(4).o_score := 86;
    class4(4).j_score := 92;

    class4(5).num := 5;
    class4(5).name := '���ü�';
    class4(5).o_score := 76;
    class4(5).j_score := 99;

    FOR i IN 1..class4.COUNT LOOP

    class4(i).sum_s := class4(i).o_score + class4(i).j_score;
    class4(i).avg_s := class4(i).sum_s/2;
   	DBMS_OUTPUT.PUT_LINE(class4(i).num||' '
       ||class4(i).name||' '||class4(i).o_score||' '
       ||class4(i).j_score||' '||class4(i).sum_s||' '
       ||class4(i).avg_s);

    IF class4(i).j_score> j_top THEN
    	j_top := class4(i).j_score;
    END IF;

    IF class4(i).o_score> o_top THEN
    	o_top := class4(i).o_score;
    END IF;

    END LOOP;

    DBMS_OUTPUT.PUT_LINE('j_top : '||j_top||', o_top : '||o_top);



END;
/
