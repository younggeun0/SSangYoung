-- eXERD를 사용해 ERD 만들고 포워드 엔지니어링으로 DB받기
-- TEST, STUDENT, SUBJECT 테이블이 생성됨
-- 과목 - 학생 - 시험 순으로 데이터 생성
-- 데이터 우선순위를 생각하며 데이터 추가

INSERT INTO subject(sub_code, title, info)
VALUES('O_000001','오라클','대용량 DataBase를 관리하는 프로그램');

INSERT INTO subject(sub_code, title, info)
VALUES('J_000001','자바','완벽한 OOP언어');

COMMIT;

SELECT * FROM subject;

INSERT INTO student(stu_num, name, age, address,email)
values('S_0000001','이재현', 27,'서울시','lee@test.com');

INSERT INTO test(test_num, sub_code, stu_num)
VALUES(3,'J_000001','S_0000001');

SELECT * FROM test;
SELECT * FROM subject;
SELECT* FROM student;



