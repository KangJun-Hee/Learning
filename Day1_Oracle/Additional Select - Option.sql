select student_name �л��̸�, student_address �ּ��� from tb_student
order by �л��̸�;

select student_name,student_ssn from tb_student
order by student_ssn desc;

select student_name �л��̸�, student_no �й�,student_address "������ �ּ�" from tb_student
where student_address like'%������%'or student_address like'%��⵵%'
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
    d.category='�ι���ȸ';

select student_no �й�,student_name "�л� �̸�",round(avg(point),1) "��ü ����"from tb_grade
join tb_student using(student_no)
join tb_department using(department_no)
where department_name='�����а�'
group by student_no,student_name
order by 1;

select department_name �а��̸�, student_name �л��̸�, professor_name ���������̸�
from tb_student 
    join tb_department using(department_no)
    join tb_professor on(professor_no=coach_professor_no)
where student_no='A313047';

select * from tb_class;//���ǹ�ȣ,�а���ȣ,���Ǹ�
select * from tb_student;//�й�,�а���ȣ,�л���
select * from tb_grade;//�б�,�й�,���ǹ�ȣ

select student_name,term_name
from tb_class
    join tb_student using(department_no)
    join tb_grade using(student_no)
where term_no like"2007%";