/*
1. 아래와 같은 데이터를 저장할 수 있는 테이블을 생성한다.
 번호 - 숫자이며 5자리까지 입력
 이름 - 가변길이형이며 한글로 10자까지 입력.
 성별 - 고정길이이며 영어로 1자 입력.
 주소 - 가변길이형이며 한글로 120자 까지입력.
 점수 - 숫자이며 3자까지 입력
 입력일 - 데이터가 추가되는 현재 일로 입력.
*/
CREATE TABLE personal_Info(
  num NUMBER(5),
  name VARCHAR2(15),
  sex CHAR(1),
  address VARCHAR2(360),
  score NUMBER(3),
  input_date DATE DEFAULT SYSDATE
);

 /*
2. 위 테이블에 아래와 같은 데이터를 추가한다.
  1, '김준호', 'M', '서울시 강남구 역삼동',64,오늘
  2, '김준현', 'M', '서울시 구로구 개봉동',87,오늘
  3, '오나미', 'F', '서울시 영등포구 여의도동',97,오늘
  4, '황재성', 'M', '서울시 동작구 상도동',100,오늘
  5, '유재석', 'M', '경기도 수원시 영통구',100,오늘
*/
INSERT INTO personal_Info
VALUES (1, '김준호', 'M', '서울시 강남구 역삼동', 64, SYSDATE);

INSERT INTO personal_Info (num, name, sex, address, score, input_date)
VALUES (2, '김준현', 'M', '서울시 구로구 개봉동', 87, SYSDATE);

INSERT INTO personal_Info
VALUES (3, '오나미', 'F', '서울시 영등포구 여의도동', 97, SYSDATE);

INSERT INTO personal_Info (input_date, score, address, sex, name, num)
VALUES (SYSDATE, 100, '서울시 동작구 상도동', 'M', '황재석', 4);

INSERT INTO personal_Info (score, sex, name, input_date, num, address)
VALUES (100, 'M', '유재석', SYSDATE, 5, '경기도 수원시 영통구');

/*
3. 위 입력된 데이터 중 에서 번호가 3번이며 점수가 97점인 사람의
    이름을 '테스트'로 성별을 'M'으로 변경한다.
*/
SAVEPOINT beforeHW4;

UPDATE 	personal_Info
SET     name='테스트', sex='M'
WHERE	num=3 AND score=97;

/*
4. 위의 데이터에서 이름이 '유재석'인 사람의성별을 'F'로 변경한다.
*/
UPDATE	personal_Info
SET		sex='F'
WHERE	name='유재석';  



/*
5. 4번의 작업을 취소한다.

6. 번호가 1번이며 이름이 김준현인 사람의 데이터를 삭제한다.

7. 모든 데이터를 절삭한다.

8. 테이블을 삭제한다.

9. 휴지통을 비운다.


*/
ROLLBACK;
SELECT * FROM personal_Info;
