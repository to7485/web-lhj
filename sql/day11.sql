create table member(
	id int auto_increment primary key,
	name varchar(50) not null,
	email varchar(100) not null unique,
	age int
);

insert into member(name,email,age)
values
('홍길동','hong@test.com',20),
('김철수','kim@test.com',30);

select * from member;

SELECT VERSION();




