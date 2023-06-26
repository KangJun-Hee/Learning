#create database onlineBook;
#use onlineBook;

CREATE TABLE manager(
	id VARCHAR(50),
    pw VARCHAR(16),
    name VARCHAR(10),
    reg_date VARCHAR(50),
    address VARCHAR(100),
    tel VARCHAR(20)
);
DESC manager;
INSERT INTO manager VALUES('admin', '1111', '관리자', now(), '경기도 구리시 교문동', '010-1111-1111');

SELECT * FROM manager;
------------------------------------------------------------------------------------------------------------------
# 책정보 테이블
-- 쇼핑몰의 상품(책) 정보를 저장 관리
drop table book;
CREATE TABLE book(
	book_id INT(20),
    book_kind VARCHAR(3),
    book_title VARCHAR(100),
    book_price INT(20),
    book_count INT(20),
    author VARCHAR(40),
    publishing_com VARCHAR(30),
    publishing_date VARCHAR(15),
    book_image VARCHAR(16),			-- 'nothing.jpg'
    book_content VARCHAR(500),
    discount_rate INT(20),			-- 10
    reg_date VARCHAR(50)
);
DESC book;
-- 문학 -----------------------------------------------------------------------------
INSERT INTO book VALUES(1, '100', '나미야 잡화점의 기적', 15000, 100, '히가시노 게이고', '현대문학', '2019-01-11', '01.jpg', '일본을 대표하는 소설가 히가시노 게이고의 신작', 10, now());
INSERT INTO book VALUES(2, '100', '연필로 쓰기', 18000, 80, '김훈', '문학동네', '2018-02-14', '02.jpg', '70대의 김훈이 연필로 꾹꾹 눌러쓴 산문의 진경', 5, now());
INSERT INTO book VALUES(3, '100', '인간 실격', 20000, 50, '다자이 오사무', '민음사', '2016-11-20', '03.jpg', '2019 상반기 종합 베스트셀러', 15, now());
INSERT INTO book VALUES(4, '100', '기묘한 신혼여행', 12000, 30, '정태원', '문학의 문학', '2017-04-20', '04.jpg', '13편의 추리문학 걸작선', 20, now());
-- 외국어 -----------------------------------------------------------------------------
INSERT INTO book VALUES(5, '200', '외국어 공부의 감각', 15000, 100, '아키야마 요헤이', '월북', '2011-03-11', '05.jpg', '나는 어떻게 10개 국어를 말하게 되었나?', 25, now());
INSERT INTO book VALUES(6, '200', 'EBS 수능완성 고등 제2외국어', 28000, 200, 'EBS 편집부', 'EBS교육방송', '2014-08-14', '06.jpg', '2014 학년도 수능 연계교재', 10, now());
INSERT INTO book VALUES(7, '200', '외국어 전파담', 23000, 70, '로버트 파우저', '혜화', '2012-10-03', '07.jpg', '외국어는 어디에서 어디로', 10, now());
INSERT INTO book VALUES(8, '200', '아무튼,외국어', 22000, 50, '조지영', '위고', '2019-04-20', '08.jpg', '모든 나라에는 철수와 영희가 있다', 10, now());
-- 컴퓨터 -----------------------------------------------------------------------------
INSERT INTO book VALUES(9, '300', '컴퓨터 비전과 딥러닝', 35000, 700, '라쟈링가파 샨무갸마니', '에이콘', '2018-02-18', '09.jpg', '텐서플로와 케라스를 사용한 전문 가이드', 5, now());
INSERT INTO book VALUES(10, '300', '쉽게 배우는 데이터 통신', 19000, 100, '박기현', '한빛아카데미', '2015-03-10', '10.jpg', '데이터 통신과 컴퓨터 네트워크', 10, now());
INSERT INTO book VALUES(11, '300', '컴퓨터활용능력', 38000, 200, '이주희', '배움', '2012-09-24', '11.jpg', '컴퓨터 자격증', 20, now());
INSERT INTO book VALUES(12, '300', '초등학생이 알아야할 숫자', 22000, 0, '엘리스 제임스', '어스본코리아', '2013-06-12', '12.jpg', '컴퓨터와 코디 100가지', 10, now());
SELECT * FROM book;
------------------------------------------------------------------------------------------------------------------
CREATE TABLE buy(
  buy_id INT(20),
  buyer VARCHAR(50),
  book_id VARCHAR(12),
  book_title VARCHAR(100),
  buy_price INT,
  buy_count INT,
  book_image VARCHAR(16),			-- 'nothing.jpg'
  buy_date VARCHAR(30),
  account VARCHAR(50),
  deliveryName VARCHAR(10),
  deliveryTel VARCHAR(20),
  deliveryAddress VARCHAR(100),
  sanction VARCHAR(10)				-- '상품준비중'(배송상황)
);
------------------------------------------------------------------------------------------------------------------
CREATE TABLE member(
  id VARCHAR(50),
  passwd VARCHAR(16),
  name VARCHAR(10),
  reg_date VARCHAR(30),
  tel VARCHAR(20),
  address VARCHAR(100)
);
DESC member;
INSERT INTO member VALUES('qwer', '1111', '홍길동', now(), '010-1234-5678', '경기도 구리시 아차산로 487번길');
INSERT INTO member VALUES('abcd', '1111', '김순홍', now(), '010-8765-9827', '강남구 광평로 34길 25-35(수서동)');
SELECT * FROM member;
------------------------------------------------------------------------------------------------------------------
CREATE TABLE cart(
  cart_id INT,
  buyer VARCHAR(50),
  book_id INT,
  book_title VARCHAR(100),
  buy_price INT,
  buy_count INT,
  book_image VARCHAR(16) -- 'nothing.jpg'
);
DESC cart;
------------------------------------------------------------------------------------------------------------------
CREATE TABLE bank(
  account VARCHAR(30),
  bank VARCHAR(10),
  name VARCHAR(10)
);
DESC bank;
insert into bank(account, bank, name)
values('11111-111-11111','우리은행','(주)코리아');
insert into bank(account, bank, name)
values('22222-222-22222','신한은행','(주)코리아');
SELECT * FROM bank;
------------------------------------------------------------------------------------------------------------------
