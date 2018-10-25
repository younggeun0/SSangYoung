-- NULL 변환
-- 레코드를 추가할 때(INSERT) 해당 컬럼을 명시하지 않으면 NULL 입력됨
-- CHAR/VARCHAR2 : 컬럼을 명시하지 않거나 값이 ''인 경우 NULL 입력됨
-- NUMBER/DATE : 컬럼을 명시하지 않은 경우 NULL 입력됨
SELECT *
FROM emp;

-- 사원테이블에서 사원명, 연봉, 보너스 조회
-- 단, 보너스가 없는 사원들은 100으로 출력
SELECT ename, sal, NVL(comm, '100')
FROM emp;

-- 우편번호테이블에서 입력한 동의 우편번호, 시도, 구군, 동, 번지 조회
-- 단, 번지가 없다면 '번지없음'을 출력
SELECT zipcode, sido, gugun, dong, NVL(bunji, '번지없음') bunji
FROM zipcode
WHERE dong LIKE '논현%';

-- class4_info 테이블에서 번호, 이름, 입력일 조회
-- 단, 입력일이 없다면 현재날짜 출력
SELECT num, name, NVL(input_date, SYSDATE)
FROM class4_info;
