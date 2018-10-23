/*
-- 조건에 맞는 레코드를 찾아 컬럼의 값을 변경하는 일
-- Class4_info 테이블에서 학생의 번호가 2인 학생을 찾아서
-- 이름을 '김희철'로 변경

UPDATE  Class4_info
SET     name = 'heechul Kim'
WHERE   num = 2;

UPDATE  Class4_info
SET     name = 'Paris'
WHERE   num = 4;

COMMIT;

-- 번호가 10번인 학생을 찾아서 이름-'youngmin Park', 나이-25, 
-- 이메일-lee@daum.net, 입력일-현재날짜로 변경 
UPDATE  Class4_info
SET     name='youngmin Park', age=25, email='lee@daum.net', input_date=SYSDATE
WHERE   num = 10;

COMMIT;

-- 학생의 번호가 10번이면서 이름이 '박영민'인 학생의 주민번호를 
-- '990101-1234567'로 변경
UPDATE  Class4_info
SET     ssn='990101-1234567'
WHERE   num=10 AND name='youngmin Park';

COMMIT;

-- OR은 둘 중 하나만 참이어도 참, OR는 나중에 IN 연산자로 바꿔 쓸 수 있음
UPDATE  Class4_info
SET     ssn='990101-55534511'
WHERE   num=11 OR name='youngmin Park';

ROLLBACK;
*/


