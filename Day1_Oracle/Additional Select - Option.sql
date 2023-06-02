select student_name 학생이름, student_address 주소지 from tb_student
order by 학생이름;

select student_name,student_ssn from tb_student
order by student_ssn desc;

select student_name 학생이름, student_no 학번,student_address "거주지 주소" from tb_student
where student_address like'%강원도%'or student_address like'%경기도%'
        and student_no like'9%'
order by 1;

select professor_name,professor_ssn from tb_professor
where department_no=005
order by professor_ssn;

select student_no,point from tb_grade
where term_no like '200402%'
        and class_no='C3118100'
order by 2 desc,1;

select s.student_no,s.student_name,d.department_name from tb_student s join tb_department d
on s.department_no=d.department_no
order by s.student_name;

select class_name,department_name from tb_class c left join tb_department d
on c.department_no=d.department_no;

select c.class_name,p.professor_name from tb_class c left join tb_professor p
on c.department_no=p.department_no;

select 
    c.class_name,p.professor_name 
from 
    tb_class c 
    left join tb_class_professor cp
        on c.class_no=cp.class_no
    left join tb_professor p
        on cp.professor_no=p.professor_no
    left join tb_department d
        on p.department_no=d.department_no
where
    d.category='인문사회';

select student_no 학번,student_name "학생 이름",round(avg(point),1) "전체 평점"from tb_grade
join tb_student using(student_no)
join tb_department using(department_no)
where department_name='음악학과'
group by student_no,student_name
order by 1;

select department_name 학과이름, student_name 학생이름, professor_name 지도교수이름
from tb_student 
    join tb_department using(department_no)
    join tb_professor on(professor_no=coach_professor_no)
where student_no='A313047';

select * from tb_class;//강의번호,학과번호,강의명
select * from tb_student;//학번,학과번호,학생명
select * from tb_grade;//학기,학번,강의번호

select student_name,term_name
from tb_class
    join tb_student using(department_no)
    join tb_grade using(student_no)
where term_no like"2007%";