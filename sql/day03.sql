-- film테이블에서 길이가 60분 이상 90분 이하인
-- 영화를 조회하세요

select title,length from film
where length not between 60 and 90;

-- film 테이블에서 등급이 G또는 PG또는 PG-13인 영화의 제목과 길이, 등급을
-- 조회해주세요

select title, length,rating
from film
where rating in('G','PG','PG-13');

-- actor테이블에서 이름이 A로 시작하는 배우의 이름을 조회하기
select FIRST_NAME from ACTOR where FIRST_NAME like 'A%';
-- film테이블에서 제목에 LOVE가 포함된 영화의 제목을 조회하세요
select TITLE from FILM where TITLE like '%LOVE%';

-- actor테이블에서 이름이 A로 시작하고 총 3글자인 배우의 이름을
-- 조회하세요
select FIRST_NAME from ACTOR
where FIRST_NAME like 'A__';

-- 배우테이블에서 이름의 두번째 글자가 A인 배우를 조회하세요
select FIRST_NAME
from actor a 
where FIRST_NAME like '_A%';

-- 배우테이블에서 이름이 정확히 4글자인 배우의 이름 조회하기
select FIRST_NAME
from actor a 
where FIRST_NAME like '____';

-- NOT LIKE
-- 패턴이 일치하지 않는 데이터를 조회할 때 사용
select TITLE
from FILM
where TITLE not like 'A%';

-- customer 테이블에서 이메일이 .org로 끝나는 고객을 조회하세요
select *  from customer c 
where email like '%.org';
-- film테이블에서 제목에 dinosaur가 포함되어 있지 않은 영화의
-- 제목을 조회하세요
select title from film
where title not like '%dinosaur%';

create table FRUIT(
	ID INT primary key,
	NAME VARCHAR(30),
	PRICE INT
)

-- 한번에 여러 행 추가하기
insert into FRUIT (ID, NAME, PRICE)
values
	(1, '사과', 3000),
	(2, '바나나', 2000),
	(3, '포도',5000);

select * from FRUIT;

-- 한 건 추가
insert into FRUIT (ID, NAME, PRICE)
values (4, '복숭아', 6000);

-- SELECT가 된 결과를 추가하는 방법
create table FRUIT_BACKUP(
	ID INT primary key,
	NAME VARCHAR(30),
	PRICE INT
)

insert into FRUIT_BACKUP(ID,NAME,PRICE)
select ID, NAME,PRICE
from FRUIT
where PRICE <= 3000;

select * from FRUIT_BACKUP;

-- 일부 컬럼만 추가하기
-- 컬럼이 NOT NULL이면 무조건 써야함
insert into FRUIT(ID)
values (5);

select * from FRUIT;

-- 컬럼명을 생략하는 INSERT
insert into FRUIT values (6, '딸기',3900);

-- NULL값을 직접 넣을 수 있다.
insert into FRUIT values (7, '키위',null);

-- DEFAULT값 사용하기
insert into tbl_student (id ,NAME,MAJOR,birth)
values (1, '홍길동','컴퓨터공학','2020-01-01');

select * from tbl_student ts ;

-- 문자열 데이터를 넣을 때 작은따옴표를 사용한다.
-- 날짜 데이터도 작은따옴표로 넣는다.

Insert into tbl_student (id ,NAME,MAJOR,GENDER,birth)
values (2, '이영희','산업디자인','W','2020-01-01');

Insert into tbl_student (id ,NAME,MAJOR,GENDER,birth)
values (3, '김철수','화학공학','M','1980-01-02');

select * from tbl_student ts ;

insert into FLOWER (FLOWER_NAME , FLOWER_COLOR , FLOWER_PRICE )
values ('장미꽃', '빨간색', 3000),
('해바라기', '노란색', 6000),
('튤림', '보라색', 5000),
('안개꽃', '흰색', 2000);

-- 화분테이블에 추가하기
select * from POT;

insert into POT(POT_ID, POT_COLOR, POT_SHAPE, FLOWER_NAME)
VALUES('2026001','흰색','타원형','장미꽃');

select * from POT;

insert into POT(POT_ID, POT_COLOR, POT_SHAPE, FLOWER_NAME)
VALUES('2026002','검은색','네모','해바라기');

-- TBL_STUDENT 테이블에 홍길동의 이름을 김길동으로 바꿔라
update TBL_STUDENT
set name ='김길동'
where id = 1; -- 조건을 걸지 않으면 테이블내의 모든 속성이 수정될 수 있다.

select * from TBL_STUDENT;

-- DEFAULT값으로 바꾸기
update TBL_STUDENT
set GENDER = default
where ID = 3;

-- 여러 조건으로 UPDATE하기
-- AND를 사용하여 조건을 모두 만족하는 행만 수정하기
-- 꽃 테이블에서 색깔이 보라색이고 가격이 5000원 이상인 꽃의 이름을
-- 진달래로 바꾸세요

update FLOWER
set FLOWER_NAME = '진달래'
where FLOWER_COLOR = '보라색' and FLOWER_PRICE >= 5000;

select * from FLOWER;

create table actor_practice as
select actor_id, first_name, last_name, last_update
from sakila.actor;

select * from actor_practice;

-- 배우 번호가 1번인 배우의 이름을 'JAMES'로 수정하세요
update actor_practice
set first_name = 'JAMES'
where actor_id = 1;
-- 배우 번호가 2번인 배우의 이름을 'MINA', 성을 'LEE'로 수정하기
update actor_practice
set first_name = 'MINA',LAST_NAME='LEE'
where ACTOR_ID = 2;
-- sakila 데이터베이스에 있는 film 테이블을 film_practice로 복사하기
create table film_practice as
select * from sakila.film;

select * from film_practice;

-- 영화 번호가 1번인 영화의 대여 가격(rental_rate)을 4.99로 수정하세요
update FILM_PRACTICE
set RENTAL_RATE = 4.99
where FILM_ID = 1;
-- 배우 테이블에서 이름이 A로 시작하는 배우의 성을 'TEST'로 바꾸세요
update ACTOR_PRACTICE
set LAST_NAME = 'TEST'
where FIRST_NAME like 'A%';
-- 영화 테이블에서 등급이 'R', 또는 'NC-17'인 영화의 대여기간(rental_duration)을
-- 3으로 수정하세요
update FILM_PRACTICE
set RENTAL_DURATION = 3 -- 수정하고자 하는 속성
where RATING in ('R','NC-17'); -- 조건

-- 영화 번호가 1인 영화에 대해 대여기간을 1증가 시키기
select TITLE, RENTAL_DURATION from FILM_PRACTICE
where FILM_ID = 1;

update FILM_PRACTICE
set RENTAL_DURATION = RENTAL_DURATION + 1
where FILM_ID = 1;

-- 영화 테이블의 대여료(rental_rate)를 10% 인상하세요
update film_practice
set rental_rate = rental_rate * 1.1;

select title, rental_rate from film_practice;

-- 배우테이블에서 id가 1인 배우 삭제하기
delete from actor_practice
where actor_id = 1;

select * from actor_pracice where actor_id = 1;

-- 여러 행을 삭제
-- 이름이 JOHN인 배우 모두 삭제하기
delete from actor_practice where FIRST_NAME = 'JHON';

-- LIKE를 이용한 삭제
-- 이름이 A로 시작하는 배우 삭제하기
delete from actor_practice
where first_name like 'A%';

-- 데이터만 전부 삭제하기
delete from ACTOR_PRACTICE;

select * from ACTOR_PRACTICE;

-- FLOWER테이블의 장미 삭제하기
-- 외래키 컬럼이 데이터를 참조하고 있으면 참조당하는 쪽의 데이터를
-- 먼저 삭제할 수 없다.
-- 외래키를 설정할 때 on delete CASCADE 설정을 주게 되면
-- 같이 삭제 된다.
delete from FLOWER where FLOWER_NAME='장미꽃';

-- POT 테이블에서 장미꽃을 담고있는 화분 데이터 삭제하기
delete from POT where POT_ID = '2026001';

-- 사용자 생성하기
create user 'student_user'@'localhost'
identified by '1234';

-- 사용자 확인하기
-- MySQL 사용자는 mysql.user 테이블에서 확인할 수 있다.
select user, host from mysql.user;

-- GRANT
-- 사용자에게 권한을 주는 명령어
-- GRANT 권한 ON 데이터베이스명.테이블명 TO '사용자명'@'접속위치';

-- sakila 데이터베이스의 actor 테이블을 조회할 수 있는 권한 주기
grant select 
on sakila.actor
to 'student_user'@'localhost';

select * from actor;

-- sakila 데이터베이스의 다른 테이블에도 접근할 수 있다.
grant select,insert,update
on sakila.*
to 'student_user'@'localhost';

-- 모든 권한 부여하기
grant all privileges
on sakila.*
to 'student_user'@'localhost';

-- 권한 확인하기
show grants for 'student_user'@'localhost';

-- REVOKE
-- 샤용자에게 부여한 권한을 회수하는 명령어
-- REVOKE 권한 ON 데이터베이스명.테이블명 FROM '사용자명'@'접속위치';

revoke select
on SAKILA.ACTOR
from 'student_user'@'localhost';

-- 모든 권한 회수하기
revoke all privileges
on sakila.*
from 'student_user'@'localhost';

-- 자주 쓰이는 권한의 종류
-- select, insert, update ,delete : 데이터 관련
-- create, drop, alter 테이블 관련
-- index : 인덱스 생성/삭제 관련
-- references : 외래키 관련 권한
-- all privilieges

-- 사용자 삭제
-- drop user '사용자명'@'접속위치';
drop user 'student_user'@'localhost';

-- 영화 가격 수정하기
select TITLE, RENTAL_RATE from FILM_PRACTICE where FILM_ID = 1;

start transaction;
-- 임시 상태
update FILM_PRACTICE
set RENTAL_RATE = RENTAL_RATE + 1
where film_id  = 1;

-- COMMIT을 해서 확정을 한다.
-- ROLLBACK을 통해서 되돌리기
rollback;

commit; -- COMMIT을 하면 확정되기 때문에 ROLLBACK을 해도 반영이 안됨








