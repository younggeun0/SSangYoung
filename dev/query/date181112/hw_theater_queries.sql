-- board, user_info, reservation, seat ���̺��� ������ �����Ͼ���� ����
SELECT * FROM board;
SELECT * FROM user_info;
SELECT * FROM reservation;
SELECT * FROM seat;

INSERT INTO seat(seat_id, seat_num)
VALUES(1, 1);

INSERT INTO seat(seat_id, seat_num)
VALUES(2, 2);

INSERT INTO seat(seat_id, seat_num)
VALUES(3, 3);

INSERT INTO seat(seat_id, seat_num)
VALUES(4, 4);

INSERT INTO seat(seat_id, seat_num)
VALUES(5, 5);

COMMIT;
SELECT * FROM seat;

-----

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young1', 1234, '������', 'java', '010-2222-3333', '�����');

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young2', 1234, '������', 'c++', '010-2333-3333', '��õ��');

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young3', 1234, '������', 'c#', '010-2222-1111', '�λ��');

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young4', 1234, '������', 'python', '010-1111-3333', '������');

COMMIT;
SELECT * FROM user_info;

----

INSERT INTO reservation(reserve_id, reserve_num, seat_id, userid)
VALUES(1, 1234, 1, 'young3');

SELECT * FROM reservation;

----

INSERT INTO board(post_num, title, contents, writer)
VALUES(1, 'hello sql', 'sql is ~~~', 'young4');

SELECT * FROM board;
