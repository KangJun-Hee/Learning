-- 문제
-- MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 
-- SQL문을 작성해주세요. 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.

-- 첫 번째 시도, max와 count의 위치 수정필요
SELECT 
member_profile.member_name,rest_review.review_text,
date_format(rest_review.review_date,'%Y-%m-%d')as'review_date'
from rest_review left join member_profile
on rest_review.member_id=member_profile.member_id
where max(count(rest_review.member_id))
order by rest_review.reviewdate,rest_review.review_text;

