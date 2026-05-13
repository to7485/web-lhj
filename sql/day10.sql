-- 프로시저 이름 : even_sum
-- 입력받은 두 숫자 사이의 짝수만 더하여 결과 출력하기
-- 시작값과 끝 값은 IN 매개변수로 받는다.
-- WHILE 사용
-- 짝수만 누적
-- 결과는 SELECT로 출력하기

DELIMITER //
create procedure EVEN_SUM(
	IN P_START INT,
	IN P_END INT
)
begin
	declare I INT; -- 조건에 사용할 변수
	declare total int default 0;

	set i = p_start; -- 내가 입력한 시작값부터 시작
	
	while i <= p_end do
		if MOD(I,2) = 0 then
			set TOTAL = TOTAL + I;
		end if;
		set I = I + 1;
	end while;
	
	select TOTAL as even_total;
end //

delimiter ;

call even_sum(1,20);

-- 회원등급 자동 변경
-- 프로시저명 : update_customer_grade
CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(50),
    total_amount INT,
    grade VARCHAR(20)
);
INSERT INTO customer VALUES
(1, '김철수', 120000, NULL),
(2, '이영희', 80000, NULL),
(3, '박민수', 300000, NULL);

-- 모든 회원을 반복 조회하면서 등급 갱신하기
-- 조건
-- 구매금액		등급
-- 20만원 이상		VIP
-- 10만원 이상		GOLD
-- 나머지			SILVER
DELIMITER //
create procedure update_customer_grade()
begin
	declare v_id int default 1;
	declare v_max_id int;
	declare v_amount int;

	-- 고객테이블에서 가장 큰 고객번호를 변수에 대입
	select MAX(customer_id)
	into v_max_id
	from customer;
	
	while v_id <= v_max_id do
	
		-- 고객별로 총 구매금액을 변수에 담는다.
		select total_amount
		into v_amount
		from customer
		where customer_id = v_id;
		
		if v_amount is not null then
			update customer
			set grade = 
				case 
					when total_amount >= 200000 then 'VIP'
					when TOTAL_AMOUNT >= 100000 then 'GOLD'
					else 'SILVER'
				end
			where CUSTOMER_ID = V_ID;
		end if;
		set V_ID = V_ID + 1;
	end while;
end //
DELIMITER ;

call update_customer_grade();

select * from CUSTOMER;


-- 새로운 회원을 추가
-- 4, 최민준, 250,000, null

insert into customer values(4,'최민준',250000,null);
select * from customer;
-- 새 회원의 등급을 정해주세요

call update_customer_grade();


-- 주문 금액 누적 시 배송시 계산
-- 프로시저명 : calculate_cart_total
CREATE TABLE cart (
    cart_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    price INT
);

INSERT INTO cart VALUES
(1, '마우스', 30000),
(2, '키보드', 50000),
(3, '모니터', 200000);

-- 장바구니 금액을 누적하면서 배송비를 계산하시오
-- 누적금액 100,000원 이상 → 배송비 0원
-- 미만 → 배송비 3000원
-- 상품을 하나씩 읽으며 누적
-- SELECT를 이용하여 조회하기
delimiter //
create procedure calcaulte_cart_total()
begin
	declare v_id int default 1; -- 시작값
	declare v_max_id int; -- 종료값
	declare v_price int; -- 가격을 담을 변수
	declare v_total int default 0; -- 총합을 담을 변수
	declare v_delivery_fee int; -- 배송비를 담을 변수
	
	-- 가장 마지막 id찾기
	select max(cart_id)
	into v_max_id
	from cart;
	
	while v_id <= v_max_id do
		select price
		into v_price
		from cart
		where cart_id = v_id;
	
		-- 가격이 null이 아니라면
		if v_price is not null then
			-- v_total에 누적
			set v_total = v_total + v_price;
		
			if v_total >= 100000 then
				set v_delivery_fee = 0;
			else
				set v_delivery_fee = 3000;
			end if;
			
			select 
				v_total as current_total,
				v_delivery_fee as delivery_fee;
		end if;
			
		set v_id = v_id + 1;
	end while;
end //
delimiter ;

call calcaulte_cart_total();

create table MEMBER(
	MEMBER_ID INT primary key,
	MEMBER_NAME VARCHAR(50) not NULL
);

DELIMITER //
create procedure INSERT_MEMBER()
begin
	declare continue HANDLER for 1062
	begin
		select '이미 존재하는 회원 ID입니다.' as message;
	end;

	insert into member(member_id, member_name)
	values(1,'홍길동');
	
	-- pk값이 중복됨
	insert into member(member_id, member_name)
	values(1,'김철수');
	
	select '프로시저가 끝까지 실행되었습니다.' as result;
end //
delimiter ;

call insert_member();
-- 두번째 INSERT에서 기본키 중복 에러가 발생하지만, CONTINUE HANDLER가
-- 처리했기 때문에 프로시저가 끝까지 실행된다.
DELIMITER //
create procedure INSERT_MEMBER_EXIT()
begin
	declare EXIT HANDLER for 1062
	begin
		select '중복 오류가 발생하여 프로시저를 종료합니다.' as message;
	end;

	insert into member(member_id, member_name)
	values(1,'홍길동');
	
	-- pk값이 중복됨
	insert into member(member_id, member_name)
	values(1,'김철수');
	
	select '이 문장은 실행되지 않습니다.' as result;
end //
delimiter ;

call INSERT_MEMBER_EXIT();

-- SELECT INTO 결과가 없을 때 처리하기
-- SELECT ... INTO는 조회 결과를 변수에 넣을 때 사용한다.
-- 조회 결과가 없으면 NOT FOUND 상황이 발생할 수 있다.

-- 프로시저명 : FIND_PRODUCT
-- 매개변수 : IN P_ID INT
-- ID를 통해 상품의 이름과 가격을 조회
-- 조회되는게 없으면 '해당 상품이 없습니다.' 라고 조회하기

DELIMITER //
create procedure FIND_PRODUCT(in P_ID INT)
begin
	declare V_NAME VARCHAR(50);
	declare V_PRICE INT;

	declare continue HANDLER for not found
	begin
		select '해당 상품이 없습니다.' as MESSAGE;
	end;
	
	select PRODUCT_NAME, PRICE
	into V_NAME, V_PRICE
	from PRODUCT
	where PRODUCT_ID = P_ID;
	
	select V_NAME as PRODUCT_NAME, V_PRICE as PRICE;
end //
DELIMITER ;

call FIND_PRODUCT(1);
call FIND_PRODUCT(999);

DELIMITER //
create procedure FIND_PRODUCT_SAFE(in P_ID INT)
begin
	declare V_NAME VARCHAR(50);
	declare V_PRICE INT;
	-- 플래그 변수
	-- 특정 상황이 발생했는지 기억해두는 변수

	declare V_NOT_FOUND BOOLEAN default false;

	declare continue HANDLER for not found
	begin
		set V_NOT_FOUND = true;
	end;
	
	select PRODUCT_NAME, PRICE
	into V_NAME, V_PRICE
	from PRODUCT
	where PRODUCT_ID = P_ID;
	
	if V_NOT_FOUND then
	 	select '해당 상품이 없습니다.' as MESSAGE;
	else
		select V_NAME as PRODUCT_NAME, V_PRICE as PRICE;
	end if;
end //
DELIMITER ;

call FIND_PRODUCT_SAFE(1);
call FIND_PRODUCT_SAFE(999);

-- SQLEXCEPTION으로 전체 SQL 오류 처리하기
-- 다양한 예외를 처리할 수 있다는 장점이 있으나
-- 어떤 예외가 발생했는지 알기 어렵다

DELIMITER //

create procedure ADD_PRODUCT(
	in P_ID INT,
	in P_NAME VARCHAR(50),
	in P_CATEGORY VARCHAR(50),
	in P_PRICE INT,
	in P_STOCK INT,
	in P_STATUS VARCHAR(50)
)
begin
	declare exit HANDLER for sqlexception
	begin
		select '상품 등록 중 오류가 발생했습니다.' as MESSAGE;
	end;

	insert into PRODUCT(PRODUCT_ID, PRODUCT_NAME,CATEGORY, PRICE, STOCK, STATUS)
	VALUES(P_ID, P_NAME,P_CATEGORY, P_PRICE, P_STOCK, P_STATUS);
	
	select '상품 등록 성공' as MESSAGE;
end //
DELIMITER ;

call ADD_PRODUCT(9, '노트북 거치대','전자기기',70000,15, '판매중');

select * from PRODUCT;

-- SIGNAL
-- 강제로 예외를 발생시키는 기능
-- PK중복, NOT NULL 위반, FOREIGN KEY 위반같은 상황에서는 자동으로
-- 예외가 발생한다.
-- 재고가 부족하면 주문 금지, 나이가 0보다 작으면 저장 금지, 이미 탈퇴한 회원은
-- 주문 금지와 같은 비즈니스 로직도 검사를 해야한다.

-- 기본문법
-- SIGNAL SQLSTATE '45000'
-- SET MESSAGE_TEXT = '오류 메시지'



DELIMITER //

create procedure ORDER_PRODUCT2(
	in P_ID INT, -- 제품아이디
	in P_ORDER_COUNT INT -- 주문 개수
)
begin
	declare V_STOCK INT;

-- 	declare exit HANDLER for sqlexception
-- 	begin
-- 		select '주문 처리 중 오류가 발생했습니다.' as MESSAGE;
-- 	end;
	
	-- 프로시저를 호출 할 때 전달한 제품ID를 통해서 STOCK을 조회하여
	-- V_STOCK에 대입하기
	select STOCK
	into V_STOCK
	from product p 
	where p.product_id = P_ID;
	
	-- 주문량보다 재고가 부족할 때 강제로 예외 발생시키기
	if P_ORDER_COUNT > V_STOCK then
		signal sqlstate '45000'
		set MESSAGE_TEXT = '재고가 부족합니다.';
	end if;
	
	update product p 
	set STOCK = STOCK - P_ORDER_COUNT
	where PRODUCT_ID = P_ID;

	select '주문 완료' as MESSAGE;
end //
DELIMITER ;

call ORDER_PRODUCT2(1,300);


-- 회원 추가 프로시저 작성하기
-- 프로시저 이름 : add_user_handler
-- 아이디, 이름, 이메일을 입력받는다.
-- 정상 등록되면 '회원가입 성공'을 출력한다.
-- 아이디 또는 이메일이 중복되면 '아이디 또는 이메일이 중복되었습니다' cnffurgksek.

-- 도서 대여 처리 프로시저
CREATE TABLE book (
    book_id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    stock INT
);

CREATE TABLE book_rental (
    rental_id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    rental_count INT,
    rental_date DATETIME DEFAULT NOW()
);

INSERT INTO book VALUES
(1, '혼자 공부하는 SQL', '우재남', 3),
(2, '이것이 자바다', '신용권', 5),
(3, '스프링 부트 입문', '김개발', 1),
(4, '리액트 시작하기', '이프론트', 0);

-- 문제
-- 도서 id와 대여 권수를 입력받아 도서를 대여하는 프로시저 rental_book 만들기
-- 요구사항
-- 도서 id와 대여 권수를 입력받는다.
-- 도서가 존재하지 않으면 '존재하지 않는 도서입니다.' 출력
-- 대여 권수가 0이하면 '대여 권수는 1권 이상이어야 합니다.' 출력
-- 재고가 부족하면 '대여 가능한 재고가 부족합니다.' 출력
-- 정상 대여면 반복문을 사용하여 대여 권수만큼 'x 권 대여 처리중 ...' 이라고 출력
-- 정상 대여 후 book 테이블의 재고를 차감한다.
-- book_rental 테이블에 대여 내역을 추가한다.
-- 예외처리는 handler를 사용한다.

DELIMITER //

create procedure rent_book(
	in p_book_id int,
	in p_rental_count int
)
begin
	-- 지역변수 선언
	declare v_title varchar(100);
	declare v_stock int;
	declare v_not_found boolean default false;
	declare i int default 1;

	-- signal을 이용한 예외처리
	declare continue handler for not found
	begin
		set v_not_found = true;
	end;
	
	declare exit handler for sqlexception
	begin
		select '대여 처리 중 오류가 발생했습니다.' as message;
	end;
	
	-- book 테이블에서 입력받은 도서ID에 해당하는 제목과 재고 조회
	select TITLE, STOCK
	into V_TITLE, V_STOCK
	from BOOK
	where BOOK_ID = P_BOOK_ID;
	
	-- 도서가 존재하지 않는 경우
	if V_NOT_FOUND then
		select '존재하지 않는 도서입니다.' as MESSAGE;
	-- 대여 권수가 0권 이하인 경우
	elseif P_RENTAL_COUNT <= 0 then
		select '대여 권수는 1권 이상이어야 합니다.' as MESSAGE;
	-- 대여 권수가 재고보다 많은 경우
	elseif P_RENTAL_COUNT > V_STOCK then
		select '대여 가능한 재고가 부족합니다.' as MESSAGE;
	-- 도서가 존재하고, 대여 권수도 정상이며, 재고도 충분한 경우
	else
		-- 대여 권수만큼 반복하면서 처리 과정 출력하기
		while i <= p_rental_count do
			select concat(i,'권 대여 처리중...') as process;
			set i = i + 1;
		end while;
	
		-- book 테이블의 재고를 대여 권수만큼 차감
		update book
		set stock = stock - p_rental_count
		where book_id = p_book_id;
		
		-- book_rental 테이블에 대여 기록을 저장
		insert into book_rental(book_id, rental_count)
		values(p_book_id, p_rental_count);
		
		-- 최종 성공 메시지 출력
		select concat(v_title, '도서 대여가 완료되었습니다.') as message;
	end if;
end //
DELIMITER ;


call rent_book(1,3);
call rent_book(88,2);
call rent_book(1,0);

-- CURSOR
-- SELECT 결과를 한 줄 씩 꺼내서 처리하는 기능

select * from PRODUCT; -- 결과를 한 번에 보여준다.

-- 커서를 사용하는 이유
-- 모든 상품을 하나씩 확인하면서 처리하고싶다.
-- CASE, UPDATE를 사용해서 한 번에 처리할수도 있지만 행마다 복잡한 로직을 실행해야 한다면
-- CURSOR를 사용하는것이 유용하다.
-- 상품 한 행을 조회 -> 재고 상태 판단 -> 다른 테이블에 기록 -> 조건에 따라 추가 작업

-- 커서의 기본 구조
-- DECLARE 커서이름 CURSOR FOR
-- SELCT 컬럼 FROM 테이블명
-- OPEN 커서이름; -> SELECT 실행 결과를 커서에 준비
-- FETCH 커서이름 INTO 변수1, 변수2; -> 결과에서 한 행을 꺼내 변수에 저장
-- CLOSE 커서이름; -> 커서 사용 종료

-- 커서도 프로시저 안에서 사용을 해야한다.

delimiter //
create procedure print_book_stock()
begin
	declare v_title varchar(100);
	declare v_stock int;
	declare done boolean default false;

	declare book_cursor cursor for
	select title,stock
	from book;
	
	declare continue handler for not found
	begin
		set done = true;
	end;

	open book_cursor;
	
	-- 모든 행을 다 읽은 뒤 다시 fetch하면 더 이상 가져올 행이 없다.
	-- 이 때 not found 예외가 발생한다.
	read_loop: loop
		fetch book_cursor into v_title, v_stock;
	
		if done then
			leave read_loop;
		end if;
		
		select concat(v_title, ' 재고: ', v_stock,'권') as result;
	end loop;
	
	close book_cursor;
end //
delimiter ;

call print_book_stock();

-- student_score 테이블의 모든 학생을 커서로 한 명 씩 읽어
-- 다음 형식으로 출력하는 print_student_score 프로시저 만들기
-- 김철수 - Java 점수 : 92점


delimiter //
create procedure print_student_scores()
begin
	declare v_name varchar(50);
	declare v_subject varchar(50);
	declare v_score int;
	declare done boolean default false;

	declare score_cursor cursor for
	select student_name, subject, score
	from student_score;
	
	declare continue handler for not found
	begin
		set done = true;		
	end;
	
	open score_cursor;
	
	read_loop: loop
		fetch SCORE_CURSOR into V_NAME, V_SUBJECT, V_SCORE;
		
		if DONE then
			leave READ_LOOP;
		end if;
		
		select CONCAT(V_NAME,' - ',V_SUBJECT,' 점수 : ', v_score,'점') as result;
	end loop;
		
	close score_cursor;
end //
delimiter ;

call print_student_scores();

-- 커서를 이용한 과락 학생 기록하기
-- student_score 테이블에서 점수가 60점 미만인 학생만 커서로 찾아
-- fail_student_log 테이블에 기록하는 insert_fail_student_log
-- 작성하기

CREATE TABLE fail_student_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    student_name VARCHAR(50),
    subject VARCHAR(50),
    score INT,
    reason VARCHAR(100),
    created_at DATETIME DEFAULT NOW()
);

delimiter //
create procedure insert_fail_student_log()
begin
	declare v_id int;
	declare v_name varchar(50);
	declare v_subject varchar(50);
	declare v_score int;
	declare done boolean default false;

	-- 커서 선언
	declare fail_cursor cursor for
	select student_id, student_name, subject, score
	from student_score
	where score < 60;
	
	-- 핸들러 만들기
	declare continue handler for not found
	set done = true;
	
	open fail_cursor;
	
	read_loop:loop
		fetch fail_cursor into v_id, v_name, v_subject, v_score;
		
		if done then
			leave read_loop;
		end if;
		
		insert into fail_student_log(student_id, student_name, subject,score,reason)
		values(v_id, v_name, v_subject, v_score, '60점 미만 과락');
	end loop;
	
	close fail_cursor;
	
	select '과락 학생 기록 완료' as message;
end //
delimiter ;


call insert_fail_student_log();

select * from fail_student_log fsl;

-- Trigger
-- insert, update, delete가 발생했을 때 자동으로 실행되는 sql 프로그램
-- 주문이 들어오면 재고 자동 차감
-- 회원 정보가 수정되면 수정 로그를 저장
-- 급여가 음수가 입력되면 막기
-- 게시글이 삭제되면 기록 남기기

-- 프로시저는 직접 호출해야 실행이 된다.
-- 트리거는 자동으로 실행된다.

-- 트리거 작동 시점
-- BEFORE : 데이터가 저장,수정,삭제 되기 전에 실행(검사)
-- AFTER : 데이터가 저장,수정,삭제 된 후 실행(기록, 다른테이블을 수정)

-- 실행 이벤트
-- INSERT : 데이터 추가시 실행
-- UPDATE : 데이터 수정시 실행
-- DELETE : 데이터 삭제시 실행

-- NEW : 새로 들어오거나 수정될 값
-- OLD : 기존에 있던 값

-- 기본 문법
-- DELIMITER //
-- CREATE TRIGGER 트리거명
-- [BEFORE 또는 AFTER] [INSERT 또는 UPDATE 또는 DELETE]
-- ON 테이블명
-- FOR EACH ROW
-- BEGIN
--	실행할 SQL;
-- END //
-- DELIMITER ;


CREATE TABLE board (
    board_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT,
    writer VARCHAR(50),
    view_count INT DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at DATETIME DEFAULT NOW(),
    updated_at DATETIME
);

CREATE TABLE board_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    board_id INT,
    action_type VARCHAR(20),
    old_title VARCHAR(100),
    new_title VARCHAR(100),
    log_message VARCHAR(255),
    created_at DATETIME DEFAULT NOW()
);

-- board테이블에 게시글이 추가되면 board_log테이블에
-- 등록 로그를 남기는 트리거 작성하기
delimiter //
create trigger trg_board_after_insert
after insert on board
for each row
begin
	insert into board_log(
		board_id,
		action_type,
		new_title,
		log_message
	)
	values(
		new.board_id, -- 새로 추가된 값을 가져온다.
		'INSERT',
		new.title,
		'게시글이 등록되었습니다.'
	);
end //
delimiter ;

-- board테이블에 데이터 추가하기
insert into board(title, content, writer)
values ('첫 번째 게시글','트리거 실습입니다.','홍길동');

select * from board;
select * from board_log;

-- 게시글이 수정됐을 때 로그를 기록하는 트리거
-- 게시글 제목이 수정되면 변경 전 제목과 변경 후 제목을 board_log 테이블에 저장
delimiter //
create trigger trg_board_after_update
after update on board
for each row
begin
	if old.title <> new.title then
		insert into board_log(
			board_id,
			action_type,
			old_title,
			new_title,
			log_message
		)
		values
		(
			new.board_id,
			'update',
			old.title,
			new.title,
			'게시글 제목이 수정되었습니다.'
		);
	end if;
end //
delimiter ;


update board
set title = '새 제목'
where board_id = 1;

select * from board_log;

select * from board;

-- 게시글이 수정될 때마다 board테이블의 updated_at에 현재 시간을 자동 저장하는
-- trg_board_before_update 만들기

delimiter //
create trigger trg_board_before_update
before update on board
for each row
begin
	set new.updated_at = now();
end //
delimiter ;

update board
set content = '내용이 수정되었습니다.'
where board_id = 1;

select * from board;





