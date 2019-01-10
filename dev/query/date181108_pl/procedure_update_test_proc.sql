-- 프로시저를 이용한 UPDATE
-- 사원번호, 직급, 연봉을 입력받아 test_proc테이블에서 변경하는 프로세저
-- 제약들
--  * 직급은 사원, 주임, 대리, 과장, 차장, 부장, 이사,
--    상무, 전무, 대표이사가 입력 되었을 때만 변경
--  * 연봉이 현재 연봉보다 작다면 현재 연봉보다 5% 인상액으로 변경

CREATE OR REPLACE PROCEDURE update_test_proc(
  i_empno NUMBER,
	i_job VARCHAR2,
	sal	NUMBER,
	res_msg OUT VARCHAR2,
	row_cnt OUT NUMBER
)
IS
	-- 현재 연봉을 받아오기 위해 만든 변수
	temp_sal NUMBER;

BEGIN
    row_cnt := 0;

	IF i_job IN ('사원','주임','대리','과장',
		       '차장','부장','이사','상무',
		       '전무','대표이사') THEN

		SELECT sal
		INTO temp_sal
		FROM test_proc
		WHERE empno = i_empno;

		IF sal < temp_sal THEN
			temp_sal := TRUNC(temp_sal*1.05, 0);
		ELSE
			temp_sal := sal;
		END IF;

		UPDATE test_proc
		SET sal = temp_sal, job = i_job
		WHERE empno = i_empno;

		row_cnt := SQL%ROWCOUNT;

		COMMIT;

		res_msg := i_empno||'번 사원의 정보가 변경되었습니다. 제시연봉 : '||sal||
						', 확정연봉 : '||temp_sal;

	ELSE
		res_msg := i_job||'은 사내 직무가 아닙니다.';
	END IF;

	EXCEPTION
	WHEN NO_DATA_FOUND THEN
		res_msg := i_empno||'번 사원은 존재하지 않습니다.';
	WHEN OTHERS THEN
		res_msg := sqlerrm;

END;
/

