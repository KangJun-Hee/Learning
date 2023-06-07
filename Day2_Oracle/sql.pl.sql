--set serveroutput on;
--
--accept input prompt '섭씨 온도 입력'
--declare
--    tmpr number:=&input;
--begin
--    tmpr:=(9/5)*tmpr+32;
--    dbms_output.put_line(tmpr);
--end;

--accept input prompt '미터를 입력하세요.'
--declare
--    meter number:=&input;
--    feet number;
--    yard number;
--begin
--    feet:=meter/0.305;
--    yard:=meter*1.0936;
--    dbms_output.put_line(meter||'meter는 '||feet||' feet, '||yard||' yard입니다.');
--end;



--모르겠음~
--accept input prompt '소비자가를 입력하세요.'
--declare
--    totalPrice number:=&input;
--    totalPrice:=productPrice+(productPrice*0.1);
--    productPrice number:=totalPrice-(productPrice*0.1);
--    tax number:=productPrice*0.1;
--begin
--    dbms_output.put_line('제품가격은 '||productPrice||'원, 부가가치세는 '||tax||'원입니다.');
--end;

DECLARE
    contractPrice := &1;
    period := &2;
    cardCod := &3;
begin
    
    
end;