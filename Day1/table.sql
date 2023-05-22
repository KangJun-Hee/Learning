-- 햄버거에 대한 정보를 저장하는 데이터베이스를 생성
-- 데이터베이스명:burgers
-- 테이블명:burger
-- 저장해야 하는 내용들: id(번호로) name price kcal
-- id int, name varchar(저장할공간크기),
-- prive int, kcal int

-- create database burgers;
-- use burgers;
-- create table burger(
-- 	id int,
--     name varchar(30),
--     price int,
--     kcal int
-- );

-- insert into burger values(1, "상하이버거", 4000, 1000);
-- insert into 
-- burger 
-- values
-- (2, "빅맥", 6000, 1050),
-- (3, "트리플치즈버거", 5700, 1100),
-- (4, "행운버거", 6800, 1200);

-- 전체 조회
select * from burger;

-- 일부 행들만 조회
select id from burger;
select name from burger;

-- 테이블 전체 구조를 확인
-- desc burger;

-- update 수정
-- 테이블명 set
set sql_safe_updates=0;
-- update burger set price = 1000;

-- 삭제
-- drop table burger;

-- 일부만 변경 where 컬럼명 = 값;
update burger set name = '상하이버거' where id = 2;

drop database members;