--pl/sql
--sql문장에서 변수, 조건처리 if, 반복문(loop,
--while,for 등을 지원
--sql에서 프로그래밍 언어를 작성할 수 있도록!
-- 시작 전 set serveroutput on; 꼭 해 줘야 값이 보임

declare section 
-- 변수나 상수를 선언하는 부분
-- 선언부라고 함

-- 실행부
executable section
if문이나 while함수 정의

-- 예외처리부
exception section 
예외적인 상황이 발생시 해결하기 위한 문장

set serveroutput on;
--프로시저를 사용하여 출력하는 내용을 화면에 보여 주도록
--설정하는 환경변수로 off-> on 변경

begin
 -- put_line이라는 프로시저를 이용하여 출력
 -- DBMS_OUTPUT패키지에 속해 있음
    dems_output.put_line('Hello World');
end;

-- 기본특성
-- 블록 단위의 실행을 제공한다.
-- begin과 end;를 사용한다.
-- 마지막 라인에 /를 입력하면 해당 블록이 실행된다.
-- 커서를 사용하여 여러행을 검색 및 처리

-- 블록의 종류(block)
-- 익명블록:이름이 없는 pl/sql block
-- 이름이 있는 블록:DB의 객체로 저장되는 블록
-- 프로시저:리턴값을 하나 이상 가질 수 있는 프로그램
-- 함수:리턴값을 반드시 반환해야 하는 프로그램
-- 패키지:하나 이상의 프로시저,함수,변수,예외 등의
--          묶음을 말한다.

-- 트리거:지정된 이벤트가 발생하면 자동으로 실행되는 
-- pl/sql 블록

-- 변수 선언시
-- 변수명 데이터타입 := 초기값;  colon equal
val_num number := 1;
val_str char(3) := 'AA';

-- 상수 선언하기
-- 상수명 constrant 데이터타입 := 상수값;
set serveroutput on;
begin
 -- put_line이라는 프로시저를 이용하여 출력
 -- DBMS_OUTPUT패키지에 속해 있음
    DBMS_OUTPUT.put_line('Hello World');
end;

declare
    EMP_ID number;
    EMP_NAME varchar(30);
    
    --상수선언
    VAR_NUM CONSTANT number := 1;
begin
    EMP_ID := 888;
    EMP_NAME := '이서희';
    DBMS_OUTPUT.put_line('EMP_ID:'||EMP_ID);
    DBMS_OUTPUT.put_line('EMP_NAME:'||EMP_NAME);
    DBMS_OUTPUT.put_line('VAR_NUM:'||VAR_NUM);
end;


--연산
declare
    VAR_NUM number := 5;
    VAR_NUM2 number := 5;
begin
    DBMS_OUTPUT.PUT_LINE(VAR_NUM+VAR_NUM2);
end;

--조건문
/*
if 조건 then
처리문

elsif 조건2 then
처리문
else

end if;
*/
declare
    point number := 80;
    
begin
    if point >= 90 then
        DBMS_OUTPUT.PUT_LINE('A');
    elsif point >= 80 then
        DBMS_OUTPUT.PUT_LINE('B');
    else
        DBMS_OUTPUT.PUT_LINE('F');
end if;
end;



--뷰테이블
/*
CASE WHEN 조건 THEN
    처리문
    
WHEN 조건2 THEN
    처리문
    
else
    처리문
    
end case;
*/
declare
    point2 number := 80;
    
begin
    case
    
    when point2 >= 90 then
        DBMS_OUTPUT.PUT_LINE('A');
    when point2 >= 80 then
        DBMS_OUTPUT.PUT_LINE('B');
    else
        DBMS_OUTPUT.PUT_LINE('F');
    end case;
end;



-- MOD함수
-- 값을 2로 나눴을 때 짝수
-- MOD(M,N) M을 N으로 나눴을 때 나머지값을 반환한다.
declare
    T_NUMBER := 10;
    
begin
    if MOD(t_number,2) = 0 then
        DBMS_OUTPUT.PUT_LINE('짝수');
    end if;
end;



-- TRUNC('값',"옵션")
-- 주로 소수점, 날짜의 시간을 없앨 때 사용.
declare
    T_NUMBER number:= 55;
    
begin
    case trunc(t_number / 10)
        when 9 then DBMS_OUTPUT.PUT_LINE('A');
        when 8 then DBMS_OUTPUT.PUT_LINE('B');
        when 7 then DBMS_OUTPUT.PUT_LINE('C');
        else DBMS_OUTPUT.PUT_LINE('F');
    end case;
end;




-- loop 반복문 사용
-- 별다른 조건 없이 반복문이 실행됩니다!
declare
    --초기값
    T_NUMBER number:= 1;
    
begin
    loop
        DBMS_OUTPUT.PUT_LINE('loop 반복횟수:'||T_number);
                            -- 1씩 증가
        t_number := t_number +1;
                            -- 4이상이면 반복문 종료
        exit when t_number > 4;
    end loop;
end;
--while
declare
    --초기값
    T_NUMBER number:= 0;
    
begin
    -- 반복문 시작 10이 될 때까지
    while t_number <= 10 loop
        DBMS_OUTPUT.PUT_LINE('loop 반복횟수:'||T_NUMBER);
        
        --1씩 증가
        T_number := T_number +1;
    end loop;
end;
--for loop 문법
--반복횟수 지정할 때
--for 변수명 in 시작..끝
--    처리문
--end loop;
--end;
begin
    for I in 1..5 loop
        DBMS_OUTPUT.PUT_LINE('LOOP 반복횟수:'|| I);
    end loop;
end;
--continue 문
-- 오라클 11G 버전부터는 사용가능
begin
    for I in 1..5 loop
        -- 3이면 실행 안 하고 건너뜀!
        continue when I=3;
        
        DBMS_OUTPUT.PUT_LINE('LOOP 반복횟수:'|| I);
    end loop;
end;