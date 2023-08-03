create table account(
	id varchar(10),
    balance int
);
insert into account values("A",1000000);
insert into account values("B",1000000);

select * from account;

start transaction; -- transaction 실행하겠다~
update account set balance = balance - 0 where id = 'A';
update account set balance = balance + 2000000 where id = 'B';

commit; -- 지금까지 작업한 내용을 DB에 영구적으로 저장하라!
		-- 트랜잭션 끝내라~ 종료~
        -- @Autocommit:각각 sql문을 자동으로 트랜잭션될 수 있게
			-- 처리해 주는 기능 
            -- sql문 성공적으로 실행되면 자동으로 commit,
            -- 실행중 에러나면 알아서 rollback
            -- MySQL은 기본적으로 autocommit되어있다
select @@autocommit; -- 확인해서 1이면 자동실행중
set autocommit = 0; -- 비활성화하고 싶으면 0으로 수정
use pos;