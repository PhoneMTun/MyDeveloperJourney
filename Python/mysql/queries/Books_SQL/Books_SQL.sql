insert into users(first_name, last_name)
values ('Jane', 'Amsden'), ('Emily', 'Dixon'), ('Theodore', 'Dostoevsky'),
('William', 'Shapiro'), ('Lao', 'Xiu');

insert into books(title, num_of_pages)
values ('C Sharp',100),('Java',200),('Python',300),('PHP',200),
('Ruby',400);

update books 
set title= 'C#'
where id=1;

update users 
set first_name= 'Bill'
where id=4;

insert into favorites(user_id, book_id)
values(1,1),(1,2),(2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(3,4),(4,1),(4,2),(4,3),(4,4),(4,5);

select * from users
join favorites
on users.id=favorites.user_id
where favorites.book_id=3;

delete from favorites 
where user_id = 2 and book_id=3;

INSERT into favorites (user_id, book_id)
VALUES (5, 2);

select * from books b
join favorites f
on b.id=f.book_id
where f.user_id=3;

select * from users u
join favorites f
on u.id=f.user_id
where f.book_id=5;


