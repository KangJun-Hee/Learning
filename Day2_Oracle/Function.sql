/*함수(Function)이란?
 데이터베이스에서 함수는 일반적인 프로그래밍에서의 함수와 동일합니다.
 매개변수를 받아 특정 계산(작업)을 수행하고 결과를 반환하는 구조로 되어 있습니다.
 즉, 특정 동작을 수행하는 코드 부분을 의미합니다.
 데이터베이스 내에서는 특정 값(매개변수)을 입력 받아 여러 쿼리문을 작업한 뒤 반환하는
 기능을 의미합니다.
 
오라클에서 제공하는 함수는 내장함수 
사용자 정의 함수
 

CREATE OR REPLACE FUNCTION 함수이름(파라미터1이름 타입, 파라미터2이름 타입...)
RETURN 반환할타입
IS
	변수 선언
BEGIN
	실행문 작성
	RETURN 반환할값
END;

create or replace function
 함수 생성
 
매개변수 : 함수로 전달되는 매개변수로 (이름, 타입)매개변수 생략 될 수도 있음!
 */
 
-- CREATE OR REPLACE FUNCTION my_mod(num1 number, num2 number)
--return number  -- 반환 number
--is
--	var_rem number := 0; -- 반환할 나머지
--    var_quo number := 0; -- 몫 
--    
--Begin
--	var_quo := floor(num1/num2);
--    return var_quo;
--end;
--/
--
--select my_mod(14,3) res
--from dual;



/*
함수는 특정 연산을 수행한 뒤 결과값 반환하지만,
프로저시는 특정한 로직을 처리하기만 하고 
결과값을 반환하진 않는 서브

데이터베이스에 대한 일련의 작업을 정리한 절차를 
관계형 데이터베이스 관리 시스템에 저장한 것으로 
영구저장모듈(Persistent Storage Module)이라고도 불립니다.


보통 저장 프로시저를 프로시저라고 부르며, 
일련의 쿼리를 마치 하나의 함수처럼 실행하기 위한 쿼리의 집합입니다.


즉, 특정 작업을 위한 쿼리들의 블록입니다.
CREATE OR REPLACE PROCEDURE 프로시저 이름
        (매개변수명1[IN |OUT | IN OUT] 데이터타입[:= 디폴트 값],
         매개변수명2[IN |OUT | IN OUT] 데이터타입[:= 디폴트 값],
         ...
        )
    IS[AS]
      변수, 상수 등 선언
    BEGIN
      실행부
    　
    [EXCEPTION
      예외 처리부]
    END [프로시저 이름];
    
    create or replace procedure
    매개변수: in입력, out출력 in out 입력과 출력을 동시에 한다 의미!
            아무것도 작성하지 않으면 기본 IN
            변수:저장 프로시저나 트리거 내에서 사용하는 값
        특정 작업을 수행하는 이름이 있는 PL/SQL블록이다~
    */
    
    
    

--CREATE TABLE JOB (
--EMPNO NUMBER(4),
--ENAME VARCHAR2(10),
--JOB VARCHAR2(10),
--DEPTNO NUMBER(2)
--);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(001, '한여진', '경찰', 24);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(002, '황시목', '검사', 37);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(003, '강원철', '검사', 50);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(004, '장건', '경찰', 22);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(005, '이연재', 'CEO', 80);
-- 
--SELECT * FROM JOB;



--SET SERVEROUTPUT ON;
--
---- 익명 프로시저
--DECLARE
--   CURSOR CUR_JOB IS SELECT * FROM JOB; -- 커서 선언
--   V_JOB JOB%ROWTYPE; --변수 선언, 모든 열의 데이터를 갖고 옴(행참조 : %ROWTYPE)
--BEGIN
--    OPEN CUR_JOB; --커서 열기
--    LOOP --반복
--    FETCH CUR_JOB INTO V_JOB; --CUR_JOB의 한 행을 V_JOB에 넣음
--    IF CUR_JOB%NOTFOUND THEN
--    EXIT;
--    END IF; --조건문을 통해 루프 탈출
--    DBMS_OUTPUT.PUT_LINE('EMPNO :' || V_JOB.EMPNO ||
--                         'ENAME :' || V_JOB.ENAME ||
--                         'JOB :' || V_JOB.JOB ||
--                         'DEPTNO :' || V_JOB.DEPTNO);
--    END LOOP;
--    CLOSE CUR_JOB;
--END;
-- 
--SELECT * FROM JOB;
--
--CREATE OR REPLACE PROCEDURE VALIDATE_JOB
--(
--    V_EMPNO JOB.EMPNO%TYPE,
--    V_DEPTNO JOB.DEPTNO%TYPE
--)
--AS
--    V_JOB JOB%ROWTYPE;
--    CURSOR CUR_JOB IS SELECT * FROM JOB WHERE EMPNO = V_EMPNO;
--BEGIN
--    OPEN CUR_JOB;
--    FETCH CUR_JOB INTO V_JOB;
--    IF CUR_JOB%NOTFOUND THEN
--        DBMS_OUTPUT.PUT_LINE('회원번호 불일치');
--    ELSIF V_DEPTNO <> V_JOB.DEPTNO THEN
--        DBMS_OUTPUT.PUT_LINE('부서번호 불일치');
--    ELSE
--        DBMS_OUTPUT.PUT_LINE('인증 성공');
--    END IF;
--CLOSE CUR_JOB;
--END;
-- 
--EXECUTE VALIDATE_JOB(1, 37);
--EXECUTE VALIDATE_JOB(4, 22);
--/
----슬래시 / 끝났다는 뜻
--
--
--CREATE TABLE CAFE(
--    CAFEID NUMBER(20),
--    CAFENAME varchar(20),
--    CORPORATION VARCHAR2(20),
--    PRICE NUMBER
--);
--
--CREATE OR REPLACE PROCEDURE INSERTCAFE(
--    mCAFEID IN number,
--    mCAFENAME in varchar,
--    mCORPORATION in VARCHAR2,
--    mPRICE in number)
--as
--begin
--    insert into cafe(CAFEID,CAFENAME,CORPORATION,PRICE)
--    values(mCAFEID,mCAFENAME,mCORPORATION,mPRICE);
--end;
--
--exec insertcafe(14,'스타벅스','신세계',7000);
--exec insertcafe(20,'이디야','이디야',4500);
--exec insertcafe(03,'빽다방','백종원',3000);

자신을 호출한 곳으로 리턴 해주는 값은 없고 호출되어 실행만 된다.

n  실행환경과 Stored Program 사이에 값을 전달하기 위해 파라미터를 사용한다.

n  파라미터 종류

IN : 호출하는 곳에서 함수 or 프로시저로 값을 전달

OUT : 함수 or 프로시저에서 호출한 곳으로 값을 전달

IN OUT : 호출하는 곳에서 함수 or 프로시저로 값을 전달하고 동시에 함수 or

프로시저에서 호출한 곳으로 값을 전달하는 변수.

n  프러시저 Header의 끝에는 IS[AS]가 와야하고 Is와 Begin사이에 Begin ~ End에서 사용할

변수를 선언한다.

n  자신의 스키마에서 프로시저를 만들기 위해서는 CREATE PROCEDURE 시스템권한이

있어야 하며 다른 스키마 계정에서 프로시저를 만들기 위해서는

CREATE ANY PROCEDURE 시스템 권한이 이 있어야 한다.
