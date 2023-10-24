insert into dojos(name)
values ('Coding Dojo'),
('Cooking Dojo'),
('Racing Dojo');

SET SQL_SAFE_UPDATES = 0;
delete from dojos;
select * from dojos;

insert into dojos(name)
values ('Drinking Dojo'),
('Swimming Dojo'),
('Flying Dojo');

select * from dojos;

insert into ninjas(first_name, last_name, age, dojo_id)
values ('Phone', 'Tun', 22,1),
('Kezia', 'OOOO', 23,1),
('Akash', 'Singh', 23,1);

insert into ninjas(first_name, last_name, age, dojo_id)
values ('Jax', 'Tin', 22,2),
('Rio', 'Lee', 23,2),
('Matt', 'Jix', 24,2);

insert into ninjas(first_name, last_name, age, dojo_id)
values ('Alex', 'Ron', 22,3),
('Steven', 'Ju', 23,3),
('Susan', 'Ddok', 24,3);

select * from ninjas;

select n.* from dojos d
join ninjas n on d.id = n.dojo_id
where d.id=1;

select n.* from dojos d
join ninjas n on d.id = n.dojo_id
where d.id=3;

select d.name from dojos d
join ninjas n on d.id = n.dojo_id
where n.id=9;

select ninjas.first_name, ninjas.last_name, dojos.*
from dojos 
join ninjas on dojos.id = ninjas.dojo_id
where ninjas.id=6;

select ninjas.* , dojos.*
from dojos 
join ninjas on dojos.id = ninjas.dojo_id;
