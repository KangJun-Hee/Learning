set serveroutput on;

--declare
--    rsize number := 52.1;
--begin
--    case
--    when rsize >51 and rsize<= 52 then
--        DBMS_OUTPUT.PUT_LINE('9ȣ');
--    when rsize >52 and rsize<=53 then
--        DBMS_OUTPUT.PUT_LINE('10ȣ');
--    when rsize >53 and rsize<=54 then
--        DBMS_OUTPUT.PUT_LINE('11ȣ');
--    else
--        DBMS_OUTPUT.PUT_LINE('�������ۺҰ�');
--end case;
--end;

--declare 
--    num1 number;
--    num2 number;
--    num3 number;
--begin
----3���� ���� ���� �Է¹ޱ�
--    num1:= &1;
--    num2:= &2;
--    num3:= &3;
--    
----3������ �� ���
--    sum:=num1+num2+num3;
--
----���� ¦���� �ִ밪 ���, Ȧ���� �ո� ���
--    if mod(sum,2)=0 then
--        if num1>=num2 and num1>=num3 then
--            DBMS_OUTPUT.PUT_LINE('���� ¦��, ���� ū ���� '||num1);
--        elsif num2>=num1 and num2>=num3 then
--            DBMS_OUTPUT.PUT_LINE('���� ¦��, ����ū ����'||num2);
--        else DBMS_OUTPUT.PUT_LINE('���� ¦��, ���� ū ���� '||num3);
--        end if;
--    else DBMS_OUTPUT.PUT_LINE('��:'||sum);
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
--        DBMS_OUTPUT.PUT_LINE('������ '||num||'�� �����.');
--        num := num+1;
--    end loop;
--end;