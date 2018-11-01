
SET serveroutput ON

DECLARE
-- 테이블의 컬럼을 참조하여 변수를 만들 수 있다
	e_name emp.ename%TYPE;

-- 테이블의 모든 컬럼을 참조하여 변수 선언(RECORD TYPE)
	row_type cp_emp%ROWTYPE;     
	r cp_emp%ROWTYPE;

BEGIN
	e_name := '이재현';

-- RECORD TYPE 변수 사용 : 변수명.컬럼명
    row_type.empno := 1234;
    row_type.ename := 'young';
    row_type.hiredate := '1990-12-06';
    row_type.sal := 5000;
	DBMS_OUTPUT.PUT_LINE(e_name||'씨');

	DBMS_OUTPUT.PUT_LINE(row_type.empno||'번, '
		||row_type.ename||'은 생년은 '||TO_CHAR(row_type.hiredate,'yyyy')||'고 '
		||row_type.sal||'정도의 연봉을 받는다.');
		
	r.empno := 1111;
	r.ename := '정택성';
	r.hiredate := SYSDATE;
	r.sal := 2800;
	
	DBMS_OUTPUT.PUT_LINE('사원번호 : '||r.empno
	||', 사원명 : '||r.ename||', 입사일 : '
	||TO_CHAR(r.hiredate, 'yyyy"년" mm"월" dd"일"')||
	', 연봉 : '||r.sal);	

END;
/

