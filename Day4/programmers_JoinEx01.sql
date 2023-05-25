-- 첫 번째 문제 "'경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 출판일을 기준으로 오름차순 정렬해주세요."

-- 첫 번째 시도, 틀림. 예시를 읽어 보니 published_date의 형식이 예제와 동일해야 한다고 함.
SELECT book.book_id,author.author_name,book.PUBLISHED_DATE as'published_date'
from book left join author
on book.author_id=author.author_id
where book.category='경제';

-- 두 번째 시도, 출판일을 date_format으로 묶어 포맷을 지정해 주었다. YYYY-MM-DD HH:MM:SS로 출력되던 결과값이 YY-MM-DD로 변경해 주었다.
SELECT book.book_id,author.author_name,date_format(book.PUBLISHED_DATE,'%Y-%m-%d')as'published_date'
from book left join author
on book.author_id=author.author_id
where book.category='경제';

-- 세 번째, 출판일을 기준으로 오름차순 정렬.
SELECT book.book_id,author.author_name,date_format(book.PUBLISHED_DATE,'%Y-%m-%d')as'published_date'
from book left join author
on book.author_id=author.author_id
where book.category='경제'
order by book.published_date;
-- 정답!

﻿