
SELECT * FROM user_sequences;

-- SEQUENCE : 순차적으로 증가하는 수를 사용하는 객체
-- 1에서부터 9999999까지 1씩 증가하는 시퀀스를 생성
CREATE SEQUENCE seq_test
 INCREMENT BY 1
 START WITH 1
 MAXVALUE 999999;

DROP SEQUENCE seq_test;
SELECT * FROM user_sequences;

-- currval은 메모리에 올리는 일은 못 함
SELECT seq_test.currval
FROM   DUAL;

SELECT	seq_test.nextval
FROM	dual;

-- 쿼리문의 실행 실패에도 시퀀스는 사라진다
INSERT INTO cp_emp(empno, ename, hiredate, sal)
VALUES(seq_test.nextval, '안기모2', SYSDATE, 300);

SELECT * FROM cp_emp;

-- 시퀀스 삭제
DROP SEQUENCE seq_test;

CREATE SEQUENCE seq_test2
 INCREMENT BY 2
 START WITH 1
 MAXVALUE 9999999
 CACHE 40
 NOCYCLE;

SELECT * FROM user_sequences;

SELECT  seq_test2.nextval
FROM	dual;

DROP SEQUENCE seq_test2;
                             
-- 시퀀스는 증가하는 수를 가지고 PK를 사용해야할 때 사용하면 좋다