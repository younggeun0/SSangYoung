/*  181029 숙제복습
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
*/

CREATE TABLE some_tab (
  deptno NUMBER(2) CONSTRAINT fk_st REFERENCES dept(deptno),
  ename VARCHAR2(30) NOT NULL,
  sal NUMBER(9) CONSTRAINT c_sal CHECK(sal BETWEEN 2400 AND 8000),
  email VARCHAR2(30) CONSTRAINT uk_email2 UNIQUE,
  tel VARCHAR2(12) CONSTRAINT uk_tel2 UNIQUE,
  gender CHAR(6) CONSTRAINT c_gender CHECK(gender IN ('남자', '여자')),
  addr VARCHAR2(100),
  hiredate DATE DEFAULT SYSDATE,
  empno NUMBER(4) CONSTRAINT pk_st PRIMARY KEY
);

SELECT * FROM some_tab;

DROP TABLE some_tab;

CREATE TABLE some_tab(
	deptno NUMBER(2),
	ename VARCHAR2(30) NOT NULL,
	sal NUMBER(9),
	email VARCHAR2(30),
	tel VARCHAR2(12),
	gender CHAR(6),
	addr VARCHAR2(100),
	hiredate DATE DEFAULT SYSDATE,
	empno NUMBER(4),
	CONSTRAINT fk_st FOREIGN KEY(deptno) REFERENCES dept(deptno),
	CONSTRAINT c_sal2 CHECK(sal BETWEEN 2400 AND 8000),
	CONSTRAINT uk_e2 UNIQUE(email),
	CONSTRAINT uk_t2 UNIQUE(tel),
	CONSTRAINT c_gender2 CHECK(gender IN ('남자', '여자')),
	CONSTRAINT pk_st PRIMARY KEY(empno)
);

SELECT * FROM some_tab;

DROP TABLE some_tab;


/*
  1. 배기량이 1500~3000사이인 차량의 제조국, 제조사,
       모델명, 연식, 가격, 이미지, 입력일, 배기량, 옵션을 조회
       단, 출력은 배기량의 내림차순 정렬했을 때 3~6번째 레코드만 조회하고,
       옵션은 처음 ',' 까지만 출력할 것.
       가격과 연식은 3자리마다 ','를 넣어 출력하고
       입력일은 월-일-년의 형식으로 출력할 것
*/
SELECT * FROM car_model;

SELECT r, country, maker, model, car_year, TO_CHAR(price,'9,999'), car_img,
		   TO_CHAR(hiredate,'mm-dd-yyyy') hiredate,
	     TO_CHAR(cc,'9,999') cc,
		   SUBSTR(car_option,1,INSTR(car_option, ',')-1) car_option
FROM (SELECT ROWNUM r, country, maker, model, car_year, price, car_img, hiredate, cc, car_option
			FROM(SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price,
							     cmo.car_img, cmo.hiredate, cmo.cc, cmo.car_option
						FROM car_country cc, car_maker cma, car_model cmo
						WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
						 AND cmo.cc BETWEEN 1500 AND 3000))
WHERE r BETWEEN 3 AND 6;

/*
  6. 사원명이 'S'로 끝나거나 이름이 5자이면서 세번째 글자가 'A'인
     사원의 사원번호, 사원명, 입사일, 연봉, 세금, 실수령액, 연봉인상액
     부서번호, 부서명, 위치, 우편번호, 시도, 구군, 동, 번지를 조회
     단, 실수령액은 연봉+퇴직금(한달치)+보너스-세금(연봉 3.3%)로 계산
      연봉인상액은 부서번호에 따라 차등 인상
      10 - 연봉 7% 인상
      20 - 연봉 4% 인상
      30 - 연봉+보너스 10% 인상
      그외는 연봉 3% 인상으로 계산하여 3자리마다 ','를 넣어 출력
      모든 영어는 소문자로 출력할 것.
*/

SELECT e.empno, LOWER(e.ename), e.hiredate, e.sal, e.sal*0.033 tax,
	     TRUNC(e.sal+(e.sal/12)+NVL(e.comm, 0)) total,
	     DECODE(d.deptno, 10, e.sal*1.07, 20, e.sal*1.04, 30, (e.sal+NVL(e.comm, 0))*1.1,
	     		    e.sal*1.03) i_sal, d.deptno, LOWER(d.dname), LOWER(d.loc)
FROM emp e, dept d, zipcode z
WHERE (e.deptno = d.deptno AND z.seq = e.empno)
 AND (e.ename LIKE '%S' OR e.ename LIKE '__A__');















