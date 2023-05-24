-- use instagram;

-- left 조인
-- 	좌측테이블 데이터에 추가로 우측정보를 join하는 문법이다.
-- right 조인은 오른쪽에

-- left던 right던 순서가 중요!
-- 	첫 번째의 테이블로 select문에 
-- 	가장 '많은'열을 가져와야 할 테이블을 '우선적'으로 적어 준다.
-- 	join순서에 따라 조회하는 결과값의 행,구성 등이 달라질 수 있음!
-- 좌측테이블 기준으로 다 가지고 온다. 거기에 우측테이블에는 조건이 맞는(해당하는)값만 가져옴

-- join을 할 때 데이터가 없으면 null로 채운다!

-- 3중 join
-- 	원하는 정보가 테이블3개를 모아야 한다면, 
-- 	outer join을 연속으로 3번 쓰는 것도 좋다!


-- 모든 사진의 '파일명'을 조회, 게시자'닉네임'은 옵션
select photos.filename,users.nickname from photos left join users 
on users.id=photos.user_id;
-- 모든댓글의 내용을 조회, 댓글이달린 사진의 파일명은 옵션
select comments.body,photos.filename 
from comments 						-- 기준!
left join photos					-- 
on comments.photo_id=photos.id;