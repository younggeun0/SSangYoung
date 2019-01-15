/* �ֹ� */
DROP TABLE ordering 
	CASCADE CONSTRAINTS;

/* ���ö� */
DROP TABLE lunch 
	CASCADE CONSTRAINTS;

/* ������ */
DROP TABLE lunch_admin 
	CASCADE CONSTRAINTS;

------------------- DDL for table ordering ---------------------------------
/* �ֹ� */
CREATE TABLE ordering (
	order_num CHAR(12) NOT NULL, /* �ֹ���ȣ */
	quan NUMBER(2) NOT NULL, /* ���� */
	order_name VARCHAR2(30) NOT NULL, /* �ֹ��ڸ� */
	phone VARCHAR2(13) NOT NULL, /* ��ȭ��ȣ */
	ip_address VARCHAR2(15) NOT NULL, /* �ֹ���IP */
	order_date DATE DEFAULT SYSDATE, /* �ֹ����� */
	status CHAR(1) DEFAULT 'N', /* ���ۻ��� */
	lunch_code CHAR(10) /* ���ö��ڵ� */
);

CREATE UNIQUE INDEX PK_ordering
	ON ordering (
		order_num ASC
	);

ALTER TABLE ordering
	ADD
		CONSTRAINT PK_ordering
		PRIMARY KEY (
			order_num
		);

------------------- DDL for table lunch ---------------------------------
/* ���ö� */
CREATE TABLE lunch (
	lunch_code CHAR(10) NOT NULL, /* ���ö��ڵ� */
	lunch_name VARCHAR2(20) NOT NULL, /* ���ö��� */
	img VARCHAR2(90) NOT NULL, /* �̹��� */
	price NUMBER(5) NOT NULL, /* �ܰ� */
	spec VARCHAR2(4000) NOT NULL, /* Ư¡ */
	input_date DATE DEFAULT SYSDATE, /* �Է��� */
	id VARCHAR2(20) /* ���̵� */
);

CREATE UNIQUE INDEX PK_lunch
	ON lunch (
		lunch_code ASC
	);

ALTER TABLE lunch
	ADD
		CONSTRAINT PK_lunch
		PRIMARY KEY (
			lunch_code
		);
                           
------------------- DDL for table lunch_admin ---------------------------------
/* ������ */
CREATE TABLE lunch_admin (
	id VARCHAR2(20) NOT NULL, /* ���̵� */
	pass VARCHAR2(20) NOT NULL, /* ��й�ȣ */
	name VARCHAR2(30) NOT NULL, /* �����ڸ� */
	input_date DATE DEFAULT SYSDATE /* �Է��� */
);

CREATE UNIQUE INDEX PK_lunch_admin
	ON lunch_admin (
		id ASC
	);

ALTER TABLE lunch_admin
	ADD
		CONSTRAINT PK_lunch_admin
		PRIMARY KEY (
			id
		);

ALTER TABLE ordering
	ADD
		CONSTRAINT FK_lunch_code
		FOREIGN KEY (
			lunch_code
		)
		REFERENCES lunch (
			lunch_code
		);

ALTER TABLE lunch
	ADD
		CONSTRAINT FK_lunch_id
		FOREIGN KEY (
			id
		)
		REFERENCES lunch_admin (
			id
		);                        