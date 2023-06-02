-- KH_��������
-- 1. EMPLOYEE���̺��� JOB ���̺��� ��� ���� ��ȸ
SELECT * FROM JOB;

-- 2. EMPLOYEE���̺��� JOB ���̺��� ���� �̸� ��ȸ
SELECT JOB_NAME FROM JOB;

-- 3. EMPLOYEE���̺��� DEPARTMENT ���̺��� ��� ���� ��ȸ
SELECT * FROM DEPARTMENT;

-- 4. EMPLOYEE���̺��� ������, �̸���, ��ȭ��ȣ, ����� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

-- 5. EMPLOYEE���̺��� �����, ��� �̸�, ���� ��ȸ
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

-- 6. EMPLOYEE���̺��� �̸�, ����, �Ѽ��ɾ�(���ʽ�����), �Ǽ��ɾ�(�Ѽ��ɾ� - (����*���� 3%)) ��ȸ
SELECT EMP_NAME, SALARY*12, SALARY*12, (SALARY+(SALARY*BONUS)) * 12, ( (SALARY+(SALARY*BONUS)) * 12) - (SALARY*12*0.03)
FROM EMPLOYEE;

-- 7. EMPLOYEE���̺��� SAL_LEVER�� S1�� ����� �̸�, ����, �����, ����ó ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, PHONE
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';

-- 8. EMPLOYEE���̺��� �Ǽ��ɾ�(6�� ����)�� 5õ���� �̻��� ����� �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
SELECT EMP_NAME, SALARY, SALARY*(1+BONUS)*12 - (SALARY*12*0.03), HIRE_DATE
FROM EMPLOYEE
WHERE SALARY*(1+BONUS)*12 - (SALARY*12*0.03) >= 50000000;

-- 9. EMPLOYEE���̺� ������ 4000000�̻��̰� JOB_CODE�� J2�� ����� ��ü ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000 AND JOB_CODE ='J2';

-- 10. EMPLOYEE���̺� DEPT_CODE�� D9�̰ų� D5�� ��� �� 
--     ������� 02�� 1�� 1�Ϻ��� ���� ����� �̸�, �μ��ڵ�, ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE='D9' OR DEPT_CODE='D5' AND HIRE_DATE < '02/01/01';
-- ���� ������ ��� ���� �߿� ���� ������ �˻��ؾߵǴ� ��� ��ȣ�� ���� ��

-- 11. EMPLOYEE���̺� ������� 90/01/01 ~ 01/01/01�� ����� ��ü ������ ��ȸ
SELECT * FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- 12. EMPLOYEE���̺��� �̸� ���� '��'���� ������ ����� �̸� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- 13. EMPLOYEE���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ�� ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';

-- 14. EMPLOYEE���̺��� �����ּ� '_'�� ���� 4���̸鼭 DEPT_CODE�� D9 �Ǵ� D6�̰� 
--     ������� 90/01/01 ~ 00/12/01�̰�, �޿��� 270�� �̻��� ����� ��ü�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____$_%' ESCAPE '$'
        AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6')
        AND HIRE_DATE BETWEEN '90/01/01' AND '00/12/01'
        AND SALARY >= 2700000;

-- 15. EMPLOYEE���̺��� ��� ��� ������ �ֹι�ȣ�� �̿��Ͽ� ����, ����, ���� ��ȸ
SELECT EMP_NAME �����,
      SUBSTR(EMP_NO, 1, 2) ����,
      SUBSTR(EMP_NO, 3, 2) ����,
      SUBSTR(EMP_NO, 5, 2) ����
FROM EMPLOYEE;

-- 16. EMPLOYEE���̺��� �����, �ֹι�ȣ ��ȸ (��, �ֹι�ȣ�� ������ϸ� ���̰� �ϰ�, '-'���� ���� '*'�� �ٲٱ�)
SELECT EMP_NAME �����, 
    RPAD(SUBSTR(EMP_NO,1,7), 14, '*') �ֹι�ȣ
FROM EMPLOYEE;
-- �ֹ� ��Ϲ�ȣ �պκи� �߶� ����ϰ�
-- ������ �߷��� �κ� (8~14)�� '*'�� ä����

-- 17. EMPLOYEE���̺��� �����, �Ի���-����, ����-�Ի��� ��ȸ
--     (��, �� ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ǵ��� �ϰ� ��� ����(����), ����� �ǵ��� ó��)
SELECT EMP_NAME, FLOOR(ABS(HIRE_DATE - SYSDATE)) "�ٹ��ϼ�1", FLOOR(ABS(SYSDATE - HIRE_DATE)) "�ٹ��ϼ�2"
FROM EMPLOYEE;

-- 18. EMPLOYEE���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2) = 1;     -- �ڵ����� ����ȯ ����
-- WHERE MOD(TO_NUMBER(EMP_ID),2)=1;   -- ��Ģ�� ����ȯ �ؾ� ��

-- 19. EMPLOYEE���̺��� �ٹ� ����� 20�� �̻��� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
--WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) > 240;
WHERE ADD_MONTHS(HIRE_DATE, 240) < SYSDATE;

-- 20. EMPLOYEE ���̺��� �����, �޿� ��ȸ (��, �޿��� '\9,000,000' �������� ǥ��)
SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999')
FROM EMPLOYEE;

-- 21. EMPLOYEE���̺��� ���� ��, �μ��ڵ�, �������, ����(��) ��ȸ
--     (��, ��������� �ֹι�ȣ���� �����ؼ� 00�� 00�� 00�Ϸ� ��µǰ� �ϸ� 
--     ���̴� �ֹι�ȣ���� ����ؼ� ��¥�����ͷ� ��ȯ�� ���� ���)
SELECT EMP_NAME, DEPT_CODE, 
        SUBSTR(EMP_NO, 1, 2) || '�� ' || SUBSTR(EMP_NO, 3, 2) || '�� ' || SUBSTR(EMP_NO, 5, 2) || '��' ����,
        EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RRRR')) ����
FROM EMPLOYEE;

-- 22. EMPLOYEE���̺��� �μ��ڵ尡 D5, D6, D9�� ����� ��ȸ�ϵ� D5�� �ѹ���, D6�� ��ȹ��, D9�� �����η� ó��
--     (��, �μ��ڵ� ������������ ����)
SELECT EMP_ID, EMP_NAME, DEPT_CODE,
        CASE
            WHEN DEPT_CODE = 'D5' THEN '�ѹ���'
            WHEN DEPT_CODE = 'D6' THEN '��ȹ��'
            WHEN DEPT_CODE = 'D9' THEN '������'
        END �μ�
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6', 'D9')
ORDER BY 3;

-- 23. EMPLOYEE���̺��� ����� 201���� �����, �ֹι�ȣ ���ڸ�, �ֹι�ȣ ���ڸ�, 
--     �ֹι�ȣ ���ڸ��� ���ڸ��� �� ��ȸ
SELECT EMP_NAME, 
       SUBSTR(EMP_NO,1,6) ���ڸ�, 
       SUBSTR(EMP_NO,8) ���ڸ�,
       TO_NUMBER(SUBSTR(EMP_NO,1,6) + SUBSTR(EMP_NO,8))
FROM EMPLOYEE
WHERE EMP_ID = 201;

-- 24. EMPLOYEE���̺��� �μ��ڵ尡 D5�� ������ ���ʽ� ���� ���� �� ��ȸ
SELECT SUM(SALARY + (SALARY*NVL(BONUS, 0))*12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 25. �������� �Ի��Ϸκ��� �⵵�� ������ �� �⵵�� �Ի� �ο��� ��ȸ
-- ��ü ���� ��, 2001��, 2002��, 2003��, 2004��
SELECT COUNT(*) ��ü������, 
      COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2001', 1)) "2001��",
      COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2002', 1)) "2002��",
      COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2003', 1)) "2003��",
      COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)), '2004', 1)) "2004��"
FROM EMPLOYEE;
