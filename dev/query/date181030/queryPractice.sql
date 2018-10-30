
SELECT * FROM user_constraints;

SELECT * FROM table_multi_primary;

INSERT INTO table_multi_primary
VALUES((SELECT 'ITEM_'||LPAD(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1))+1, 4, 0)
	    FROM table_multi_primary), '목검5', '바람의나라~');

/*
1. 아래에 조건에 맞는 테이블을 생성하고 적절한 제약사항을 부여한 후
    모든 제약조건에 성공하는 경우와 각각의 경우에 따라 실패하는 모든
    쿼리문을 작성하세요.

    부서번호, 사원명, 연봉, 이메일, 전화번호, 성별, 주소, 입사일, 사원번호를
    저장하는 테이블을 생성

    제약사항
    - 부서번호는 숫자 두자리이며 dept테이블의 deptno만 입력할 수 있다
    - 사원명은 가변길이형이고 한글로 10글자까지 입력 가능하며 반드시 입력해야한다.
    - 연봉은 숫자이고 억단위의 입력이 가능, 입력가능 연봉은 2400~8000까지 입력가능
    - 이메일과 전화번호는 없을 수도 있지만 있다면 유일함
    - 성별은 남자 또는 여자만 입력가능
    - 주소는 없을 수도 있다
    - 입사일은 날짜형식이며 추가할 때 입사일이 null이라면 현재날짜가 입력됨
    - 사원번호는 숫자 4자리이며 null을 허용하지 않고 데이터를 중복데이터를 저장할 수 없음

    모든 에러상황과 성공상황에 대한 쿼리 작성 후 FOREIGN KEY에 해당하는 제약사항을
    비활성화 시킨 후 삭제를 해보세요.
*/

DROP TABLE personal_info;

CREATE TABLE personal_info (
	deptno NUMBER(2),
	ename VARCHAR(30) NOT NULL,
	sal NUMBER(9),
	email VARCHAR2(20),
	tel VARCHAR(14),
	gender CHAR(6),
	address VARCHAR(100),
	hiredate DATE DEFAULT SYSDATE,
	empno NUMBER(4),
	CONSTRAINT fk_personal_info_deptno
		FOREIGN KEY(deptno) REFERENCES dept(deptno),
	CONSTRAINT c_check CHECK(sal BETWEEN 2400 AND 8000),
	CONSTRAINT uk_personal_info_email UNIQUE(email),
	CONSTRAINT uk_personal_info_tel UNIQUE(tel),
	CONSTRAINT c_personal_info_gender CHECK (gender IN ('남자', '여자')),
	CONSTRAINT pk_personal_info_empno PRIMARY KEY(empno)
);

SELECT * FROM user_constraints
WHERE table_name='PERSONAL_INFO';

SELECT * FROM user_tab_cols
WHERE table_name='PERSONAL_INFO';

ALTER TABLE personal_info MODIFY ename VARCHAR(20) NULL;
ALTER TABLE personal_info MODIFY ename VARCHAR(30) NOT NULL;

ALTER TABLE personal_info ADD CONSTRAINT uk_temp UNIQUE(address);
ALTER TABLE personal_info DROP CONSTRAINT uk_temp;
