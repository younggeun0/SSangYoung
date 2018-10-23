/*
-- 테이블에 레코드(row, 행) 추가


-- DESC Class4_info;

-- 컬럼명을 생략하는 경우, 컬럼의 순서를 명확히 알고 있어야 함
INSERT INTO Class4_info
VALUES (1, 'young', '901206-1234567', 29, 1.0, 'young@young.com', SYSDATE);

-- 컬럼명을 명시 안하면 이렇게 순서를 틀리면 이름이 이메일에, 이메일이 이름에 저장될 수 있다
INSERT INTO Class4_info
VALUES (2, 'young@young.com', '991206-1234567', 22, 1.0, 'young', SYSDATE);

COMMIT;

-- 컬럼의 정의 순서는 테이블에 정의된 컬럼의 순서와 관려니 없음
INSERT INTO Class4_info(num, name, ssn, age, eye, email, input_date) 
VALUES(3, 'sol', '930815-1234567', 26, 0.7, 'sol@sol.com', SYSDATE);

-- 컬럼명을 명시한 경우, 컬럼의 순서는 상관 없이 입력
INSERT INTO Class4_info (name, email, num, ssn, age, input_date, eye)
VALUES ('영근', 'oh@test.com', 4, '900000-0000000', 28, SYSDATE, 0.8);

COMMIT;

-- 컬럼을 생략하면 null이 입력된다.
INSERT INTO Class4_info (num, name, age) 
VALUES (5, 'Kim', 33);

COMMIT;

*/