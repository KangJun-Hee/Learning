-- 서브쿼리
-- 	쿼리 속에 다른 쿼리가 들어있다
-- 	먼저 수행된 쿼리결과를 가지고 다시 쿼리를 수행할 때 사용!

-- 서브쿼리 실행순서
-- 	서브쿼리 실행->메인(부모)쿼리 실행

-- ()괄호 안에 들어있는 것이 서브쿼리!
-- 서브쿼리 = 자식쿼리,내부쿼리 - 메인쿼리 컬럼 사용가능
-- 메인쿼리 = 부모쿼리,외부쿼ㅓ리 - 서브쿼리 컬럼 사용불가능!

-- 서브쿼리가 자바의 상속개념과 비슷
# select(스칼라 서브쿼리- 하나의 컬럼처럼 사용,표현용도)
# from(인라인 뷰- 하나의 테이블처럼 사용(대체용으로도))
# where(일반 서브쿼리- 하나의 변수(상수처럼)사용)
# join
-- 위의 것들에 쓰인다.



-- create database subQuerytest;
-- use subQuerytest;
CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64),
  salary INT,
  office_worker VARCHAR(64)
);

INSERT INTO employee VALUES(1,'허사장',20000000,'사장');

INSERT INTO employee (name,salary,office_worker) VALUES('유부장',10000000,'부장');
INSERT INTO employee (name,salary,office_worker) VALUES('박차장',5000000,'차장');
INSERT INTO employee (name,salary,office_worker) VALUES('정과장',4000000,'과장');
INSERT INTO employee (name,salary,office_worker) VALUES('정대리',3895000,'대리');
INSERT INTO employee (name,salary,office_worker) VALUES('노사원',2500000,'사원');
INSERT INTO employee (name,salary,office_worker) VALUES('하사원',2000000,'사원');
INSERT INTO employee (name,salary,office_worker) VALUES('길인턴',1000000,'인턴');

select * from employee;



-- where절에서 서브쿼리를 사용할 때
-- 단일행

-- 정대리의 직급을 구하시오!
select office_worker from employee 
where 
	office_worker=(select 
    office_worker
    from employee
	where
    name='정대리'
);
-- 정대리보다 급여가 높은 사람들을 구하시오!
select * from employee
where
	salary>(select
    salary from employee
    where name='정대리'
);
-- 직급이 사원인 사람들을 모두 구하시오!
select * from employee
where
	office_worker in (select
		office_worker
        from employee
        where office_worker='사원'
    );
    
    
    
    
-- in : 서브쿼리의 결과에 존재하는 임의의 값과 동일한 조건을 의미한다.
-- all : 서브쿼리에 결과에 존재하는 모든 값을 만족하는 것.
-- any : 서브쿼리의 결과에 존재하는 어느 하나라도 만족하는 조건(or랑 조금 비슷)

-- 인라인 뷰(inline view)
-- 	from절에서 서브쿼리를 사용할 때
-- 	파생테이블에는 별칭을 정해 줘야 한다(as).




-- 직급이 사원인 사람들의 이름과 급여를 구하시오!
select ex1.name,ex1.salary 
from 
	(select*
    from employee as li
    where 
		li.office_worker='사원')as ex1;
-- from절에서 나온 테이블의 결과에 별칭을 달지 않으면 에러발생가능




-- 스칼라 서브쿼리(scalar subquery)
-- 정대리 급여, 테이블전체 평균급여 구하시오~
select name,salary, (
		select
			round(avg(salary),-1)-- 빼기1은 소수점없이
		from employee)as '평균급여'
from employee
where name='정대리';


-- insert into문에도 서브쿼리 가능
create table table2(
	id int ,
    pw int
);
create table table1(
	id int auto_increment primary key,
    pw int
);
insert into table1(pw) values(1111);
insert into table2(pw) values(2222);
-- 테이블2의 정보를 뽑아 그 데이터를 테이블1에 넣어 준다.
insert into table1(select*from table2);
select*from table1;





create table orders(
	id int auto_increment primary key,
    status varchar(30),
    created_at timestamp
);
create table order_details(
	id int auto_increment primary key,
    order_id int,
    beverage_id int,
    count int
);
create table beverages(
	id int auto_increment primary key,
    name varchar(30),
    price int,
    btype varchar(30)
);
-- 주문(orders)
INSERT INTO
  orders(status, created_at)
VALUES
  ('DELIVERED', '2022-02-26 8:32:13'),
  ('CANCELLED', '2022-02-26 8:35:27'),
  ('DELIVERED', '2022-02-26 8:44:53'),
  ('DELIVERED', '2022-02-26 9:05:12'),
  ('DELIVERED', '2022-02-26 9:11:35'),
  ('DELIVERED', '2022-02-26 9:14:18'),
  ('DELIVERED', '2022-02-26 9:34:20'),
  ('DELIVERED', '2022-02-26 9:44:27'),
  ('DELIVERED', '2022-02-26 9:48:25'),
  ('DELIVERED', '2022-02-26 11:14:52'),
  ('CANCELLED', '2022-02-26 11:32:13'),
  ('DELIVERED', '2022-02-26 11:55:40'),
  ('DELIVERED', '2022-02-26 12:15:01'),
  ('DELIVERED', '2022-02-26 12:21:52'),
  ('CANCELLED', '2022-02-26 12:29:17')
;
-- 음료(beverages)
INSERT INTO
  beverages(name, price, btype)
VALUES
  ('아메리카노',   4500, 'COFFEE'),
  ('라떼',        5000, 'COFFEE'),
  ('카푸치노',     5000, 'COFFEE'),
  ('카페모카',     5500, 'COFFEE'),
  ('콜드브루',     5200, 'COFFEE'),
  ('레몬 에이드',  3800, 'AID'),
  ('자몽 에이드',  4800, 'AID'),
  ('바닐라 쉐이크', 5800, 'SHAKE')
;
-- 주문내역(order_details)
INSERT INTO
  order_details(order_id, beverage_id, count)
VALUES
  (1,  1, 1),
  (2,  1, 2),
  (2,  2, 3),
  (2,  8, 2),
  (3,  1, 2),
  (4,  8, 1),
  (5,  4, 1),
  (6,  5, 3),
  (7,  1, 3),
  (7,  2, 2),
  (8,  1, 1),
  (9,  5, 1),
  (10, 1, 4),
  (11, 2, 1),
  (12, 3, 1),
  (13, 1, 6),
  (14, 1, 8),
  (14, 2, 2),
  (14, 6, 1),
  (15, 1, 4)
;

-- Select 절 서브쿼리
-- 음료의 이름 및 가격과 함께, 가장 비싼 음료와의 가격 차이를 조사하려 한다.
-- 주어진 두 쿼리를 조합하여 이를 구하시오 (Select절 서브쿼리로)
SELECT
 name       		AS "음료명",
 price 				AS "가격",
 price - (
	 SELECT 
	 	MAX(price)
	 FROM 
	 	beverages) AS "최대 가격과의 차이"
FROM 
 beverages;
-- 가장 비싼 음료의 가격 (단일값 결과 생성)
SELECT
 MAX(price)
FROM 
 beverages;
 
 
 
-- 주문내역으로부터 주문 별 음료 개수의 평균을 조회하려 한다.
 -- 주어진 쿼리를 조합하여 이를 구하시오. (FROM절 서브 쿼리로)
 -- 집계함수는 중첩해서 사용할 수 없기 때문에 서브쿼리 사용한 예제
SELECT 
	AVG(SUM) AS "주문 별 음료 개수 평균"
FROM(
	-- 주문별 음료 개수
	SELECT order_id,
		SUM(count)
	FROM
		order_details
	GROUP BY
		order_id
	) AS "주문 별 음료개수 집계";

SELECT 
	order_id,
	SUM(count)
FROM
 	order_details
GROUP BY
	order_id;
    
    
    
    
    
-- 주어진 두 쿼리를 조합하여 이를 구하시오 (Join 서브쿼리로)
SELECT 
	name AS "음료명",
	COALESCE(null, 0) AS "주문개수"
	-- COALESCE() 함수 SUM값이 NULL이면 0을 넣게 설정할수있음
FROM
	beverages
LEFT JOIN (
	SELECT
		beverage_id,
		SUM(count)
	FROM	 
		order_details
	GROUP BY beverage_id) AS b_counts ON
b_counts.beverage_id = beverages.id;





-- 음료 id별 주문개수
SELECT
	beverage_id,
	SUM(count)
FROM 
	order_details
GROUP BY beverage_id;




-- 평균가격보다 비싼음료를 다음과 같이 조회하려한다
-- 주어진 두 쿼리를 조합하여 이를 구하시오 (where절 서브쿼리)
SELECT
	name,
	price
FROM
	beverages
where 
	price > ( -- 음료의 평균가격 (4950원)
			SELECT 
				AVG(price)
			FROM
			beverages
		);
	

-- 음료의 평균가격 (4950원)
SELECT 
	AVG(price)
FROM
beverages;









create table students(
	id int auto_increment primary key,
    nickname varchar(10)
);
create table grades(
	id int auto_increment primary key,
    student_id int,
    course_id int,
    exam_score int,
    grade varchar(10)
);
create table courses(
	id int auto_increment primary key,
    title varchar(30)
);
create table grade_points(
	grade varchar(10),
    point decimal
);






/* 레코드 등록 */
-- 학생
INSERT INTO
  students(nickname)
VALUES
  ('홍팍'),
  ('쿠마'),
  ('호크'),
  ('젤리'),
  ('알파고'),
  ('베이글'),
  ('라이언')
;
-- 과목
INSERT INTO
  courses(title)
VALUES
  ('프로그래밍'),
  ('대학 수학'),
  ('영작문'),
  ('글쓰기'),
  ('물리와 실험'),
  ('사고와 표현'),
  ('공학 윤리')
;
-- 등급 점수
INSERT INTO
  grade_points(grade, point)
VALUES
  ('A+', 4.5),
  ('A0', 4.0),
  ('B+', 3.5),
  ('B0', 3.0),
  ('C+', 2.5),
  ('C0', 2.0),
  ('D0', 1.5),
  ('F',  0.0)
;
-- 수강성적
INSERT INTO
  grades(student_id, course_id, exam_score, grade)
VALUES
  (1, 1, 90,  'A0'),
  (2, 1, 97,  'A+'),
  (3, 1, 100, 'A+'),
  (4, 1, 98,  'A+'),
  (5, 1, 64,  'D0'),
  (6, 1, 81,  'B+'),
  (7, 1, 79,  'B+'),
  (1, 2, 88,  'A0'),
  (2, 2, 99,  'A+'),
  (3, 2, 82,  'B+'),
  (4, 2, 68,  'C+'),
  (5, 2, 76,  'B0'),
  (6, 2, 63,  'C0'),
  (7, 2, 71,  'C+'),
  (1, 3, 76,  'B+'),
  (2, 3, 72,  'B+'),
  (3, 3, 79,  'B+'),
  (4, 3, 83,  'A0'),
  (5, 3, 91,  'A+'),
  (6, 3, 69,  'B0'),
  (7, 3, 84,  'A0'),
  (1, 4, 90,  'A0'),
  (2, 4, 82,  'B+'),
  (3, 4, 88,  'A0'),
  (4, 4, 99,  'A+'),
  (5, 4, 68,  'C+'),
  (6, 4, 94,  'A+'),
  (7, 4, 60,  'C0'),
  (1, 5, 66,  'B0'),
  (2, 5, 78,  'A0'),
  (3, 5, 73,  'B+'),
  (4, 5, 84,  'A+'),
  (5, 5, 76,  'A0'),
  (6, 5, 84,  'A+'),
  (7, 5, 71,  'B+'),
  (1, 6, 79,  'B+'),
  (2, 6, 89,  'A0'),
  (3, 6, 96,  'A+'),
  (4, 6, 82,  'B+'),
  (5, 6, 91,  'A0'),
  (6, 6, 100, 'A+'),
  (7, 6, 70,  'C+'),
  (1, 7, 99,  'A+'),
  (2, 7, 94,  'A0'),
  (3, 7, 60,  'C0'),
  (4, 7, 68,  'C+'),
  (5, 7, 75,  'B0'),
  (6, 7, 81,  'B0'),
  (7, 7, 89,  'B+')
;

-- 1. 다음 중 올바른 것을 모두 고르시오.
-- 	a)홍팍이의 프로그래밍 성적은 80점을 받아 A0(4.0)이다.ㄴㄴ
-- 	b)라이언의 프로그래밍 성적은 79점을 받아 B+(3.5)이다.ㅇㅇ
-- 	c)젤리의 대학 수학 성적은 68점을 받아 C+(2.5)이다.ㅇㅇ
-- 	d)알파고의 영작문 성적은 91점을 받아 A+(5.0)이다.
# 젤리도 나와야된다~ 어케해야 할까? 이건 알아서 해 보기

SELECT 
    students.nickname,
    courses.title,
    grades.exam_score,
    grade_points.grade,
    grade_points.point
    
FROM
    students                  
JOIN grades ON 

	grades.id = students.id

join courses on 
	courses.id = grades.course_id
    
join grade_points on 
	grade_points.grade = grades.grade
    
where (nickname,title,exam_score,grade_points.grade,point) in (
	('홍팍','프로그래밍',80,'A0',4.0),
	('라이언','프로그래밍',79,'B+',3.5),
    ('젤리','대학 수학',68,'C+',2.5),
    ('알파고','영작문',91,'A+',5.0)
);



-- 두 번째
-- 강의 테이블과 집계결과를 이용해서 구하시오!
select title,round as '평균학점'
from courses 
join (
	select
		course_id,
		round(avg(exam_score),0)as round
	from 
		grades
	group by course_id) as avg_exam_score on
		avg_exam_score.course_id=courses.id;
        
        
-- 평균 시험점수를 처리하는 문장
select students.nickname as 학생,
		평균학점.ROUND as 평균학점
from students 
join(select 
	grades.student_id,
    round(avg(grade_points.point),2)as ROUND
from grades
join grade_points on
		grades.grade=grade_points.grade
group by 
	grades.student_id
having
	avg(grade_points.point)<=3.5) as 평균학점 on
	students.id=평균학점.student_id;
    
    





-- 4번문제
SELECT 
    courses.title,
    round(AVG(grade_points.point), 2) AS ROUND
    
FROM
    courses
JOIN    grades ON 
    courses.id = grades.course_id

JOIN    grade_points ON 
	grades.grade = grade_points.grade
GROUP BY 
	courses.title
ORDER BY 
	ROUND DESC
LIMIT 
	3;
