
------------------- Data for table lunch_admin ---------------------------
INSERT INTO lunch_admin(id, pass, name)
VALUES('admin','1234','������');
INSERT INTO lunch_admin(id, pass, name)
VALUES('lunch','1234','���ٿ�');
INSERT INTO lunch_admin(id, pass, name)
VALUES('root','1234','������');
COMMIT;
------------------- Data for table lunch ---------------------------------
INSERT INTO lunch(lunch_code, lunch_name, img, price, spec, id)
VALUES(lunch_code, '��ũĥ��', 'm1_l1.gif', 4500, '����� ������ ���������� ȯ���� ��������
 �پ��� ���� ������ �� �ִ� �κ� ������.', 'admin');
INSERT INTO lunch(lunch_code, lunch_name, img, price, spec, id)
VALUES(lunch_code, '���', 'm1_l2.gif', 3800, '������ �����ϴ� ���!
�ٻ�Ƣ�ܳ� Ƣ��ʾȿ� ������ ��⸦ ���� �����
�������� ����Ե�  ��� ������ȭ�� �κ� ������.
�ҽ����� �����ݴϴ�.', 'admin');
COMMIT;
SELECT * FROM lunch;
------------------- Data for table ordering ------------------------------
INSERT INTO ordering(order_num, quan, order_name, phone, ip_address, lunch_code)
VALUES(order_code, 1, '������', '010-3456-4567', '211.63.89.132', 'L_00000002');
INSERT INTO ordering(order_num, quan, order_name, phone, ip_address, lunch_code)
VALUES(order_code, 3, '������', '010-5436-2455', '211.63.89.157', 'L_00000001');
INSERT INTO ordering(order_num, quan, order_name, phone, ip_address, lunch_code)
VALUES(order_code, 1, '������', '010-2314-8781', '211.63.89.135', 'L_00000002');
COMMIT;
