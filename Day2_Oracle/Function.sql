/*�Լ�(Function)�̶�?
 �����ͺ��̽����� �Լ��� �Ϲ����� ���α׷��ֿ����� �Լ��� �����մϴ�.
 �Ű������� �޾� Ư�� ���(�۾�)�� �����ϰ� ����� ��ȯ�ϴ� ������ �Ǿ� �ֽ��ϴ�.
 ��, Ư�� ������ �����ϴ� �ڵ� �κ��� �ǹ��մϴ�.
 �����ͺ��̽� �������� Ư�� ��(�Ű�����)�� �Է� �޾� ���� �������� �۾��� �� ��ȯ�ϴ�
 ����� �ǹ��մϴ�.
 
����Ŭ���� �����ϴ� �Լ��� �����Լ� 
����� ���� �Լ�
 

CREATE OR REPLACE FUNCTION �Լ��̸�(�Ķ����1�̸� Ÿ��, �Ķ����2�̸� Ÿ��...)
RETURN ��ȯ��Ÿ��
IS
	���� ����
BEGIN
	���๮ �ۼ�
	RETURN ��ȯ�Ұ�
END;

create or replace function
 �Լ� ����
 
�Ű����� : �Լ��� ���޵Ǵ� �Ű������� (�̸�, Ÿ��)�Ű����� ���� �� ���� ����!
 */
 
-- CREATE OR REPLACE FUNCTION my_mod(num1 number, num2 number)
--return number  -- ��ȯ number
--is
--	var_rem number := 0; -- ��ȯ�� ������
--    var_quo number := 0; -- �� 
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
�Լ��� Ư�� ������ ������ �� ����� ��ȯ������,
�������ô� Ư���� ������ ó���ϱ⸸ �ϰ� 
������� ��ȯ���� �ʴ� ����

�����ͺ��̽��� ���� �Ϸ��� �۾��� ������ ������ 
������ �����ͺ��̽� ���� �ý��ۿ� ������ ������ 
����������(Persistent Storage Module)�̶�� �Ҹ��ϴ�.


���� ���� ���ν����� ���ν������ �θ���, 
�Ϸ��� ������ ��ġ �ϳ��� �Լ�ó�� �����ϱ� ���� ������ �����Դϴ�.


��, Ư�� �۾��� ���� �������� ����Դϴ�.
CREATE OR REPLACE PROCEDURE ���ν��� �̸�
        (�Ű�������1[IN |OUT | IN OUT] ������Ÿ��[:= ����Ʈ ��],
         �Ű�������2[IN |OUT | IN OUT] ������Ÿ��[:= ����Ʈ ��],
         ...
        )
    IS[AS]
      ����, ��� �� ����
    BEGIN
      �����
    ��
    [EXCEPTION
      ���� ó����]
    END [���ν��� �̸�];
    
    create or replace procedure
    �Ű�����: in�Է�, out��� in out �Է°� ����� ���ÿ� �Ѵ� �ǹ�!
            �ƹ��͵� �ۼ����� ������ �⺻ IN
            ����:���� ���ν����� Ʈ���� ������ ����ϴ� ��
        Ư�� �۾��� �����ϴ� �̸��� �ִ� PL/SQL����̴�~
    */
    
    
    

--CREATE TABLE JOB (
--EMPNO NUMBER(4),
--ENAME VARCHAR2(10),
--JOB VARCHAR2(10),
--DEPTNO NUMBER(2)
--);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(001, '�ѿ���', '����', 24);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(002, 'Ȳ�ø�', '�˻�', 37);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(003, '����ö', '�˻�', 50);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(004, '���', '����', 22);
-- 
--INSERT INTO JOB (EMPNO, ENAME, JOB, DEPTNO)
--VALUES(005, '�̿���', 'CEO', 80);
-- 
--SELECT * FROM JOB;



--SET SERVEROUTPUT ON;
--
---- �͸� ���ν���
--DECLARE
--   CURSOR CUR_JOB IS SELECT * FROM JOB; -- Ŀ�� ����
--   V_JOB JOB%ROWTYPE; --���� ����, ��� ���� �����͸� ���� ��(������ : %ROWTYPE)
--BEGIN
--    OPEN CUR_JOB; --Ŀ�� ����
--    LOOP --�ݺ�
--    FETCH CUR_JOB INTO V_JOB; --CUR_JOB�� �� ���� V_JOB�� ����
--    IF CUR_JOB%NOTFOUND THEN
--    EXIT;
--    END IF; --���ǹ��� ���� ���� Ż��
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
--        DBMS_OUTPUT.PUT_LINE('ȸ����ȣ ����ġ');
--    ELSIF V_DEPTNO <> V_JOB.DEPTNO THEN
--        DBMS_OUTPUT.PUT_LINE('�μ���ȣ ����ġ');
--    ELSE
--        DBMS_OUTPUT.PUT_LINE('���� ����');
--    END IF;
--CLOSE CUR_JOB;
--END;
-- 
--EXECUTE VALIDATE_JOB(1, 37);
--EXECUTE VALIDATE_JOB(4, 22);
--/
----������ / �����ٴ� ��
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
--exec insertcafe(14,'��Ÿ����','�ż���',7000);
--exec insertcafe(20,'�̵��','�̵��',4500);
--exec insertcafe(03,'���ٹ�','������',3000);

�ڽ��� ȣ���� ������ ���� ���ִ� ���� ���� ȣ��Ǿ� ���ุ �ȴ�.

n  ����ȯ��� Stored Program ���̿� ���� �����ϱ� ���� �Ķ���͸� ����Ѵ�.

n  �Ķ���� ����

IN : ȣ���ϴ� ������ �Լ� or ���ν����� ���� ����

OUT : �Լ� or ���ν������� ȣ���� ������ ���� ����

IN OUT : ȣ���ϴ� ������ �Լ� or ���ν����� ���� �����ϰ� ���ÿ� �Լ� or

���ν������� ȣ���� ������ ���� �����ϴ� ����.

n  �������� Header�� ������ IS[AS]�� �;��ϰ� Is�� Begin���̿� Begin ~ End���� �����

������ �����Ѵ�.

n  �ڽ��� ��Ű������ ���ν����� ����� ���ؼ��� CREATE PROCEDURE �ý��۱�����

�־�� �ϸ� �ٸ� ��Ű�� �������� ���ν����� ����� ���ؼ���

CREATE ANY PROCEDURE �ý��� ������ �� �־�� �Ѵ�.
