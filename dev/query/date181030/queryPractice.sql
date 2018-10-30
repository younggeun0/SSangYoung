
SELECT * FROM user_constraints;

SELECT * FROM table_multi_primary;

INSERT INTO table_multi_primary
VALUES((SELECT 'ITEM_'||LPAD(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1))+1, 4, 0)
	    FROM table_multi_primary), '���5', '�ٶ��ǳ���~');

/*
1. �Ʒ��� ���ǿ� �´� ���̺��� �����ϰ� ������ ��������� �ο��� ��
    ��� �������ǿ� �����ϴ� ���� ������ ��쿡 ���� �����ϴ� ���
    �������� �ۼ��ϼ���.

    �μ���ȣ, �����, ����, �̸���, ��ȭ��ȣ, ����, �ּ�, �Ի���, �����ȣ��
    �����ϴ� ���̺��� ����

    �������
    - �μ���ȣ�� ���� ���ڸ��̸� dept���̺��� deptno�� �Է��� �� �ִ�
    - ������� �����������̰� �ѱ۷� 10���ڱ��� �Է� �����ϸ� �ݵ�� �Է��ؾ��Ѵ�.
    - ������ �����̰� ������� �Է��� ����, �Է°��� ������ 2400~8000���� �Է°���
    - �̸��ϰ� ��ȭ��ȣ�� ���� ���� ������ �ִٸ� ������
    - ������ ���� �Ǵ� ���ڸ� �Է°���
    - �ּҴ� ���� ���� �ִ�
    - �Ի����� ��¥�����̸� �߰��� �� �Ի����� null�̶�� ���糯¥�� �Էµ�
    - �����ȣ�� ���� 4�ڸ��̸� null�� ������� �ʰ� �����͸� �ߺ������͸� ������ �� ����

    ��� ������Ȳ�� ������Ȳ�� ���� ���� �ۼ� �� FOREIGN KEY�� �ش��ϴ� ���������
    ��Ȱ��ȭ ��Ų �� ������ �غ�����.
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
	CONSTRAINT c_personal_info_gender CHECK (gender IN ('����', '����')),
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
