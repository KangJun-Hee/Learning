create table TB_CATEGORY(
    pk_category_name varchar(10),
    USE_YN char(1) default 'Y',
    
    constraint pk primary key(pk_category_name)
);

//null값이 들어가지 않도록 속성 변경
create table TB_CLASS_TYPE(
    NO varchar(5),
    CLASS_TYPE_name varchar(10) not null,
    
    constraint pk primary key(NO)
);

insert into tb_class_type values('12345','junhee');
insert into tb_class_type values('12347','');//null추가 불가능
insert into tb_class_type values('3929492939','djwidkspxjdwodjftose');

select * from TB_CATEGORY;
select * from tb_class_type;

//테이블 수정
alter table tb_class_type modify(no varchar(10),name varchar(20));
alter table tb_category modify(pk_category_name varchar(20));
alter table tb_category rename column name to category_name;
alter table TB_CLASS_TYPE rename column name to CLASS_TYPE_name;
alter table TB_CLASS_TYPE rename column no to CLASS_TYPE_no;

//primary key 이름변경
alter table tb_category drop constraint pk;
create unique index pk_category_name on tb_category(category_name);
alter table tb_class_type drop constraint pk;
create unique index pk_NO on tb_CLASS_TYPE(no);

insert into tb_category(pk_category_name) values('공학');
insert into tb_category(pk_category_name) values('자연과학');
insert into tb_category(pk_category_name) values('의학');
insert into tb_category(pk_category_name) values('예체능');
insert into tb_category(pk_category_name) values('인문사회');
commit;


//foreign key지정
alter table tb_department add constraint fk_department_category foreign key(category) references tb_category;




-- 춘 기술대는 특정 인기과목들에 수강신청이 몰린다. 최근 3년 기준으로 수강인원이
-- 가장 많았던 3과목을 찾는 구문을 작성하시오오오.
SELECT 과목번호, 과목이름, "누적수강생수(명)"
FROM (SELECT CLASS_NO 과목번호, CLASS_NAME 과목이름, COUNT(*) "누적수강생수(명)"
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

-- 내가 해 본 것. 어디가 날짠지 못찾았었음.
//과목 정보
select* from tb_class;
//과목번호,학점
select* from tb_grade;

select tb_class.class_no as 과목번호,tb_class.class_name as 과목이름,count(tb_class.class_no)as 누적수강생수 from tb_class left join tb_grade
on tb_class.class_no=tb_grade.class_no
group by tb_class.class_no,tb_class.class_name
order by 누적수강생수 desc;