create database Stu;
use Stu;
-- 학생 테이블 생성
CREATE TABLE students (
  id INTEGER,                -- 학생 id
  nickname VARCHAR(50),      -- 닉네임
  math_score INTEGER,        -- 수학 성적
  english_score INTEGER,     -- 영어 성적
  programming_score INTEGER  -- 프로그래밍 성적
);
-- 학생 레코드 추가
INSERT INTO
  students(id, nickname, math_score, english_score, programming_score)
VALUES
  (1, 'Sparkles', 98, 96, 93),
  (2, 'Soldier', 82, 66, 98),
  (3, 'Lapooheart', 84, 70, 82),
  (4, 'Slick', 87, 99, 98),
  (5, 'Smile', 75, 73, 70),
  (6, 'Jellyboo', 84, 82, 70),
  (7, 'Bagel', 97, 91, 87),
  (8, 'Queen', 99, 100, 88)
;


select * from students;


-- 모든 과목성적이 90점 이상인 학생정보 출력
select * from students 
where math_score >= 90 and english_score >= 90 and programming_score >= 90;
-- 75점 미만 과목이 하나라도 있는 학생정보 출력
select * from students 
where math_score < 75 or english_score < 75 or programming_score < 75;

-- 모든 학생별 정보, 성적 총점
select id, nickname, math_score, english_score, programming_score, 
math_score+english_score+programming_score 
from students;
-- 모든 학생별 정보, 성적 평균
select id, nickname, math_score, english_score, programming_score, 
(math_score+english_score+programming_score)/3 
from students;
-- 총점이 270점 이상인 학생의 닉네임, 성적총점, 성적평균
select nickname, math_score+english_score+programming_score, 
(math_score+english_score+programming_score)/3 
from students 
where math_score+english_score+programming_score >= 270;