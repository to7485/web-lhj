-- 고객이름, 주문한 제품명을 left outer join을 이용하여 조회하기
select customer_name, product_name
from customer c
left outer join orders o
on c.customer_id = o.customer_id
left outer join product p
on o.product_id = p.product_id
where product_name = '노트북';

select * from EMPLOYEE E; -- 별칭은 해당 SELECT문에서만 유효하다.

select * from E; -- 다른 SELECT에서 사용할 수 없다!!

DELIMITER //
create procedure hello_proc()
begin
	select 'HELLO MYSQL';
end
DELIMITER ;

call hello_proc();

-- product 테이블의 전체 내용을 조회하는
-- show_product 프로시저 만들고 호출하여
-- 결과 확인하기

delimiter //
create procedure show_product()
begin
	select * from product;
end

delimiter ;

call show_product();

-- 프로시저 삭제
drop procedure hello_proc;

-- 프로시저 목록 확인
show procedure STATUS;

-- 변수 추가하기
DELIMITER //
create procedure VARIABLE_PROC()
begin
	declare num int;
	set num = 100;
	select num;
end
delimiter ;

call variable_proc();

-- product에서 101번의 제품 가격을 v_price
-- 변수에 넣어서 조회하는 get_product_price()
-- 프로시저 만들기
DELIMITER //
create procedure get_product_price()
begin
	declare v_price INT;

-- 	select PRICE
-- 	into v_price -- 테이블 조회 결과를 변수에 대입
-- 	from PRODUCT
-- 	where PRODUCT_ID = 101;
	
	set v_price = (
		select PRICE
		from PRODUCT
		where PRODUCT_ID = 101;
	)
	select v_price as product_price;
end
DELIMITER ;

call get_product_price();

drop procedure find_product;

DELIMITER //
create procedure find_product(in p_id int)
begin
	select *
	from product
	where product_id = p_id;
end //
delimiter ;

call find_product(101);

DELIMITER //
create procedure GET_STOCK(
	IN P_ID INT,
	out P_STOCK INT
)
begin
	select stock
	into p_stock
	from product
	where product_id = p_id;
end //
delimiter ;

call get_stock(1,@result_stock);

select @result_stock;

-- 세션변수
-- @변수명
-- 현재 MYSQL 연결동안만 유지되는 변수

-- MYSQL의 변수의 종류
-- 지역변수 : 프로시저 내부에서만 사용 가능
-- 세션변수 : 전체 세션에서 사용이 가능하다.

-- INOUT변수를 통해서 숫자를 전달받고, 10을 더한뒤 내보내는
-- increase_number 프로시저 만들기

DELIMITER //
create procedure increase_number(inout p_num int)
begin
	set p_num = p_num + 10;
end //
delimiter ;

-- 세션변수는 declare 없이 선언이 가능하다
set @num = 5;
call increase_number(@num);
select @num;

DELIMITER //
create procedure check_stock(in P_ID INT)
begin
	declare v_stock int;
	
	select stock
	into v_stock
	from product
	where product_id = p_id;
	
	if v_stock >= 10 then
		select '재고가 충분합니다.' as message;
	elseif v_stock = 0 then
		select '품절입니다.' as message;
	end if;
end //
delimiter ;

call check_stock(6);

-- save_product 프로시저 만들기
-- product_id를 매개변수로 전달하여 조회가 된다면 상품정보를 수정하기
-- 조회가 안된다면 새로운 상품을 추가하기
-- 매개변수는 다음과 같다.
-- p_product_id
-- p_product_name
-- p_category
-- p_price
-- p_stock

DELIMITER //
create procedure save_product(
	in p_product_id int,
	in p_product_name varchar(50),
	in p_category varchar(30),
	in p_price int,
	in p_stock int
)
begin
	declare v_count int;

	select count(*)
	into v_count
	from product
	where product_id = p_product_id;
	
	if v_count = 0 then
		insert into PRODUCT(PRODUCT_NAME,CATEGORY,PRICE,STOCK)
		values (P_PRODUCT_NAME, P_CATEGORY, P_PRICE, P_STOCK);
	else
		update PRODUCT
		set PRODUCT_NAME = P_PRODUCT_NAME,
			CATEGORY = P_CATEGORY,
			PRICE = P_PRICE,
			STOCK = P_STOCK
		where product_id = p_product_id;
	end if;
end //
delimiter ;

call save_product(7,'USB 허브','전자기기',30000,40);
call SAVE_PRODUCT(1,'기계식 키보드','전자기기',150000,50);
select * from PRODUCT;


-- delete_product 프로시저 만들기
-- 전달받은 product_id가 있으면 해당 데이터 삭제하기
-- 존재하지 않으면 '데이터가 없습니다'라고 출력하기
DELIMITER //
create procedure DELETE_PRODUCT(
	in P_PRODUCT_ID INT
)
begin
	declare V_COUNT INT;

	select COUNT(*)
	into v_count
	from product
	where product_id = p_product_id;
	
	if V_COUNT = 0 then
		select '데이터가 없습니다.' as MESSAGE;
	else
		delete from PRODUCT where PRODUCT_ID = P_PRODUCT_ID;
		select '삭제가 완료되었습니다.' as MESSAGE;
	end if;
end //
DELIMITER ;

call DELETE_PRODUCT(7);







