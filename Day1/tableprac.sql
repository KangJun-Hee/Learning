-- create database book_store;
-- use book_store;

-- drop table book;

-- create table book(
-- 	title varchar(16),
--     price int,
--     publi varchar(16),
--     page int,
--     autho varchar(4),
--     pudate varchar(10)
-- );

-- insert into book values('낭만서점',14500,'북모닝',300,'김초엽','2023-04-31'),
-- ('작은 가능성에 대한 글쓰기',30000,'한국리터러시학회',260,'손혜숙','2022-04-30'),
-- ('공존을 기억하는 길',8900,'자이언트북스',350,'이희영','2022-06-30'),
-- ('지구 끝의 온실',13500,'고마요',310,'김초엽','2021-08-18'),
-- ('내게 남은 사랑을 드릴게요',14220,'자이언트북스',300,'이유리','2023-01-30');

select * from book;

-- update book set price = 10000 where title = '공존을 기억하는 길';
delete from book where title = '작은 가능성에 대한 글쓰기';
-- select title from book;

-- 필터링 연산자 사용하기
-- 비교연산자 
# >크다  <작다 
# >= 크거나 같다 <=작거나 같다
# <> 다르다 (주의!!!)
-- select * from book where price >= 14000;
-- select * from book where page >= 310;

-- 각 도서의 가격을 10% 인상한 금액을 출력
-- select title, price, price+price*0.1 from book;

-- select 20+20;

-- and
-- 출판사 이름이 뭐뭐이면서 저자 뭐뭐인 정보 가져오기
select * from book where publi = "자이언트북스" and autho = "이희영";

-- or
-- 출판사 명이 뭐뭐 또는 가격이 14000원 이상인 도서 가져오기
select * from book where publi = "고마오" or price >= 14000;

-- 출판사 뭐뭐이면서 쪽수가 300 이상인 책 이름만 가져오기
select * from book where publi="자이언트북스" and page >= 300;