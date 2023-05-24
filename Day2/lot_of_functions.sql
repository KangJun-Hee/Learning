-- create database Test;
-- set sql_safe_updates=0;

-- 거래내역에 대한 테이블을 만들고 시간을 저장해서 기간을 기점으로 거래내역을 구하시오!

-- create table transactions(
-- 	id int,		-- 고유번호 as
--     amount Decimal(12,2),	-- 거래금액(총12자리, 소수점2이하)
--     msg varchar(20),	-- 메시지
--     create_at timestamp	-- 거래시각
--     -- timestamp : 기본기준 런던, 다른나라로 변경가능
-- );
-- INSERT INTO transactions(id, amount, msg, create_at) VALUES
--   (1,   -24.20, 'Google',          '2021-11-01 10:02:48'),
--   (2,   -36.30, 'Amazon',          '2021-11-02 10:01:05'),
--   (3,   557.13, 'Udemy',           '2021-11-10 11:00:09'),
--   (4,  -684.04, 'Bank of America', '2021-11-15 17:30:16'),
--   (5,   495.71, 'PayPal',          '2021-11-26 10:30:20'),
--   (6,   726.87, 'Google',          '2021-11-26 10:31:04'),
--   (7,   124.71, 'Amazon',          '2021-11-26 10:32:02'),
--   (8,   -24.20, 'Google',          '2021-12-01 10:00:21'),
--   (9,   -36.30, 'Amazon',          '2021-12-02 10:03:43'),
--   (10,  821.63, 'Udemy',           '2021-12-10 11:01:19'),
--   (11, -837.25, 'Bank of America', '2021-12-14 17:32:54'),
--   (12,  695.96, 'PayPal',          '2021-12-27 10:32:02'),
--   (13,  947.20, 'Google',          '2021-12-28 10:33:40'),
--   (14,  231.97, 'Amazon',          '2021-12-28 10:35:12'),
--   (15,  -24.20, 'Google',          '2022-01-03 10:01:20'),
--   (16,  -36.30, 'Amazon',          '2022-01-03 10:02:35'),
--   (17, 1270.87, 'Udemy',           '2022-01-10 11:03:55'),
--   (18, -540.64, 'Bank of America', '2022-01-14 17:33:01'),
--   (19,  732.33, 'PayPal',          '2022-01-25 10:31:21'),
--   (20, 1328.72, 'Google',          '2022-01-26 10:32:45'),
--   (21,  824.71, 'Amazon',          '2022-01-27 10:33:01'),
--   (22,  182.55, 'Coupang',         '2022-01-27 10:33:25'),
--   (23,  -24.20, 'Google',          '2022-02-03 10:02:23'),
--   (24,  -36.30, 'Amazon',          '2022-02-03 10:02:34'),
--   (25,  -36.30, 'Notion',          '2022-02-03 10:04:51'),
--   (26, 1549.27, 'Udemy',           '2022-02-14 11:00:01'),
--   (27, -480.78, 'Bank of America', '2022-02-14 17:30:12')
-- ;

-- A. 거래 내역의 총합은?
select sum(amount)as '거래내역 총합금액' from transactions;
-- B. 최대 거래 금액과 최저 거래 금액은?
select max(amount)as '최대거래액',min(amount)as'최소거래액' from transactions;
-- C. “Google”과 거래한 총 횟수는?
select count(msg)as'Google과 거래횟수' from transactions where msg='Google';
-- D. 거래 내역의 평균 금액은?
select avg(amount)as'거래내역 평균액' from transactions;
-- E. 거래 메시지 목록을 중복되지 않게 추출하면?
select distinct msg from transactions;
-- F. 거래 내역의 입금 총액은?
select sum(amount)as'입금총액' from transactions where amount >=1;