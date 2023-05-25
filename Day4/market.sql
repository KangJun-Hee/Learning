-- create database market;
-- use market;

-- 사용자
CREATE TABLE users(
  id     int  AUTO_INCREMENT PRIMARY KEY, -- PK
  email    VARCHAR(60) UNIQUE,      -- 이메일
  nickname VARCHAR(30)              -- 닉네임
);
-- 주문
CREATE TABLE orders(
  id        int AUTO_INCREMENT PRIMARY KEY,  -- PK
  status     VARCHAR(15),                      -- 주문 상태
  created_at TIMESTAMP,                      -- 주문시각
  user_id   integer      REFERENCES users(id) -- FK: 주문 사용자
);
-- 결제
CREATE TABLE payments(
  id     int AUTO_INCREMENT PRIMARY KEY,          -- PK
  amount   int,                          -- 결재액
  ptype    VARCHAR(30),                      -- 결제 종류
  order_id INTEGER     REFERENCES orders(id) -- FK: 결제된 주문
);
-- 상품
CREATE TABLE products(
  id    int AUTO_INCREMENT PRIMARY KEY, -- PK
  name  VARCHAR(60),             -- 상품명
  price int,                 -- 가격
  ptype VARCHAR(15)              -- 상품 종류
);
-- 주문내역
CREATE TABLE order_details(
  id int AUTO_INCREMENT PRIMARY KEY,                      -- PK
  order_id INTEGER REFERENCES orders(id),     -- FK: 연관된 주문
  product_id INTEGER REFERENCES products(id), -- FK: 연관된 상품
  count int                               -- 주문 개수
);


-- 사용자
INSERT INTO
users(email, nickname)
VALUES
('sehongpark@cloudstudying.kr', '홍팍'),
('kuma@cloudstudying.kr', '쿠마'),
('hawk@cloudstudying.kr', '호크')
;

-- 주문
INSERT INTO
orders(status, created_at, user_id)
VALUES
('DELIVERED', '2021-11-12 5:07:12', 1),
('DELIVERED', '2021-11-17 22:14:54', 1),
('DELIVERED', '2021-11-24 19:13:46', 2),
('DELIVERED', '2021-11-29 23:57:29', 3),
('DELIVERED', '2021-12-06 22:25:13', 3),
('DELIVERED', '2022-01-02 13:04:25', 2),
('DELIVERED', '2022-01-06 15:45:51', 2),
('DELIVERED', '2022-02-13 17:55:35', 1),
('DELIVERED', '2022-02-28 17:50:14', 2),
('IN_CART', '2022-03-06 14:54:23', 1)
;

-- 결제
INSERT INTO
payments(amount, ptype, order_id)
VALUES
(33640, 'SAMSUNG CARD', 1),
(33110, 'SAMSUNG CARD', 2),
(31200, 'LOTTE CARD', 3),
(69870, 'KAKAO PAY', 4),
(32800, 'KAKAO PAY', 5),
(42210, 'LOTTE CARD', 6),
(46060, 'LOTTE CARD', 7),
(42520, 'SAMSUNG CARD', 8),
(23070, 'LOTTE CARD', 9)
;

-- 상품
INSERT INTO
products(name, price, ptype)
VALUES
('돈까스 8입 1kg', 12900, '냉장 식품'),
('우유 900mL', 1970, '냉장 식품'),
('채소 믹스 500g', 4990, '냉장 식품'),
('참치마요 120g',4400,'냉장 식품'),
('돼지 프랑크 360g',3900,'냉장 식품'),
('달걀감자 샐러드 500g',6900,'냉장 식품'),
('달걈듬뿍 샐러드 500g',6900,'냉장 식품'),
('크림치즈',2180,'냉장 식품'),
('김자반 볶음 50g + 50g',3000,'상온 식품'),
('신라면 멀티 5봉',3680,'상온 식품'),
('우유식빵',2900, '상온 식품'),
('야채참치 100g',1590, '상온 식품'),
('고추참치 85g 8캔',10800,'상온 식품'),
('간편 양배추 280g',2200, '냉장 식품'),
('샐러드 키트 6봉',8900,'냉장 식품'),
('직화구이 햄',2990,'냉장 식품'),
('비앤나 소시지 800g',6900,'냉장 식품'),
('무항생제 특란 20구',7200,'냉장 식품'),
('나가사키짬뽕 5입',4480,'상온 식품'),
('수제 크림치즈 200g',9000,'냉장 식품'),
('한돈 떡갈비',3100,'냉장 식품'),
('플레인 베이글',1300,'냉장 식품'),
('노브랜드 리얼 햄 1kg',7380,'냉장 식품'),
('짜파게티 멀티 5봉',3680,'상온 식품'),
('짜왕 멀티 4봉',5300,'상온 식품'),
('노브랜드 짜장라면 멀티 4봉',2280,'상온 식품')
;

-- 주문내역
INSERT INTO
order_details(order_id, product_id, count)
VALUES
(1, 22, 6),
(1, 20, 1),
(1, 2, 2),
(1, 1, 1),
(2, 2, 3),
(2, 20, 1),
(2, 11, 2),
(2, 21, 4),
(3, 18, 1),
(3, 19, 1),
(3, 10, 1),
(3, 2, 2),
(3, 20, 1),
(3, 11, 1),
(4, 15, 1),
(4, 7, 1),
(4, 1, 1),
(4, 9, 4),
(4, 12, 6),
(4, 16, 1),
(4, 17, 1),
(4, 2, 2),
(4, 11, 2),
(5, 11, 2),
(5, 20, 1),
(5, 14, 1),
(5, 15, 1),
(5, 7, 1),
(6, 10, 1),
(6, 3, 1),
(6, 1, 1),
(6, 2, 2),
(6, 6, 1),
(6, 7, 1),
(6, 11, 1),
(7, 4, 1),
(7, 12, 10),
(7, 13, 1),
(7, 14, 1),
(7, 2, 1),
(7, 3, 1),
(7, 11, 2),
(8, 8, 1),
(8, 5, 1),
(8, 2, 2),
(8, 11, 2),
(8, 1, 1),
(8, 6, 1),
(8, 7, 1),
(9, 11, 1),
(9, 4, 1),
(9, 2, 1),
(9, 6, 1),
(9, 7, 1),
(10, 1, 1),
(10, 2, 2),
(10, 5, 1),
(10, 8, 1)
;

-- 1. 홍팍이의 모든 주문 목록은?
select order_details.* from order_details 
join products on 
	order_details.product_id=products.id
join users on
	order_details.order_id=users.id
where users.id=1;
-- 2. 홍팍이의 모든 주문 횟수는?
select count(order_id) from order_details
join users
on order_details.order_id=users.id
where users.id=1;
-- 3. 홍팍이의 모든 주문별 결제 금액을 다음과 같이 조회하시오.
-- 각각의 테이블에서 users 테이블과 orders테이블을 먼저 조인해서 
-- 결제 금액은 payments에 있으니 3개의 테이블을 연결해서 데이터를 가지고 와야된다. 
select 
	users.nickname as "주문자명",
    orders.id as "주문번호" ,
    payments.amount as "결제 금액" # 우선 전체적으로 확인 해보고 원하는 내용만 가지고 오기
from users join orders
on orders.user_id = users.id
and users.nickname ='홍팍'
left join payments on 
	payments.order_id = orders.id
;

-- 4. 홍팍이의 총 결제 금액은?
select sum(order_details.count*products.price)as'총결제액'
from products
join order_details
on products.id=order_details.product_id
join users
on order_details.order_id=users.id
where users.id=1;
-- 5. 상품#1 돈까스의 총판매 금액은 64,500원이다. 이를 쿼리를 통해 조회하시오
select sum(order_details.count*products.price)
from order_details
join products
on order_details.product_id=products.id
where order_details.product_id=1;

-- 6. 주문#10 장바구니에 담긴 상품들의 총합은?
-- select sum()
-- 7. 상품#11 우유식빵의 총 판매 금액은?
select sum(order_details.count*products.price)
from order_details
join products
on order_details.product_id=products.id
where order_details.product_id=11;
-- 8. 쿠마가 구매한 모든 상품 목록들 중, 다음을 조회하시오.
select users.nickname as '구매자명',products.name as'상품명',
products.price as'가격',order_details.count as'주문수량'
from order_details
join products
on order_details.product_id=products.id
join users
on order_details.order_id=users.id
where users.id=2;
-- 9. 호크가 구매한 모든 상품의 총 구매 가격은?
select sum(order_details.count*products.price)as'총구매액'
from order_details join products
on order_details.product_id=products.id
join users
on order_details.order_id=users.id
where users.id=3;
-- 10. 호크가 결제한 총 금액은?
select sum(order_details.count*products.price)
from order_details left join products
on order_details.product_id=products.id
where order_details.order_id=3;


-- having 분류된 그룹중 특정 조건을 만족하는 것만 가져오기~
-- 	그룹이 꼭 되어있어야 한다!

-- limit 조회 개수 제한하기
-- 	정렬이랑 같이 많이 쓰인다. 가져올 레코드(필드) 수를 제한하는 것!

-- 결제(payments)테이블에서 수단별 평균 결제금액이 다음과 같을 때,
-- 	평균 결제금액이 36,000원 이상인 것만 조회하시옹
select ptype as'결제수단', round(avg(amount),2) as'평균 결제금액' from payments
group by ptype 
having avg(amount)>=36000; -- 조건!
-- 상품명과 가격을 기준으로 누적판매정보(판매량,매출)를 조회한다.
select products.name as'상품명',
products.price as'가격',
sum(order_details.count)as'누적판매량',
sum(products.price*order_details.count)as'누적매출'
from products
left join order_details
on order_details.product_id=products.id
group by products.name,products.price;
-- 누적 매출이 35,000원 이상인 상품을 조회
select products.name as'상품명',
products.price as'가격',
sum(order_details.count)as'누적 판매량',
sum(order_details.count*products.price)as'누적 매출'
from order_details join products
on order_details.product_id=products.id
group by products.price,products.name
having sum(order_details.count*products.price)>=35000;

-- 누적 매출이 20000원 이상,누적판매량도 10개 이상인 상품을 조회
select
products.name as'상품명',
products.price as'가격',
sum(order_details.count)as'누적 판매량',
sum(order_details.count*products.price)as'누적매출'
from products left join order_details
on order_details.product_id=products.id
group by products.name,products.price
having 
	sum(order_details.count*products.price)>=20000
	and sum(order_details.count)>=10
;
-- 누적매출이 없는 제품을 가격을 기준으로 오름차순 정렬해 조회
select 
products.name as'상품명',
products.price as '가격',
sum(order_details.count)as'누적판매량',
sum(order_details.count*products.price)as'누적매출'
from products left join order_details
on order_details.product_id=products.id
group by products.name,products.price
having sum(order_details.count)is null
and sum(order_details.count*products.price)is null
order by products.price;
-- 누적매출 상위 5개 상품을 조회하시오
select 
products.name as'상품명',
products.price as'가격',
sum(order_details.count)as'누적 판매량',
sum(order_details.count*products.price)as'누적매출'
from products left join order_details
on products.id=order_details.product_id
group by products.name,products.price
order by sum(order_details.count*products.price)desc
limit 5;
-- 누적판매량 상위 5개 상품을 조회하시오
select 
products.name as'상품명',
products.price as'가격',
sum(order_details.count)as'누적판매량',
sum(order_details.count*products.price)as'누적 매출'
from products left join order_details
on products.id=order_details.product_id
group by products.name,products.price
order by sum(order_details.count) desc -- 내림차순
limit 5;
-- 가격 하위5개 상품의 누적매출을 조회하쇼
select
products.name as'상품명',
products.price as'가격',
sum(order_details.count)as'누적 판매량',
sum(order_details.count*products.price)as'누적 매출'
from products left join order_details
on products.id=order_details.product_id
	-- 그룹거는이유:같은값가진행끼리 그룹으로 뭉쳐줌.
	-- 나는 상품명,상품가격으로 묶음. 왜냐! 상품id랑
    -- 주문내역의 상품id를 동일시했으니 주문내역에 있는
    -- 플레인베이글들을(여러사람들or여러개주문햇으니까)
    -- 합쳐서(그룹화)해서 '누적'판매량을 구하니까~
    -- A가 주문한 베이글,B가주문한베이글 합쳐서(그룹화)
    -- 해야 '총, 누적'판매량 구할 수 있으니까~
group by products.name,products.price
order by products.price
limit 5;