#SELECT

-- ONLINE_SALE 테이블과 OFFLINE_SALE 테이블에서 2022년 3월의 오프라인/온라인 상품 판매 데이
-- 터의 판매 날짜, 상품ID, 유저ID, 판매량을 출력하는 SQL문을 작성해주세요. OFFLINE_SALE 테이블의 
-- 판매 데이터의 USER_ID 값은 NULL 로 표시해주세요. 결과는 판매일을 기준으로 오름차순 정렬해주시
-- 고 판매일이 같다면 상품 ID를 기준으로 오름차순, 상품ID까지 같다면 유저 ID를 기준으로 오름차순 정렬
-- 해주세요.

-- group으로 시도했다가 다른 유저들이 남긴 답에 union all이라는 걸 보고 시도해 봄.
-- UNION ALL:모든 컬럼값이 같은 ROW도 결과로 보여준다. 중복제거 하지 않는다.
SELECT date_format(SALES_DATE,'%Y-%m-%d')as sales_date,product_id,user_id,sales_amount
from  online_sale
WHERE sales_date >= '2022-03-01' and sales_date < '2022-04-01'

union all

SELECT date_format(SALES_DATE,'%Y-%m-%d'),product_id,null as 'user_id', sales_amount
from  offline_sale
WHERE sales_date >= '2022-03-01' and sales_date < '2022-04-01'
order by SALES_DATE,product_id,user_id
;








-- REST_INFO와 REST_REVIEW 테이블에서 서울에 위치한 식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨
-- 찾기수, 주소, 리뷰 평균 점수를 조회하는 SQL문을 작성해주세요. 이때 리뷰 평균점수는 소수점 세 번째 자
-- 리에서 반올림 해주시고 결과는 평균점수를 기준으로 내림차순 정렬해주시고, 평균점수가 같다면 즐겨찾
-- 기수를 기준으로 내림차순 정렬해주세요.

-- 조회 후 결과값이 1개만 나와서 알아 보니 group by를 해야 한다고 한다.
-- GROUP BY를 하게 되면 해당 식당에 대한 리뷰들이 모여서 평균을 내게 되고, GROUP BY를 하지 않으면 
-- 서울에 존재하는 모든 식당의 평균을 구하게 됩니다.
-- 해당 문제는 리뷰 점수의 평균을 구하는 문제입니다.
-- LEFT JOIN 을 하면 오른쪽 테이블에 값이 null 이어도 값이 붙어버려서 의미없는 값이 뻥튀기가 되어버립
-- 니다. 따라서 평균이 맞게 구해지지 않습니다. LEFT JOIN을 하실 거면 WHERE 절에서 점수가 null 인 것을 제
-- 거하시면 됩니다.
SELECT 
    rest_info.rest_id,rest_info.rest_name,rest_info.food_type,
    rest_info.favorites,rest_info.address,
    round(avg(rest_review.review_score),2)as score
from rest_info left join rest_review
on rest_info.rest_id=rest_review.rest_id
where rest_info.address like ('서울%') 
        and rest_review.review_score is not null
group by rest_info.address
order by round(avg(rest_review.review_score),2)desc,rest_info.favorites desc;
#SELECT 끝!









#SUM, MAX, MIN
-- FOOD_PRODUCT 테이블에서 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가
-- 격을 조회하는 SQL문을 작성해주세요.
SELECT * from food_product 
order by price desc limit 1;




-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
SELECT datetime from animal_ins order by datetime desc limit 1;




-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주
-- 세요. 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.

-- count 함수에 컬럼 이름을 넣으면 NULL 값은 카운트 하지 않습니다.
SELECT  count(distinct name) from animal_ins;




-- PRODUCT 테이블에서 만원 단위의 가격대 별로 상품 개수를 출력하는 SQL 문을 작성해주세요. 이때 
-- 컬럼명은 각각 컬럼명은 PRICE_GROUP, PRODUCTS로 지정해주시고 가격대 정보는 각 구간의 최소
-- 금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시해주세요. 결과는 가격대를 기준
-- 으로 오름차순 정렬해주세요.
SELECT price-price%10000 as price_group,count(*) 
from product
group by price_group
order by price_group;





-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 각 시간
-- 대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해
-- 야 합니다.
SELECT hour(DATETIME)as hour,count(*)
from animal_outs
where hour(DATETIME) between 9 and 19
group by date_format(datetime,"%H") order by hour;




-- 동물 보호소에 들어온 동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작
-- 성해주세요. 이때 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회해주세요.
SELECT name, count(name)as count from animal_ins
group by name
having count>1
order by name;




-- 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고
-- 양이를 개보다 먼저 조회해주세요.
SELECT animal_type,count(animal_type) from animal_ins
group by animal_type
order by animal_type;



-- CAR_RENTAL_COMPANY_CAR 테이블에서 '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 
-- 자동차가 자동차 종류 별로 몇 대인지 출력하는 SQL문을 작성해주세요. 이때 자동차 수에 대한 컬럼명은 
-- CARS로 지정하고, 결과는 자동차 종류를 기준으로 오름차순 정렬해주세요.

-- 문장이 여러개 있을 땐 %%로 잘 덮어 줘야 검색되는 거 기억하기
SELECT car_type, count(*)as cars from car_rental_company_car
where OPTIONS like '%통풍시트%' or OPTIONS like'%열선시트%' or OPTIONS like'%가죽시트%'
group by car_type
order by car_type;






-- APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해
-- 주세요. 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 결과는 진료과별 예약한 환자 수를 기
-- 준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요.

-- date_format()잘 확인
SELECT mcdp_cd as 진료과코드, count(apnt_no)as 5월예약건수 from appointment
where date_format(apnt_ymd,'%Y-%m')='2022-05'
group by mcdp_cd
order by 5월예약건수, 진료과코드;



-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서
-- 대로 조회하는 SQL 문을 작성해주세요. 이때 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해주
-- 세요.
SELECT icecream_info.ingredient_type,sum(first_half.total_order) as total_order
from icecream_info left join first_half
on icecream_info.flavor=first_half.flavor
group by icecream_info.ingredient_type
order by total_order;