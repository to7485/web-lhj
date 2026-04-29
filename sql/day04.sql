
-- length() -> 몇바이트 인지 반환
select title, length(title) from film_practice;

-- 테이블에 저장된 데이터가 아니라, 값 자체를 함수에 직접 전달해서
-- 결과를 확인할 수 있다.
select length('가나다');

-- char_length()
-- 글자 수를 반환한다.
-- 한글 이모지를 포함해서 실제 글자 수를 보고싶을 때 사용한다.
select char_length('가나다');
select title, char_length(title) from film_practice;

-- select 절에 사용하는 것은 조회해서 확인을 하겠다.

-- 영화제목이 10자 이하인 것만 영화제목(title)을 조회하세요
select title, char_length(title)
from film_practice fp 
where char_length(title) <= 10;

-- Upper(), UCASE()
-- 문자열을 대문자로 변환
select upper('Hello MySQL');

-- 검색에서 대소문자 무시하고 비교하고 싶을 때 사용한다.

create table customer_practice as
select * from sakila.customer;

select * from customer_practice;

-- LOWER()
-- 모든 글자를 소문자로 출력

-- CUSTOMER 테이블의 이름을 소문자로 조회하기
select FIRST_NAME,LOWER(FIRST_NAME) from CUSTOMER_PRACTICE;

-- 테이블에 들어있는 데이터가 대문자인지 소문자인지 모를 때
-- 전부다 대문자로 바꾸던지, 소문자로 변환해서 사용

-- TRIM(), LTRIM(), RTRIM()
-- 공백제거하기

select TRIM('    HI    '); -- 양쪽 공백 제거
select LTRIM('    HI    '); -- 왼쪽 공백 제거
select RTRIM('    HI    '); -- 오른쪽 공백 제거

-- 특정 문자 지우기 문법 제공
select TRIM('x' from 'xxxHELLOxxx');

-- LPAD(), RPAD()
-- 왼쪽/오른쪽에 문자열을 채워 넣는 함수
-- LPAD(문자열, 총길이, 채울문자)

select LPAD('HELLO',10,'*');
select RPAD('HELLO',10,'*');

-- 문자열이 길이를 초과하게 되면 자른다.
select LPAD('ABCDEF',4,'0');

-- 고객테이블에서 회원번호의 자리수를 5로 만들고
-- 빈자리는 0으로 채워 고객 번호와 이름을 조회하세요.
select LPAD(customer_id,5,'0'), first_name
from customer_practice cp;

-- SUBSTRING(문자열,시작위치,길이)
-- SUBSTR()
-- MID()

select SUBSTRING('Hello MySQL', 1,5);
-- 글자를 셀 때 1부터 시작한다.

-- 길이를 생략하면 끝까지 자른다.
select substr('Hello MySQL',7);

-- 음수 사용 가능함(뒤에서부터 자른다.)
select mid('Hello MySQL',-5);

-- LEFT(), RIGHT()
-- 문자열에서 왼쪽/오른쪽에서 원하는 길이만큼 잘라서 반환하는 함수

select 
	LEFT('Hello',2),
	right('Hello',2);

-- '900101-1234567' 문자열에서 주민번호 앞 6자리만 자르기
select left('900101-1234567',6);
-- photo.png에서 파일 확장하 추출하기
select right('photo.png',4);

-- INSTR(전체 문자열,찾을 문자열)
-- 찾을 문자열이 시작되는 위치번호를 반환
-- 위치번호는 1부터 시작
-- 찾지 못하면 0을 반환한다.

select
	INSTR('HELLO','L'),
	INSTR('사과바나나포도','바나나'),
	INSTR('사과바나나포도','딸기');

-- 이메일에서 @위치 찾기
-- 'USER01@TEST.COM'

-- 이메일에서 아이디 부분을 추출하기
select
	MID(
	'USER01@TEST.COM',
	1,
	INSTR('USER01@TEST.COM','@')-1);

select * from customer_practice cp;

-- 고객 테이블에서 고객번호와 이메일에서 추출한 아이디를
-- 조회하세요

select 
	CUSTOMER_ID, 
	MID(EMAIL,1,INSTR(EMAIL,'@')-1)
from customer_practice cp;

-- 고객테이블에서 이메일에 @sakilacustomer.org가 포함된
-- 고객객의 고객번호와 이름 조회하세요

select customer_id, first_name
from customer_practice cp
where instr(email, '@sakilacustomer.org') <> 0;

-- CONCAT('문자열1','문자열2',...)
-- 인자로 전달된 문자열을 하나로 이어붙이는 함수이다.
-- 괄호 안에 들어간 문자열들을 순서대로 이어붙인다.
-- 문자열이 아닌 숫자도 자동으로 문자열로 변환해서 이어 붙인다.

select
	CONCAT('HELLO', 'WORLD'),
	CONCAT('HELLO',' ','WORLD');

select CONCAT('나이 : ',25,'세');

-- 고객 테이블에서 이름과 성을 연결하여 조회하기
select CONCAT(FIRST_NAME,' ',LAST_NAME)
from customer_practice cp;

-- REPLACE(문자열, OLD, NEW)
-- 문자열 안에 있는 OLD 문자열을 찾아서 NEW 문자열로 치환

select REPLACE('ABCDAB','AB','XY');

-- 공백 문자 치환
select REPLACE('Hello world',' ', '');

-- 없는 문자열을 찾으려고 하면 그대로 반환한다.

-- REPEAT(문자열, 횟수)
-- 같은 문자열을 여러 번 반복해서 이어붙이고 싶을 때
select REPEAT('ABC',3);
select REPEAT('*',5);

CREATE TABLE member (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(100),
  phone VARCHAR(50),
  nickname VARCHAR(50)
);

INSERT INTO member VALUES
(1, '홍길동', 'gildong@test.com', '010-1234-5678', '길동이'),
(2, '김영희', 'younghee@test.com', '010-999-8888', '영희짱'),
(3, '이철수', 'chulsoo@oldmail.com', '010-7777-3333', '철수'),
(4, 'Jane', 'jane@example.com', '010-1212-3434', NULL);

-- 이름과 이메일을 하나의 문자열로 합쳐서 출력하기
-- 홍길동 - GILDONG@TEST.COM
select CONCAT(NAME, ' - ', EMAIL) from member;
-- 전화번호에서 하이픈을 모두 제거한 결과 출력하기
-- 01012345678
select REPLACE(PHONE, '-','') from member;
-- 이름을 3번 반복하여 출력하기
-- 홍길동홍길동홍길동
select REPEAT(NAME, 3) from member;
-- 이메일 도메인에서 @TEST.COM은 @SCHOOL.COM으로 변경하여 출력하기
select replace(EMAIL,'@test.com','@school.com') from member;
-- 전화번호 앞 3자리는 그냥 두고 뒤 숫자는 *로 마스킹하기
-- 010-****-****
select concat(
		left(phone,3),
		'-',
		repeat('*',char_length(substring_index(substring_index(phone,'-',2),'-',-1))),
		'-',
		repeat('*',char_length(substring_index(phone,'-',-1))))
from member;

-- substring_inex('문자열','구분자',개수)
-- 구분자를 기준으로 문자열을 나누고 앞 또는 뒤에서 
-- 원하는 부분만 가져오는 함수
select substring_index('a-b-c-d','-',-2);

-- 이름의 글자수와 닉네임의 글자수 구하기
-- 홍길동 3 길동이 3
select name, char_length(name), nickname, char_length(nickname) from member;
-- 전화번호가 010으로 시작하지 않는 회원을 찾고 "국내번호 아님: 전화번호"를 붙여서 출력하기
select
	concat('국내번호 아님 : ', phone)
from member
where left(phone,3) <> '010';


-- customer_practice 테이블에서 이름의 첫글자만 남기고 나머지는 *로 마스킹하기
select CONCAT(
	left(FIRST_NAME,1),
	RPAD('',CHAR_LENGTH(FIRST_NAME)-1,'*')) 
from customer_practice cp ;


-- film테이블에서 제목이 'A'로 시작하는 영화만 조회하기 (LIKE X);
select *
from  film_practice fp 
where LEFT(TITLE,1) = 'A';











