delete from guestbook;

create sequence guestbook_idx_seq;

select * from guestbook;

insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, 'ȫ�浿', '1111', '1�� �Դϴ�.', '192.168.100.101');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '�Ӳ���', '2222', '2�� �Դϴ�.', '192.168.100.102');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '����', '3333', '3�� �Դϴ�.', '192.168.100.103');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '������', '4444', '4�� �Դϴ�.', '192.168.100.104');
commit;