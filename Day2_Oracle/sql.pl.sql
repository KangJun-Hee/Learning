--set serveroutput on;
--
--accept input prompt '���� �µ� �Է�'
--declare
--    tmpr number:=&input;
--begin
--    tmpr:=(9/5)*tmpr+32;
--    dbms_output.put_line(tmpr);
--end;

--accept input prompt '���͸� �Է��ϼ���.'
--declare
--    meter number:=&input;
--    feet number;
--    yard number;
--begin
--    feet:=meter/0.305;
--    yard:=meter*1.0936;
--    dbms_output.put_line(meter||'meter�� '||feet||' feet, '||yard||' yard�Դϴ�.');
--end;



--�𸣰���~
--accept input prompt '�Һ��ڰ��� �Է��ϼ���.'
--declare
--    totalPrice number:=&input;
--    totalPrice:=productPrice+(productPrice*0.1);
--    productPrice number:=totalPrice-(productPrice*0.1);
--    tax number:=productPrice*0.1;
--begin
--    dbms_output.put_line('��ǰ������ '||productPrice||'��, �ΰ���ġ���� '||tax||'���Դϴ�.');
--end;

DECLARE
    contractPrice := &1;
    period := &2;
    cardCod := &3;
begin
    
    
end;