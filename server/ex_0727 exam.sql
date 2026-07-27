CREATE DATABASE movie_reservation_db;

create table movie_reservation_db.movies(
movie_id int auto_increment primary key,
movie_title varchar(100) not null,
movie_genre varchar(50) not null,
running_time int not null,
ticket_price int not null,
release_date datetime default CURRENT_TIMESTAMP()
)

create table movie_reservation_db.reservation(
reservation_id int auto_increment primary key,
customer_name varchar(50) not null,
movie_id int not null,
reservation_date datetime default CURRENT_TIMESTAMP(),
seat_number varchar(10) not null,
ticket_count int not null,
reservation_status varchar(20) not null,
constraint fk_movie_id foreign key (movie_id) REFERENCES movie_reservation_db.movies(movie_id)
)