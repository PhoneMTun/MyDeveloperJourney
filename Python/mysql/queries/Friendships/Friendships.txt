insert into users(first_name, last_name)
values('Phone', 'Tun'), ('Kevin', 'Ramada'), ('Shawn', 'Mendes'),('Tiffiny', 'Alla'),('Noah', 'Sheins')
,('John','Hokins');


insert friendship(user_id, friend_id)
values(1,2),(1,4),(1,6);

insert friendship(user_id, friend_id)
values(2,1),(2,3),(2,5);

insert friendship(user_id, friend_id)
values(3,2),(3,5);

insert friendship(user_id, friend_id)
values(4,3);

insert friendship(user_id, friend_id)
values(5,1),(5,6);

insert friendship(user_id, friend_id)
values(6,2),(6,3);


select users.first_name as first_name, users.last_name as last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name from users
join friendship on users.id =friendship.user_id
join users as users2 on  users2.id= friendship.friend_id;

select count(*) num_friendships from friendship;

select users.first_name, users.last_name, count(user_id) as total_friendships from friendship
join users on users.id=friendship.user_id
group by user_id
Order by total_friendships desc
limit 1;

select users2.first_name as friend_first_name, users2.last_name as friend_last_name from users
join friendship on users.id =friendship.user_id
join users as users2 on  users2.id= friendship.friend_id
where users.id=3
order by users2.first_name;

