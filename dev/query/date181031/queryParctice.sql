-- 30일 숙제 복습
/*
  1. 배기량이 1500~3000사이인 차량의 제조국, 제조사,
       모델명, 연식, 가격, 이미지, 입력일, 배기량, 옵션을 조회
       단, 출력은 배기량의 내림차순 정렬했을 때 3~6번째 레코드만 조회하고,
       옵션은 처음 ',' 까지만 출력할 것.
       가격과 연식은 3자리마다 ','를 넣어 출력하고
       입력일은 월-일-년의 형식으로 출력할 것
*/

SELECT r, country, maker ,model, car_year,
	   TO_CHAR(price, '999,999') price, car_img,
	   TO_CHAR(hiredate,'mm-dd-yyyy') hiredate, TO_CHAR(cc,'999,999') cc,
	   SUBSTR(car_option, 1, INSTR(car_option, ',')-1) car_option
FROM  (SELECT ROWNUM r, country, maker, model, car_year, price, car_img,
      	      hiredate, cc, car_option
	   FROM(SELECT cc.country, cc.maker, cma.model, cmo.car_year, cmo.price,
			 	    cmo.car_img, cmo.hiredate, cmo.cc, cmo.car_option
		    FROM car_country cc, car_maker cma, car_model cmo
		 	WHERE cma.maker = cc.maker AND cmo.model = cma.model
		    ORDER BY cmo.cc DESC))
WHERE r BETWEEN 3 AND 6;

/*
  2. 부서번호가 10과 30번 40번인 모든 부서의 사원번호, 사원명, 입사일, 연봉,
     연봉순위, 부서명, 부서번호, 위치, 우편번호, 시도, 구군, 동, 번지를 조회할 것.
     (억지로) zipcode테이블은 사원번호와 seq가 같다는 조건으로 조인할 것
       단, 출력은 사원번호의 오름차순으로 정렬했을 때, 2~5번째 레코드만 출력할 것
     연봉순위는 2~5번째 레코드의 순위
     우편번호는 '-'뒤부터 끝까지 출력, 번지가 없다면 '번지없음'으로 대체하여 출력,
     입사일은 월-일-년 요일까지 출력
*/
SELECT r, empno, ename, TO_CHAR(hiredate, 'mm-dd-yyyy') hiredate,
	   sal, RANK() OVER(ORDER BY sal) rank,
	   dname, deptno,
	   loc, SUBSTR(zipcode,INSTR(zipcode,'-')+1) zipcode,
	   sido, gugun, dong, NVL(bunji, '번지없음')
FROM(SELECT ROWNUM r, empno, ename, hiredate, sal, dname, deptno,
		    loc, zipcode, sido, gugun, dong, bunji
	 FROM (SELECT e.empno, e.ename, e.hiredate, e.sal, d.dname, d.deptno,
				 d.loc, z.zipcode, z.sido, z.gugun, z.dong, z.bunji
		   FROM   emp e, dept d, zipcode z
	       WHERE (e.deptno(+) = d.deptno AND z.seq(+) = e.empno)
	       	 AND e.deptno IN (10,30, 40)
	       ORDER BY empno ASC))
WHERE r BETWEEN 2 AND 5;

/*
  3. 차량의 제조사가 '현대','기아',삼성','BMW','AUDI'이고 옵션에 'ABS','TCS'가 있는 차량의
     제조국, 제조사, 모델명, 연식, 가격, 옵션, 이미지, 배기량 조회
     단, 연식 내림차순 정렬, 연식이 같으면 가격의 내림차순으로 정렬하여 출력할 것
     이미지는 이미지명과 확장자를 구분하여 출력.('.'전, 후)
     제조사명이 영어라면 Bmw, Audi의 형식으로 출력
*/

SELECT cc.country, cc.maker, cma.model, cmo.car_year,
	   cmo.price, cmo.car_option,
	   SUBSTR(cmo.car_img,1,INSTR(cmo.car_img,'.')-1) img_name,
	   SUBSTR(cmo.car_img,INSTR(cmo.car_img,'.')+1) file_extension, cmo.cc
FROM  car_country cc, car_maker cma, car_model cmo
WHERE (cma.maker(+) = cc.maker AND cmo.model(+) = cma.model)
	AND cc.maker IN ('현대','기아','삼성','BMW','AUDI')
	AND cmo.car_option LIKE '%ABS%'
	AND cmo.car_option LIKe '%TCS%'
ORDER BY cmo.car_year DESC, cmo.price DESC;

/*
  4. 모델명이 'K5','아반테','소렌토','A8','SM3'인 차량의 모델명, 제조국, 제조사,
     가격, 연식 아래와 같은 형식의 문장으로 출력
     단, 출력은 가격의 오름차순으로 정렬했을 때 2~7번째 사이의 레코드만 출력
     [모델명] 차량의 연식은 [xxxx]이고, 제조국은 [국산|수입]이며, [xx]가 제조사입니다.
     가격은 [0,000,000]원입니다.
*/
SELECT r, model||' 차량의 연식은 '||car_year||'이고, 제조국은 '||country||'이며, '||
	   maker||'가 제조사입니다. 가격은 '||TO_CHAR(price,'0,000,000')||'원입니다.' output
FROM  (SELECT ROWNUM r, model, country, maker, price, car_year
	   FROM(SELECT cmo.model, cc.country, cc.maker, cmo.price, cmo.car_year
		    FROM car_country cc, car_maker cma, car_model cmo
            WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
			   AND cma.model IN ('K5','아반테','소렌토','A8','SM3')
		    ORDER BY price ASC))
WHERE r BETWEEN 2 AND 7;

/*
  5. 제조사가 '현대'인 차량의 연식, 모델명, 연식별 총 가격을 조회
*/

SELECT   cmo.car_year, cmo.model, SUM(price)
FROM     car_maker cma, car_model cmo
WHERE    (cmo.model = cma.model)
  AND    cma.maker = '현대'
GROUP BY ROLLUP(cmo.model, cmo.car_year);

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

SELECT e.empno, e.ename, e.hiredate, e.sal,
	   sal*0.033 tax, TRUNC(sal+(sal/12)+NVL(comm,0)-(sal*0.033),0) total,
	   TO_CHAR(DECODE(d.deptno, 10, sal*0.07,
	                            20, sal*0.04,
	   				  	        30, (sal+NVL(comm,0))*0.1,
	   				  	        sal*0.03), '999,999') s_inc,
	   d.deptno, d.dname, d.loc, z.zipcode, z.sido, z.gugun, z.dong, z.bunji
FROM   (SELECT *
		FROM emp
		WHERE ename LIKE '%S' OR ename LIKE '__A__') e,
		dept d, zipcode z
WHERE  (e.deptno = d.deptno AND z.seq = e.empno);

--------------------------------------------------------------------------------

/* 숙제 풀이 복습
숙제.
1. 배기량이 1500~3000 사이인 차량의 제조국,제조사,모델명,년식,가격,
    이미지,입력일,배기량, 옵션을 조회
   단. 출력은 배기량의 내림차순 정렬했을때 3~6번째 레코드만 조회하고,
     옵션은 처음 ',' 까지만 출력 할것. 가격과 연식은 3자리마다 ,를 넣어출력,
     입력일은 월-일-년 의 형식으로 출력 할것.
*/
SELECT r, country, maker, model, TO_CHAR(car_year,'999,999') car_year,
	   TO_CHAR(price, '999,999') price, car_img,
	   TO_CHAR(hiredate,'mm-dd-yyyy') hiredate, cc,
	   SUBSTR(car_option, 1, INSTR(car_option, ',')-1) car_option
FROM (SELECT ROWNUM r, country, maker, model, car_year, price, car_img,
	         hiredate, cc, car_option
	  FROM(SELECT cc.country, cc.maker, cma.model, cmo.car_year,
		    cmo.price, cmo.car_img, cmo.hiredate, cmo.cc, cmo.car_option
	       FROM car_country cc, car_maker cma, car_model cmo
	       WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
	       	AND cmo.cc BETWEEN 1500 AND 3000
	       ORDER BY cmo.cc DESC))
WHERE r BETWEEN 3 AND 6;
/*
3. 차량의 제조사가 '현대','기아','삼성','BMW','AUDI'이고 옵션에 'ABS'또는 'TCS'가
 있는 차량의  제조국, 제조사,모델명, 연식,가격, 옵션, 이미지, 배기량 조회
  --단, 연식의 내림차순 정렬하고, 연식이 같다면 가격의 내림차순으로 정렬
   하여 출력, 이미지는 이미지명과 확장자를 구분하여 출력할것,
   제조사명이 영어라면 Bmw, Audi 의 형식으로 출력 .
*/

SELECT cc.country, INITCAP(cc.maker) maker, cmo.car_year,
	   cmo.price, cmo.car_option,
	   SUBSTR(cmo.car_img,1,INSTR(cmo.car_img, '.')-1) i_name,
	   SUBSTR(cmo.car_img,INSTR(cmo.car_img, '.')+1) f_ext,
	   cmo.cc
FROM	car_country cc, car_maker cma, car_model cmo
WHERE	(cma.maker = cc.maker AND cmo.model = cma.model)
  AND   cc.maker IN ('현대','기아','삼성','BMW','AUDI')
  AND   (cmo.car_option LIKE '%ABS%'
   OR   cmo.car_option LIKE '%TCS%')
ORDER BY cmo.car_year DESC, cmo.price DESC;

/*
4. 모델명이 'K5','아반테', '소렌토','A8','SM3' 인 차량의 모델명, 제조국,
  제조사,가격,연식을 아래와 같은 형식의 문장으로 출력.
  단, 출력 가격의 오름차순을 정렬했을 때 2~7 사이의 레코드만 출력,
   [모델명] 차량의 연식은 [ xxxx ]이고, 제조국은 [국산|수입]이며,
   [XX]사가 제조사입니다. 가격은 [0,000,000]원 입니다.
*/

SELECT r, model||' 차량의 연식은 '||car_year||'이고, 제조국은 '||country||
	   '이며, '||maker||'가 제조사입니다. 가격은 '||TO_CHAR(price, '0,000,000')||
	   '원 입니다.' output
FROM(SELECT ROWNUM r, model, country, maker, price, car_year
	 FROM(SELECT cma.model, cc.country, cc.maker, cmo.price, cmo.car_year
	 	  FROM   car_country cc, car_maker cma, car_model cmo
		  WHERE  (cma.maker = cc.maker AND cmo.model = cma.model)
			 AND cma.model IN ('K5', '아반테', '소렌토', 'A8', 'SM3')
		  ORDER BY cmo.price ASC))
WHERE  r BETWEEN 2 AND 7;
/*
6. 사원명이 'S'로 끝나거나 이름5자이면서 세번째 글자가 'A'인
   사원의  사원번호, 사원명, 입사일,연봉,세금, 실수령액, 연봉인상액,
   부서번호,부서명,위치,우편번호,시도, 구군,동,번지 를 조회
   단,실수령액은 연봉+퇴직금+보너스-세금(연봉 3.3) 로 계산
     연봉인상액은 부서번호에 따라 차등 인상
     10- 년봉 7%, 20- 년봉 4%, 30- 년봉+보너스 10%, 그외 3%로
     계산하여 3자리마다 ,를 넣어 출력.
     모든 영어는 소문자로 출력.
*/

SELECT e.empno, LOWER(e.ename), e.hiredate, e.sal,
	   e.sal*0.033 tax,
	   TRUNC(e.sal+(e.sal/12)+NVL(e.comm,0)-(e.sal*0.33), 0) total,
	   TO_CHAR(DECODE(e.deptno, 10, e.sal*0.07,
	                  20, e.sal*0.04,
	                  30, (e.sal+NVL(e.comm,0))*0.1,
	                  e.sal*0.03), '999,999') s_inc,
       d.deptno, LOWER(d.dname), LOWER(d.loc),
       z.zipcode, z.sido, z.gugun, z.dong, z.bunji
FROM   emp e, dept d, zipcode z
WHERE  (e.deptno = d.deptno AND z.seq = e.empno)
   AND (ename LIKE '%S' OR ename LIKE '__A__');

-- 서브쿼리 안쓰고 풀 수 있음(서브쿼리는 일부분의 데이터를 가져올 때 사용!)