-- USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 2022년 10월에 작성된 게시글 제목, 게
-- 시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요. 결과는 
-- 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차
-- 순 정렬해주세요.

-- 열 이름을 잘 확인해야겠다. 
SELECT USED_GOODS_BOARD.title,USED_GOODS_BOARD.board_id,USED_GOODS_REPLY.reply_id,USED_GOODS_REPLY.writer_id,USED_GOODS_REPLY.contents,date_format(USED_GOODS_REPLY.created_date,'%Y-%m-%d')as created_date
from USED_GOODS_board join USED_GOODS_REPLY
on USED_GOODS_board.board_id=USED_GOODS_REPLY.board_id
where 
    date_format(USED_GOODS_BOARD.created_date,'%Y-%m')='2022-10'
order by USED_GOODS_REPLY.created_date,USED_GOODS_board.title;
-- 정답!



-- CAR_RENTAL_COMPANY_CAR 테이블에서 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금을 출
-- 력하는 SQL문을 작성해주세요. 이때 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림하고, 컬럼명은 
-- AVERAGE_FEE 로 지정해주세요.

-- 문제를 꼼꼼히 읽어야겠다.
SELECT round(avg(daily_fee),0)as'AVERAGE_FEE' from car_rental_company_car
where car_type='suv';




-- BOOK 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서 도서
-- ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력하는 SQL문을 작성해주세요.
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요.

-- 날짜포맷을 변경하는 것에 익숙해지고 있다.
SELECT book_id,date_format(published_date,'%Y-%m-%d')as published_date
from book 
where date_format(published_date,'%Y')='2021' and category='인문'
order by published_date;






-- 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 
-- 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.

-- 열 이름을 잘 확인할 것
SELECT FIRST_HALF.flavor from ICECREAM_INFO left join FIRST_HALF
on FIRST_HALF.flavor=ICECREAM_INFO.flavor
where FIRST_HALF.total_order>3000 and ICECREAM_INFO.INGREDIENT_TYPE='fruit_based'
order by FIRST_HALF.total_order desc;




-- 상반기에 판매된 아이스크림의 맛을 총주문량을 기준으로 내림차순 정렬하고 총주문량이 같다면 출하 번
-- 호를 기준으로 오름차순 정렬하여 조회하는 SQL 문을 작성해주세요.

-- 문제를 꼼꼼히 읽자
SELECT flavor from first_half
order by total_order desc, shipment_id;





-- DOCTOR 테이블에서 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용
-- 일자를 조회하는 SQL문을 작성해주세요. 이때 결과는 고용일자
-- 를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬해주세요.
SELECT dr_name,dr_id,mcdp_cd,date_format(hire_ymd,'%Y-%m-%d')as hire_ymd from doctor
where mcdp_cd='cs' or mcdp_cd='gs'
order by hire_ymd desc, dr_name;




-- PATIENT 테이블에서 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회하
-- 는 SQL문을 작성해주세요. 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고 결과는 나이를 기준
-- 으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬해주세요.

-- 문제 꼼꼼히 읽기
SELECT pt_name,pt_no,gend_cd,age,ifnull(tlno,'NONE')as'tlno' from patient
where age<=12 and gend_cd='w'
order by age desc, pt_name;




-- USER_INFO 테이블에서 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출
-- 력하는 SQL문을 작성해주세요.

-- between 형식을 대략적으로 알고 있었는데 이번에 한번 바로잡았다.
SELECT count(user_id) from user_info 
where 
    date_format(joined,'%Y')='2021'and
    age between 20 and 29;
    
    
    
    
-- FOOD_FACTORY 테이블에서 강원도에 위치한 식품공장의 공장 ID, 공장 이름, 주소를 조회하는 SQL문을
-- 작성해주세요. 이때 결과는 공장 ID를 기준으로 오름차순 정렬해주세요.

-- like+'%'로 문자열 검색하는 것 잠시 잊고 있다가 스스로 기억해냄~

SELECT factory_id,factory_name,address
from food_factory
where address like '강원도%'
order by factory_id;




-- 동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL 문을 작성해주세요.
SELECT name from animal_ins
order by datetime limit 1;






-- 동물 보호소에 들어온 모든 동물의 아이디와 이름, 보호 시작일을 이름 순으로 조회하는 SQL문을 작성해
-- 주세요. 단, 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 합니다.
SELECT animal_id,name,datetime from animal_ins
order by name, datetime desc;





-- 동물 보호소에 들어온 모든 동물의 아이디와 이름을 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요. 
-- SQL을 실행하면 다음과 같이 출력되어야 합니다.
SELECT animal_id,name from animal_ins
order by animal_id;




-- 동물 보호소에 들어온 동물 중 젊은 동물1의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과
-- 아이디 순으로 조회해주세요.

-- aged가 아닌 걸 뭘로 표현할까 고민하다가 not도 사용해 봤는데
-- <> 꺾쇄 표시가 기억나서 사용했더니 정답~
SELECT animal_id,name from animal_ins
where intake_condition<>'aged'
order by animal_id;





-- 동물 보호소에 들어온 동물 중 아픈 동물1의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과
-- 는 아이디 순으로 조회해주세요.
SELECT animal_id,name from animal_ins
where intake_condition ='sick'
order by animal_id;





-- 동물 보호소에 들어온 모든 동물의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 
-- ANIMAL_ID 역순으로 보여주세요. SQL을 실행하면 다음과 같이 출력되어야 합니다.
SELECT name,datetime from animal_ins
order by animal_id desc;




-- 동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요. SQL을
-- 실행하면 다음과 같이 출력되어야 합니다.
SELECT * from animal_ins order by animal_id;




-- ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 재구매한 회원 ID와 
-- 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 결과는 회원 ID를 기준으로 오름차순 정렬해주시고 
-- 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.

-- group by를 사용할까 했다. where에는 count()를 사용할 수 없으니까.
-- 아직 익숙치 않은듯!
SELECT user_id,product_id from online_sale
group by user_id, product_id
having count(user_id)>=2
order by user_id,product_id desc;






-- MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 
-- 작성해주세요. 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으
-- 로 오름차순 정렬해주세요.

-- 데이터가 null인 경우 출력대상 제외하는 방법은 검색 후 사용했다.
-- 날짜에서 월만 지정할 때는 ''따옴표를 지정하지 않아도 된다는 것을 시도해 보고 알았다.
SELECT MEMBER_id,member_name,gender,date_format(date_of_birth,'%Y-%m-%d')as date_of_birth
from member_profile
where date_format(date_of_birth,'%m')=3 and gender='w' and tlno is not null
order by member_id;






-- ONLINE_SALE 테이블과 OFFLINE_SALE 테이블에서 2022년 3월의 오프라인/온라인 상품 판매 데이
-- 터의 판매 날짜, 상품ID, 유저ID, 판매량을 출력하는 SQL문을 작성해주세요. OFFLINE_SALE 테이블의
-- 판매 데이터의 USER_ID 값은 NULL 로 표시해주세요. 결과는 판매일을 기준으로 오름차순 정렬해주시
-- 고 판매일이 같다면 상품 ID를 기준으로 오름차순, 상품ID까지 같다면 유저 ID를 기준으로 오름차순 정렬
-- 해주세요.
