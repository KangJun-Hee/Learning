create table TB_CATEGORY(
    pk_category_name varchar(10),
    USE_YN char(1) default 'Y',
    
    constraint pk primary key(pk_category_name)
);

//null���� ���� �ʵ��� �Ӽ� ����
create table TB_CLASS_TYPE(
    NO varchar(5),
    CLASS_TYPE_name varchar(10) not null,
    
    constraint pk primary key(NO)
);

insert into tb_class_type values('12345','junhee');
insert into tb_class_type values('12347','');//null�߰� �Ұ���
insert into tb_class_type values('3929492939','djwidkspxjdwodjftose');

select * from TB_CATEGORY;
select * from tb_class_type;

//���̺� ����
alter table tb_class_type modify(no varchar(10),name varchar(20));
alter table tb_category modify(pk_category_name varchar(20));
alter table tb_category rename column name to category_name;
alter table TB_CLASS_TYPE rename column name to CLASS_TYPE_name;
alter table TB_CLASS_TYPE rename column no to CLASS_TYPE_no;

//primary key �̸�����
alter table tb_category drop constraint pk;
create unique index pk_category_name on tb_category(category_name);
alter table tb_class_type drop constraint pk;
create unique index pk_NO on tb_CLASS_TYPE(no);

insert into tb_category(pk_category_name) values('����');
insert into tb_category(pk_category_name) values('�ڿ�����');
insert into tb_category(pk_category_name) values('����');
insert into tb_category(pk_category_name) values('��ü��');
insert into tb_category(pk_category_name) values('�ι���ȸ');
commit;


//foreign key����
alter table tb_department add constraint fk_department_category foreign key(category) references tb_category;




-- �� ������ Ư�� �α����鿡 ������û�� ������. �ֱ� 3�� �������� �����ο���
-- ���� ���Ҵ� 3������ ã�� ������ �ۼ��Ͻÿ�����.
SELECT �����ȣ, �����̸�, "������������(��)"
FROM (SELECT CLASS_NO �����ȣ, CLASS_NAME �����̸�, COUNT(*) "������������(��)"
      FROM TB_GRADE
           JOIN TB_CLASS USING(CLASS_NO)
      WHERE TERM_NO LIKE '2009%'
            OR TERM_NO LIKE '2008%'
            OR TERM_NO LIKE '2007%'
            OR TERM_NO LIKE '2006%'
            OR TERM_NO LIKE '2005%'
      GROUP BY CLASS_NO, CLASS_NAME
      ORDER BY 3 DESC)
WHERE ROWNUM <= 3;

-- ���� �� �� ��. ��� ��§�� ��ã�Ҿ���.
//���� ����
select* from tb_class;
//�����ȣ,����
select* from tb_grade;

select tb_class.class_no as �����ȣ,tb_class.class_name as �����̸�,count(tb_class.class_no)as ������������ from tb_class left join tb_grade
on tb_class.class_no=tb_grade.class_no
group by tb_class.class_no,tb_class.class_name
order by ������������ desc;