select * from names;
insert into names(name)
Values ('Phone Tun');
insert into names(name)
values('Kevin Ramada'),('Chelsea Henz'),('Rio Oliva');
update names
set name='Robert Jr'
where id=7;
delete from names 
where created_at> '2023-07-15 21:06:35';
update names 
set id=1
where name='Phone Tun'
