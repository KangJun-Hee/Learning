set serveroutput on;
--DECLARE
--
--    TEMPERATURE NUMBER; 
--    CHANGE_TEMP NUMBER;
--
--BEGIN
--    TEMPERATURE := &TEMPERATURE;
--    CHANGE_TEMP := (TEMPERATURE * 9/5) + 32   ;  -- ȭ�� �µ� ��ȯ ���� 
--
--        DBMS_OUTPUT.PUT_LINE('�Է��� ���� �µ� -> ȭ�� �µ� ��ȯ ���: ' || CHANGE_TEMP);
--END; 

--DECLARE 
--    METER NUMBER;
--    YARD NUMBER;
--    FEET NUMBER;
--
--BEGIN
--
--    METER := & METER;
--    FEET := METER / 0.305;
--    YARD := METER * 1.0936;
--        
--        DBMS_OUTPUT.PUT_LINE('FEET ��ȯ��: ' || FEET);
--        DBMS_OUTPUT.PUT_LINE('YARD ��ȯ��: ' || YARD);
--
--END;




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

declare
    contractPrice number := &��� �ݾ�;
    period number := &��� ���� ��;
    cardCode number:= &ī�� �ڵ�;
    discount number;
    peridis number;
    carddis number;
begin
    case
    when period<=6 then
        discount:=0;
    when period>6 and period<=12 then
        discount:=10;
    when period>12 then
        discount:=20;
    peridis:=contractPrice*discount;
    end case;
    
    case
    when cardCode=11 then
        carddis:=5;
    when cardCode=12 then
        carddis:=8;
    when cardCode=13 then
        carddis:=12;
    carddis:
end;