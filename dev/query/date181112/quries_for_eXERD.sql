-- eXERD�� ����� ERD ����� ������ �����Ͼ���� DB�ޱ�
-- TEST, STUDENT, SUBJECT ���̺��� ������
-- ���� - �л� - ���� ������ ������ ����
-- ������ �켱������ �����ϸ� ������ �߰�

INSERT INTO subject(sub_code, title, info)
VALUES('O_000001','����Ŭ','��뷮 DataBase�� �����ϴ� ���α׷�');

INSERT INTO subject(sub_code, title, info)
VALUES('J_000001','�ڹ�','�Ϻ��� OOP���');

COMMIT;

SELECT * FROM subject;

INSERT INTO student(stu_num, name, age, address,email)
values('S_0000001','������', 27,'�����','lee@test.com');

INSERT INTO test(test_num, sub_code, stu_num)
VALUES(3,'J_000001','S_0000001');

SELECT * FROM test;
SELECT * FROM subject;
SELECT* FROM student;



