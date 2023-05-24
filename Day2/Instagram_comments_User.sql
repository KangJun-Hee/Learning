-- create database Instagram;
-- use Instagram

-- 이메일,닉네임,아이디 저장
create table users(
	id int auto_increment primary key,-- pk선언:얘를 기본으로 할 거다~라고 하는 것.
    email varchar(100),
    nickname varchar(50)
);
create table photos(
	id int auto_increment primary key,-- pk선언
    filename varchar(255),
    user_id INTEGER REFERENCES users(id)-- fk : 사진 게시자의 pk로 연결
);
-- 게시글 좋아요!
create table comments(
	id int auto_increment primary key,-- pk선언
	body varchar(1000),
    user_id integer REFERENCES users(id),
    photos_id integer references photos(id)
    -- fk:댓글 작성자
    -- fk:댓글이 달린 사진
);

insert into 
users(email,nickname) 
values 
('empress8069@gmail.com','하이네쓔'),
('clinihi@gmail.com','클리니'),
('fofo@gmail.com','뽀로로');

insert into
photos(filename,user_id)
values('cat.png',1),('dog.png',1),('cat2.png',1),
('cat3.png',2),('dog3.png',2),('cat5.png',3);

insert into 
comments(body,user_id,photos_id)
values -- 1번 사진의 댓글들
('야옹',1,1),
('nyaong',2,1),
('뭐지?',3,1),
-- 2번 사진의 댓글들
('sunset',1,2),
('뭐지?',3,2),
-- 3번 사진의 댓글들
('덥다',1,3);

-- 일부만 변경 where 컬럼명 = 값;
-- update comments set photos_id = 2 where id =3;
-- values 다시 새로운 내용으로 넣으려면 걍 테이블 delete하고 넣어야 하는듯
-- delete table comments;


select * from users;
select * from comments;

-- 댓글을 가장 많이 작성한 유저는?
select user_id from comments 
group by user_id
order by count(user_id) desc limit 1;
-- 위 코드의 문제점. limit 1로 제한하였으므로 최대값을 지니는 attribute가 두 개 이상이어도 하나만 출력된다.



-- 사진을 게시한 유저는 모두 몇명?
select count(distinct photos_id) from comments where photos_id;
-- 3번 댓글이 달린 사진은?
select photos_id from comments where user_id=3;
-- 3번 댓글을 달린 사람 닉네임은?
select users.nickname from users inner join comments 
on users.id=comments.photos_id 
where user_id=3 group by users.nickname;


-- 다대다(M:N)
-- 양방향에서 모두 다수로 연결될 수 있다. 쇼핑몰
-- 여러가지 물건에 여러 사람이 접근할 수 있는 것!
-- 중간에 테이블을 두고 사람과 물건을 잇는 관계 그래서 FK
-- 2개가 필요하다
