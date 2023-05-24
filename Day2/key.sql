-- 데이터베이스끼리 관계성 주기 위해서 key를 설정
-- 가장 기본키 혹은 대표키(primary key)
-- 		예: 주민등록증 주민번호
-- 		설정시 중복이 되면 안된다. 유니크(unique)
-- 		저장할 때 값이 비어있으면 안 된다.(not null)

create database test2;
use test2;

create table test(
	id int primary key,
    pw int not null
);

insert into test values(111,111);
select * from test;

-- 외래키 혹은 외부키(foregin key) 테이블끼리 연결해서 사용하는 내용

-- auto_increment : 자동으로 값을 증가시킴
create table test2(
	id int not null auto_increment primary key,
	name varchar(100)
);