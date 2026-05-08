select * from sales;
-- 별칭(Alias)
-- 컬럼이나 테이블에 임시 이름을 붙이는 기능
-- 컬럼의 이름을 보기좋게 변경
-- 테이블 이름을 짧게 줄인다.
-- 함수를 걸었을 때 너무 길어지면 별명을 줄 수 있다.
-- select 컬럼명 as 별칭 from 테이블명;
-- from 테이블명 as 별칭;
-- as 생략 가능
-- 사용자 화면에는 emp_name보다 이름 이라고 보여주는게 낫다.
select category 카테고리, avg_amount as "평균 판매량"
from(
	select category, avg(sales_amount) as avg_amount
	from sales
	group by category -- 쿼리 결과로 얻어진 임시 테이블
) as t; 
-- 서브쿼리로 조회된 결과에는 이름이 없기 때문에
-- 서브쿼리로 조회된 테이블에는 별칭이 필수이다.

select * from employee;

-- 부서별 평균을 inline view를 활용하여 조회하기
-- 출력 컬럼 : department, avg_salary
select *
from (select DEPARTMENT, AVG(SALARY) as AVG_SALARY 
from EMPLOYEE group by DEPARTMENT) as D;

-- 평균 급여가 5000 이상인 부서만 조회하세요
-- inline view 활용하기
select *
from (
	select DEPARTMENT, AVG(SALARY) as AVG_SALARY
	from EMPLOYEE
	group by DEPARTMENT
	having AVG_SALARY >= 5000
) as D;

-- 각 부서의 최고 급여 조회하기
select *
FROM(
	select DEPARTMENT, MAX(SALARY) as MAX_SALARY
	from EMPLOYEE
	group by DEPARTMENT
) D;

-- SALES 테이블을 이용하여 지역별 판매 건수를 서브쿼리를 이용하여 조회하기
-- 지역 : REGION
select *
FROM(
	select REGION, SUM(sales_amount)
	from sales
	group by region
) t;

-- 지역별로 최고 판매금액, 최저 판매금액, 최고와 최저 판매금액의 차이를 조회하기
select 
	region, 
	max_price, 
	min_price, 
	max_price - min_price as price_gap
from (
	select region,
		   max(sales_amount) as max_price,
		   min(sales_amount) as min_price
	from sales
	group by region
) d;
-- 카테고리별 총 판매금액 조회 후 평균보다 높은 카테고리 조회하기
-- 카테고리별 총 판매금액을 구한뒤, 전체 카테고리 평균 판매금액보다 높은 카테고리를 조회
-- inline view를 사용해야 하는 이유
-- 1. 카테고리별 총 판매금액
-- 2. 그 결과들의 평균

select *
from (
	select category,
		   sum(sales_amount) as total_price
	from sales
	group by category
)t
where total_price > (
	select avg(total_price)
	from (
		select category,
	   			sum(sales_amount) as total_price
		from sales
		group by category
	)x
);

-- inline view를 쓰면 좋을 때
-- 중간 결과를 재사용
-- 복잡한 통계의 처리
-- 정렬/필터링

-- 상관 서브쿼리(Correlated Subquery)
-- 서브쿼리가 바깥쪽 쿼리의 값을 참조하는 서브쿼리
-- 서브쿼리가 혼자 실행될 수 없고, 바깥쪽 쿼리의 각 행마다 반복 실행되는 구조

select *
from sales
where sales_amount > (
	select avg(sales_amount)
	from sales
);

-- 1. 전체 평균 가격을 구한다.
-- 2. 각 상품 가격과 비교한다.
-- 서브쿼리 1번 실행 -> 메인쿼리를 실행한다.

-- 상관 서브쿼리
select *
from sales s1
where sales_amount > (
	select avg(sales_amount)
	from sales s2
	where s2.region = s1.region
);

-- 서브쿼리에서 바깥쪽 쿼리의 s1.region을 참조하고 있다.
-- 각 행마다 자기 지역의 평균 가격을 구해서 비교하게 된다.
-- 서울 행 -> 서울 평균과 비교
-- 부산 행 -> 부산 평균과 비교
-- 대구 행 -> 대구 평균과 비교

-- 실행 방식
-- 1. 바깥쪽 쿼리에서 행을 하나 꺼낸다.
-- 2. 그 행의 값을 서브쿼리에 전달한다.
-- 3. 서브쿼리를 실행한다.
-- 4. 결과를 비교
-- 5. 다음행으로 이동한다.

select * from sales;

-- 
select region,avg(sales_amount)
from sales
where region = '서울'
group by region;

-- having절 서브쿼리
select department, avg(salary)
from employee
group by department
having avg(salary) > (
	select avg(salary) from employee
);

-- INSERT 서브쿼리
insert into employee_practice
select * from employee where salary >= 6000;

select * from employee_practice;

create table employee_practice(
	emp_id int primary key,
	emp_name varchar(100),
	department varchar(100),
	salary int
)

-- update에서 사용하는 서브쿼리
-- 김철수의 부서와 같은 부서에서 일하는 사람의 급여를 10%인상
update employee
set salary = salary * 1.1
where department = (
	select department 
	from (
		select department
		from employee
		where emp_name='김철수') t
	);

select * from employee;

-- delete에서 사용하는 서브쿼리
-- 전체 평균 급여보다 적게 받는 사람 삭제하기
delete from employee
where salary < (
	select avg_salary
	from (
		select avg(salary) as avg_salary
		from employee)t
);

select avg(salary)
		from employee;

select * from employee;


-- 학생 테이블
CREATE TABLE student (
  id INT PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO student (id, name) VALUES
(1, '철수'),
(2, '영희'),
(3, '민수');

-- 수강 테이블
CREATE TABLE enroll (
  id INT PRIMARY KEY,
  student_id INT,
  class_name VARCHAR(50),
  constraint fk_enroll_student foreign key (student_id)
  references student(id)
);

INSERT INTO enroll (id, student_id, class_name) VALUES
(1, 1, '데이터베이스'),
(2, 1, '자바'),
(3, 2, '데이터베이스');

insert into enroll values (4,null,'파이썬');

-- Inner Join
-- 학생 이름, 수업명을 조회하고 싶다.
select name,class_name
from student s
inner join enroll e
on s.id = e.student_id;

-- on이 where의 역할을 한다.
-- on절로 연결 기준을 알려줘야 한다.

-- 값 자체가 연결 역할을 하기 때문에 fk로 설정하지 않아도 가능은 하다.
-- fk로 연결하지 않으면 데이터의 무결성이 보장되지 않기 때문이다.
-- 잘못된 데이터가 들어와도 막을 수 없다.
-- fk로 연결하여 join을 하는것을 기본으로 한다.

-- 고객
-- 상품
-- 주문

CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(30),
    grade VARCHAR(20)
);

CREATE TABLE product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    category VARCHAR(30),
    price INT
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    CONSTRAINT fk_orders_customer
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    CONSTRAINT fk_orders_product
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

INSERT INTO customer VALUES
(1, '김민준', 'VIP'),
(2, '이서연', '일반'),
(3, '박지훈', 'VIP'),
(4, '최유나', '일반'),
(5, '정하늘', '실버');

INSERT INTO product VALUES
(101, '노트북', '전자제품', 1200000),
(102, '마우스', '전자제품', 50000),
(103, '키보드', '전자제품', 80000),
(201, '의자', '가구', 150000),
(202, '책상', '가구', 300000);

INSERT INTO orders VALUES
(1, 1, 101, 1, '2026-05-01'),
(2, 1, 102, 2, '2026-05-01'),
(3, 2, 201, 1, '2026-05-02'),
(4, 3, 101, 1, '2026-05-02'),
(5, 3, 202, 1, '2026-05-03'),
(6, 4, 103, 3, '2026-05-03'),
(7, 5, 201, 2, '2026-05-04'),
(8, 5, 102, 1, '2026-05-04');

-- 고객명, 상품명, 주문수량, 주문일자 조회하기
select customer_name, product_name, quantity, order_date
from orders o
inner join product p
on o.product_id = p.product_id
inner join customer c 
on o.customer_id = c.customer_id;

-- 고객별 총 구매 금액
-- group by 사용하기
select CUSTOMER_NAME, SUM(QUANTITY * PRICE)
from ORDERS O
inner join CUSTOMER C
on O.customer_id = C.customer_id
inner join PRODUCT P
on O.product_id = P.product_id
group by C.customer_name;

-- 총 구매금액이 100만원 이상인 고객 조회하기
select CUSTOMER_NAME, SUM(QUANTITY * PRICE) as TOTAL_PRICE
from ORDERS O
inner join CUSTOMER C
on O.customer_id = C.customer_id
inner join PRODUCT P
on O.product_id = P.product_id
group by C.customer_name
having TOTAL_PRICE >= 1000000;

-- 카테고리별 총 매출 조회
select CATEGORY, SUM(QUANTITY * PRICE)
from ORDERS O
inner join PRODUCT P
on O.product_id = P.product_id 
group by P.CATEGORY;

-- VIP 고객의 주문내역 조회하기
-- 이름, 등급, 제품명, 주문수량, 주문날짜
select CUSTOMER_NAME, GRADE, PRODUCT_NAME, QUANTITY, ORDER_DATE
from ORDERS O
inner join customer c 
on O.customer_id = C.customer_id 
inner join product p 
on O.product_id = P.product_id
where GRADE = 'VIP';

select NAME, CLASS_NAME
from student s 
left outer join enroll e
on S.id = E.student_id;

-- 민수는 수강내역이 없지만, 왼쪽 테이블에 있으므로 반드시 나온다.
-- 대신 enroll쪽 값은 없기 때문에 null로 채워진다.


INSERT INTO customer VALUES
(6, '한지민', '일반');

INSERT INTO product VALUES
(203, '소파', '가구', 700000);

-- 주문내역이 한번도 없는 고객의 이름을 조회하세요
select CUSTOMER_NAME
from CUSTOMER C
left outer join ORDERS O
on O.CUSTOMER_ID = C.CUSTOMER_ID;



-- 모든 고객의 주문 건수를 조회하세요
-- 주문이 없는 고객은 0으로 출력되게 하세요
select CUSTOMER_NAME, COUNT(ORDER_ID)
from CUSTOMER C
left outer join ORDERS O
on C.customer_id = O.customer_id
group by C.customer_name;

-- RIGHT OUTER JOIN
-- 오른쪽 테이블을 기준으로 전부 출력하는 JOIN
select NAME, CLASS_NAME
from STUDENT S
right outer join enroll e 
on S.id  = E.student_id;
-- 모든 수강 기록을 기준으로 학생 이름을 붙여줘
-- 실무에서는 LEFT JOIN을 더 자주 사용하고, RIGHT JOIN은
-- 방향만 바뀐 개념이라 잘 쓰지 않는 편이다.

-- FULL OUTER JOIN
-- 양쪽 테이블의 모든 데이터를 조회
-- 일치하면 연결하고, 일치하지 않으면 없는 쪽을 NULL로 표시한다.
-- MySQL은 Full Outer JOin을 직접 지원하지는 않는다.
-- LEFT JOIN과 RIGHT JOIN을 UNION으로 합쳐서 구현한다.

-- union : 두 가지 select 결과를 이어붙인다.
-- 중복제거를 자동으로 해준다.
select NAME, CLASS_NAME
from student s 
left outer join enroll e
on S.id = E.student_id
union
select NAME, CLASS_NAME
from STUDENT S
right outer join enroll e 
on S.id  = E.student_id;

-- union all : 중복 제거 없이 모두 출력이 된다.

CREATE TABLE color (
  name VARCHAR(20)
);

INSERT INTO color VALUES ('빨강'), ('파랑');

CREATE TABLE size (
  name VARCHAR(20)
);

INSERT INTO size VALUES ('S'), ('M'), ('L');

-- 색상과 사이즈의 모든 조합을 만들어보자
select c.name, e.name
from color c
cross join size e;

-- 일반적인 조회에서는 많이 사용하지 않으나, 모든 조합이 필요한 경우 사용

CREATE TABLE employees (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  manager_id INT  -- 상사의 id
);

INSERT INTO employees VALUES
(1, '대표', NULL),
(2, '팀장', 1),
(3, '사원A', 2),
(4, '사원B', 2);

select 
	e.name as employee_name,
	m.name as manager_name
from employees e
left outer join employees as m
on e.manager_id = m.id;

-- 모든 고객과 상품의 가능한 조합을 조회하세요
select c.customer_name, p.product_name
from customer c 
cross join product p;
-- 모든 상품 조합 개수 조회
select count(*)
from customer c
cross join product p;

-- 모든 고객과 전자제품 카테고리 상품 조합 조회
select c.customer_name, p.product_name
from customer c
cross join product p
where p.category ='전자제품';
-- CUSTOMER 테이블에 추천인 아이디 컬럼 추가(recommender_id)
-- 자료형은 int
alter table customer add recommender_id int;
UPDATE customer

-- 고객명과 추천인 이름을 조회하기
select c.customer_name as customer,
	r.customer_name as recommender
from customer c
inner join customer r
on c.recommender_id = r.customer_id;
-- 추천인이 없는 고객 조회
select * from customer where recommender_id is null;
-- 추천 관계 문장 출력하기
-- ex) 이서연의 추천인은 김민준
select concat(c.customer_name,'의 추천인은 ',r.customer_name) as relation_info
from customer c
inner join customer r
on c.recommender_id = r.customer_id;

-- 가장 많은 고객을 추천한 사람순으로 조회하기
select r.customer_name as 추천인,
count(*) as "추천 횟수"
from customer c
inner join customer r
on c.recommender_id = r.customer_id
group by r.customer_name;

-- 고객테이블과 주소테이블을 이용하여
-- 고객의 이름, 성, 주소를 조회하세요
select c.first_name, c.last_name, a.address
from customer c 
inner join address a
on c.address_id = a.address_id;


create view customer_address_view as
select c.first_name, c.last_name, a.address
from customer c 
inner join address a
on c.address_id = a.address_id;

-- 복잡한 SELECT를 테이블처럼 사용할 수 있다.
select * from customer_address_view;

-- 영화 번호(film),
-- 영화 제목(film), 
-- 카테고리(film_category), 
-- 대여료(film)를 조회하는 SELECT문을
-- film_category_view라는 이름의 view로 만들기





create view film_category_view as
select f.film_id, f.title, c.name as category_name, f.rental_rate
from film f 
inner join film_category fc
on f.film_id = fc.film_id
inner join category c 
on c.category_id = fc.category_id
order by film_id;

select * from film_category_view;

-- 고객별 영화 대여 횟수를 customer_rental_count_view로 만들기
create view customer_rental_count_view as
select 
	c.customer_id,
	c.first_name,
	c.last_name,
	count(r.rental_id) as rental_count
from customer c
inner join rental r
on c.customer_id = r.customer_id
group by
	c.customer_id,
	c.first_name,
	c.last_name;

select * from customer_rental_count_view;

-- 30번 이상 빌려본 고객의 정보를 조회하세요
select * from customer_rental_count_view
where rental_count >= 30;

-- view를 사용하면 좋은 경우
-- 1. 복잡한 join과 조건이 반복될 때
-- 2. 비즈니스 규칙을 숨겨둘 때
-- 3. 보안,권한 제어용으로 사용한다.


















