-- 회원 테이블
CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(30) NOT NULL
);

-- 도서 테이블
CREATE TABLE book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    stock INT NOT NULL
);

-- 대여 테이블
CREATE TABLE rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    book_id INT NOT NULL,
    rental_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(customer_id)
        REFERENCES customer(customer_id),
    FOREIGN KEY(book_id)
        REFERENCES book(book_id)
);

-- 회원 데이터
INSERT INTO customer(name, phone) VALUES
('김철수', '010-1111-1111'),
('이영희', '010-2222-2222');
-- 도서 데이터
INSERT INTO book(title, author, stock) VALUES
('자바의 정석', '남궁성', 5),
('혼자 공부하는 SQL', '우재남', 3),
('스프링부트 입문', '김영한', 4);

-- 도서 대여 서비스를 만들고싶다.
-- 어떤 테이블이 필요하고, 어떤 속성이 필요하고, 제약조건을 뭘로 정하고

select * from customer;

select * from rental;
select * from book;

