drop table if exists user;

create table user (
	id bigint(20) not null,
	name varchar(30),
	age int(11),
	email varchar(50),
	primary key (id)
);

insert into user (id, name, age, email) values
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');