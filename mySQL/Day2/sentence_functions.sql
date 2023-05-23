-- 문자열 함수
-- 문자열 길이
select length('1234567');

-- 문자열 결합
-- 전달받은 문자열을 모두 결합하여 하나의 문자열로 반환한다.
-- 문자열 중간에 null이 하나라도 존재하면 결과를 null 반환
select concat('My','sql','No');
select concat('My',Null,'No');

-- 문자열 반복
select repeat('이것이',3);

-- 문자열 뒤집기
select reverse('mysql');

-- 문자열검색
-- 문자열이 특정 문자열에서 처음으로 나타나는 위치를 찾아 해당위치 반환.
-- 만약 값이 없으면 0을 반환.
-- 문자열 첫 인덱스가 '1'부터 시작
select locate('abc','abcdefg');
-- 중복되는 값 있을 때 자릿수를 지정
select locate('abc','abcdefabcg',4);

-- 문자열 추출
-- left right 함수는 전달받은 문자열의 왼쪽,오른쪽부터 갯수만큼 문자
-- 반환.
select left('Mysql php html java',10);
select right('Mysql php html java',10);
-- 특정부분 추출		(*부터 *까지)
-- substring('문자열',시작숫자,끝숫자);
select substring('가나다라마바사아',1,6);
-- 구분자로 끊어서 추출('문장','기준','기준갯수')
-- 		문자열에 음수 집어넣으면 오른쪽부터 거꾸로 반환
select substring_index('[www.google.com](http://www.google.com)','.','3');
select substring_index('[www.google.com](http://www.google.com)','.','-3');

-- 대소문자 변경
select lower('ABCD');
select upper('abcd');

-- 문자열 대체('문자열','A를','B로 변경')
select replace('Mysql','My','Junhee');

-- 문자열 다듬기
-- 		특정 문자제거를 하거나 앞이나 뒤
-- 		기본설정 : 전달받은 문자열 양 끝의 공백제거!
select trim('   !!!!mysql hph thml java!!!!  ');
-- leading : 전달받은 문자열 앞에! 제거
select trim(leading '!' from '!!!!mysql hph thml java!!!!');
-- trailing : 			 뒤에! 제거
select trim(trailing '!' from '!!!!mysql hph thml java!!!!');