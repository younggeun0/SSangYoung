
CREATE VIEW test_view
AS (SELECT *
	FROM emp);

-- VIEW를 생성하려면 관리자권한을 가진 계정이 VIEW 생성권한을 부여해야 함
-- GRANT CREATE VIEW TO 계정명

DROP VIEW test_view;

-- 단순 VIEW 생성 (테이블 하나로 생성된 VIEW)
SELECT * FROM cp_emp3;

CREATE VIEW emp_view
AS (SELECT *
	FROM cp_emp3);

SELECT * FROM user_views;

SELECT * FROM emp_view;
SELECT * FROM cp_emp3;

-- 단순 VIEW DML
INSERT INTO emp_view(empno, ename, deptno, job, sal)
VALUES(1234, '오영근', 20, '과장', 4000);

SELECT * FROM emp_view;

UPDATE emp_view
SET    job='차장', sal=4100
WHERE  empno=1234;

DELETE FROM emp_view
WHERE empno=1234;

COMMIT;

-- VIEW 삭제
DROP VIEW emp_view;

SELECT * FROM user_views;

-- 단순 VIEW(하나의 테이블에 몇개의 컬럼으로 view 생성)
-- cp_emp3테이블의 사원번호, 사원명, 직무, 연봉으로 VIEW 생성
CREATE VIEW emp_view
AS (SELECT empno, ename, job, sal
	FROM cp_emp3);
DELETE FROM emp
WHERE empno=1234;
SELECT * FROM emp_view;

DROP VIEW emp_view;
-- 뷰 사용 예)고객정보 사용할 때 사원이 보는 정보와 관리자가 보는 정보는 다를 것
-- 사원(고객명, 고객번호, 전화번호) 만 볼 수 있다면 세 컬럼을 갖는 뷰를 생성하면 됨
-- 관리자(고객명, 고객번호, 전화번호, 주민번호, 카드번호 ..) 이렇게 뷰를 만들어 관리자 사용
-- 이처럼 여러 정보들을 직급에 따라 제공하는 정보를 다르게 할 수 있다

SELECT * FROM user_views;

-- VIEW에 포함되지 않은 컬럼은 INSERT를 수행하면 NULL이 입력된다
INSERT INTO emp_view(empno, ename, job, sal)
VALUES (1234, '오영근', '차장', 4100);

SELECT * FROM cp_emp3;
SELECT * FROM emp_view;

-- 복합 VIEW : 테이블 여러개를 사용하여 생성한 VIEW 또는
-- 조회할 때 함수를 사용하여 조회한 결과로 생성한 VIEW
-- 복합 VIEW는 INSERT, UPDATE, DELETE가 수행되지 않는다.
-- 여러개의 테이블을 모으고 단순 SELECT를 사용하여 조회할 때 사용

CREATE VIEW car_view
AS (SELECT cma.maker, cma.model, cmo.car_year, cmo.price,
	       cmo.cc, cmo.car_option
	FROM car_maker cma, car_model cmo
	WHERE cmo.model = cma.model);

SELECT * FROM user_views;
SELECT * FROM car_View;

-- VIEW를 사용하면 JOIN된 결과를 단순쿼리로 얻을 수 있다
SELECT  maker, model, car_year, price, cc, car_option
FROM	car_view
WHERE	maker='현대';

-- 복합 VIEW는 INSERT, UPDATE, DELETE를 할 수 없다
INSERT INTO car_view(maker, model, car_year, price, cc, car_option)
VALUES('현대', '벨로스터', 2017, 3000, 1999, '문짝3개,ABS');

-- 단순 VIEW에 INSERT, UPDATE, DELETE를 막기 위해선
-- VIEW 생성 시 WITH READ ONLY라는 옵션을 주면 된다
CREATE VIEW read_emp
AS (SELECT *
	FROM cp_emp2)
WITH READ ONLY;

SELECT view_name,read_only FROM user_views
WHERE view_name='READ_EMP';

SELECT * FROM read_emp;

-- WITH READ ONLY 옵션을 사용한 VIEW는 DML(추가, 삭제, 변경)을 할 수 없다.
INSERT INTO read_emp(empno, ename, hiredate, sal)
VALUES(1234, '오영근', SYSDATE, 5000);
                                       