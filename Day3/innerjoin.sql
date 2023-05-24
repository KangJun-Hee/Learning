-- set sql_safe_updates = 0;
-- use instagram;

-- drop table likes;
-- drop table comments;
-- drop table photos;
-- drop table users;

-- join 
-- 	여러 테이블에서 가져 온 레코드를 조합하여 1개의 테이블로 결과를 집합
-- 	inner,left,right,full
-- 	조인하는 테이블의 on절의 조건이 일치하는 결과만 출력
-- 	from절에 콤마 쓰면 inner join으로 본다.
-- 	조인을 할 때 조건이 맞지 않으면, null값이 있을 경우는 데이터를 가져오지 않는다.

-- users 테이블
CREATE TABLE users (
  id       int AUTO_INCREMENT PRIMARY KEY,
  nickname VARCHAR(50),
  email    VARCHAR(100)
);
-- photos 테이블
CREATE TABLE photos (
  id       int AUTO_INCREMENT PRIMARY KEY,
  filename VARCHAR(255),
  user_id  INTEGER       REFERENCES users(id)
);
-- comments 테이블
CREATE TABLE comments (
  id       int AUTO_INCREMENT PRIMARY KEY,
  body     VARCHAR(1000),
  user_id  INTEGER        REFERENCES users(id),
  photo_id INTEGER        REFERENCES photos(id)
);
-- settings 테이블
CREATE TABLE settings (
  id           int AUTO_INCREMENT PRIMARY KEY,
  private       BOOLEAN,
  adding_photos VARCHAR(15),
  user_id       INTEGER      UNIQUE REFERENCES users(id)
);
-- likes 테이블 생성(사용자와 사진을 다대다 연결)
CREATE TABLE likes (
  id       int AUTO_INCREMENT PRIMARY KEY,
  user_id  INTEGER REFERENCES users(id),
  photo_id INTEGER REFERENCES photos(id)
);

-- users 레코드
INSERT INTO
  users(nickname, email)
VALUES
  ('cloudstudying_kr', 'mail@cloudstudying.kr'),
  ('hongpark_cs',      'sehongpark@cloudstudying.kr'),
  ('haesamq',          'haesamq@naver.com')
;
-- photos 레코드
INSERT INTO
  photos(filename, user_id)
VALUES
  ('cat-on-road.jpg',           1),
  ('sunset-over-the-ocean.jpg', 1),
  ('andromeda-galaxy.jpg',      1),
  ('white-tiger.jpg',           2),
  ('nero-the-black-cat.jpg',    2),
  ('deleted-image.jpg',         NULL),
  ('blocked-image.jpg',         NULL)
;
-- comments 레코드
INSERT INTO
  comments(body, user_id, photo_id)
VALUES
  ('meow',             1, 1),
  ('nyaong',           2, 1),
  ('냐옹',              3, 1),
  ('sunset',           1, 2),
  ('falling slowly',   2, 2),
  ('Andromeda galaxy', 1, 3),
  ('mysteriouse..!',   3, 3),
  ('wow..!',           3, NULL),
  ('oh..!',            3, NULL)
;
-- settings 레코드
INSERT INTO
  settings(private, adding_photos, user_id)
VALUES
  (FALSE, 'MANUAL', 1),
  (FALSE, 'AUTO',   2),
  (TRUE,  'AUTO',   3)
;
-- likes 레코드
INSERT INTO
  likes(user_id, photo_id)
VALUES
  (1,    1),
  (2,    1),
  (1,    2),
  (2,    2),
  (3,    2),
  (1,    3),
  (3,    3),
  (NULL, 6),
  (NULL, 7)
;
select * from users;
select * from photos;
select * from comments;
select * from settings;
select * from likes;

-- 사진 1번째 달린 모든 댓글내용과 작성자 닉네임을 조회하시오!
select comments.body, users.nickname-- 4.댓글내용,닉넴가져오기
from comments						-- 1.댓글포함 테이블가져오기
join users 							-- 2. 연결할 테이블
on users.id=comments.user_id
where comments.photo_id=1;			-- 3.연결한 테이블에서 조건
-- 5번 사진의 파일명, 게시자 닉네임 조회!
select photos.filename,users.nickname-- 원하는 정보
from photos							 -- 정보가져올 테이블
join users				 			 -- 연결할 테이블
on photos.user_id=users.id			 
where photos.id=5;					 -- 연결한 테이블에서 조건
-- 2번 사진의 파일명, 그 사진에 좋아요누른 사용자의 닉네임 조회!
-- 여러개 적는다. join on if문처럼 붙이기
select photos.filename,users.nickname-- 원하는 정보
from likes
join users on 						 -- 연결할 테이블
	users.id=likes.user_id			 -- 유저의아이디=좋아요누른아이디
join photos on						 -- !또 연결! 총 3개
	photos.id=likes.photo_id		 -- 이 사진=좋아요누름당한사진
where photos.id=2;					 -- 조건! 2번 사진




# 문제) cart테이블에서 buyer의 이름과 cart의 가격 가져오기
select distinct member.member_name,cart.buy_price from cart join member
on member.member_no=cart.cart_no;
# 문제) cart테이블에서 회원이 구매한 도서의 할인되기 전의 가격과 할인율 가져오기
select distinct book.book_price,book.book_discount_rate from cart join book
on cart.book_title=book.book_title;

# 문제) cart테이블에서 회원이 구매한 도서의 할인되기 전의 가격이 2만원 이상인 도서정보와 할인율 가져오기
select distinct book.* from cart join book 
on cart.book_title=book.book_title
where book.book_price>=20000;

-- use db2_book_store;
# 문제) cart테이블에서 buyer의 이름과 cart의 가격 가져오기
select member.member_name,cart.buy_price from cart join member
on member.member_no=cart.cart_no;
# 문제) cart테이블에서 회원이 구매한 도서의 할인되기 전의 가격과 할인율 가져오기
select book.book_price,book.book_discount_rate from cart join book
on cart.book_title=book.book_title;

# 문제) cart테이블에서 회원이 구매한 도서의 할인되기 전의 가격이 2만원 이상인 도서정보와 할인율 가져오기
select book.* from cart join book 
on cart.book_title=book.book_title
where book.book_price>=20000;

select * from cart order by cart_no;