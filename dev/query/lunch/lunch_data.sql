
------------------- Data for table lunch_admin ---------------------------
INSERT INTO lunch_admin(id, pass, name)
VALUES('admin','1234','오영근');
INSERT INTO lunch_admin(id, pass, name)
VALUES('lunch','1234','영근오');
INSERT INTO lunch_admin(id, pass, name)
VALUES('root','1234','영영영');
COMMIT;
------------------- Data for table lunch ---------------------------------
INSERT INTO lunch(lunch_code, lunch_name, img, price, spec, id)
VALUES(lunch_code, '포크칠리', 'm1_l1.gif', 4500, '돈까스와 떡갈비에 탕수육까지 환상의 조합으로
 다양한 맛을 느끼실 수 있는 부분 인지용.', 'admin');
INSERT INTO lunch(lunch_code, lunch_name, img, price, spec, id)
VALUES(lunch_code, '돈까스', 'm1_l2.gif', 3800, '누구나 좋아하는 돈까스!
바삭튀겨낸 튀김옷안에 숨겨진 고기를 한입 베어물면
오지마을 이장님도  울고갈 감동실화인 부분 인지용.
소스맛도 끝내줍니다.', 'admin');
COMMIT;
SELECT * FROM lunch;
------------------- Data for table ordering ------------------------------
INSERT INTO ordering(order_num, quan, order_name, phone, ip_address, lunch_code)
VALUES(order_code, 1, '김정윤', '010-3456-4567', '211.63.89.132', 'L_00000002');
INSERT INTO ordering(order_num, quan, order_name, phone, ip_address, lunch_code)
VALUES(order_code, 3, '공선의', '010-5436-2455', '211.63.89.157', 'L_00000001');
INSERT INTO ordering(order_num, quan, order_name, phone, ip_address, lunch_code)
VALUES(order_code, 1, '이재현', '010-2314-8781', '211.63.89.135', 'L_00000002');
COMMIT;
