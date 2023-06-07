--pl/sql
--sql���忡�� ����, ����ó�� if, �ݺ���(loop,
--while,for ���� ����
--sql���� ���α׷��� �� �ۼ��� �� �ֵ���!
-- ���� �� set serveroutput on; �� �� ��� ���� ����

declare section 
-- ������ ����� �����ϴ� �κ�
-- ����ζ�� ��

-- �����
executable section
if���̳� while�Լ� ����

-- ����ó����
exception section 
�������� ��Ȳ�� �߻��� �ذ��ϱ� ���� ����

set serveroutput on;
--���ν����� ����Ͽ� ����ϴ� ������ ȭ�鿡 ���� �ֵ���
--�����ϴ� ȯ�溯���� off-> on ����

begin
 -- put_line�̶�� ���ν����� �̿��Ͽ� ���
 -- DBMS_OUTPUT��Ű���� ���� ����
    dems_output.put_line('Hello World');
end;

-- �⺻Ư��
-- ��� ������ ������ �����Ѵ�.
-- begin�� end;�� ����Ѵ�.
-- ������ ���ο� /�� �Է��ϸ� �ش� ����� ����ȴ�.
-- Ŀ���� ����Ͽ� �������� �˻� �� ó��

-- ����� ����(block)
-- �͸���:�̸��� ���� pl/sql block
-- �̸��� �ִ� ���:DB�� ��ü�� ����Ǵ� ���
-- ���ν���:���ϰ��� �ϳ� �̻� ���� �� �ִ� ���α׷�
-- �Լ�:���ϰ��� �ݵ�� ��ȯ�ؾ� �ϴ� ���α׷�
-- ��Ű��:�ϳ� �̻��� ���ν���,�Լ�,����,���� ����
--          ������ ���Ѵ�.

-- Ʈ����:������ �̺�Ʈ�� �߻��ϸ� �ڵ����� ����Ǵ� 
-- pl/sql ���

-- ���� �����
-- ������ ������Ÿ�� := �ʱⰪ;  colon equal
val_num number := 1;
val_str char(3) := 'AA';

-- ��� �����ϱ�
-- ����� constrant ������Ÿ�� := �����;
set serveroutput on;
begin
 -- put_line�̶�� ���ν����� �̿��Ͽ� ���
 -- DBMS_OUTPUT��Ű���� ���� ����
    DBMS_OUTPUT.put_line('Hello World');
end;

declare
    EMP_ID number;
    EMP_NAME varchar(30);
    
    --�������
    VAR_NUM CONSTANT number := 1;
begin
    EMP_ID := 888;
    EMP_NAME := '�̼���';
    DBMS_OUTPUT.put_line('EMP_ID:'||EMP_ID);
    DBMS_OUTPUT.put_line('EMP_NAME:'||EMP_NAME);
    DBMS_OUTPUT.put_line('VAR_NUM:'||VAR_NUM);
end;


--����
declare
    VAR_NUM number := 5;
    VAR_NUM2 number := 5;
begin
    DBMS_OUTPUT.PUT_LINE(VAR_NUM+VAR_NUM2);
end;

--���ǹ�
/*
if ���� then
ó����

elsif ����2 then
ó����
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



--�����̺�
/*
CASE WHEN ���� THEN
    ó����
    
WHEN ����2 THEN
    ó����
    
else
    ó����
    
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



-- MOD�Լ�
-- ���� 2�� ������ �� ¦��
-- MOD(M,N) M�� N���� ������ �� ���������� ��ȯ�Ѵ�.
declare
    T_NUMBER := 10;
    
begin
    if MOD(t_number,2) = 0 then
        DBMS_OUTPUT.PUT_LINE('¦��');
    end if;
end;



-- TRUNC('��',"�ɼ�")
-- �ַ� �Ҽ���, ��¥�� �ð��� ���� �� ���.
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




-- loop �ݺ��� ���
-- ���ٸ� ���� ���� �ݺ����� ����˴ϴ�!
declare
    --�ʱⰪ
    T_NUMBER number:= 1;
    
begin
    loop
        DBMS_OUTPUT.PUT_LINE('loop �ݺ�Ƚ��:'||T_number);
                            -- 1�� ����
        t_number := t_number +1;
                            -- 4�̻��̸� �ݺ��� ����
        exit when t_number > 4;
    end loop;
end;
--while
declare
    --�ʱⰪ
    T_NUMBER number:= 0;
    
begin
    -- �ݺ��� ���� 10�� �� ������
    while t_number <= 10 loop
        DBMS_OUTPUT.PUT_LINE('loop �ݺ�Ƚ��:'||T_NUMBER);
        
        --1�� ����
        T_number := T_number +1;
    end loop;
end;
--for loop ����
--�ݺ�Ƚ�� ������ ��
--for ������ in ����..��
--    ó����
--end loop;
--end;
begin
    for I in 1..5 loop
        DBMS_OUTPUT.PUT_LINE('LOOP �ݺ�Ƚ��:'|| I);
    end loop;
end;
--continue ��
-- ����Ŭ 11G �������ʹ� ��밡��
begin
    for I in 1..5 loop
        -- 3�̸� ���� �� �ϰ� �ǳʶ�!
        continue when I=3;
        
        DBMS_OUTPUT.PUT_LINE('LOOP �ݺ�Ƚ��:'|| I);
    end loop;
end;