-- create database tables;
-- use tables;
drop table book;
create table Book(
	bookid int, bookname varchar(30), publisher varchar(15), price int
);
-- create table Customer(
-- 	custid int, name varchar(4), address varchar(20), phone varchar(13)
-- );
-- create table Orders(
-- 	orderid int, custid int, bookid int, saleprice int, orderdate datetime
-- );

insert into Book values(1,'축구의 역사','굿스포츠',7000);
insert into Book values(2,'축구 아는 여자','나무수',13000);
insert into Book values(3,'축구의 이해','대한미디어',22000);
insert into Book values(4,'골프 바이블','대한미디어',35000);
insert into Book values(5,'피겨 교본','굿스포츠',8000);
insert into Book values(6,'역도 단계별기술','굿스포츠',6000);
insert into Book values(7,'야구의 추억','이상미디어',20000);
insert into Book values(8,'야구를 부탁해','이상미디어',13000);
insert into Book values(9,'올림픽 이야기','삼성당',7500);
insert into Book values(10,'Olympic Champions','Pearson',13000);

-- insert into Customer values(1,'박지성','영국 맨체스터','000-5000-0001');
-- insert into Customer values(2,'김연아','대한민국 서울','000-6000-0001');
-- insert into Customer values(3,'장미란','대한민국 강원도','000-7000-0001');
-- insert into Customer values(4,'추신수','미국 클리블랜드','000-8000-0001');
-- insert into Customer values(5,'박세리','대한민국 대전','');

-- insert into Orders values(1,1,1,6000,'2020-07-01');
-- insert into Orders values(2,1,3,21000,'2020-07-03');
-- insert into Orders values(3,2,5,8000,'2020-07-03');
-- insert into Orders values(4,3,6,6000,'2020-07-04');
-- insert into Orders values(5,4,7,20000,'2020-07-05');
-- insert into Orders values(6,1,2,12000,'2020-07-07');
-- insert into Orders values(7,4,8,13000,'2020-07-07');
-- insert into Orders values(8,3,10,12000,'2020-07-08');
-- insert into Orders values(9,2,10,7000,'2020-07-09');
-- insert into Orders values(10,3,8,13000,'2020-07-10');

# Sql기능에 따른 분류
# 데이터 정의어(DDL)
# 	테이블이나 관계의 구조를 생성하는데 사용.
#	create, alter, drop

# 데이터 조작어(DML)
#	테이블에 데이터를 삽입,수정,검색하는데 사용.
#	select, insert, delete, update

# 데이터 제어어(DCL)
#	데이터의 사용권한을 관리하는데 사용
#	Grant, revoke문

# 키워드
# select : 질의결과 추출되는 속성리스트를 열거한다.
# from : 질의에 어느 테이블이 사용되는지 열거한다.
# where : 질의의 조건을 작성한다.
# distinct : 중복제거!
# between : 
# in : 
# not :
# order by : 정렬(기본이 오름차순임)
#	desc : 내림차순 정렬
#	asc : 오름차순 정렬지정
# sum() : 집계함수
# as : 새로운 column명 지정, 별칭같은 것.
# min(column명), max() : 최솟값최댓값 구함
# round(값,자릿수) : 괄호안에 실수 넣으면 소수점 반올림해서 표현
# now() : 현재 시간과 날짜를 변환
#	curdate() : 날짜만 반환
#	curtime() : 시간만 반환
#	date() : '전달받은' 값에 해당하는 날짜정보를 반환
#	month() : 			서 월만 반환 0~12의 값을 가짐.
#	day() : 			서 일만 반환 0~31의 값을 가짐.
#	hour() :			서 시만 반환 0~23사이의 값 가짐.
#	minute() :			서 분만 반환 0~59사이 값을 가짐.
#	second() :			서 초만 반환 0~59사이 값
# monthname() : 월을 영어로 ex: April
# dayname() :요일 영어로 ex: friday
# dayofweek() : 해당주에서 몇번째 날인지 반환. 일요일=1 토요일=7;
# dayofmonth(): 해당월에서 몇번째 날인지 반환. 1~31
# dayofyear() : 해당 연도에서 몇번째 날인지 반환. 1~365 사이;
# count() : 갯수 세는 
# group by : 그룹을 지어 줄 필드명!

# [속성] : 예약어를 사용할 수 있다.

-- 김연아 고객의 전화번호를 찾으시오!
-- select phone from customer where name = '김연아';

-- 출판사 명을 가지고 온다. 단! 중복되는 이름 제거하고 출력!
-- select distinct publisher from Book;

-- 가격이 10000원 이상 20000원 이하 도서를 검색하시오
-- select * from Book where price between 10000 and 20000;

-- 출판사가 굿스포츠 혹은 대한미디어인 도서를 검색하시오
-- select * from Book where publisher in('굿스포츠','대한미디어');
-- 출판가 굿스포츠 혹은 대한미디어가 '아닌' 도서를 검색하시오
-- select * from Book where publisher not in('굿스포츠','대한미디어');

-- 도서이름에 축구가 포함된 출판사를 검색하시오!
-- select publisher from book where bookname like '%축구%';

# 정렬
# 키워드 order by
-- select * from Book order by bookname;

-- 도서를 가격순으로 검색하고 가격이 같으면 이름순으로 검색하시오!
-- select * from Book order by price,bookname;
-- 도서를 가격의 내림차순으로 검색하시오 가격이 같다면 출판사의 오름차순으로 검색하시오!
-- select * from Book order by price desc, publisher asc;

# 집계함수
# 키워드 sum()
-- Book 테이블에 있는 도서의 총 판매액을 구하시오!
-- select sum(price) as '합계' from Book;

-- 도서의 최대가격, 최소가격을 구하시오~
-- select max(price) as '최대가',min(price) as '최소가', round(avg(price),0) as '평균가' from Book;

-- 날짜와 시간에 관한 정보 저장하기
-- select Date('2016-02-19 12:34:56'),
-- month('2016-02-19 12:34:56'),
-- day('2016-02-19 12:34:56'),
-- hour('2016-02-19 12:34:56'),
-- minute('2016-02-19 12:34:56'),
-- second('2016-02-19 12:34:56');

-- select * from orders;
-- -- Orders 테이블에서 총매출을 구하시오~
-- select sum(saleprice) as '총매출'from Orders;
-- -- Orders 테이블에서 2번 고객이 주문한 도서의 총 판매액을 구하시오!
-- select sum(saleprice) as '2번 고객 총 주문액'from Orders where custid = 2; 
-- -- 도서판매건수
-- select count(*) from Orders;
-- -- 고객별로 주문한 도서의 총수량,총판매액 구하시오!
-- select custid,
-- 	   count(*) as '도서수량',
--        sum(saleprice) as '총액'
-- from Orders group by custid;


-- 서점의 고객이 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
--   (1) 도서번호가 1인 도서의 이름
-- select * from Book;
-- select bookname from Book where bookid = 1;
-- --   (2) 가격이 20,000원 이상인 도서의 이름
-- select bookname from Book where price >=20000;
-- --   (3) 박지성의 총 구매액(박지성의 고객번호는 1번으로 놓고 작성)
-- select * from Orders;
-- select sum(saleprice) as '총구매액' from Orders where custid = 1; 
-- --   (4) 박지성이 구매한 도서의 수(박지성의 고객번호는 1번으로 놓고 작성)
-- select sum(custid) as '1번고객이 구매한 도서수' from Orders where custid=1;
-- -- 서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
-- -- (1) table Book의 도서 총 개수
-- select count(bookname) from book;
-- -- (2) table Book에 도서를 출고하는 출판사의 총 개수
-- select count(distinct publisher) from book;

-- -- (3) 모든 고객의 이름, 주소
-- select name,address from Customer;
-- -- (4) 2020년 7월 4일~7월 7일 사이에 주문 받은 도서의 주문번호
-- select * from Orders;
-- select orderid from Orders where orderdate between '2020-07-04'and'2020-07-07';
-- -- (5) 2020년 7월 4일~7월 7일 사이에 주문 받은 도서를 제외한 도서의 주문번호
-- select orderid from Orders where orderdate not between '2020-07-04'and'2020-07-07';
-- -- (6) 성이 ‘김’ 씨인 고객의 이름과 주소
-- select name,address from Customer where name like '김%';
-- -- (7) 성이 ‘김’ 씨이고 이름이 ‘아’로 끝나는 고객의 이름과 주소
-- select name,address from Customer where name like '김%아';



-- 두 개 이상 테이블 
select * from Customer, Orders;

-- 고객, 고객의 주문에 관한 데이터를 모두 구하시오!
select * from Customer, Orders where Customer.custid = Orders.custid;
-- 위의 내용을 정렬하기
select * from Customer, Orders where Customer.custid = Orders.custid
order by Customer.custid;
-- 고객별로 주문한 모든 도서의 총 판매액 구하고 고객별로 정렬하시오!
-- 김연아 15000
-- 박지성 39000 이런식
select name,sum(saleprice)as '총구매액' from Customer,Orders where Customer.custid=Orders.custid
group by Customer.name order by Customer.name;