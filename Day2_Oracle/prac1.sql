set serveroutput on;

--declare
--    rsize number := 52.1;
--begin
--    case
--    when rsize >51 and rsize<= 52 then
--        DBMS_OUTPUT.PUT_LINE('9호');
--    when rsize >52 and rsize<=53 then
--        DBMS_OUTPUT.PUT_LINE('10호');
--    when rsize >53 and rsize<=54 then
--        DBMS_OUTPUT.PUT_LINE('11호');
--    else
--        DBMS_OUTPUT.PUT_LINE('반지제작불가');
--end case;
--end;

--declare 
--    num1 number;
--    num2 number;
--    num3 number;
--begin
----3개의 양의 정수 입력받기
--    num1:= &1;
--    num2:= &2;
--    num3:= &3;
--    
----3숫자의 합 계산
--    sum:=num1+num2+num3;
--
----합이 짝수면 최대값 출력, 홀수면 합만 출력
--    if mod(sum,2)=0 then
--        if num1>=num2 and num1>=num3 then
--            DBMS_OUTPUT.PUT_LINE('합은 짝수, 가장 큰 수는 '||num1);
--        elsif num2>=num1 and num2>=num3 then
--            DBMS_OUTPUT.PUT_LINE('합은 짝수, 가장큰 수는'||num2);
--        else DBMS_OUTPUT.PUT_LINE('합은 짝수, 가장 큰 수는 '||num3);
--        end if;
--    else DBMS_OUTPUT.PUT_LINE('합:'||sum);
--end if;
--end;


--begin
--    for num in 10..20 loop
--    continue when mod(num,2)=0;
--        DBMS_OUTPUT.PUT_LINE(num||'is a odd number');
--    end loop;
--end;

--declare 
--    num number:=1;
--begin
--    while num<=10 loop
--        DBMS_OUTPUT.PUT_LINE('나무를 '||num||'번 찍었다.');
--        num := num+1;
--    end loop;
--end;