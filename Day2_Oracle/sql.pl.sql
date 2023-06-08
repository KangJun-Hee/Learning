set serveroutput on;
--DECLARE
--
--    TEMPERATURE NUMBER; 
--    CHANGE_TEMP NUMBER;
--
--BEGIN
--    TEMPERATURE := &TEMPERATURE;
--    CHANGE_TEMP := (TEMPERATURE * 9/5) + 32   ;  -- 화씨 온도 변환 계산식 
--
--        DBMS_OUTPUT.PUT_LINE('입력한 섭씨 온도 -> 화씨 온도 변환 결과: ' || CHANGE_TEMP);
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
--        DBMS_OUTPUT.PUT_LINE('FEET 변환값: ' || FEET);
--        DBMS_OUTPUT.PUT_LINE('YARD 변환값: ' || YARD);
--
--END;




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

declare
    contractPrice number := &계약 금액;
    period number := &사용 개월 수;
    cardCode number:= &카드 코드;
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