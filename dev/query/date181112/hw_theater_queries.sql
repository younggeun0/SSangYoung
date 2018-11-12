-- board, user_info, reservation, seat 테이블을 포워드 엔지니어링으로 받음
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
VALUES('young1', 1234, '오영근', 'java', '010-2222-3333', '서울시');

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young2', 1234, '오영구', 'c++', '010-2333-3333', '인천시');

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young3', 1234, '오영조', 'c#', '010-2222-1111', '부산시');

INSERT INTO user_info(userid, pw, name, lang, tel, addr)
VALUES('young4', 1234, '오영쥬', 'python', '010-1111-3333', '대전시');

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
