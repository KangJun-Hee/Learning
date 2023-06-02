SQL ���� ���� ���� ������ 
���� �ۼ��� : 2021�� 1�� 11��


-------------------------------------------------
-- 2��

CREATE TABLE tCity
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL
);

INSERT INTO tCity VALUES ('����',605,974,'y','���');
INSERT INTO tCity VALUES ('�λ�',765,342,'y','���');
INSERT INTO tCity VALUES ('����',42,21,'n','���');
INSERT INTO tCity VALUES ('û��',940,83,'n','��û');
INSERT INTO tCity VALUES ('����',205,65,'n','����');
INSERT INTO tCity VALUES ('��õ',910,27,'n','����');
INSERT INTO tCity VALUES ('��õ',1116,27,'n','����');
INSERT INTO tCity VALUES ('ȫõ',1819,7,'n','����');

SELECT * FROM tCity;

CREATE TABLE tStaff
(
	name CHAR (15) PRIMARY KEY,
	depart CHAR (10) NOT NULL,
	gender CHAR(3) NOT NULL,
	joindate DATE NOT NULL,
	grade CHAR(10) NOT NULL,
	salary INT NOT NULL,
	score DECIMAL(5,2) NULL
);

INSERT INTO tStaff VALUES ('������','�ѹ���','��','2000-2-3','�̻�',420,88.8);
INSERT INTO tStaff VALUES ('������','������','��','2009-3-1','����',380,NULL);
INSERT INTO tStaff VALUES ('���߱�','�λ��','��','2012-5-5','�븮',256,76.5);
INSERT INTO tStaff VALUES ('������','������','��','2015-8-15','����',350,71.25);
INSERT INTO tStaff VALUES ('������','������','��','2018-10-9','���',320,56.0);
INSERT INTO tStaff VALUES ('������','�ѹ���','��','2010-9-16','�븮',370,89.5);
INSERT INTO tStaff VALUES ('�㳭����','�λ��','��','2020-1-5','���',285,44.5);
INSERT INTO tStaff VALUES ('�Ż��Ӵ�','������','��','2013-6-19','����',400,92.0);
INSERT INTO tStaff VALUES ('���﹮','������','��','2014-6-8','�븮',285,87.75);
INSERT INTO tStaff VALUES ('��','�λ��','��','2010-9-16','�븮',340,46.2);
INSERT INTO tStaff VALUES ('Ȳ����','�λ��','��','2012-5-5','���',275,52.5);
INSERT INTO tStaff VALUES ('������','�ѹ���','��','2016-3-8','����',385,65.4);
INSERT INTO tStaff VALUES ('�̻��','�ѹ���','��','2000-2-3','�븮',375,50);
INSERT INTO tStaff VALUES ('��âȣ','������','��','2015-8-15','���',370,74.2);
INSERT INTO tStaff VALUES ('��������','������','��','2019-6-29','���',330,NULL);
INSERT INTO tStaff VALUES ('�����','�ѹ���','��','2020-3-14','����',380,69.8);
INSERT INTO tStaff VALUES ('ȫ�浿','�λ��','��','2019-8-8','����',380,77.7);
INSERT INTO tStaff VALUES ('������','�ѹ���','��','2020-7-7','����',290,49.9);
INSERT INTO tStaff VALUES ('�庸��','�λ��','��','2005-4-1','����',440,58.3);
INSERT INTO tStaff VALUES ('��������','�λ��','��','2017-8-3','���',315,45.1);

SELECT * FROM tStaff;

-------------------------------------------------
-- 4��

SELECT name, area, popu, metro, region FROM tCity;
SELECT * FROM tCity;

SELECT name AS ���ø�, area AS "����(����Km)", popu AS "�α�(����)" FROM tCity;

SELECT ���ø� = name, area '����(����Km)', popu [�α�(����)] FROM tCity;

SELECT name, popu * 10000 AS "�α�(��)" FROM tCity;

SELECT name, area, popu, popu * 10000 / area AS "�α��е�" FROM tCity;

SELECT 60 * 60 * 24 AS "�Ϸ�" FROM dual;

SELECT 60 * 60 * 24;

SELECT * FROM tCity WHERE area > 1000;

SELECT name, area FROM tCity WHERE area > 1000;

SELECT * FROM tCity WHERE name = '����'			-- ����
SELECT * FROM tCity WHERE name = ����				-- Ʋ��
SELECT * FROM tCity WHERE name = "����"			-- Ʋ��. ��, �����ƴ� �����Ѵ�.

SELECT * FROM tStaff WHERE score = NULL;

SELECT * FROM tStaff WHERE score IS NULL;

SELECT * FROM tStaff WHERE score IS NOT NULL;

SELECT * FROM tCity WHERE popu >= 100 AND area >= 700;

SELECT * FROM tCity WHERE region = '���' AND popu >= 50 OR area >= 500;
SELECT * FROM tCity WHERE region = '���' AND (popu >= 50 OR area >= 500);

SELECT * FROM tCity WHERE region != '���';
SELECT * FROM tCity WHERE NOT(region = '���');

SELECT * FROM tCity WHERE region = '����' OR metro = 'y';

SELECT * FROM tCity WHERE region != '����' AND metro != 'y';

SELECT * FROM tCity WHERE NOT(region = '����' OR metro = 'y');

SELECT * FROM tCity WHERE name LIKE '%õ%';

SELECT * FROM tCity WHERE name NOT LIKE '%õ%';

SELECT * FROM tCity WHERE name LIKE 'õ%';
SELECT * FROM tCity WHERE name LIKE '%õ';

SELECT * FROM tCity WHERE TRIM(name) LIKE '%õ';

SELECT * FROM tCity WHERE popu BETWEEN 50 AND 100;

SELECT * FROM tCity WHERE popu >= 50 AND popu <= 100;

SELECT * FROM tStaff WHERE name BETWEEN '��' AND '��';
SELECT * FROM tStaff WHERE joindate BETWEEN '20150101' AND '20180101';

SELECT * FROM tCity WHERE region IN ('���', '����');

SELECT * FROM tCity WHERE region = '���' OR region = '����';

SELECT * FROM tCity WHERE region NOT IN ('���', '����');

SELECT * FROM tStaff WHERE name LIKE IN ('��%', '��%');

SELECT * FROM tStaff WHERE name LIKE '��%' OR name LIKE '��%';

SELECT * FROM tCity ORDER BY popu;
SELECT * FROM tCity ORDER BY popu DESC;

SELECT region, name, area, popu FROM tCity ORDER BY region, name DESC;

SELECT * FROM tCity ORDER BY area;
SELECT * FROM tCity ORDER BY 2;

SELECT name FROM tCity ORDER BY popu;

SELECT name, popu * 10000 / area FROM tCity ORDER BY popu * 10000 / area;

SELECT * FROM tCity WHERE region = '���' ORDER BY area;

SELECT * FROM tCity ORDER BY area WHERE region = '���';

SELECT region FROM tCity;
SELECT DISTINCT region FROM tCity;
SELECT DISTINCT region FROM tCity ORDER BY region;

SELECT ALL depart FROM tStaff;
SELECT DISTINCT depart FROM tStaff;

SELECT name, rowid, rownum FROM tCity;

SELECT * FROM tCity WHERE rownum <= 4;

SELECT * FROM tCity ORDER BY area DESC WHERE rownum <= 4;

SELECT * FROM tCity WHERE rownum <= 4 ORDER BY area DESC;

SELECT * FROM (SELECT * FROM tCity ORDER BY area DESC) WHERE rownum <= 4;

SELECT TOP 4 * FROM tCity ORDER BY area DESC;

SELECT TOP 20 PERCENT * FROM tCity ORDER BY popu DESC;

SELECT * FROM tExam ORDER BY Score DESC;

SELECT TOP 100 * FROM tExam ORDER BY Score DESC;

SELECT TOP 1 PERCENT WITH TIES * FROM tExam ORDER BY Score DESC;

SELECT * FROM tCity ORDER BY area DESC LIMIT 4;

SELECT * FROM tCity ORDER BY area DESC LIMIT 2, 3;

SELECT * FROM tCity ORDER BY area DESC OFFSET 0 ROWS FETCH NEXT 4 ROWS ONLY;

SELECT * FROM tCity ORDER BY area DESC OFFSET 2 ROWS FETCH NEXT 3 ROWS ONLY;

SELECT * FROM tCity WHERE metro = 'n' ORDER BY area DESC OFFSET 2 ROWS FETCH NEXT 3 ROWS ONLY;

-------------------------------------------------
-- 5��

SELECT COUNT(*) FROM tStaff;

SELECT COUNT(*) AS "�� ������" FROM tStaff;

SELECT COUNT(*) FROM tStaff WHERE salary >= 400;

SELECT COUNT(*) FROM tStaff WHERE salary >= 10000;

SELECT name FROM tStaff WHERE salary >= 400;

SELECT COUNT(name) FROM tStaff;
SELECT COUNT(depart) FROM tStaff;

SELECT COUNT(DISTINCT depart) FROM tStaff;

SELECT COUNT(score) FROM tStaff;

SELECT COUNT(*) - COUNT(score) FROM tStaff;
SELECT COUNT(*) FROM tStaff WHERE score IS NULL;

SELECT SUM(popu), AVG(popu) FROM tCity;

SELECT MIN(area), MAX(area) FROM tCity;

SELECT SUM(score), AVG(score) FROM tStaff WHERE depart = '�λ��';
SELECT MIN(salary), MAX(salary) FROM tStaff WHERE depart = '������';

SELECT SUM(name) FROM tStaff;		-- ����

SELECT MIN(name) FROM tStaff;

SELECT MAX(popu), name FROM tCity;

SELECT AVG(salary) FROM tStaff;
SELECT SUM(salary)/COUNT(*) FROM tStaff;

SELECT AVG(score) FROM tStaff;
SELECT SUM(score)/COUNT(*) FROM tStaff;

SELECT COUNT(*) FROM tStaff WHERE depart = '�񼭽�';
SELECT MAX(salary) FROM tStaff WHERE depart = '�񼭽�';

SELECT '������', AVG(salary) FROM tStaff WHERE depart='������';
SELECT '�ѹ���', AVG(salary) FROM tStaff WHERE depart='�ѹ���';
SELECT '�λ��', AVG(salary) FROM tStaff WHERE depart='�λ��';

SELECT depart, AVG(salary) FROM tStaff GROUP BY depart;

SELECT depart, COUNT(*), MAX(joindate), AVG(score) FROM tStaff GROUP BY depart; 

SELECT gender, AVG(salary) FROM tStaff GROUP BY gender;

SELECT name, SUM(salary) FROM tStaff GROUP BY name;

SELECT depart, gender, COUNT(*) FROM tStaff GROUP BY depart, gender;

SELECT gender, depart, COUNT(*) FROM tStaff GROUP BY gender, depart;

SELECT depart, gender, COUNT(*) FROM tStaff GROUP BY depart, gender 
ORDER BY depart, gender;

SELECT depart, salary FROM tStaff GROUP BY depart;

SELECT SUM(salary) FROM tStaff GROUP BY depart;

SELECT depart, SUM(salary) FROM tStaff;

SELECT depart, SUM(salary) FROM tStaff GROUP BY depart;
SELECT SUM(salary) FROM tStaff;

SELECT depart, AVG(salary) FROM tStaff GROUP BY depart HAVING AVG(salary) >= 340;

SELECT depart, AVG(salary) FROM tStaff GROUP BY depart HAVING AVG(salary) >= 340 
ORDER BY AVG(salary);

SELECT depart, AVG(salary) FROM tStaff WHERE salary > 300 GROUP BY depart ;

SELECT depart, AVG(salary) FROM tStaff WHERE salary > 300 
GROUP BY depart HAVING AVG(salary) >= 360 ORDER BY depart;

SELECT depart, MAX(salary) FROM tStaff WHERE depart IN ('�λ��', '������') GROUP BY depart;
SELECT depart, MAX(salary) FROM tStaff GROUP BY depart HAVING depart IN ('�λ��', '������');

-------------------------------------------------
-- 6��

INSERT INTO tCity (name, area, popu, metro, region) 
VALUES ('����', 605, 974, 'y', '���');

INSERT INTO tCity VALUES ('����', 605, 974, 'y', '���');

INSERT INTO tCity VALUES ('����', 453, 51, 'n', '���');

INSERT INTO tCity VALUES ('����', 51, 453, 'n', '���');		// area�� popu�� �ٲ�
INSERT INTO tCity VALUES ('����', 453, 'n', 51, '���');		// popu�� metro ������ �ٲ�
INSERT INTO tCity VALUES ('����', 453, 'n', '���');		// popu �ʵ尪 ����

INSERT INTO tCity (area, popu, metro, region, name) 
VALUES (453, 51, 'n', '���', '����');

TRUNCATE TABLE tCity;

INSERT INTO tCity (name, area, popu, metro, region) VALUES 
('����',605,974,'y','���'), 
('�λ�',765,342,'y','���'),
('����',42,21,'n','���'),
('û��',940,83,'n','��û'),
('����',205,65,'n','����'),
('��õ',910,27,'n','����'),
('��õ',1116,27,'n','����'),
('ȫõ',1819,7,'n','����');

INSERT INTO tStaff(name, depart, gender, joindate, grade, salary, score)
SELECT name, region, metro, '20210629', '����', area, popu FROM tCity WHERE region = '���';

INSERT INTO tStaff(name, depart, gender, joindate, grade, salary, score)
SELECT name, �����μ�, gender, ����, '����', 230, score * 0.1 FROM tCandidate 
WHERE result = '�հ�';

CREATE TABLE tSudo AS SELECT name, area, popu FROM tCity WHERE region = '���';
SELECT * FROM tSudo;

SELECT * INTO tCityCopy FROM tCity;

CREATE TABLE tStaff_8��20�� AS SELECT * FROM tStaff;

DELETE FROM tCity WHERE name = '�λ�';

DELETE FROM tCity WHERE region = '���';

DELETE FROM tCity;

SELECT * FROM tCity WHERE popu > 50;

-- DELETE
-- SELECT *
FROM tStaff WHERE grade = '����';

UPDATE tCity SET popu = 1000, region = '��û' WHERE name = '����';

UPDATE tCity SET popu = 1000, region = '��û';

UPDATE tCity SET popu = popu * 2 WHERE name = '����';

-------------------------------------------------
-- 7��

INSERT INTO tCity VALUES ('���','��û ����','�� ������','n','�����ιι������ǰ�ȭ��');

INSERT INTO tCity (name, popu, metro, region) VALUES ('���', 114, 'y', '���');
INSERT INTO tCity (name, metro, region) VALUES ('��ô', 'n', '����');

INSERT INTO tCity (area, popu, metro, region) VALUES (456, 123, 'n', '��û');
INSERT INTO tCity (name, area, popu) VALUES ('������', 456,123);

CREATE TABLE tNullable
(
    name CHAR(10) NOT NULL,
    age INT
);

CREATE TABLE tCityDefault
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) DEFAULT 'n' NOT NULL,
	region CHAR(6) NOT NULL
);

INSERT INTO tCityDefault (name, area, popu, region) VALUES ('����', 712, 34, '���');
INSERT INTO tCityDefault (name, area, popu, metro, region) VALUES ('��õ', 1063, 295, 'y', '���');

INSERT INTO tCityDefault VALUES ('����', 1111, 22, '����');			-- ����
INSERT INTO tCityDefault VALUES ('����', 1111, 22, DEFAULT, '����');	-- ���� ����

UPDATE tCity_Default SET metro = DEFAULT WHERE name = '��õ'

CREATE TABLE tCheckTest
(
	gender CHAR(3) NULL CHECK(gender = '��' OR gender = '��'),
	grade INT NULL CHECK (grade >= 1 AND grade <= 3),
	origin CHAR(3) NULL CHECK(origin IN ('��','��','��','��')),
	name CHAR(10) NULL CHECK(name LIKE '��%')
);

INSERT INTO tCheckTest (gender) VALUES ('��');
INSERT INTO tCheckTest (grade) VALUES (1);
INSERT INTO tCheckTest (origin) VALUES ('��');
INSERT INTO tCheckTest (name) VALUES ('������');

INSERT INTO tCheckTest (gender) VALUES ('��');
INSERT INTO tCheckTest (grade) VALUES (0);
INSERT INTO tCheckTest (origin) VALUES ('��');
INSERT INTO tCheckTest (name) VALUES ('û�긮');

UPDATE tCheckTest SET grade = 4 WHERE grade IS NOT NULL;

region CHAR(6) NOT NULL CHECK (region IN ('���', '��û', '����', '���', '����', '����'))
INSERT INTO tCity3 VALUES ('�︪',72,1,'n','���');

INSERT INTO tCity VALUES ('��õ',1116,27,'n','����');

CREATE TABLE tCity
(
	name CHAR(10),
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL,
	CONSTRAINT PK_tCity_name PRIMARY KEY(name)
); 

CREATE TABLE tCity
(
	name CHAR(10) PRIMARY KEY,
	region CHAR(6) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL
);

CREATE TABLE tCityCompoKey
(
	name CHAR(10) NOT NULL,
	region CHAR(6) NOT NULL,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL,
	CONSTRAINT PK_tCity_name_region PRIMARY KEY (name, region)
);

INSERT INTO tCityCompoKey VALUES ('����', '����', 123, 456, 'y');
INSERT INTO tCityCompoKey VALUES ('����', '���', 123, 456, 'n');

CREATE TABLE tCityUnique
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT UNIQUE NULL,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL
);

CREATE TABLE tCityUnique
(
	name CHAR(10) PRIMARY KEY,
	area INT NULL ,
	popu INT NULL,
	metro CHAR(1) NOT NULL,
	region CHAR(6) NOT NULL,
	CONSTRAINT Unique_tCity_area_popu UNIQUE(area, popu)
);

CREATE SEQUENCE seqSale START WITH 1 INCREMENT BY 1;

CREATE TABLE tSale
(
	saleno INT PRIMARY KEY,
	customer VARCHAR(20),
	product VARCHAR(30)
);

INSERT INTO tSale VALUES (seqSale.NEXTVAL, '�ܱ�', '������');
INSERT INTO tSale VALUES (seqSale.NEXTVAL, '���ָ�', '����');

INSERT INTO tSale VALUES (NEXT VALUE FOR seqSale, '�ܱ�', '������');
INSERT INTO tSale VALUES (NEXT VALUE FOR seqSale, '���ָ�', '����');

DELETE FROM tSale WHERE saleno = 2;

����Ŭ : INSERT INTO tSale VALUES (seqSale.NEXTVAL, '�����ż�', '���');
MSSQL : INSERT INTO tSale VALUES (NEXT VALUE FOR seqSale, '�����ż�', '���');

INSERT INTO tSale VALUES (2, '���ָ�', '����');

CREATE TABLE tSaleSeq
(
	saleno INT GENERATED AS IDENTITY PRIMARY KEY,
	customer VARCHAR(20),
	product VARCHAR(30)
);

INSERT INTO tSaleSeq (customer, product) VALUES ('�ܱ�', '������');
INSERT INTO tSaleSeq (customer, product) VALUES ('���ָ�', '����');

saleno INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
saleno INT GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,

INSERT INTO tSale (saleno, customer, product) VALUES (5, '�ܱ�', '������');	-- ����
INSERT INTO tSale (saleno, customer, product) VALUES (NULL, '���ָ�', '����');	-- ����

CREATE TABLE tSaleId
(
	saleno INT IDENTITY PRIMARY KEY,
	customer VARCHAR(20),
	product VARCHAR(30)
);

INSERT INTO tSaleId (customer, product) VALUES ('�ܱ�', '������');
INSERT INTO tSaleId (customer, product) VALUES ('���ָ�', '����');

DELETE FROM tSaleId WHERE saleno = 2;
INSERT INTO tSaleId (customer, product) VALUES ('�����ż�', '���');

INSERT INTO tSaleId (saleno, customer, product) VALUES (2, '���ָ�', '����');

SET IDENTITY_INSERT tSaleId ON;
INSERT INTO tSaleId (saleno, customer, product) VALUES (2, '���ָ�', '����');
SET IDENTITY_INSERT tSaleId OFF;

INSERT INTO tSaleId VALUES ('�հ�', '�ʱ���');

UPDATE tSaleId SET product = '¥�İ�Ƽ' WHERE saleno = @@IDENTITY;

CREATE TABLE tSale
(
	saleno INT AUTO_INCREMENT PRIMARY KEY,
	customer NCHAR(10),
	product NCHAR(30)
);

INSERT INTO tSale (customer, product) VALUES ('�ܱ�', '������');
INSERT INTO tSale (customer, product) VALUES ('���ָ�', '����');

DELETE FROM tSale WHERE saleno = 2;
INSERT INTO tSale (customer, product) VALUES ('�����ż�', '���');

INSERT INTO tSale (saleno, customer, product) VALUES (2, '���ָ�', '����');

ALTER TABLE tSale AUTO_INCREMENT = 100;

INSERT INTO tSale (customer, product) VALUES ('�հ�', '�ʱ���');
UPDATE tSale SET product = '¥�İ�Ƽ' WHERE saleno = LAST_INSERT_ID();

-------------------------------------------------
-- 8��

UPDATE tProject SET �����='������' WHERE ������Ʈ='TV �����';

SELECT ������Ʈ�� FROM tProject WHERE ����� = '�����';

CREATE TABLE tEmployee
(
	name CHAR(10) PRIMARY KEY,
	salary INT NOT NULL,
	addr VARCHAR(30) NOT NULL
);

INSERT INTO tEmployee VALUES ('�����', 650, '��õ��');
INSERT INTO tEmployee VALUES ('������', 480, '�뱸��');
INSERT INTO tEmployee VALUES ('�Ǽ���', 625, '�ȵ���');

CREATE TABLE tProject
(
	projectID INT PRIMARY KEY,
	employee CHAR(10) NOT NULL,
	project VARCHAR(30) NOT NULL,
	cost INT
);

INSERT INTO tProject VALUES (1, '�����', 'ȫ�� �����', 800);
INSERT INTO tProject VALUES (2, '�����', 'TV �����', 3400);
INSERT INTO tProject VALUES (3, '�����', '����м���', 200);
INSERT INTO tProject VALUES (4, '������', '�濵 ���ž� �ۼ�', 120);
INSERT INTO tProject VALUES (5, '������', '�븮�� ��ȹ', 85);
INSERT INTO tProject VALUES (6, '�Ǽ���', '���� �����', 24);

INSERT INTO tProject VALUES (7, 'ȫ�浿', '������ ����', 900);

DELETE FROM tEmployee WHERE name = '�����';

CREATE TABLE tProject
(
	projectID ... ,
	employee ... ,
	project ... ,
	cost ... ,
	CONSTRAINT FK_emp FOREIGN KEY(employee) REFERENCES tEmployee(name)
);

INSERT INTO tEmployee VALUES ('ȫ�浿', 330, '�强');
INSERT INTO tProject VALUES (7, 'ȫ�浿', '������ ����', 900);

DELETE FROM tProject WHERE employee = '�����';
DELETE FROM tEmployee WHERE name = '�����';

DROP TABLE tEmployee;

CREATE TABLE tProject
(
	....
	CONSTRAINT FK_emp FOREIGN KEY(employee) REFERENCES tEmployee(name)
	ON DELETE CASCADE
);

DELETE FROM tEmployee WHERE name = '�����';

CREATE TABLE tProject
(
	....
	CONSTRAINT FK_emp FOREIGN KEY(employee) REFERENCES tEmployee(name)
	ON DELETE CASCADE ON UPDATE CASCADE
);

UPDATE tEmployee SET name = '������' WHERE Name = '������';

-- ȸ�� ���̺�
CREATE TABLE tMember
(
    member VARCHAR(20) PRIMARY KEY, 	-- ���̵�
    age INT NOT NULL,                      	-- ���� 
    email VARCHAR(30) NOT NULL,           	-- �̸���
    addr VARCHAR(50) NOT NULL,            	-- �ּ�
    money INT DEFAULT 1000 NOT NULL,     	-- ��ġ��
    grade INT DEFAULT 1 NOT NULL,         	-- �����. 1=��ȸ��, 2=��ȸ��, 3=���ȸ��
    remark VARCHAR(100) NULL             	-- �޸� ����
);

-- ȸ�� ������
INSERT INTO tMember VALUES ('����',16,'1004@naver.com','���� ������',20000, 2, '');
INSERT INTO tMember VALUES ('�̵���',18,'wolf@gmail.com','���� �Ż絿',150000, 3, '');
INSERT INTO tMember VALUES ('���',25,'candy@daum.net','���� ������',5000, 2, '');
INSERT INTO tMember VALUES ('����',28,'devlin@ssang.co.kr','���� ������',1000, 1, '������ ��');

-- ��ǰ �з� ���̺�
CREATE TABLE tCategory
(
   category VARCHAR(10) PRIMARY KEY,	-- �з���
   discount INT NOT NULL,			-- ������
   delivery INT NOT NULL,                   	-- ��ۺ�
   takeback CHAR(1)                         	-- ��ǰ ���ɼ�
);

-- �з� ������
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('��ǰ', 0, 3000, 'n');
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('�м�', 10, 2000, 'y');
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('����', 20, 2500, 'y');
INSERT INTO tCategory (category, discount, delivery, takeback) VALUES ('����', 5, 1000, 'n');

-- ��ǰ ���̺�
CREATE TABLE tItem
(
    item VARCHAR(20) PRIMARY KEY,   	-- ��ǰ��
    company VARCHAR(20) NULL,            	-- ������
    num INT NOT NULL,                      	-- ���
    price INT NOT NULL,                     	-- ����
    category VARCHAR(10) NOT NULL,       	-- �з�
    CONSTRAINT item_fk FOREIGN KEY(category) REFERENCES tCategory(category)
);

-- ��ǰ ������
INSERT INTO tItem (item,company,num,price,category) VALUES ('��Ʈ��', '����', 3, 820000, '����');
INSERT INTO tItem (item,company,num,price,category) VALUES ('û����', '���', 80, 32000, '�м�');
INSERT INTO tItem (item,company,num,price,category) VALUES ('���', '������', 24, 16000, '��ǰ');
INSERT INTO tItem (item,company,num,price,category) VALUES ('����', '�������', 19, 15000, '��ǰ');
INSERT INTO tItem (item,company,num,price,category) VALUES ('���ڴ��', 'TNG', 4, 70000, '����');
INSERT INTO tItem (item,company,num,price,category) VALUES ('���콺', '����', 3, 90000, '����');

-- �ֹ� ���̺�
MSSQL :
CREATE TABLE tOrder
(
  orderID INT IDENTITY PRIMARY KEY,		-- �ֹ� ��ȣ
  member VARCHAR(20) NOT NULL,   		-- �ֹ���
  item VARCHAR(20) NOT NULL,			-- ��ǰ
  orderDate DATE DEFAULT GETDATE() NOT NULL,	-- �ֹ� ����
  num INT NOT NULL,				-- ����
  status INT DEFAULT 1 NOT NULL,			-- 1:�ֹ�, 2:�����, 3:��ۿϷ�, 4:��ǰ
  remark VARCHAR(1000) NULL			-- �޸� ����
);

����Ŭ :
CREATE TABLE tOrder
(
  orderID INT GENERATED AS IDENTITY PRIMARY KEY,	-- �ֹ� ��ȣ
  member VARCHAR(20) NOT NULL,   		-- �ֹ���
  item VARCHAR(20) NOT NULL,			-- ��ǰ
  orderDate DATE DEFAULT SYSDATE NOT NULL,	-- �ֹ� ����
  num INT NOT NULL,				-- ����
  status INT DEFAULT 1 NOT NULL,			-- 1:�ֹ�, 2:�����, 3:��ۿϷ�, 4:��ǰ
  remark VARCHAR2(1000) NULL			-- �޸� ����
);

������ :
CREATE TABLE tOrder
(
  orderID INT AUTO_INCREMENT PRIMARY KEY,	-- �ֹ� ��ȣ
  member VARCHAR(20) NOT NULL,   		-- �ֹ���
  item VARCHAR(20) NOT NULL,			-- ��ǰ
  orderDate DATE DEFAULT CURDATE() NOT NULL,	-- �ֹ� ����
  num INT NOT NULL,				-- ����
  status INT DEFAULT 1 NOT NULL,			-- 1:�ֹ�, 2:�����, 3:��ۿϷ�, 4:��ǰ
  remark VARCHAR(1000) NULL			-- �޸� ����
);

-- �ֹ� ������
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('����','û����','2019-12-3',3,2);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('���','����','2019-12-4',10,1);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('����','���ڴ��','2019-12-2',4,1);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('���','���','2019-12-5',5,2);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('���','��Ʈ��','2019-12-5',2,1);
INSERT INTO tOrder (member,item,orderDate,num,status) VALUES ('����','�ڵ���','2019-11-1',1,3);

member VARCHAR(20) NOT NULL REFERENCES tMember(member),   	-- �ֹ���
item VARCHAR(20) NOT NULL REFERENCES tItem(item),			-- ��ǰ

DROP TABLE tOrder, tItem, tCategory, tMember;

-------------------------------------------------
-- 9��

SELECT MAX(popu), name FROM tCity;

SELECT name FROM tCity WHERE popu = MAX(popu);

SELECT MAX(popu) FROM tCity;

SELECT name FROM tCity WHERE popu = 974;

SELECT name FROM tCity WHERE popu = (SELECT MAX(popu) FROM tCity);

SELECT MAX(num) FROM tItem;

SELECT item FROM tItem WHERE num = 80;

SELECT item FROM tItem WHERE num = (SELECT MAX(num) FROM tItem);

SELECT category FROM tItem WHERE item= 'û����';

SELECT delivery FROM tCategory WHERE category = '�м�';

SELECT delivery FROM tCategory WHERE category = (SELECT category FROM tItem 
WHERE item = 'û����');

SELECT item FROM tItem WHERE price = 70000;

SELECT member FROM tOrder WHERE item = 
(SELECT item FROM tItem WHERE price = 70000);

SELECT age FROM tMember WHERE member = 
(SELECT member FROM tOrder WHERE item = 
(SELECT item FROM tItem WHERE price = 70000));

SELECT price FROM tItem WHERE item = 
(SELECT item FROM tOrder WHERE member = '���');

SELECT price FROM tItem WHERE item = 
(SELECT item FROM tOrder WHERE member = '���' 
ORDER BY item OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY);

SELECT item, price FROM tItem WHERE item IN 
(SELECT item FROM tOrder WHERE member = '���');

SELECT item, price FROM tItem WHERE item IN ('����', '���');

SELECT price FROM tItem WHERE item = (SELECT item FROM tOrder WHERE member = '�̵���');

SELECT depart, gender FROM tStaff WHERE name = '������';

SELECT * FROM tStaff WHERE depart = '������' AND gender = '��';

SELECT * FROM tStaff WHERE depart = 
(SELECT depart FROM tStaff WHERE name = '���߱�')
AND gender = (SELECT gender FROM tStaff WHERE name = '���߱�');

SELECT * FROM tStaff WHERE (depart, gender) = 
(SELECT depart, gender FROM tStaff WHERE name = '���߱�');

SELECT * FROM tStaff WHERE (depart, salary) IN 
(SELECT depart, MAX(salary) FROM tStaff GROUP BY depart);

SELECT * FROM tStaff S WHERE salary = 
(SELECT MAX(salary) FROM tStaff WHERE depart = S.depart);

SELECT T.* FROM tStaff T
INNER JOIN (SELECT depart, MAX(salary) ms FROM tStaff GROUP BY depart) M
ON T.depart = M.depart AND T.salary = M.ms;

UPDATE tCity SET (area, popu) = (SELECT area, popu FROM tCity WHERE name='�λ�') 
WHERE name = '����';

SELECT name FROM tStaff WHERE salary > ANY 
(SELECT salary FROM tStaff WHERE depart = '������');
SELECT name FROM tStaff WHERE salary > ALL 
(SELECT salary FROM tStaff WHERE depart = '������');

SELECT name FROM tStaff WHERE salary > 
(SELECT MIN(salary) FROM tStaff WHERE depart = '������');
SELECT name FROM tStaff WHERE salary > 
(SELECT MAX(salary) FROM tStaff WHERE depart = '������');

SELECT item, price FROM tItem WHERE item = ANY 
(SELECT item FROM tOrder WHERE member = '���');

SELECT member, item, (SELECT price FROM tItem WHERE tItem.item = tOrder.item) price 
FROM tOrder;

SELECT O.member, O.item, (SELECT price FROM tItem I WHERE I.item = O.item) price 
FROM tOrder O;

SELECT O.member, O.item, I.price FROM tOrder O JOIN tItem I ON I.item = O.item; 

EXISTS (SELECT * FROM tCity WHERE area > 1000)

SELECT name FROM tCity WHERE EXISTS (SELECT * FROM tCity WHERE area > 1000);

SELECT name FROM tCity C WHERE EXISTS (SELECT * FROM tCity WHERE C.area > 1000);

SELECT * FROM tMember M WHERE EXISTS 
(SELECT * FROM tOrder O WHERE O.member = M.member);

SELECT * FROM tMember M WHERE NOT EXISTS 
(SELECT * FROM tOrder O WHERE O.member = M.member);

SELECT * FROM tMember WHERE member IN (SELECT DISTINCT member FROM tOrder);

....EXISTS (SELECT item FROM tOrder O WHERE O.member = M.member);
....EXISTS (SELECT member FROM tOrder O WHERE O.member = M.member);
....EXISTS (SELECT '�󾾱�' FROM tOrder O WHERE O.member = M.member);

SELECT * FROM (SELECT * FROM tCity) A;

SELECT * FROM (SELECT name, popu, area FROM tCity) A;
SELECT * FROM (SELECT * FROM tCity WHERE metro = 'y') B;

SELECT member, addr FROM (SELECT * FROM tMember WHERE age < 19) A 
WHERE A.money >= 100000;

SELECT member, addr FROM tMember WHERE age < 19 AND money >= 100000;

SELECT * FROM (SELECT * FROM tStaff WHERE grade = '����' OR grade = '����') A 
WHERE A.score >= 70;

SELECT * FROM tStaff WHERE grade = '����' OR grade = '����' AND score >= 70;

SELECT member, addr FROM (SELECT * FROM tMember WHERE age < 19) A 
WHERE A.money >= 100000;

SELECT * FROM (SELECT * FROM tCity WHERE metro = 'y') A;

SELECT * FROM (SELECT * FROM tCity WHERE metro = 'y') AS A;

SELECT name, popu * 10000 AS ingu FROM tCity;

SELECT name, popu * 10000 AS ingu FROM tCity WHERE ingu > 1000000;

SELECT * FROM (
	SELECT name, popu * 10000 AS ingu FROM tCity
) A
WHERE A.ingu > 1000000;

SELECT * FROM (
	SELECT name, popu * 10000 AS ingu FROM tCity
)
WHERE ingu > 1000000;

SELECT name, (popu * 10000 / area) AS dens FROM tCity;

SELECT name, (popu * 10000 / area) AS dens 
	,CASE 
		WHEN (popu * 10000 / area) > 1000 THEN '��е�'
		WHEN (popu * 10000 / area) > 100 THEN '�߹е�'
		ELSE '���е�'
	END densgrade
FROM tCity;

SELECT name, (popu * 10000 / area) AS dens 
	,CASE 
		WHEN dens > 1000 THEN '��е�'
		WHEN dens > 100 THEN '�߹е�'
		ELSE '���е�'
	END densgrade
FROM tCity;

SELECT name, dens 
	,CASE 
		WHEN dens > 1000 THEN '��е�'
		WHEN dens > 100 THEN '�߹е�'
		ELSE '���е�'
	END densgrade
FROM
(
	SELECT name, (popu * 10000 / area) AS dens FROM tCity
) CD;

SELECT name, dens 
	,CASE 
		WHEN dens > 1000 THEN '��е�'
		WHEN dens > 100 THEN '�߹е�'
		ELSE '���е�'
	END densgrade
	,
    CASE
    WHEN
        CASE 
            WHEN dens > 1000 THEN '��е�'
            WHEN dens > 100 THEN '�߹е�'
            ELSE '���е�'
        END = '��е�' THEN '8����'
    WHEN
        CASE 
            WHEN dens > 1000 THEN '��е�'
            WHEN dens > 100 THEN '�߹е�'
            ELSE '���е�'
        END = '�߹е�' THEN '4����'
    ELSE '2����' 
    END roadplan
FROM
(
	SELECT name, (popu * 10000 / area) AS dens FROM tCity
) CD;

SELECT name, dens, densgrade,
CASE
    WHEN densgrade = '��е�' THEN '8����'
    WHEN densgrade = '�߹е�' THEN '4����'
    ELSE '2����' 
END roadplan
FROM
(
    SELECT name, dens 
        ,CASE 
            WHEN dens > 1000 THEN '��е�'
            WHEN dens > 100 THEN '�߹е�'
            ELSE '���е�'
        END densgrade
    FROM
    (
        SELECT name, (popu * 10000 / area) AS dens FROM tCity
    ) CD
) CR;

SELECT * FROM tItem WHERE category = '��ǰ' 
UNION 
SELECT * FROM tItem WHERE category = '����';

SELECT DISTINCT depart FROM tStaff WHERE salary > 400 
UNION ALL
SELECT DISTINCT depart FROM tStaff WHERE score > 80;

SELECT * FROM tItem WHERE category = '��ǰ' OR category = '����';

SELECT * FROM tMember UNION SELECT * FROM tItem;

SELECT member FROM tMember 
UNION
SELECT name FROM tStaff 
UNION
SELECT name FROM tEmployee;

SELECT * FROM �λ�븮�� UNION SELECT * FROM ����븮��;

SELECT name FROM tStaff WHERE depart = '������'
INTERSECT 
SELECT name FROM tStaff WHERE gender = '��';

SELECT name FROM tStaff
INTERSECT
SELECT member FROM tMember;

SELECT name FROM tStaff WHERE depart = '������'
MINUS 
SELECT name FROM tStaff WHERE gender = '��';

SELECT name FROM tStaff WHERE gender = '��'
MINUS
SELECT name FROM tStaff WHERE depart = '������';

����Ŭ, ������ : CREATE TABLE tStaff2 AS SELECT * FROM tStaff;
MSSQL : SELECT * INTO tStaff2 FROM tStaff;

UPDATE tStaff2 SET salary = 500 WHERE name = '��âȣ';
UPDATE tStaff2 SET depart = '�λ��' WHERE name = '���﹮';
DELETE FROM tStaff2 WHERE name = 'ȫ�浿';
INSERT INTO tStaff2 VALUES ('��쵿', '�ѹ���', '��', '20220401', '����', 450, 0);

SELECT * FROM tStaff2
MINUS 
SELECT * FROM tStaff;

����Ŭ, ������ : CREATE TABLE tCityNew AS SELECT * FROM tCity;
MSSQL : SELECT * INTO tCityNew FROM tCity;

UPDATE tCityNew SET popu = 1000 WHERE name = '����';
UPDATE tCityNew SET area = 900 WHERE name = '�λ�';
DELETE FROM tCityNew WHERE name = '��õ';
INSERT INTO tCityNew VALUES ('��õ',461,21,'n','���');

MERGE INTO tCity T USING tCityNew S ON (S.name = T.name)
WHEN MATCHED THEN
	UPDATE SET T.area = S.area, T.popu = S.popu
WHEN NOT MATCHED THEN
	INSERT VALUES (S.name, S.area, S.popu, S.metro, S.region);

MERGE INTO tCity T USING (SELECT * FROM tCityNew WHERE region = '���') S ON (S.name = T.name)
....

MERGE INTO tCity T USING tCityNew S ON (S.name = T.name AND S.region = '���')
....

CREATE TABLE tCityPopu
(
	name CHAR(10) PRIMARY KEY,
	popu INT NULL
);

INSERT INTO tCityPopu VALUES ('����',1000);
INSERT INTO tCityPopu VALUES ('�λ�',500);
INSERT INTO tCityPopu VALUES ('��õ',100);

MERGE INTO tCity C USING tCityPopu P ON (C.name = P.name)
WHEN MATCHED THEN UPDATE SET C.popu = P.popu;

UPDATE tCity SET popu = tCityPopu.popu FROM tCityPopu WHERE tCity.name = tCityPopu.name;

UPDATE tCity SET popu = S.popu FROM tCityPopu AS S WHERE tCity.name = S.name;

UPDATE tCity AS T SET T.popu = S.popu FROM tCityPopu AS S WHERE T.name = S.name;

UPDATE tCity SET popu = (SELECT popu FROM tCityPopu P WHERE P.name = tCity.name)
WHERE name IN (SELECT name FROM tCityPopu)

-------------------------------------------------
-- 10��

CREATE TABLE tCar
(
	car VARCHAR(30) NOT NULL,		-- �̸�
	capacity INT NOT NULL,			-- ��ⷮ
	price INT NOT NULL,			-- ����
	maker VARCHAR(30) NOT NULL		-- ������
);

INSERT INTO tCar (car, capacity, price, maker) VALUES ('�ҳ�Ÿ', 2000, 2500, '����');
INSERT INTO tCar (car, capacity, price, maker) VALUES ('Ƽ����', 1600, 2300, '�ֿ�');
INSERT INTO tCar (car, capacity, price, maker) VALUES ('A8', 3000, 4800, 'Audi');
INSERT INTO tCar (car, capacity, price, maker) VALUES ('SM5', 2000, 2600, '�Ｚ');

CREATE TABLE tMaker
(
	maker VARCHAR(30) NOT NULL,		-- ȸ��
	factory CHAR(10) NOT NULL,	    	-- ����
	domestic CHAR(1) NOT NULL		-- ���� ����. Y/N
);

INSERT INTO tMaker (maker, factory, domestic) VALUES ('����', '�λ�', 'y');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('�ֿ�', 'û��', 'y');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('Audi', '����', 'n');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('���', '����', 'y');

SELECT * FROM tCar, tMaker;

SELECT * FROM tCar CROSS JOIN tMaker;

SELECT * FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT tCar.car, tCar.price, tMaker.maker, tMaker.factory FROM tCar, tMaker 
WHERE tCar.maker = tMaker.maker;

SELECT tCar.*, tMaker.factory FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT car, price, tMaker.maker, factory FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT car, price, maker, factory FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C, tMaker M WHERE C.maker = M.maker;

SELECT A.car, A.price, B.maker, B.factory FROM tCar A, tMaker B WHERE A.maker = B.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C INNER JOIN tMaker M 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tMaker M INNER JOIN tCar C 
ON M.maker = C.maker;

SELECT C.car, C.price, maker, M.factory FROM tCar C INNER JOIN tMaker M USING(maker);

SELECT C.car, C.price, M.maker, M.factory FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C RIGHT OUTER JOIN tMaker M 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tMaker M LEFT OUTER JOIN tCar C 
ON C.maker = M.maker;

SELECT C.car, C.price, M.maker, M.factory FROM tCar C FULL OUTER JOIN tMaker M 
ON C.maker = M.maker;

SELECT * FROM tCar C 
INNER JOIN tMaker M ON C.maker = M.maker 
INNER JOIN tCity T ON M.factory = T.name;

SELECT C.car, M.factory, T.area FROM tCar C 
INNER JOIN tMaker M ON C.maker = M.maker 
INNER JOIN tCity T ON M.factory = T.name;

SELECT * FROM tCar C 
LEFT OUTER JOIN tMaker M ON C.maker = M.maker 
LEFT OUTER JOIN tCity T ON M.factory = T.name;

SELECT * FROM tMaker M 
INNER JOIN tCity T ON M.factory = T.name 
INNER JOIN tCar C ON M.maker = C.maker;

SELECT * FROM tMaker M 
LEFT OUTER JOIN tCity T ON M.factory = T.name 
LEFT OUTER JOIN tCar C ON M.maker = C.maker;

SELECT maker FROM tCar WHERE car = 'Ƽ����';
SELECT factory FROM tMaker WHERE maker = '�ֿ�';

SELECT factory FROM tMaker WHERE maker = 
(SELECT maker FROM tCar WHERE car = 'Ƽ����');

SELECT * FROM tCar C INNER JOIN tMaker M ON M.maker = C.maker;

SELECT * FROM tCar C INNER JOIN tMaker M ON M.maker = C.maker AND C.car = 'Ƽ����';

SELECT M.factory FROM tCar C INNER JOIN tMaker M 
ON M.maker = C.maker AND C.car = 'Ƽ����';

SELECT M.factory, C.price FROM tCar C INNER JOIN tMaker M 
ON M.maker = C.maker AND C.car = 'Ƽ����';

SELECT factory, price FROM tMaker WHERE maker = 
(SELECT maker FROM tCar WHERE car = 'Ƽ����');

SELECT factory, (SELECT price FROM tCar WHERE car = 'Ƽ����') AS price 
FROM tMaker WHERE maker = (SELECT maker FROM tCar WHERE car = 'Ƽ����');

SELECT C.*, M.factory, M.domestic FROM tCar C INNER JOIN tMaker M 
ON M.maker = C.maker AND C.car = 'Ƽ����';

INSERT INTO tCar (car, capacity, price, maker) VALUES ('Ƽ����', 1800, 2600, '�ֿ�');

SELECT C.*, M.factory, M.domestic FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker;

INSERT INTO tCar (car, capacity, price, maker) VALUES ('�ҳ�Ÿ', 2400, 2900, '����');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('����', '���', 'y');
INSERT INTO tMaker (maker, factory, domestic) VALUES ('����', '����', 'y');

SELECT * FROM tCar C INNER JOIN tMaker M ON C.maker = M.maker;

SELECT * FROM tCar C INNER JOIN tMaker M ON C.maker = M.maker WHERE C.capacity = 2000;

SELECT * FROM tCar C INNER JOIN tMaker M ON C.maker = M.maker AND C.capacity = 2000;

SELECT * FROM tCar C LEFT OUTER JOIN tMaker M ON C.maker = M.maker 
WHERE C.capacity = 2000;

SELECT * FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker AND C.capacity = 2000;

SELECT * FROM tCar C LEFT OUTER JOIN tMaker M 
ON C.maker = M.maker AND C.capacity = 2000 WHERE C.price > 2800 ORDER BY price DESC;

SELECT * FROM tCar WHERE capacity > 2000 C LEFT JOIN tMaker M ON C.maker = M.maker;

SELECT * FROM (SELECT * FROM tCar WHERE capacity > 2000) C 
LEFT JOIN tMaker M ON C.maker = M.maker;

SELECT * FROM tCar C LEFT JOIN tMaker M ON C.maker = M.maker WHERE C.capacity > 2000;

SELECT * FROM (SELECT * FROM tCar WHERE capacity > 2000) C LEFT JOIN 
(SELECT * FROM tMaker WHERE factory = '���') M ON C.maker = M.maker;

SELECT * FROM (SELECT * FROM tCar WHERE capacity > 2000) C LEFT JOIN 
tMaker M ON C.maker = M.maker WHERE M.factory = '���';

SELECT * FROM tMember, tOrder;

SELECT * FROM tMember M, tOrder O WHERE M.member = O.member;
SELECT * FROM tMember M INNER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, M.member, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, M.member, O.item, O.num, O.orderDate FROM tMember M 
LEFT OUTER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, O.member, O.item, O.num, O.orderDate FROM tMember M 
RIGHT OUTER JOIN tOrder O ON M.member = O.member;

SELECT M.addr, M.member, O.member, O.item, O.num, O.orderDate FROM tMember M 
FULL OUTER JOIN tOrder O ON M.member = O.member;

SELECT item, price FROM tItem WHERE item = 
(SELECT item FROM tOrder WHERE member='����');

SELECT * FROM tItem I INNER JOIN tOrder O ON O.item = I.item;

SELECT * FROM tItem I INNER JOIN tOrder O ON O.item = I.item WHERE O.member = '����';
SELECT * FROM tItem I INNER JOIN tOrder O ON O.item = I.item AND O.member = '����';

SELECT O.item, I.price FROM tItem I 
INNER JOIN tOrder O ON O.item = I.item WHERE O.member = '����';

SELECT O.item, I.price, O.num FROM tItem I 
INNER JOIN tOrder O ON O.item = I.item WHERE O.member = '���';

SELECT item, price, num FROM tItem WHERE item IN 
(SELECT item FROM tOrder WHERE member='���');

SELECT item, price, (SELECT num FROM tOrder O WHERE O.item = I.item) 
FROM tItem I WHERE item IN (SELECT item FROM tOrder WHERE member='���');

SELECT * FROM tMember;

SELECT * FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member; 

SELECT * FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item;

SELECT * FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item
INNER JOIN tCategory C ON I.category = C.category;

SELECT M.member, O.item, O.num, O.orderDate, I.price, C.delivery FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item
INNER JOIN tCategory C ON I.category = C.category;

SELECT M.member, O.item, O.num, O.orderDate, I.price, C.delivery 
FROM (SELECT * FROM tMember WHERE age > 19) M 
INNER JOIN tOrder O ON M.member = O.member 
INNER JOIN tItem I ON I.item = O.item
LEFT OUTER JOIN tCategory C ON I.category = C.category AND C.category != '����'
WHERE I.price * O.num > 100000 ORDER BY M.member;

SELECT M.member, O.item, O.num, I.price FROM tMember M 
INNER JOIN tOrder O ON M.member = O.MEMBER 
INNER JOIN tItem I ON I.item = O.item;

SELECT member, num * price AS total, item FROM
(
    SELECT M.member, O.item, O.num, I.price FROM tMember M 
    INNER JOIN tOrder O ON M.member = O.MEMBER 
    INNER JOIN tItem I ON I.item = O.item
) A;

SELECT * FROM
(
	SELECT M.member, M.addr, O.item, O.num, O.orderDate, I.price, C.delivery 
	FROM (SELECT * FROM tMember WHERE age > 19) M 
	INNER JOIN tOrder O ON M.member = O.member 
	INNER JOIN tItem I ON I.item = O.item
	LEFT OUTER JOIN tCategory C ON I.category = C.category AND C.category != '����'
	WHERE I.price * O.num > 100000
) A
LEFT OUTER JOIN tCity T ON TRIM(T.name) = SUBSTR(A.addr, 0, 2);

MSSQL : LEFT OUTER JOIN tCity T ON T.name = SUBSTRING(A.addr, 0, 4);
������ : LEFT OUTER JOIN tCity T ON T.name = SUBSTRING(addr, 1, 2);

CREATE TABLE tDirectory
(
	id INT PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	parent INT NOT NULL
);

INSERT INTO tDirectory (id, Name, parent) VALUES (1, 'Root', 0);
INSERT INTO tDirectory (id, Name, parent) VALUES (2, 'Data', 1);
INSERT INTO tDirectory (id, Name, parent) VALUES (3, 'Program', 1);
INSERT INTO tDirectory (id, name, parent) VALUES (4, 'Sound', 2);
INSERT INTO tDirectory (id, name, parent) VALUES (5, 'Picture', 2);
INSERT INTO tDirectory (id, name, parent) VALUES (6, 'Game', 3);
INSERT INTO tDirectory (id, name, parent) VALUES (7, 'StartCraft', 6);

SELECT A.name �θ�, B.name �ڽ� FROM tDirectory A 
INNER JOIN tDirectory B ON A.id = B.parent;

SELECT A.name �θ�, A.id, B.name, B.parent �ڽ� FROM tDirectory A CROSS JOIN tDirectory B;

SELECT * FROM tCar, tMaker WHERE tCar.maker = tMaker.maker;

SELECT * FROM tCar INNER JOIN tMaker ON tCar.maker = tMaker.maker;

SELECT * FROM tCar LEFT OUTER JOIN tMaker ON tCar.maker = tMaker.maker;

SELECT * FROM tCar, tMaker WHERE tCar.maker = tMaker.maker(+);
SELECT * FROM tCar, tMaker WHERE tCar.maker(+) = tMaker.maker;

SELECT * FROM tCar, tMaker WHERE tCar.maker *= tMaker.maker;

-------------------------------------------------
-- 11��

SELECT AVG(score) FROM tStaff WHERE depart = '������';

SELECT ROUND(AVG(score), 2) FROM tStaff WHERE depart = '������';

SELECT name, REPLACE(depart, '��', '��') FROM tStaff;

SELECT name, grade, salary FROM tStaff WHERE depart='�λ��';

SELECT TRIM(name) || ' ' || grade, salary FROM tStaff WHERE depart='�λ��';

MSSQL : SELECT TRIM(name) + ' ' + grade, salary FROM tStaff WHERE depart='�λ��';
������ : SELECT CONCAT(name, ' ', grade), salary FROM tStaff WHERE depart='�λ��';

SELECT ROUND(1234.5678, 0) FROM dual;	-- 1235
SELECT ROUND(1234.5678, 1) FROM dual;	-- 1234.6
SELECT ROUND(1234.5678, 2) FROM dual; 	-- 1234.57

SELECT name, area, ROUND(area, -2) FROM tCity;

SELECT LENGTH('korea���ѹα�') FROM dual;		-- 9
SELECT LENGTHB('korea���ѹα�') FROM dual;		-- 17

SELECT * FROM tItem WHERE LENGTH(item) = 2;

SELECT CONCAT(region, name) FROM tCity;

����Ŭ : SELECT region || name FROM tCity;
MSSQL : SELECT region + name FROM tCity;

SELECT region || '���� ' || name FROM tCity;

SELECT CONCAT(CONCAT(region, '���� '), name) FROM tCity;
MSSQL, ������ : SELECT CONCAT(region, '���� ' , name) FROM tCity;

SELECT INSTR('�츮���� ���ѹα�', '����') FROM dual;      -- 3
SELECT INSTR('�츮���� ���ѹα�', '����') FROM dual;      -- 0

SELECT INSTR('���ο� ���� ������ ���� ������ ���δ�', '����', 3) FROM dual;     -- 8
SELECT INSTR('���ο� ���� ������ ���� ������ ���δ�', '����', 1, 3) FROM dual;  -- 15
SELECT INSTR('���ο� ���� ������ ���� ������ ���δ�', '����', -1) FROM dual;    -- 19

MSSQL : SELECT CHARINDEX('����', '���ο� ���� ������ ���� ������ ���δ�', 3);     -- 8
������ : SELECT POSITION('����' IN '���ο� ���� ������ ���� ������ ���δ�');     -- 1

SELECT SUBSTR('�Ƹ��ٿ� ���ѹα� �ݼ�����', 6, 4) FROM dual;    -- ���ѹα�
SELECT SUBSTR('�Ƹ��ٿ� ���ѹα� �ݼ�����', -4, 2) FROM dual;   -- �ݼ�

SELECT SUBSTR(name,1,1), COUNT(*) FROM tStaff GROUP BY SUBSTR(name,1,1) 
ORDER BY COUNT(*) DESC;

SELECT SUBSTR('...�̸�:ȫ�浿,...', INSTR('...�̸�:ȫ�浿,...','�̸�') + 3, 3) FROM dual;

SELECT LOWER('wonderful SQL') FROM dual; -- wonderful sql
SELECT UPPER('wonderful SQL') FROM dual; -- WONDERFUL SQL
SELECT INITCAP('wonderful SQL') FROM dual; -- Wonderful Sql

SELECT * FROM tCity WHERE metro = 'y';

SELECT * FROM tCity WHERE UPPER(metro) = 'Y';
SELECT * FROM tCity WHERE LOWER(metro) = 'y';

SELECT CONCAT(name, ' �����') FROM tStaff;

SELECT CONCAT(TRIM(name), ' �����') FROM tStaff;

SELECT LPAD('SQL', 10, '>') FROM dual;  -- >>>>>>>SQL
SELECT RPAD('SQL', 10, '<') FROM dual;  -- SQL<<<<<<<

SELECT LPAD(RPAD('SQL', 10, '<'), 17, '>') FROM dual;	-- >>>>>>>SQL<<<<<<<

SELECT name, LPAD(area, 4, '0') FROM tCity;

SELECT REPLACE('������ �Ϻ����̴�', '�Ϻ�', '�ѱ�') FROM dual;

SELECT REPLACE('���ۿ��� ���۸��Ѵ�.', '����', '���̹�') FROM dual; 	
-- ���̹����� ���̹����Ѵ�.

SELECT REPLACE('Get_Total_Score', '_', '') FROM dual;   -- GetTotalScore

SELECT REPLACE('������ �Ϻ����̴�. �븶���� �Ϻ����̴�.', '�Ϻ�', '�ѱ�') FROM dual;

SELECT STUFF('������ �Ϻ����̴�. �븶���� �Ϻ����̴�.', 5, 2, '�ѱ�');

SELECT SUBSTR('������ �Ϻ����̴�. �븶���� �Ϻ����̴�.', 1, 
INSTR('������ �Ϻ����̴�. �븶���� �Ϻ����̴�.', '�Ϻ�') - 1) || '�ѱ�' ||
SUBSTR('������ �Ϻ����̴�. �븶���� �Ϻ����̴�.', 
INSTR('������ �Ϻ����̴�. �븶���� �Ϻ����̴�.', '�Ϻ�') + 2) FROM dual;

SELECT SUBSTR(str, 1 , INSTR(str, '�Ϻ�') - 1) || '�ѱ�' || SUBSTR(str, INSTR(str, '�Ϻ�') + 2) 
FROM tTable;

pos = INSTR(str, '�Ϻ�');
SELECT SUBSTR(str, 1 , pos - 1) || '�ѱ�' || SUBSTR(str, pos + 2) FROM tTable;

INSERT INTO tDate VALUES (TO_DATE('2021/12/25 12:34:56', 'yyyy/mm/dd hh24:mi:ss'));

SELECT AVG(popu) FROM tCity;

����Ŭ : SELECT CAST(AVG(popu) AS INT) FROM tCity;		-- 193
MSSQL : SELECT AVG(CAST(popu AS DECIMAL)) FROM tCity;	-- 193.25

SELECT '12' + 34 FROM dual;	-- 46
SELECT '12' || 34 FROM dual;	-- 1234

SELECT '12' + 34;					-- 46
SELECT '12' + CAST(34 AS VARCHAR(10));	-- 1234

SELECT '�����϶� ' + 1989;				-- ����
SELECT '�����϶� ' + CAST(1989 AS VARCHAR(10));	-- �����϶� 1989

SELECT '�����϶� ' || 1989 FROM dual;

SELECT TO_CHAR(12345) FROM dual;		-- 12345
SELECT TO_CHAR(12345, '999,999') FROM dual;	--  12,345
SELECT TO_CHAR(12345, 'FM999,999') FROM dual; 	-- 12,345
SELECT TO_CHAR(12345, '000,999') FROM dual; 	-- 012,345

SELECT TO_NUMBER('12345') FROM dual;		-- 12345
SELECT TO_NUMBER('12,345') FROM dual;		-- ����
SELECT TO_NUMBER('12,345', '999,999') FROM dual;	-- 12345

SELECT '�����϶� ' + CONVERT(VARCHAR(10), 1989);		-- �����϶� 1989

����Ŭ : SELECT name, NVL(score, 10) FROM tStaff;
MSSQL : SELECT name, ISNULL(score, 10) FROM tStaff;
������ : SELECT name, IFNULL(score, 10) FROM tStaff;

SELECT name, NULLIF(score, 0) FROM tStaff;

SELECT name, NVL(NULLIF(score, 0), 60) FROM tStaff;

SELECT name, NVL2(score, salary * score / 100, 50) FROM tStaff;

SELECT name, DECODE(gender, '��', '������', '��', '������', '����') FROM tStaff;

SELECT SYSDATE FROM dual;  -- 20/10/17 12:21:42

INSERT INTO tStaff VALUES ('���ѽ�', '��ȹ��', '��', SYSDATE, '����', 480, 50);

SELECT SYSDATE + 12 FROM dual;

SELECT SYSDATE + 5/24 FROM dual;
SELECT SYSDATE - 30/1440 FROM dual;
SELECT SYSDATE - 80/86400 FROM dual;

SELECT name, sysdate - joindate FROM tStaff;

SELECT TO_CHAR(SYSDATE, 'yyyy/mm/dd hh24:mi:ss') FROM dual;	  -- 2020/10/17 12:18:51
SELECT TO_CHAR(SYSDATE, 'yyyy/mm/dd AM hh:mi:ss') FROM dual; -- 2020/10/17 ���� 12:20:35

SELECT TO_CHAR(SYSDATE, 'yyyy"��" mm"��" dd"��" hh24"��" mi"��" ss"��"') FROM dual;
-- 2020�� 10�� 17�� 12�� 24�� 44��

SELECT name, TO_CHAR(joindate, 'yyyy') FROM tStaff;

SELECT TO_CHAR(joindate, 'yyyy') AS ��, TO_CHAR(joindate, 'mm') AS ��, 
TO_CHAR(joindate, 'dd') AS �� FROM tStaff;

SELECT TO_DATE('1919/3/1', 'yyyy/mm/dd') FROM dual;

SELECT TO_DATE('1919-3-1', 'yyyy-mm-dd') FROM dual;
SELECT TO_DATE('19190301', 'yyyymmdd') FROM dual;

SELECT TO_DATE('1919/3/1') FROM dual;
SELECT TO_DATE('1919-3-1') FROM dual;
SELECT TO_DATE('19190301') FROM dual;

SELECT sysdate - '1919/3/1' FROM dual;	-- ����

SELECT sysdate - TO_DATE('1919/3/1') FROM dual;

SELECT TO_CHAR(TO_DATE('2023/3/8', 'yyyy/mm/dd') + 99, 'yyyy"��" mm"��" dd"��"') FROM dual;

SELECT GETDATE();

SELECT name, YEAR(joindate) AS ��, MONTH(joindate) AS ��, DAY(joindate) AS �� FROM tStaff;

SELECT YEAR(joindate), count(*) FROM tStaff GROUP BY YEAR(joindate) 
ORDER BY YEAR(joindate);

SELECT DATEPART(dw, GETDATE());
SELECT DATENAME(dw, GETDATE());

SELECT name, DATEDIFF(day,joindate,GETDATE()) FROM tStaff;

SELECT DATEDIFF(day, '1919/3/1', GETDATE());

SELECT CONVERT(VARCHAR(20), GETDATE(),0);		-- 06 29 2021 10:43PM
SELECT CONVERT(VARCHAR(20), GETDATE(),11);		-- 21/06/29
SELECT CONVERT(VARCHAR(20), GETDATE(),111); 		-- 2021/06/29
SELECT CONVERT(VARCHAR(20), GETDATE(),101); 		-- 06/29/2021
SELECT CONVERT(VARCHAR(20), GETDATE(),103); 		-- 29/06/2021

SELECT NOW();

SELECT DATE_FORMAT(NOW(), '%Y/%m/%d %H:%i:%s');

SELECT DATE_FORMAT(joindate, '%Y'), count(*) FROM tStaff 
GROUP BY DATE_FORMAT(joindate, '%Y') ORDER BY DATE_FORMAT(joindate, '%Y');

SELECT DATE_ADD(NOW(), INTERVAL 12 DAY);		-- 12�� ��
SELECT DATE_ADD(NOW(), INTERVAL 5 HOUR);		-- 5�ð� ��
SELECT DATE_SUB(NOW(), INTERVAL 30 MINUTE);		-- 30�� ��

SELECT name, DATEDIFF(NOW(), joindate) FROM tStaff;

-------------------------------------------------
-- 12��

SELECT member, age, addr FROM tMember;

CREATE VIEW vMember AS
SELECT member, age, addr FROM tMember;

SELECT * FROM vMember;

SELECT member, age FROM vMember;
SELECT * FROM vMember WHERE addr LIKE '%����%';
SELECT * FROM vMember ORDER BY member;

SELECT name, email FROM vMember;

DROP VIEW vMember;

CREATE VIEW vMember AS SELECT member, age, addr, email FROM tMember;

����Ŭ, ������ : CREATE OR REPLACE VIEW vMember AS SELECT member, age, addr, email FROM tMember;
MSSQL : ALTER VIEW vMember AS SELECT member, age, addr, email FROM tMember;

CREATE VIEW vMemberMirror AS SELECT * FROM tMember;

CREATE VIEW vStaffVirt AS SELECT depart, salary, name FROM tStaff;

CREATE VIEW vStaffHorz AS SELECT * FROM tStaff WHERE depart = '�ѹ���';

CREATE VIEW vStaffPart AS SELECT name, salary FROM tStaff WHERE depart = '�ѹ���';

CREATE VIEW vStaffAlias(n, d, s) AS SELECT name, depart, salary FROM tStaff;

CREATE OR REPLACE VIEW vStaffAlias AS SELECT name n, depart d , salary s FROM tStaff;

SELECT * FROM vStaffAlias ORDER BY s;           -- ����
SELECT * FROM vStaffAlias ORDER BY salary;      -- ����

CREATE VIEW vStaffBonus AS SELECT name, salary * score / 100 AS bonus FROM tStaff;

SELECT * FROM vStaffBonus WHERE bonus > 300;

CREATE VIEW vShopping AS
SELECT M.member, M.addr, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member;

CREATE VIEW vUnion AS
SELECT name, salary FROM tStaff WHERE depart = '�λ��'
UNION
SELECT name, salary FROM tEmployee;

CREATE VIEW vvStaffHorz AS
SELECT name, joindate, salary FROM vStaffHorz;

CREATE VIEW vOriginal AS SELECT a, b, c FROM tOriginal;

CREATE VIEW vOriginal(a, b, c) AS SELECT x, y, c FROM tOriginal;

UPDATE vMember SET addr = '���� �Ż絿' WHERE member = '����';

UPDATE vStaffBonus SET bonus = 500 WHERE name = '������';

INSERT INTO vStaffHorz VALUES ('���ѽ�', '�ѹ���', '��', '2022/08/14', '���', 520, 55);

INSERT INTO vStaffHorz VALUES ('���Ѱ�', '������', '��', '2023/05/13', '���', 490, 35);

CREATE VIEW vStaffHorzCheck AS 
SELECT * FROM tStaff WHERE depart = '�ѹ���' WITH CHECK OPTION;

DELETE FROM tStaff WHERE name IN ('���ѽ�','���Ѱ�');
INSERT INTO vStaffHorzCheck VALUES ('���Ѱ�', '������', '��', '2023/05/13', '���', 490, 35);

UPDATE vStaffHorzCheck SET depart = '��ȹ��' WHERE name = '������';

INSERT INTO vStaffVirt (name, depart, salary) VALUES ('�̿Ͽ�', '������', 99);

CREATE VIEW vNotExist AS SELECT * FROM tNotExist;		-- ����
CREATE FORCE VIEW vNotExist AS SELECT * FROM tNotExist;	-- ����

CREATE VIEW vStaffReadOnly AS SELECT * FROM tStaff 
WHERE depart = '�λ��' WITH READ ONLY;

CREATE VIEW vMemberEnc WITH ENCRYPTION AS
SELECT member, age, addr FROM tMember;

CREATE GLOBAL TEMPORARY TABLE tGtt (
	name VARCHAR(20) PRIMARY KEY,
	score INT
);

INSERT INTO tGtt VALUES ('���ѽ�', 95);
INSERT INTO tGtt VALUES ('���Ѱ�', 80);
SELECT * FROM tGtt;

DROP TABLE tGtt;
CREATE GLOBAL TEMPORARY TABLE tGtt (
	name VARCHAR(20) PRIMARY KEY,
	score INT
) ON COMMIT PRESERVE ROWS;

INSERT INTO tGtt VALUES ('��Թ�', 70);
SELECT * FROM tGtt;

CREATE TABLE #tTemp (
	name VARCHAR(20) PRIMARY KEY,
	score INT
);

INSERT INTO #tTemp VALUES ('���ѽ�', 95);
INSERT INTO #tTemp VALUES ('���Ѱ�', 80);
INSERT INTO #tTemp VALUES ('��Թ�', 70);
SELECT * FROM #tTemp;

CREATE TEMPORARY TABLE tTemp (
	name VARCHAR(20) PRIMARY KEY,
	score INT
);

INSERT INTO tTemp VALUES ('���ѽ�', 95);
INSERT INTO tTemp VALUES ('���Ѱ�', 80);
INSERT INTO tTemp VALUES ('��Թ�', 70);
SELECT * FROM tTemp;

CREATE GLOBAL TEMPORARY TABLE tTaskForce AS SELECT * FROM tStaff;

INSERT INTO tTaskForce SELECT * FROM (SELECT * FROM tStaff 
WHERE joindate <= '20160101' ORDER BY salary DESC) WHERE rownum <= 10;

MSSQL : SELECT TOP 10 * INTO #tTaskForce FROM tStaff 
WHERE joindate <= '20160101' ORDER BY salary DESC;
������ : CREATE TEMPORARY TABLE tTaskForce AS SELECT * FROM tStaff 
WHERE joindate <= '20160101' ORDER BY salary DESC LIMIT 10;

DELETE FROM tTaskForce WHERE score < (SELECT AVG(score) FROM tTaskForce 
WHERE gender = '��') AND gender = '��';

DELETE FROM tTaskForce WHERE salary < 
(SELECT AVG(salary) FROM tStaff) AND gender = '��';

DELETE FROM tTaskForce WHERE salary > 300 AND grade = '�븮';
INSERT INTO tTaskForce SELECT * FROM tStaff WHERE salary > 380 AND grade = '����';

SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��';

SELECT * FROM 
(
	SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��'
) A
WHERE salary >= (
	SELECT avg(salary) FROM 
	(
		SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��'
	) B
);

CREATE GLOBAL TEMPORARY TABLE tBusiMan AS SELECT name, salary, score FROM tStaff;
INSERT INTO tBusiMan SELECT name, salary, score FROM tStaff 
WHERE depart = '������' AND gender = '��';

MSSQL: SELECT name, salary, score INTO #tBusiMan FROM tStaff 
WHERE depart = '������' AND gender = '��';
������ : CREATE TEMPORARY TABLE tBusiMan AS 
SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��';

SELECT * FROM tBusiMan WHERE salary >= (SELECT avg(salary) FROM tBusiMan);

CREATE VIEW vBusiMan AS SELECT name, salary, score FROM tStaff 
WHERE depart = '������' AND gender = '��';
SELECT * FROM vBusiMan WHERE salary >= (SELECT avg(salary) FROM vBusiMan);

WITH tBusiMan AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��')
SELECT * FROM tBusiMan WHERE salary >= (SELECT avg(salary) FROM tBusiMan);

WITH tBusiMan(�̸�, ����, ���뵵) AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��')
SELECT * FROM tBusiMan WHERE ���� >= (SELECT avg(����) FROM tBusiMan);

WITH tBusiMan AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��'),
tBusiGirl AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��')
SELECT * FROM tBusiGirl WHERE salary >= (SELECT avg(salary) FROM tBusiMan);

WITH tBusiMan AS 
(SELECT name, salary, score FROM tStaff WHERE depart = '������' AND gender = '��'),
tBusiManGod AS 
(SELECT name, salary, score FROM tBusiMan WHERE score > 70)
SELECT * FROM tBusiManGod;

WITH Shopping AS
(SELECT M.member, M.addr, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member)
SELECT * FROM Shopping WHERE num >= (SELECT AVG(num) FROM Shopping);

CREATE VIEW vTemp AS
(SELECT M.member, M.addr, O.item, O.num, O.orderDate FROM tMember M 
INNER JOIN tOrder O ON M.member = O.member);

SELECT * FROM vTemp WHERE num >= (SELECT AVG(num) FROM vTemp);

WITH tFact(num, sum) AS (
	SELECT 1 AS num, 1 AS sum FROM dual
	UNION ALL
	SELECT num + 1, sum * (num + 1) FROM tFact T WHERE T.num < 10
)
SELECT * FROM tFact;

WITH tTree(id, name, parent, depth) AS
(
	SELECT id, name, parent, 0 FROM tDirectory WHERE parent = 0
	UNION ALL
	SELECT D.id, D.name, D.parent, T.depth + 1 FROM tDirectory D 
	INNER JOIN tTree T ON D.parent = T.id
)
SELECT * FROM tTree;

WITH tTree(id, name, parent, depth, fullpath) AS
(
	SELECT id, name, parent, 0, CAST(name AS VARCHAR(256)) 
	FROM tDirectory WHERE parent = 0
	UNION ALL
	SELECT D.id, D.name, D.parent, T.depth + 1, 
	CAST(CONCAT(CONCAT(T.fullpath, '/'), D.name) AS VARCHAR(256)) 
	FROM tDirectory D 
	INNER JOIN tTree T ON D.parent = T.id
)
SELECT * FROM tTree;

WITH tTree(id, name, parent, depth, fullpath) AS
(
	SELECT id, name, parent, 0, CAST(name AS VARCHAR(256)) 
	FROM tDirectory WHERE parent = 0
	UNION ALL
	SELECT D.id, D.name, D.parent, T.depth + 1, 
	LPAD('L ', (T.depth + 1) * 4) || D.name 
	FROM tDirectory D 
	INNER JOIN tTree T ON D.parent = T.id
)
SELECT fullpath FROM tTree;

CAST(SPACE((T.depth + 1) * 4) + 'L ' + D.name AS VARCHAR(256))

-------------------------------------------------
-- 13��

CREATE TABLE tMonthSale
(
	year INT,
	month INT,
	sales	INT
);

INSERT INTO tMonthSale VALUES(2021, 9, 3650);
INSERT INTO tMonthSale VALUES(2021, 10, 4120);
INSERT INTO tMonthSale VALUES(2021, 11, 5000);
INSERT INTO tMonthSale VALUES(2021, 12, 4420);
INSERT INTO tMonthSale VALUES(2022, 1, 3800);
INSERT INTO tMonthSale VALUES(2022, 2, 4200);
INSERT INTO tMonthSale VALUES(2022, 3, 4150);

SELECT gender, SUM(salary) FROM tStaff GROUP BY gender;
SELECT depart, SUM(salary) FROM tStaff GROUP BY depart;
SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY depart, gender;

SELECT depart, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart, gender);

SELECT gender, depart, SUM(salary) FROM tStaff GROUP BY ROLLUP(gender, depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY depart, ROLLUP(gender);
SELECT gender, depart, SUM(salary) FROM tStaff GROUP BY gender, ROLLUP(depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY CUBE(depart, gender);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart, gender)
UNION
SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY ROLLUP(gender, depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY CUBE(gender, depart);

SELECT depart, gender, SUM(salary) FROM tStaff GROUP BY GROUPING SETS(depart, gender);

SELECT GROUPING(depart), depart, SUM(salary) FROM tStaff GROUP BY ROLLUP(depart);

SELECT CASE GROUPING(depart) WHEN 1 THEN '��ü�μ�' ELSE depart END AS depart, 
SUM(salary) FROM tStaff GROUP BY ROLLUP(depart);

SELECT CASE GROUPING(depart) WHEN 1 THEN '��ü�μ�' ELSE depart END AS depart,
	CASE GROUPING(gender) WHEN 1 THEN '��ü����' ELSE gender END AS gender, 
	SUM(salary) FROM tStaff GROUP BY CUBE(depart, gender)
	ORDER BY /*GROUPING(depart), GROUPING(gender),*/ depart, gender;

SELECT name, depart, salary, SUM(salary) FROM tStaff;

SELECT depart, SUM(salary) FROM tStaff GROUP BY depart;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff) AS �������� FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER() AS �������� FROM tStaff;

SELECT name, depart, salary, ROUND(salary * 100.0 / SUM(salary) OVER(), 2) 
AS ���޺��� FROM tStaff;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff GROUP BY depart) 
AS �μ��������� FROM tStaff;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff WHERE depart = A.depart) 
AS �μ��������� FROM tStaff A ORDER BY depart;

SELECT name, depart, salary, SUM(salary) OVER(PARTITION BY depart) 
AS �μ��������� FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY name) 
AS �������� FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(PARTITION BY depart ORDER BY name) 
AS �μ��������� FROM tStaff;

SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff 
WHERE name <= A.name) AS �������� FROM tStaff A ORDER BY name;
SELECT name, depart, salary, (SELECT SUM(salary) FROM tStaff 
WHERE name <= A.name AND depart = A.depart) AS �μ��������� 
FROM tStaff A ORDER BY depart, name;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY name 
ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING) AS �������� FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY name 
ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) AS �������� FROM tStaff;

SELECT name, depart, joindate, salary, 
SUM(salary) OVER(PARTITION BY depart ORDER BY joindate 
ROWS BETWEEN CURRENT ROW AND 2 FOLLOWING) AS �������� FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY salary 
ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS �������� FROM tStaff;

SELECT name, depart, salary, SUM(salary) OVER(ORDER BY salary 
RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS �������� FROM tStaff;

SELECT RANK() OVER (ORDER BY salary DESC), tStaff.* FROM tStaff;
MSSQL, ������ : SELECT RANK() OVER (ORDER BY salary DESC), * FROM tStaff;

SELECT RANK() OVER (ORDER BY salary DESC), tStaff.* FROM tStaff ORDER BY score;

SELECT RANK() OVER (ORDER BY salary DESC) AS ����, tStaff.* FROM tStaff 
WHERE depart = '������';

SELECT RANK() OVER (PARTITION BY depart ORDER BY salary DESC) 
AS ����, tStaff.* FROM tStaff;

SELECT DENSE_RANK() OVER (ORDER BY salary DESC), tStaff.* FROM tStaff;

SELECT ROW_NUMBER() OVER (ORDER BY name), tStaff.* FROM tStaff;

SELECT ROW_NUMBER() OVER (ORDER BY rownum) AS ����, tStaff.* FROM tStaff;

SELECT ROW_NUMBER() OVER (ORDER BY name) AS ����, tStaff.* FROM tStaff
ORDER BY ���� OFFSET 2 * 5 ROWS FETCH NEXT 5 ROWS ONLY;

SELECT * FROM
(SELECT ROW_NUMBER() OVER (ORDER BY name) AS ����, tStaff.* FROM tStaff) S
WHERE S.���� > 2 * 5 AND rownum <= 5;

SELECT TOP(5) * FROM
(SELECT ROW_NUMBER() OVER (ORDER BY name) AS ����, tStaff.* FROM tStaff) S
WHERE S.���� > 2 * 5;

SELECT ROW_NUMBER() OVER (ORDER BY name) AS ����, tStaff.* FROM tStaff LIMIT 11, 5;

SELECT NTILE(4) OVER (ORDER BY salary DESC) AS ����, name, salary FROM tStaff;
SELECT NTILE(4) OVER (PARTITION BY gender ORDER BY salary DESC) 
AS ����, name, gender, salary FROM tStaff;

SELECT name, score FROM 
(SELECT NTILE(5) OVER (ORDER BY score DESC) AS ����, tStaff.* FROM tStaff) S 
WHERE S.���� = 3;

SELECT year, month, sales,
	LAG(sales) OVER (ORDER BY year, month) AS priorMonth,
	LEAD(sales) OVER (ORDER BY year, month) AS nextMonth
FROM tMonthSale;

SELECT year, month, sales,
	sales - LAG(sales) OVER (ORDER BY year, month) AS incsales
FROM tMonthSale;

SELECT year, month, sales,
	LAG(sales) OVER (PARTITION BY year ORDER by year, month) AS priorMonth,
	LEAD(sales) OVER (PARTITION BY year ORDER by year, month) AS nextMonth
FROM tMonthSale;

SELECT year, month, sales,
	ROUND(CUME_DIST() OVER (ORDER BY year, month) * 100, 2) AS cume,
	ROUND(PERCENT_RANK() OVER (ORDER BY year, month) * 100, 2) AS rank
FROM tMonthSale;

SELECT name, salary,
	ROUND(CUME_DIST() OVER (ORDER BY salary) * 100, 2) AS cume,
	ROUND(PERCENT_RANK() OVER (ORDER BY salary) * 100, 2) AS rank
FROM tStaff;

SELECT depart, name, salary,
	ROUND(CUME_DIST() OVER (PARTITION BY depart ORDER BY salary) * 100, 2) AS cume,
	ROUND(PERCENT_RANK() OVER (PARTITION BY depart ORDER BY salary) * 100, 2) AS rank
FROM tStaff;

SELECT name, salary,
	FIRST_VALUE(salary) OVER (ORDER BY salary) AS first,
	LAST_VALUE(salary) OVER (ORDER BY salary) AS midlast,
	LAST_VALUE(salary) OVER (ORDER BY salary ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS last
FROM tStaff;

SELECT name, salary,
	salary - FIRST_VALUE(salary) OVER (ORDER BY salary) AS �������ޱ���,
	LAST_VALUE(salary) OVER (ORDER BY salary ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) - salary AS �ְ���ޱ���
FROM tStaff ORDER BY name;

SELECT depart, name, salary,
	salary - FIRST_VALUE(salary) OVER (PARTITION BY depart ORDER BY salary) AS �������ޱ���,
	LAST_VALUE(salary) OVER (PARTITION BY depart ORDER BY salary ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) - salary AS �ְ���ޱ���
FROM tStaff ORDER BY depart, salary;

SELECT year, month, sales,	
PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY sales) 
OVER (PARTITION BY year) AS cont,	
PERCENTILE_DISC(0.5) WITHIN GROUP (ORDER BY sales) 
OVER (PARTITION BY year) AS disc
FROM tMonthSale;

CREATE TABLE tSeason
(
	item VARCHAR(10),
	season VARCHAR(10),
	sale INT
);

INSERT INTO tSeason VALUES ('�ø�', '��', 20);
INSERT INTO tSeason VALUES ('�ø�', '����', 50);
INSERT INTO tSeason VALUES ('�ø�', '����', 30);
INSERT INTO tSeason VALUES ('�ø�', '�ܿ�', 10);
INSERT INTO tSeason VALUES ('«��', '��', 30);
INSERT INTO tSeason VALUES ('«��', '����', 10);
INSERT INTO tSeason VALUES ('«��', '����', 20);
INSERT INTO tSeason VALUES ('«��', '�ܿ�', 40);

SELECT * FROM tSeason
PIVOT (MAX(sale) FOR season IN ('��', '����', '����', '�ܿ�'));

SELECT * FROM tSeason
PIVOT (MAX(sale) FOR season IN ('����', '��', '����'));

SELECT * FROM tSeason
PIVOT (MAX(sale) FOR item IN ('�ø�', '«��'))

SELECT * FROM tSeason
PIVOT (sale FOR season IN ('��', '����', '����', '�ܿ�')) pvt;

SELECT * FROM tSeason
PIVOT (SUM(sale) FOR season IN ('��', '����', '����', '�ܿ�')) pvt;

INSERT INTO tSeason2 VALUES ('�ø�', '��', 20);
INSERT INTO tSeason2 VALUES ('�ø�', '����', 50);
INSERT INTO tSeason2 VALUES ('�ø�', '����', 30);
INSERT INTO tSeason2 VALUES ('«��', '��', 30);
INSERT INTO tSeason2 VALUES ('«��', '����', 20);
INSERT INTO tSeason2 VALUES ('«��', '�ܿ�', 40);
INSERT INTO tSeason2 VALUES ('«��', '�ܿ�', 30);

SELECT * FROM tSeason2 PIVOT (MAX(sale) FOR season IN ('��', '����', '����', '�ܿ�')) pvt;
SELECT * FROM tSeason2 PIVOT (SUM(sale) FOR season IN ('��', '����', '����', '�ܿ�')) pvt;

CREATE TABLE tTraffic
(
	line VARCHAR(10),
	hour INT,
	car VARCHAR(20),
	traffic INT
);

INSERT INTO tTraffic VALUES ('���', 1, '�¿���', 40);
INSERT INTO tTraffic VALUES ('���', 2, '�¿���', 41);
INSERT INTO tTraffic VALUES ('���', 3, '�¿���', 42);
INSERT INTO tTraffic VALUES ('���', 1, 'Ʈ��', 30);
INSERT INTO tTraffic VALUES ('���', 3, 'Ʈ��', 32);
INSERT INTO tTraffic VALUES ('ȣ��', 1, '�¿���', 20);
INSERT INTO tTraffic VALUES ('ȣ��', 2, '�¿���', 10);
INSERT INTO tTraffic VALUES ('ȣ��', 2, '�¿���', 11);
INSERT INTO tTraffic VALUES ('ȣ��', 3, '�¿���', 22);
INSERT INTO tTraffic VALUES ('ȣ��', 1, 'Ʈ��', 10);
INSERT INTO tTraffic VALUES ('ȣ��', 2, 'Ʈ��', 11);
INSERT INTO tTraffic VALUES ('ȣ��', 3, 'Ʈ��', 12);

SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR line IN ('���', 'ȣ��')) pvt;
SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR hour IN ('1', '2', '3')) pvt;

SELECT line, car, traffic FROM tTraffic 
PIVOT (SUM(traffic) FOR car IN ('�¿���', 'Ʈ��')) pvt;

SELECT * FROM
(
	SELECT line, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('�¿���', 'Ʈ��')) pvt;

SELECT line, SUM(�¿���), SUM(Ʈ��) FROM tTraffic
PIVOT (SUM(traffic) FOR car IN ('�¿���' AS �¿���, 'Ʈ��' AS Ʈ��)) pvt
GROUP BY line;

SELECT * FROM
(
	SELECT hour, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('�¿���', 'Ʈ��')) pvt;

SELECT * FROM
(
	SELECT car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('�¿���', 'Ʈ��')) pvt;

SELECT line, Ʈ��, �¿��� FROM
(
	SELECT line, hour, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('�¿���' AS �¿���, 'Ʈ��' AS Ʈ��)) pvt;

SELECT line || '�� ' || CAST(hour AS VARCHAR(10)) || '��' AS ����, Ʈ��, �¿��� FROM
(
	SELECT line, hour, car, traffic FROM tTraffic
) prepvt
PIVOT (SUM(traffic) FOR car IN ('�¿���' AS �¿���, 'Ʈ��' AS Ʈ��)) pvt
ORDER BY line;

CREATE TABLE tCityStat
(
	name CHAR(10),
	attr CHAR(10),
	value INT
);

INSERT INTO tCityStat VALUES ('����', 'area', 605);
INSERT INTO tCityStat VALUES ('����', 'popu', 974);
INSERT INTO tCityStat VALUES ('����', 'gu', 25);
INSERT INTO tCityStat VALUES ('����', 'area', 1646);
INSERT INTO tCityStat VALUES ('����', 'popu', 3);
INSERT INTO tCityStat VALUES ('����', 'home', 15409);
INSERT INTO tCityStat VALUES ('ȫõ', 'area', 1819);

SELECT * FROM tCityStat
PIVOT (MAX(value) FOR attr IN ('area' AS area, 'popu' AS popu)) pvt;

SELECT name, ROUND(popu * 10000 / area, 2) AS �α��е� FROM
(
    SELECT * FROM tCityStat
    PIVOT (MAX(value) FOR attr IN ('area' AS area, 'popu' AS popu)) pvt
) A;

WHERE popu IS NOT NULL AND area IS NOT NULL

CREATE TABLE tSeasonPivot AS 
SELECT * FROM tSeason
PIVOT (SUM(sale) FOR season IN ('��' AS ��, '����' AS ����, '����' AS ����, '�ܿ�' AS �ܿ�));

SELECT * INTO tSeasonPivot FROM tSeason
PIVOT (SUM(sale) FOR season IN (��, ����, ����, �ܿ�)) pvt;

SELECT * FROM tSeasonPivot
UNPIVOT (sale FOR season IN (��, ����, ����, �ܿ�)) unpvt;

SELECT * FROM
(
    SELECT * FROM tSeason
    PIVOT (SUM(sale) FOR season IN 
    ('��' AS ��, '����' AS ����, '����' AS ����, '�ܿ�' AS �ܿ�)) pvt
) A
UNPIVOT (sale FOR season IN (��, ����, ����, �ܿ�)) unpvt;

-------------------------------------------------
-- 14��

ALTER TABLE tCity ADD mayor CHAR(12) NULL;

UPDATE tCity SET mayor = '������' WHERE name = '�λ�';

ALTER TABLE tCity ADD mayor CHAR(12) NOT NULL;

ALTER TABLE tCity DROP COLUMN mayor;

DROP TABLE tProject;
CREATE TABLE tProject
(
	projectID INT,
	employee CHAR(10),
	project VARCHAR(30),
	cost INT
);

INSERT INTO tProject VALUES (1, '�����', 'ȫ�� �����', 800);
INSERT INTO tProject VALUES (1, '�����', 'TV �����', 3400);

TRUNCATE TABLE tProject;
ALTER TABLE tProject ADD CONSTRAINT PK_projectID PRIMARY KEY(projectID);

����Ŭ, MSSQL : ALTER TABLE tProject DROP CONSTRAINT PK_projectID;
����Ŭ, ������ : ALTER TABLE tProject DROP PRIMARY KEY;

DELETE FROM tProject WHERE employee='���̵�';
ALTER TABLE tProject ADD CONSTRAINT FK_Project_Employee 
FOREIGN KEY(employee) REFERENCES tEmployee(name);

ALTER TABLE tProject DROP CONSTRAINT FK_Project_Employee;

����Ŭ, ������ : ALTER TABLE tCity MODIFY region CHAR(30);
MSSQL : ALTER TABLE tCity ALTER COLUMN region CHAR(30);

INSERT INTO tCity VALUES ('����',1849,67,'y','����Ư����ġ��');

����Ŭ, ������ : ALTER TABLE tCity MODIFY region CHAR(1);
MSSQL : ALTER TABLE tCity ALTER COLUMN region CHAR(1);

����Ŭ, ������ : ALTER TABLE tCity MODIFY popu DECIMAL(10,2);
MSSQL : ALTER TABLE tCity ALTER COLUMN popu DECIMAL(10,2);

UPDATE tCity SET popu = 21.2389 WHERE name = '����';

CREATE TABLE tCityBackup AS SELECT * FROM tCity;		-- ���
TRUNCATE TABLE tCity;					-- ���� ���
ALTER TABLE tCity MODIFY popu DECIMAL(10,2);		-- �ʵ� Ÿ�� ����
INSERT INTO tCity SELECT * FROM tCityBackup;		-- ��� ����
UPDATE tCity SET popu = 21.2389 WHERE name = '����';		-- �ʵ尪 ����
COMMIT;									-- Ȯ��
DROP TABLE tCityBackup;					-- ��� ����

DELETE FROM tProject WHERE employee='Ʈ����';
����Ŭ, ������ : ALTER TABLE tProject MODIFY project VARCHAR(30) NOT NULL;	
MSSQL : ALTER TABLE tProject ALTER COLUMN project VARCHAR(30) NOT NULL;

����Ŭ : ALTER TABLE tProject MODIFY cost DEFAULT 100;
������ : ALTER TABLE tProject MODIFY cost VARCHAR(30) DEFAULT 100;
MSSQL : ALTER TABLE tProject ALTER COLUMN project VARCHAR(30) DEFAULT 100 NOT NULL;

INSERT INTO tProject (projectid, employee, project) VALUES (4, '���ٸ�', '���� ��ȭ ȸ�� ����');

INSERT INTO tProject VALUES (5, 'Ŭ����', '���� ����', -100);

DELETE FROM tProject WHERE employee='Ŭ����';
ALTER TABLE tProject ADD CONSTRAINT cost_check CHECK(cost > 0);

CREATE TABLE tCityBackup AS SELECT * FROM tCity;
DROP TABLE tCity;
CREATE TABLE tCity
(
	name CHAR(10) PRIMARY KEY,
	region CHAR(6) NOT NULL,
	area INT NULL ,
	popu INT NULL ,
	metro CHAR(1) NOT NULL
);
INSERT INTO tCity (name, region, area, popu, metro) 
    SELECT name, region, area, popu, metro FROM tCityBackup;
COMMIT;
DROP TABLE tCityBackup;

����Ŭ : ALTER TABLE tCity RENAME COLUMN popu TO ingu;
MSSQL : sp_rename 'tCity.popu', 'ingu';
������ : ALTER TABLE tCity CHANGE popu ingu INT NULL; 

����Ŭ, ������ : ALTER TABLE tCity RENAME TO tDosi;
MSSQL : sp_rename 'tCity', 'tDosi';

COMMENT ON TABLE tCity IS '���� ���';
COMMENT ON COLUMN tCity.popu IS '�α�';

SELECT COMMENTS FROM user_tab_comments where table_name = 'TCITY';
SELECT * FROM user_col_comments where table_name = 'TCITY';

sp_addextendedproperty 'MS_Description', '���ø��', 'USER', DBO, 'TABLE', tCity;
sp_addextendedproperty 'MS_Description', '�α�', 'USER', DBO, 'TABLE', tCity, 'COLUMN', popu;

-------------------------------------------------
-- 15��

SET SERVEROUTPUT ON;

BEGIN
	DBMS_OUTPUT.PUT_LINE('�ȳ��ϼ���');
END;

BEGIN
	DBMS_OUTPUT.PUT_LINE('�ȳ��ϼ���')
END

BEGIN
	DBMS_OUTPUT.PUT_LINE(2 + 3 * 4);
	DBMS_OUTPUT.PUT_LINE(POWER(2, 3));
END;

DECLARE
    v_price INT := 1000;
    v_num INT := 5;
    v_total INT;
BEGIN
    v_total := v_price * v_num;
    DBMS_OUTPUT.PUT_LINE(v_total);
END;

DECLARE v_price INT := 1000;v_num INT := 5;v_total INT;
BEGIN v_total := v_price * v_num;DBMS_OUTPUT.PUT_LINE(v_total);END;

DECLARE
    c_mile CONSTANT NUMBER := 1.609;
    v_kilo INT;
BEGIN
    v_kilo := 400;
    DBMS_OUTPUT.PUT_LINE(v_kilo * c_mile);
END;

DECLARE
    v_price tItem.price%TYPE := 1000;
    v_num v_price%TYPE := 5;
    v_total v_price%TYPE;
BEGIN
    v_total := v_price * v_num;
    DBMS_OUTPUT.PUT_LINE(v_total);
END;

DECLARE 
    v_isOk BOOLEAN;
BEGIN
    v_isOk := (1 = 1);
    IF v_isOK THEN
        DBMS_OUTPUT.PUT_LINE('OK');
    END IF;
END;

DECLARE 
    v_member tOrder.member%TYPE;
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID = 1;
    DBMS_OUTPUT.PUT_LINE(v_member);
END;

DECLARE 
    v_member tOrder.member%TYPE;
    v_item VARCHAR(20);
BEGIN
    SELECT member, item INTO v_member, v_item FROM tOrder WHERE orderID = 1;
    DBMS_OUTPUT.PUT_LINE(v_member || '�� ' || v_item || ' �ֹ�');
END;

DECLARE
    v_row tCity%ROWTYPE;
BEGIN
    SELECT * INTO v_row FROM tCity WHERE name = '�λ�';
    DBMS_OUTPUT.PUT_LINE(TRIM(v_row.name) || ', ' || v_row.area || ', ' || v_row.popu);
END;

DECLARE
    v_row tCity%ROWTYPE;
BEGIN
    SELECT name, region INTO v_row.name, v_row.region FROM tCity WHERE name = '��õ';
    DBMS_OUTPUT.PUT_LINE(v_row.region || '���� ' || v_row.name);
END;

DECLARE
    TYPE cap IS RECORD(area INT, popu INT);
    city cap;
BEGIN
    SELECT area, popu INTO city FROM tCity WHERE name = '�λ�';
    DBMS_OUTPUT.PUT_LINE(city.area || ',' || city.popu);
END;

TYPE cap IS RECORD(area tCity.area%TYPE, popu tCity.popu%TYPE);

DECLARE
    v_maxPopu INT;
    v_cityName VARCHAR(10);
BEGIN
    SELECT MAX(popu) INTO v_maxPopu FROM tCity;
    SELECT name INTO v_cityName FROM tCity WHERE popu = v_maxPopu;
    DBMS_OUTPUT.PUT_LINE(v_cityName);
END;

DECLARE
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '����';
    v_popu := v_popu * 2;
    UPDATE tCity SET popu = v_popu WHERE name = '����';
END;

DECLARE
    TYPE int_array IS VARRAY(5) OF NUMBER;
    ar int_array;
BEGIN
    ar := int_array(8, 9, 0, 6, 2);
    FOR idx IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(ar(idx));
    END LOOP;
END;

DECLARE
    TYPE int_array IS VARRAY(3) OF NUMBER;
    TYPE int_array2 IS VARRAY(3) OF int_array;
    ar int_array2;
BEGIN
    ar := int_array2(int_array(1, 2, 3), int_array(4, 5, 6), int_array(7, 8, 9));
    DBMS_OUTPUT.PUT_LINE(ar(2)(3));
END;

DECLARE
    TYPE int_table IS TABLE OF NUMBER;
    ar int_table;
BEGIN
    ar := int_table(1, 2, 3, 4, 5, 6);
    DBMS_OUTPUT.PUT_LINE(ar(4));
END;

DECLARE
    TYPE string_int_map IS TABLE OF NUMBER INDEX BY STRING(20);
    score string_int_map;
BEGIN
    score('ȫ�浿') := 80;
    score('Ȳ����') := 90;
    score('��쵿') := 90;
    score.DELETE('Ȳ����');
    DBMS_OUTPUT.PUT_LINE(score.COUNT());
    DBMS_OUTPUT.PUT_LINE(score('ȫ�浿'));
END;

DECLARE v_score INT := 12;
BEGIN
    IF v_score = 12 THEN
        DBMS_OUTPUT.PUT_LINE('12�Դϴ�');
    ELSE
        DBMS_OUTPUT.PUT_LINE('12�� �ƴմϴ�');
    END IF;
END;

DECLARE v_score INT := 12;
BEGIN
    IF v_score = 12 THEN
        DBMS_OUTPUT.PUT_LINE('12�Դϴ�');
        DBMS_OUTPUT.PUT_LINE('�� ���߾��.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('12�� �ƴմϴ�');
        DBMS_OUTPUT.PUT_LINE('�� �� ����ϼ���.');
    END IF;
END;

DECLARE 
    v_popu INT;
    v_message VARCHAR(50);
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '�λ�';
    IF v_popu > 100 THEN
        v_message := '100���� �ѽ��ϴ�';
    ELSE
        v_message := '100������ �����ϴ�';
    END IF;    
    DBMS_OUTPUT.PUT_LINE('�λ��� �α��� ' || v_message);
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    WHILE v_num <= 100
    LOOP
        v_total := v_total + v_num;
        v_num := v_num + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100������ �ջ� ��� = ' || v_total);
END;

DECLARE 
    v_total INT := 0;
BEGIN
    FOR v_num IN 1 .. 100
    LOOP
        v_total := v_total + v_num;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100������ �ջ� ��� = ' || v_total);
END;

BEGIN
    FOR v_cities IN (SELECT * FROM tCity WHERE region='���')
    LOOP
        DBMS_OUTPUT.PUT_LINE(TRIM(v_cities.name) || ' : ' || v_cities.area || ',' || v_cities.popu);
    END LOOP;
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    WHILE 1 = 1
    LOOP
        v_total := v_total + v_num;
        v_num := v_num + 1;
        IF v_num > 100 THEN
            EXIT;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100������ �ջ� ��� = ' || v_total);
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    LOOP
        v_total := v_total + v_num;
        v_num := v_num + 1;
        EXIT WHEN v_num > 100;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1~100������ �ջ� ��� = ' || v_total);
END;

DECLARE 
    v_num INT := 1;
    v_total INT := 0;
BEGIN
    <<HERE>>    
    v_total := v_total + v_num;
    v_num := v_num + 1;
    IF v_num <= 100 THEN
        GOTO HERE;
    END IF;
   	DBMS_OUTPUT.PUT_LINE('1~100������ �ջ� ��� = ' || v_total);
END;

BEGIN
    DBMS_LOCK.SLEEP(5);
    DBMS_OUTPUT.PUT_LINE('�������');
END;

DECLARE 
    v_num INT := 2;
    v_numword CHAR(30);
BEGIN
    v_numword := 
    CASE v_num
        WHEN 1 THEN '�ϳ�'
        WHEN 2 THEN '��'
        WHEN 3 THEN '��'
        WHEN 4 THEN '��'
        ELSE '�׿�'
    END;
    DBMS_OUTPUT.PUT_LINE(v_numword);
END;

DECLARE 
    v_num INT := 6;
    v_numword CHAR(30);
BEGIN
    v_numword := 
    CASE 
        WHEN v_num < 0 THEN '����'
        WHEN v_num IN (1, 2, 3) THEN '�ϳ�, ��, ��'
        WHEN v_num > 4 THEN '�ݺ��� �� ŭ'
        ELSE '�׿�'
    END;
    DBMS_OUTPUT.PUT_LINE(v_numword);
END;

SELECT item, 
    CASE category 
        WHEN '�м�' THEN '���� ���� ���Ƽ� ��������.'
        WHEN '����' THEN '����� ���� ������.'
        WHEN '��ǰ' THEN '���� �����ϼ���.'
        WHEN '����' THEN '�ֵ��� ����'
    END AS ���ǻ���
FROM tItem

SELECT member, item,
    CASE status
        WHEN 1 THEN '�ֹ�'
        WHEN 2 THEN '�����'
        WHEN 3 THEN '��ۿϷ�'
        ELSE '��Ÿ'
    END AS ����
FROM tOrder;

SELECT member, item, DECODE(status, 1, '�ֹ�', 2, '�����', 3, '��ۿϷ�', '��Ÿ') 
AS ���� FROM tOrder;

DECLARE 
    v_num INT := 2;
    v_popu INT;
BEGIN
    CASE 
        WHEN v_num = 1 THEN SELECT popu INTO v_popu FROM tCity WHERE name = '����';
        WHEN v_num = 2 THEN DBMS_OUTPUT.PUT_LINE('��');
        WHEN v_num = 3 THEN COMMIT;
        WHEN v_num > 4 THEN ROLLBACK;
        ELSE DBMS_OUTPUT.PUT_LINE('�� �� ���� ���');
    END CASE;
END;

DECLARE v_member CHAR(20);
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID = 100;
    DBMS_OUTPUT.PUT_LINE(v_member);
END;

DECLARE v_member CHAR(20);
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID = 100;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('�ֹ� ��ȣ�� �����ϴ�.');
END;

DECLARE v_member CHAR(20);
BEGIN
    SELECT member INTO v_member FROM tOrder WHERE orderID > 1;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('�ϳ��� �ֹ��� �����Ͻʽÿ�.');
END;

DECLARE 
    v_member CHAR(20);
    v_orderID INT := -1;
    negativeOrder EXCEPTION;
BEGIN
    IF (v_orderID < 0) THEN
        RAISE negativeOrder;
    END IF;
    SELECT member INTO v_member FROM tOrder WHERE orderID = v_orderID;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN negativeOrder THEN
            DBMS_OUTPUT.PUT_LINE('�ֹ� ��ȣ�� ���������� �ȵ˴ϴ�.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('������ �� �� ���� ���ܰ� �߻��߽��ϴ�.');
END;

DECLARE 
    v_member CHAR(20);
    v_orderID INT := -1;
BEGIN
    IF (v_orderID < 0) THEN
        RAISE_APPLICATION_ERROR(-20000, '�ֹ� ��ȣ�� ���������� �ȵ˴ϴ�.');
    END IF;
    SELECT member INTO v_member FROM tOrder WHERE orderID = v_orderID;
    DBMS_OUTPUT.PUT_LINE(v_member);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE(SQLCODE);
            DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

SELECT '�ȳ��ϼ���';
SELECT 2 + 3 * 4;
SELECT POWER(2, 3);

DECLARE @salary INT;			-- �������� @salary ����
DECLARE @a INT, @b INT = 100;		-- �� ���� ������ ����. b�� 100���� �ʱ�ȭ
DECLARE @age INT, @name CHAR(5);	-- ������ ������ ���ڿ� ���� ����

DECLARE @price INT;
SET @price = 1000;
SELECT @price;

DECLARE @name CHAR(20);
SELECT @name = member FROM tOrder WHERE orderID=1;
SELECT @name;

SET @name = (SELECT member FROM tOrder WHERE orderID=1);

DECLARE @score INT = 12;
IF @score = 12
	PRINT '12�Դϴ�.';
ELSE
	PRINT '12�� �ƴմϴ�.';

DECLARE @message VARCHAR(50);
IF (SELECT popu FROM tCity WHERE name = '�λ�') > 100
BEGIN	
	SET @message='100���� �ѽ��ϴ�';
	PRINT '���̵� ���ҳ׿�'
END
ELSE
BEGIN
	SET @message='100������ �����ϴ�';
	PRINT '���� �� ���� ���ƾ߰ڳ׿�'
END
PRINT '�λ��� �α��� ' + @message;

DECLARE @num INT = 1, @sum INT = 0;

WHILE @num <= 100
BEGIN
	SET @sum = @sum + @num;
	SET @num = @num + 1;
END
PRINT '1~100������ �ջ� ��� = ' + CONVERT(VARCHAR(10), @sum);

WHILE 1=1
BEGIN
	SET @sum = @sum + @num;
	SET @num = @num + 1;
	IF @num > 100
		BREAK;
END

HERE:
SET @sum = @sum + @num;
SET @num = @num + 1;
IF @num <= 100
	GOTO HERE;

WAITFOR DELAY '00:00:05';		-- 5�ʰ� ���
WAITFOR TIME '02:20:00';			-- 2:20�б��� ���

BEGIN TRY
	INSERT INTO tCity VALUES ('����',600,1000,'y','���');
END TRY
BEGIN CATCH
    PRINT '�⺻Ű�� ���� ���ڵ带 ������ �� �����ϴ�.';
    PRINT '���� ��ȣ : ' + CAST(ERROR_NUMBER() AS VARCHAR(10))
    PRINT '�޽��� : ' + ERROR_MESSAGE()
END CATCH

BEGIN TRY
    SELECT mayor FROM tCity;
END TRY
BEGIN CATCH
    PRINT '����Կ� ���� ������ �����ϴ�.'
END CATCH

DECLARE @popu INT = 12345;

BEGIN TRY
	IF @popu > 10000
		THROW 50001, '������ �α��� 1���� ���� ���� �����ٵ�...', 1;
	ELSE
		INSERT INTO tCity VALUES ('����',600,@popu,'y','����');
END TRY
BEGIN CATCH
    PRINT '���� ��ȣ : ' + CAST(ERROR_NUMBER() AS VARCHAR(10))
    PRINT '�޽��� : ' + ERROR_MESSAGE()
END CATCH

-------------------------------------------------
-- 16��

CREATE PROCEDURE SP_GetPopu
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '����';
    DBMS_OUTPUT.PUT_LINE(v_popu);
END;

EXECUTE SP_GetPopu();

SELECT * FROM user_objects WHERE object_type = 'PROCEDURE';

SELECT * FROM user_source WHERE name = 'SP_GETPOPU';

CREATE PROCEDURE SP_GetPopu
...
    SELECT popu INTO v_popu FROM tCity WHERE name = '�λ�';

DROP PROCEDURE SP_GetPopu;

CREATE OR REPLACE PROCEDURE SP_GetPopu
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = '�λ�';
    DBMS_OUTPUT.PUT_LINE(v_popu);
END;

CREATE OR REPLACE PROCEDURE SP_GetPopu
AS
    v_popu INT;
BEGIN
    SELECT population INTO v_popu FROM tCity WHERE name = '�λ�';
    DBMS_OUTPUT.PUT_LINE(v_popu);
END;

DROP TABLE tCity;

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN CHAR)
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = p_name;
    DBMS_OUTPUT.PUT_LINE(p_name || '�� �α��� ' || v_popu || '�����Դϴ�.');
END;

EXEC SP_GetCityPopu('����');		-- ������ �α��� 21�����Դϴ�.
EXEC SP_GetCityPopu('û��');		-- û���� �α��� 83�����Դϴ�.

EXEC SP_GetCityPopu();      		-- ����
EXEC SP_GetCityPopu('����', '�λ�');    	-- ����

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN tCity.name%TYPE := '����')
....

CREATE OR REPLACE PROCEDURE SP_GrantBonus(p_member CHAR, p_bonus INT)
AS
BEGIN
    UPDATE tMember SET money = money + p_bonus WHERE member = p_member;
    COMMIT;
END;

EXEC SP_GrantBonus('����', 123);

EXEC SP_GrantBonus(p_member=>'����', p_bonus=>123);
EXEC SP_GrantBonus(p_bonus=>123, p_member=>'����');

CREATE OR REPLACE PROCEDURE SP_OutCityPopu(p_name IN CHAR, o_popu OUT INT)
AS
BEGIN
    SELECT popu INTO o_popu FROM tCity WHERE name = p_name;
END;

DECLARE 
    v_popu INT;
BEGIN
    SP_OutCityPopu('����', v_popu);
    DBMS_OUTPUT.PUT_LINE(v_popu);
END; 

CREATE OR REPLACE PROCEDURE SP_OutCityAreaPopu(p_name IN CHAR, o_area OUT INT, o_popu OUT INT)
AS
BEGIN
    SELECT area, popu INTO o_area, o_popu FROM tCity WHERE name = p_name;
END;

DECLARE 
    v_area INT;
    v_popu INT;
BEGIN
    SP_OutCityAreaPopu('�λ�', v_area, v_popu);
    DBMS_OUTPUT.PUT_LINE(v_area || ' ,' || v_popu);
END;

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN tCity.name%TYPE := '����')
AS
    v_popu INT;
BEGIN
    SP_OutCityPopu(p_name, v_popu);
    DBMS_OUTPUT.PUT_LINE(p_name || '�� �α��� ' || v_popu || '�����Դϴ�.');
END;

EXECUTE SP_GetCityPopu('���');

CREATE OR REPLACE PROCEDURE SP_GetCityPopu(p_name IN tCity.name%TYPE := '����')
AS
    v_popu INT;
BEGIN
    SELECT popu INTO v_popu FROM tCity WHERE name = p_name;
    DBMS_OUTPUT.PUT_LINE(p_name || '�� �α��� ' || v_popu || '�����Դϴ�.');
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('���� �����Դϴ�.');
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('���ð� �ʹ� �����ϴ�.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('�� �� ���� �����Դϴ�.');
END;

SELECT popu INTO v_popu FROM tCity WHERE name = p_name;
IF v_popu IS NULL THEN
    DBMS_OUTPUT.PUT_LINE('���� �����Դϴ�.');
END IF;

CREATE OR REPLACE FUNCTION FN_AddInt(a INT, b INT) 
RETURN INT
AS
BEGIN
	RETURN a + b;
END;

SELECT FN_AddInt(2, 3) FROM dual;
SELECT * FROM tCity WHERE popu > FN_AddInt(10, 20);

DECLARE v_sum INT;
BEGIN
    v_sum := FN_AddInt(2, 3);
    DBMS_OUTPUT.PUT_LINE(v_sum);
END;

CREATE OR REPLACE FUNCTION FN_GetSum(p_upBound INT)
RETURN INT
AS
    v_total INT := 0;
BEGIN
    FOR v_num IN 1 .. p_upBound
    LOOP
        v_total := v_total + v_num;
    END LOOP;
    RETURN v_total;
END;

SELECT FN_GetSum(10) FROM dual;

CREATE OR REPLACE TYPE gu_row AS OBJECT
(
    dan INT, 
    num INT, 
    multi INT
);

CREATE OR REPLACE TYPE gu_table AS TABLE OF gu_row;

CREATE OR REPLACE FUNCTION makeDan(p_dan INT)
RETURN gu_table PIPELINED
AS
    v_row gu_row;
BEGIN
    FOR v_num IN 1..9
    LOOP
        v_row := gu_row(p_dan, v_num, p_dan * v_num);
        PIPE ROW(v_row);
    END LOOP;
    RETURN;
END;

SELECT * FROM TABLE(makeDan(5));
SELECT * FROM TABLE(makeDan(7));

CREATE PROCEDURE PROC_GetCityPopu
	@p_name CHAR(10)
AS
BEGIN
	SELECT popu FROM tCity WHERE name = @p_name;
END

EXEC PROC_GetCityPopu @p_name = '����';
EXEC PROC_GetCityPopu '����';
PROC_GetCityPopu '����';

ALTER PROCEDURE PROC_GetCityPopu
	@p_name CHAR(10)
AS
DECLARE
	@popu INT
BEGIN
	SELECT @popu = popu FROM tCity WHERE name = @p_name;
	PRINT @popu
END

ALTER PROCEDURE PROC_GetCityPopu
	@p_name CHAR(10)
AS
BEGIN
	SELECT popu FROM tCity2 WHERE name = @p_name;
END

CREATE PROCEDURE PROC_GrantBonus
	@p_member CHAR(20),
	@p_bonus INT = 100
AS
BEGIN
    UPDATE tMember SET money = money + @p_bonus WHERE member = @p_member;
END;

PROC_GrantBonus '����', 2000;
PROC_GrantBonus '����';

PROC_GrantBonus @p_member = '����', @p_bonus = 2000;
PROC_GrantBonus @p_bonus = 2000, @p_member = '����';

CREATE PROCEDURE PROC_OutCityPopu
	@p_name CHAR(10), 
	@o_popu INT OUTPUT
AS
BEGIN
    SELECT @o_popu = popu FROM tCity WHERE name = @p_name;
END;

DECLARE @popu INT;
EXECUTE PROC_OutCityPopu '����', @popu OUTPUT;
PRINT '������ �α��� ' + CAST(@popu AS VARCHAR(10)) + '�����Դϴ�.';

CREATE PROCEDURE PROC_RetCityPopu
	@p_name CHAR(10)
AS
DECLARE
	@popu INT;
BEGIN
    SELECT @popu = popu FROM tCity WHERE name = @p_name;
    RETURN @popu;
END;

DECLARE @popu INT;
EXECUTE @popu = PROC_RetCityPopu '����';
PRINT '������ �α��� ' + CAST(@popu AS VARCHAR(10)) + '�����Դϴ�.';

PRINT '������ �α��� ' + CAST(PROC_RetCityPopu '����' AS VARCHAR(10)) + '�����Դϴ�';
SELECT PROC_RetCityPopu '����';

CREATE PROCEDURE PROC_InsertSeoul
AS
BEGIN
	INSERT INTO tCity VALUES ('����',605,974,'y','���');
END

ALTER PROCEDURE PROC_InsertSeoul
AS
BEGIN
	INSERT INTO tCity VALUES ('����',605,974,'y','���');
	IF @@ERROR != 0
	BEGIN
		PRINT('�� ���ڵ带 �������� ���߽��ϴ�.');
	END
END

ALTER PROCEDURE PROC_InsertSeoul
AS
BEGIN
	BEGIN TRY
		INSERT INTO tCity VALUES ('����',605,974,'y','���');
	END TRY

	BEGIN CATCH
		PRINT '���� ��ȣ : ' + CAST(ERROR_NUMBER() AS VARCHAR(10));
		PRINT '���� �޽��� : ' + ERROR_MESSAGE();
	END CATCH
END

CREATE FUNCTION FN_AddInt(@a INT, @b INT) RETURNS INT
AS
BEGIN
	RETURN @a + @b;
END

SELECT Study.dbo.FN_AddInt(2, 3);

CREATE FUNCTION FN_GetCity(@region CHAR(10))
RETURNS TABLE
AS
RETURN SELECT * FROM tCity WHERE region = @region;

SELECT * FROM dbo.FN_GetCity('����');

SELECT * FROM dbo.FN_GetCity('����') WHERE popu > 10;

CREATE FUNCTION FN_GetCityTable(@region CHAR(10))
RETURNS @result TABLE
	(name VARCHAR(10),popu INT)
AS
BEGIN
	INSERT INTO @result SELECT name, popu FROM tCity WHERE region = @region;
	RETURN;
END

SELECT * FROM dbo.FN_GetCityTable('���');

-------------------------------------------------
-- 17��

DECLARE
    CURSOR v_cursor IS SELECT name FROM tCity;
    v_name CHAR(10);
BEGIN
    OPEN v_cursor;
    LOOP
        FETCH v_cursor INTO v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name);
    END LOOP;
    CLOSE v_cursor;
END;

DECLARE
    CURSOR v_cursor IS SELECT * FROM tCity;
    v_city tCity%ROWTYPE;
BEGIN
    OPEN v_cursor;
    LOOP
        FETCH v_cursor INTO v_city;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_city.region || v_city.name || v_city.area);
    END LOOP;
    CLOSE v_cursor;
END;

DECLARE
BEGIN
    FOR v_cursor IN (SELECT name FROM tCity)
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_cursor.name);
    END LOOP;
END;

BEGIN
    UPDATE tCity SET popu = popu WHERE region = '����';
    IF SQL%FOUND THEN DBMS_OUTPUT.PUT_LINE('������� ����'); END IF;
    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || '���� ���� �ٲ�');
END;

DECLARE
    v_cursor SYS_REFCURSOR;
    v_name CHAR(10);
BEGIN
    OPEN v_cursor FOR SELECT name FROM tCity;
    LOOP
        FETCH v_cursor INTO v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name);
    END LOOP;
    CLOSE v_cursor;
END;

CREATE OR REPLACE PROCEDURE SP_OutCityName(p_region IN CHAR, o_cursor OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN o_cursor FOR SELECT name FROM tCity WHERE region = p_region;
END;

DECLARE
    v_cursor SYS_REFCURSOR;
    v_name CHAR(10);
BEGIN
    SP_OutCityName('����', v_cursor);
    LOOP
        FETCH v_cursor INTO v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_name);
    END LOOP;
END;

DECLARE
    CURSOR v_cursor IS SELECT * FROM tCity FOR UPDATE;
    v_city tCity%ROWTYPE;
BEGIN
    OPEN v_cursor;
    LOOP
        FETCH v_cursor INTO v_city;
        EXIT WHEN v_cursor%NOTFOUND;
        IF v_city.metro = 'y' THEN
            UPDATE tCity SET area = area + 10 WHERE CURRENT OF v_cursor;
        END IF;
    END LOOP;
    CLOSE v_cursor;
END;

DECLARE @name CHAR(10)
DECLARE testcursor CURSOR FOR SELECT name FROM tCity
OPEN testcursor
FETCH NEXT FROM testcursor INTO @name
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT @name
	FETCH NEXT FROM testcursor INTO @name
END
CLOSE testcursor
DEALLOCATE testcursor

START:
FETCH NEXT FROM testcursor INTO @name
IF @@FETCH_STATUS = 0
BEGIN
	PRINT @name
	GOTO START
END

DECLARE @name CHAR(10)
DECLARE @varCur CURSOR
SET @varCur = CURSOR FOR SELECT name FROM tCity;
OPEN @varCur
FETCH NEXT FROM @varCur INTO @name
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT @name
	FETCH NEXT FROM @varCur INTO @name
END
CLOSE @varCur
DEALLOCATE @VarCur

DECLARE testcursor CURSOR LOCAL SCROLL FOR SELECT name FROM tCity;
OPEN testcursor;

FETCH NEXT FROM testcursor;
FETCH NEXT FROM testcursor;
FETCH PRIOR FROM testcursor;
FETCH LAST FROM testcursor;

DECLARE testcursor CURSOR LOCAL FOR SELECT * FROM tCity;
OPEN testcursor;

FETCH NEXT FROM testcursor;
UPDATE tCity SET popu=1234 WHERE CURRENT OF testcursor;

CLOSE testcursor;
DEALLOCATE testcursor;

DECLARE testcursor CURSOR LOCAL STATIC FOR SELECT name, popu FROM tCity;
OPEN testcursor;

DECLARE @name CHAR(10);
DECLARE @popu INT;
FETCH NEXT FROM testcursor INTO @name, @popu;
PRINT @name + ':' + CONVERT(VARCHAR(12), @popu);
WAITFOR DELAY '00:00:10';
FETCH NEXT FROM testcursor INTO @name, @popu;
PRINT @name + ':' + CONVERT(VARCHAR(12), @popu);

UPDATE tCity SET popu = 500 WHERE name = '�λ�';

DECLARE testcursor CURSOR LOCAL DYNAMIC FOR SELECT name, popu FROM tCity;
OPEN testcursor;

DECLARE @name CHAR(10);
DECLARE @popu INT;
FETCH NEXT FROM testcursor INTO @name, @popu;
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT @name + ':' + CONVERT(NVARCHAR(12), @popu);
	WAITFOR DELAY '00:00:01';
	FETCH NEXT FROM testcursor INTO @name, @popu;
END

INSERT INTO tCity VALUES ('����',453,51,'n','���');

DECLARE 
    v_orderID INT := 1;
    v_sql VARCHAR(100);
    v_member CHAR(20);
BEGIN
    v_sql := 'SELECT member FROM tOrder WHERE orderID = ' || v_orderID;
    EXECUTE IMMEDIATE v_sql INTO v_member;
    DBMS_OUTPUT.PUT_LINE(v_member);
END;

DECLARE
    v_area INT := 0;
    v_op CHAR(10) := 'ũ��';
    v_sql VARCHAR(100);
    v_name CHAR(10);
BEGIN
    v_sql := 'SELECT name FROM tCity WHERE ';
    IF v_area != 0 THEN
        v_sql := v_sql || 'area ';
        IF v_op = '����' THEN v_sql := v_sql || '= '; END IF;
        IF v_op = 'ũ��' THEN v_sql := v_sql || '> '; END IF;
        IF v_op = '�۴�' THEN v_sql := v_sql || '< '; END IF;
        v_sql := v_sql || v_area || ' AND ';
    END IF;
    v_sql := v_sql || ' rownum = 1';
    EXECUTE IMMEDIATE v_sql INTO v_name;
    DBMS_OUTPUT.PUT_LINE(v_name);
END;

SELECT member INTO v_member FROM tOrder WHERE orderID = v_orderID;

v_table VARCHAR(10) := 'tCity';
SELECT name INTO v_name FROM v_table WHERE rownum = 1;

DECLARE 
    v_table VARCHAR(10) := 'tCity';
    v_sql VARCHAR(100);
    v_name CHAR(20);
BEGIN
    v_sql := 'SELECT name FROM ' || v_table || ' WHERE rownum = 1';
    EXECUTE IMMEDIATE v_sql INTO v_name;
    DBMS_OUTPUT.PUT_LINE(v_name);
END;

DECLARE @area INT = 1000;
DECLARE @op CHAR(10) = 'ũ��';
DECLARE @sql VARCHAR(100);

SET @sql = 'SELECT TOP 1 name FROM tCity';
IF @area != 0
BEGIN
	SET @sql += ' WHERE area ';
	IF @op = '����' SET @sql += '=';
	IF @op = 'ũ��' SET @sql += '>';
	IF @op = '�۴�' SET @sql += '<';
	SET @sql = @sql + CAST(@area AS VARCHAR(10));
END
EXECUTE(@sql);

DECLARE 
    hour_begin INT := 1;
    hour_end INT := 2;
    hour_now INT := hour_begin;
    v_sql VARCHAR(1000);
    v_cursor SYS_REFCURSOR;
    TYPE linecar IS RECORD(line VARCHAR(100), car VARCHAR(100), t1 VARCHAR(100), t2 VARCHAR(100));
    v_lc linecar;
BEGIN
    v_sql := 'SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR hour IN (';
    WHILE hour_now <= hour_end
    LOOP
        v_sql := v_sql || hour_now;
        IF hour_now != hour_end THEN v_sql := v_sql || ', '; END IF;
        hour_now := hour_now + 1;
    END LOOP;
    v_sql := v_sql || '))'; 
    
    OPEN v_cursor FOR v_sql;
    LOOP
        -- INTO ���� ���ڵ� Ÿ���� ������ �Ǵµ� Ÿ���� �̸� ������ �� ����.
        FETCH v_cursor INTO v_lc;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_lc.line || v_lc.car || v_lc.t1 || ',' || v_lc.t2);
    END LOOP;
END;

DECLARE @hour_begin INT = 1;
DECLARE @hour_end INT = 2;
DECLARE @hour INT = @hour_begin;
DECLARE @sql VARCHAR(1000);

SET @sql = 'SELECT * FROM tTraffic PIVOT (SUM(traffic) FOR hour IN (';
WHILE @hour <= @hour_end
BEGIN
	SET @sql += '[' + CAST(@hour AS VARCHAR) + ']';
	IF @hour != @hour_end SET @sql += ', ';
	SET @hour += 1;
END
SET @sql += ')) as pvt';

EXEC(@sql);

-------------------------------------------------
-- 18��

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
BEGIN
    DBMS_OUTPUT.PUT_LINE('���� ������ �����Ͽ����ϴ�.');
END;

UPDATE tCity SET popu = popu + 1 WHERE name = '����';


CREATE OR REPLACE TRIGGER TR_Message
AFTER INSERT OR UPDATE OR DELETE ON tCity
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('���ο� ���ø� �����Ͽ����ϴ�.');
    END IF;
    IF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('���� ������ �����Ͽ����ϴ�.');
    END IF;
    IF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('���ø� �����Ͽ����ϴ�.');
    END IF;
END;

INSERT INTO tCity VALUES ('����',608,11,'n','���');
UPDATE tCity SET popu = 12 WHERE name = '����';
DELETE FROM tCity WHERE NAME = '����';

UPDATE tCity SET popu = popu + 1 WHERE region = '���';

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

REFERENCING OLD AS pre_rec NEW AS post_rec

UPDATE tCity SET area = area + 1 WHERE name = '����';

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE OF popu ON tCity 
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity 
FOR EACH ROW
WHEN (NEW.popu > 10)
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

UPDATE tCity SET popu = popu + 1 WHERE region = '����';

CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    IF :NEW.popu > 10000 THEN
        RAISE_APPLICATION_ERROR(-20000, '�α��� 1���� ���� ���� �����ϴ�.');
    END IF;
    DBMS_OUTPUT.PUT_LINE(:OLD.name || ':' || :OLD.popu || '->' || :NEW.popu);
END;

UPDATE tCity SET popu = 12345 WHERE name = '����';

CREATE OR REPLACE TRIGGER TR_PreventChoi
AFTER INSERT ON tStaff
FOR EACH ROW
BEGIN
    IF SUBSTR(:NEW.name,1,1) = '��' THEN
        RAISE_APPLICATION_ERROR(-20000, '�ְ��� �ȵ�!');
    END IF;
END;

INSERT INTO tStaff VALUES ('�ֹ���','�ѹ���','��','2021-6-25','���',280,0);

CREATE OR REPLACE TRIGGER TR_PreventChoi
BEFORE INSERT ON tStaff
FOR EACH ROW
BEGIN
    IF SUBSTR(:NEW.name,1,1) = '��' THEN
        DBMS_OUTPUT.PUT_LINE('�ְ��� �ȵ�');
        :NEW.name := '��' || SUBSTR(:NEW.name, 2);
    END IF;
END;

CREATE OR REPLACE TRIGGER TR_DoubleMoney
BEFORE INSERT ON tMember
FOR EACH ROW
BEGIN
    IF :NEW.age = 18 THEN
        :NEW.money := :NEW.money * 2;
    END IF;
END;

INSERT INTO tMember (member, age, email, addr, money) VALUES 
('���Ի�', 18, 'fresher@kyunghee.ac.kr', '���� ȸ�⵿', 8000);

CREATE VIEW vCarMaker AS
SELECT tCar.*, factory, domestic FROM tCar INNER JOIN tMaker ON
tCar.maker = tMaker.maker;

INSERT INTO vCarMaker VALUES('Ƽ��', 800, 900, '���', '�︪', 'y');

CREATE OR REPLACE TRIGGER TR_AddNewCar
INSTEAD OF INSERT ON vCarMaker
FOR EACH ROW
BEGIN
	INSERT INTO tCar (car, capacity, price, maker) VALUES 
        (:NEW.car, :NEW.capacity, :NEW.price, :NEW.maker);
	INSERT INTO tMaker (maker, factory, domestic) VALUES 
        (:NEW.maker, :NEW.factory, :NEW.domestic);
END;

CREATE OR REPLACE TRIGGER TR_Message2
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || '����:' || :OLD.area || '->' || :NEW.area);
END;

CREATE OR REPLACE TRIGGER TR_Message3
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || '����:' || :OLD.region || '->' || :NEW.region);
END;

CREATE OR REPLACE TRIGGER TR_Message3
AFTER UPDATE ON tCity
FOR EACH ROW
FOLLOWS TR_Message
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name || '����:' || :OLD.region || '->' || :NEW.region);
END;

UPDATE tCity SET area = 1000, popu = 12345 WHERE name = '����';

CREATE OR REPLACE TRIGGER TR_OnNewCar
AFTER INSERT ON tCar
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('������ ��õǾ����ϴ�.');
END;

INSERT INTO vCarMaker VALUES('Ƽ��', 800, 900, '���', '�︪', 'y');

CREATE OR REPLACE TRIGGER TR_Change
AFTER DDL ON DATABASE
BEGIN
    DBMS_OUTPUT.PUT_LINE('��� : ' || ora_sysevent);
    DBMS_OUTPUT.PUT_LINE('Ÿ�� : ' || ora_dict_obj_type);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ora_dict_obj_name);
END;

CREATE TABLE tTemp ( id INT );
DROP TABLE tTemp;

CREATE TABLE tCityHistory
(
    dt DATE,
    suser VARCHAR(20),
    ip VARCHAR(20),
    action VARCHAR(10),
    name CHAR(10),
    area VARCHAR(30) NULL,
    popu VARCHAR(30) NULL
);

CREATE OR REPLACE TRIGGER TR_History
AFTER INSERT OR UPDATE OR DELETE ON tCity
FOR EACH ROW
DECLARE
    areaChange VARCHAR(30);
    popuChange VARCHAR(30);
    suser VARCHAR(20);
    ip VARCHAR(20);
BEGIN
    SELECT SYS_CONTEXT('USERENV', 'SESSION_USER') INTO suser FROM DUAL;
    SELECT SYS_CONTEXT('USERENV', 'IP_ADDRESS') INTO ip FROM DUAL;
    
    IF INSERTING THEN
        INSERT INTO tCityHistory VALUES 
            (SYSDATE, suser, ip, 'INSERT', :NEW.name, :NEW.area, :NEW.popu);
    END IF;
    IF UPDATING THEN
        IF :OLD.area = :NEW.area THEN
            areaChange := :OLD.area;
        ELSE
            areaChange := :OLD.area || '->' || :NEW.area;
        END IF;
        IF :OLD.popu = :NEW.popu THEN
            popuChange := :OLD.popu;
        ELSE
            popuChange := :OLD.popu || '->' || :NEW.popu;
        END IF;
        INSERT INTO tCityHistory VALUES 
            (SYSDATE, suser, ip, 'UPDATE', :NEW.name, areaChange, popuChange);
    END IF;
    IF DELETING THEN
        INSERT INTO tCityHistory VALUES 
            (SYSDATE, suser, ip, 'DELETE', :OLD.name, :OLD.area, :OLD.popu);
    END IF;
END;

CREATE TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
    PRINT('���� ������ �����Ͽ����ϴ�.');
END;

UPDATE tCity SET popu = popu + 1 WHERE name = '����';
UPDATE tCity SET popu = popu + 1 WHERE region = '���';

ALTER TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
	SELECT * FROM deleted;
	SELECT * FROM inserted;
END;

ALTER TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
	SELECT name, popu, ' => ', (SELECT popu FROM inserted WHERE name = D.name) FROM deleted D;
END;

ALTER TABLE tCity DISABLE TRIGGER TR_Message;

ALTER TRIGGER TR_Message
ON tCity AFTER UPDATE 
AS
BEGIN
	IF (SELECT popu FROM inserted) > 10000
	BEGIN
		PRINT('�α��� 1���� ���� ���� �����ϴ�.');
		ROLLBACK;
	END
END;

CREATE TRIGGER TR_PreventChoi
ON tStaff AFTER INSERT
AS
IF EXISTS (SELECT * FROM inserted WHERE name LIKE '��%')
BEGIN
	PRINT '�ְ��� �ȵ�!';
	ROLLBACK TRANSACTION;
END

CREATE TRIGGER TR_AddNewCar
ON vCarMaker INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO tCar (car, capacity, price, maker) SELECT car, capacity, price, maker FROM inserted;
	INSERT INTO tMaker (maker, factory, domestic) SELECT maker, factory, domestic FROM inserted;
END

CREATE TRIGGER TR_DoubleMoney
ON tMember AFTER INSERT
AS
DECLARE @name CHAR(20)
DECLARE @age INT
SELECT @name = member, @age = age FROM inserted;
IF @age = 18
	UPDATE tMember SET money = money * 2 WHERE member = @name;

CREATE TRIGGER TR_MoneyChange
ON tMember
AFTER UPDATE
AS
DECLARE @name CHAR(20)
IF UPDATE(money)
BEGIN
	SELECT @name = member FROM inserted;
	PRINT @name + '�� ��ġ���� ���ŵǾ����ϴ�. ������ �ƴ��� Ȯ���� ���ʽÿ�';
END;

CREATE TRIGGER NewDataBase
ON ALL SERVER
AFTER CREATE_DATABASE, DROP_DATABASE
AS
PRINT '���ο� DB�� ���� �Ǵ� �ı��Ǿ����ϴ�.';

CREATE DATABASE NewDB
DROP DATABASE NewDB

DROP TRIGGER NewDataBase ON ALL SERVER

-------------------------------------------------
-- 19��

INSERT INTO tCity VALUES ('����',453,51,'n','���');
SELECT * FROM tCity;

SELECT * FROM v$transaction;

DELETE FROM tCity WHERE metro = 'n';
SELECT * FROM tCity;

UPDATE tMember SET money = money + 100 WHERE member='����';
APDATE tMember SET money = money - 100 WHERE member='�̵���';

UPDATE tMember SET money = money + 100 WHERE member='����';
UPDATE tMember2 SET money = money - 100 WHERE member='�̵���';

BEGIN TRANSACTION
UPDATE tMember SET money = money + 100 WHERE member='����';
UPDATE tMember SET money = money - 100 WHERE member='�̵���';
ROLLBACK;

BEGIN TRAN
UPDATE tMember SET money = money + 10000 WHERE member = '����';
DECLARE @remain INT
SELECT @remain = money FROM tMember WHERE member = '�̵���';
IF @remain < 10000 
BEGIN
	ROLLBACK
END
ELSE
BEGIN
	UPDATE tMember SET money = money - 10000 WHERE member = '�̵���';
	COMMIT
END
SELECT * FROM tMember WHERE member IN ('����', '�̵���');

UPDATE tCity SET popu = 1000 WHERE name = '����';
SAVEPOINT p1000;
UPDATE tCity SET popu = 1100 WHERE name = '����';
SAVEPOINT p1100;
UPDATE tCity SET popu = 1200 WHERE name = '����';
SAVEPOINT p1200;
ROLLBACK TO SAVEPOINT p1100;

SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;

����Ŭ : ALTER PROFILE DEFAULT LIMIT IDLE_TIME 1;
MSSQL : SET LOCK_TIMEOUT 60000

UPDATE tMember SET age=25 WHERE member='���';
UPDATE tItem SET num=10 WHERE item='�κ�';
COMMIT

UPDATE tItem SET num=5 WHERE item='�κ�';
UPDATE tMember SET age=18 WHERE member='���';
COMMIT

-------------------------------------------------
-- �η�

SET @score = 123;
SELECT @score;

SELECT @maxnum := MAX(num) FROM tItem;
SELECT item FROM tItem WHERE num = @maxnum;

DELIMITER $$
CREATE [OR REPLACE] PROCEDURE ���ν��� �̸�()
BEGIN
	���⿡ �ڵ带 �ۼ��Ѵ�.
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT DEFAULT 123;
	SELECT score;
	SET score = score + 1;
	SELECT score;
END $$
DELIMITER ;

CALL SP_proc();

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT;
	SET score = 12;
	IF score = 12 THEN
		SELECT '12�Դϴ�';
	ELSE
		SELECT '12�� �ƴմϴ�.';
	END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT DEFAULT 86;
	CASE
		WHEN score > 95 THEN SELECT 'A+';
		WHEN score > 90 THEN SELECT 'A';
		WHEN score > 85 THEN SELECT 'B+';
		WHEN score > 80 THEN SELECT 'B';
		ELSE SELECT 'C';
	END CASE;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE score INT DEFAULT 86;
	DECLARE grade CHAR(2);
	SET grade = CASE
		WHEN score > 95 THEN 'A+'
		WHEN score > 90 THEN 'A'
		WHEN score > 85 THEN 'B+'
		WHEN score > 80 THEN 'B'
		ELSE 'C'
	END;
	SELECT grade;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	WHILE (num <= 100) DO
		SET sum = sum + num;
		SET num = num + 1;
	END WHILE;

	SELECT sum;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	REPEAT
		SET sum = sum + num;
		SET num = num + 1;
		UNTIL num > 100
	END REPEAT;

	SELECT sum;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_proc()
BEGIN
	DECLARE num INT DEFAULT 1;
	DECLARE sum INT DEFAULT 0;
	sumloop: LOOP
		SET sum = sum + num;
		SET num = num + 1;
		IF num > 100 THEN
			LEAVE sumloop;
		END IF;
	END LOOP;

	SELECT sum;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_GrantBonus(IN p_member CHAR(20))
BEGIN
	UPDATE tMember SET money = money + 1000 WHERE member = p_member;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_GetMemberNum(OUT o_member_num INT)
BEGIN
	SELECT COUNT(*) INTO o_member_num FROM tMember;
END $$
DELIMITER ;

CALL SP_GetMemberNum(@num);
SELECT @num;

DELIMITER $$
CREATE OR REPLACE FUNCTION FN_AddInt(a INT, b INT) RETURNS INT
BEGIN
	RETURN a + b;
END $$
DELIMITER ;

SELECT FN_AddInt(2, 3);

DELIMITER $$
CREATE OR REPLACE PROCEDURE SP_dumpCity()
BEGIN
	DECLARE city_name CHAR(10);
	DECLARE eof INT DEFAULT 0;

	DECLARE testcursor CURSOR FOR SELECT name FROM tCity;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET eof = 1; 
	OPEN testcursor;

	fetch_loop: LOOP
		FETCH testcursor INTO city_name;
		IF eof THEN 
			LEAVE fetch_loop;
		END IF;
		SELECT city_name;
	END LOOP;
	CLOSE testcursor;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE TRIGGER TR_Message
AFTER UPDATE ON tCity
FOR EACH ROW
BEGIN
	SET @result = CONCAT(OLD.popu, '->', NEW.popu);
END $$
DELIMITER ;

UPDATE tCity SET popu = popu + 1 WHERE name = '����';

SELECT @result;

