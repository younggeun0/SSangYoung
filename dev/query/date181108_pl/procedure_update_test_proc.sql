-- ���ν����� �̿��� UPDATE
-- �����ȣ, ����, ������ �Է¹޾� test_proc���̺��� �����ϴ� ���μ���
-- �����
--  * ������ ���, ����, �븮, ����, ����, ����, �̻�,
--    ��, ����, ��ǥ�̻簡 �Է� �Ǿ��� ���� ����
--  * ������ ���� �������� �۴ٸ� ���� �������� 5% �λ������ ����

CREATE OR REPLACE PROCEDURE update_test_proc(
  i_empno NUMBER,
	i_job VARCHAR2,
	sal	NUMBER,
	res_msg OUT VARCHAR2,
	row_cnt OUT NUMBER
)
IS
	-- ���� ������ �޾ƿ��� ���� ���� ����
	temp_sal NUMBER;

BEGIN
    row_cnt := 0;

	IF i_job IN ('���','����','�븮','����',
		       '����','����','�̻�','��',
		       '����','��ǥ�̻�') THEN

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

		res_msg := i_empno||'�� ����� ������ ����Ǿ����ϴ�. ���ÿ��� : '||sal||
						', Ȯ������ : '||temp_sal;

	ELSE
		res_msg := i_job||'�� �系 ������ �ƴմϴ�.';
	END IF;

	EXCEPTION
	WHEN NO_DATA_FOUND THEN
		res_msg := i_empno||'�� ����� �������� �ʽ��ϴ�.';
	WHEN OTHERS THEN
		res_msg := sqlerrm;

END;
/

