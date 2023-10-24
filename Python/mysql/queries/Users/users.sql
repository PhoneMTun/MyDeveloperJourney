insert into users (first_name, last_name, email)
values	("Phone", "Tun", "hanminsoe10@gmail.com"),
("di", "di", "asdfasdfasdf@gmail.com"),
("ei", "zizi", "zxcvzxvczxcv@gmail.com");

select * from users;

select * from users
where email = 'hanminsoe10@gmail.com';

update users
set last_name = 'Pancakes'
where id=3;


delete from users
where id ='2';

select first_name from users;

select * from users
order by first_name DESC;