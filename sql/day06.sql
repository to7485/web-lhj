-- having
-- where과 기능은 같다.
-- 그룹화된 결과에 조건을 적용할 때 사용하는 키워드

-- where -> 묶기 전에 필터링
-- having -> 묶은 후에 필터링

-- group by를 사용하면 데이터가 다음과 같이 바뀐다.
-- 여러 행 -> 그룹으로 묶임 -> 집계 값이 생성

-- where에서는 집계함수를 사용할 수 없다.

-- 평균 급여가 5000 보다 큰 부서의 정보를 조회하세요
select department_id, avg(salary)
from employees
-- where avg(salary) > 5000 -- 전체 행에 대해서 평균급여를 구함
group by department_id
having avg(salary) > 5000;

-- select
-- from
-- where
-- group by
-- haivng

-- 급여가 5000 이상인 사원들을 대상으로
-- 부서별 평균 급여가 7000 이상인 부서 조회하기
select department_id, avg(salary)
from employees
where salary >= 5000
group by DEPARTMENT_ID 
having avg(salary) >= 7000;

-- 많이 하는 실수
-- where 절에 그룹함수 조건 걸기
-- group by 안한 속성을 select에서 사용
-- having 대신에 where 사용
-- 

-- 부서별 사원 수를 구하고 사원 수가 3명 이상인 부서만
-- 조회하세요
select department_id, count(*)
from employees e 
group by department_id 
having count(*) >= 3;
-- 부서별 최고 급여가 10000 이상인 부서 조회
select department_id, max(salary)
from employees
group by DEPARTMENT_ID 
having max(salary) >= 10000;

-- 입사년도별 사원 수 중 5명 이상인 년도만 출력
select year(hire_date), count(*)
from employees
group by year(hire_date)
having count(*) >= 5;

DROP TABLE IF EXISTS sales;

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    amount INT,
    sale_date DATE
);

INSERT INTO sales (category, amount, sale_date) VALUES
('식품', 80000, '2025-01-01'),
('식품', 70000, '2025-01-02'),
('식품', 60000, '2025-01-03'),
('전자제품', 250000, '2025-01-01'),
('전자제품', 150000, '2025-01-02'),
('의류', 30000, '2025-01-01'),
('의류', 25000, '2025-01-03'),
('도서', 12000, '2025-01-02'),
('가구', 180000, '2025-01-03'),
('가구', 50000, '2025-01-04'),
('문구', 10000, '2024-12-31'),
('문구', 15000, '2025-01-02');

-- 판매 내역 테이블
select * from sales;

-- 판매가 2번 이상 발생한 카테고리만 조회하기
select category, count(*)
from sales
group by category
having count(*) >= 2;
-- 카테고리별 평균 결제 금액이 100,000원 이상이 것만 
-- 조회하기
select category, avg(amount)
from sales s 
group by category 
having avg(amount) >= 100000;

-- 2025-01-02 이후의 거래만 대상으로, 카테고리별 총액이 20,000원
-- 이상인 경우만 조회하기
select category, sum(amount)
from sales
where sale_date >= '2025-01-02'
group by category 
having sum(amount) >= 20000;

-- 카테고리별 총 판매 금액을 구하되, 판매금액이 200,000이상인
-- 카테고리만 조회하기
select category, sum(amount)
from sales s
group by category
having sum(amount) >= 200000;

-- 카테고리별 가장 큰 판매금액을 구하되
-- 가장 큰 금액이 200,000원 이상인 카테고리만 조회하세요
select category, max(amount)
from sales s
group by category 
having max(amount) >= 200000;

-- 카테코리별 판매 총액을 구한 뒤, 총 판매금액이 50,000이상인
-- 카테고리만 조회하세요

select category, sum(amount)
from sales s 
group by category
having sum(amount) >= 50000;


-- 2025년 1월 1일에 판매된 데이터만 대상으로 하여
-- 카테고리별 판매 총액 구하기
-- 총 판매 금액이 20,000이상인것만 조회하기
select category, sum(amount)
from sales s 
where sale_date = '2025-01-01'
group by category 
having sum(amount) >= 20000;

-- ROLLUP
-- GROUP BY가 그룹별로 집계를 해준다면, ROLLUP은 소계와 총계
-- 까지 한 번에 만드는 기능

-- 아래에서 위로 합계를 말아 올리는 기능
-- 카테고리별 판매금액
select CATEGORY, SUM(AMOUNT)
from SALES
group by CATEGORY;

-- ROLLUP을 사용하여 카테고리별 합계와 전체합계를 같이 조회
select IFNULL(CATEGORY,'전체'), SUM(AMOUNT)
from SALES
group by CATEGORY with ROLLUP;

INSERT INTO sales (category, amount, sale_date) VALUES
-- 2024 데이터 보강
('식품', 50000, '2024-01-02'),
('식품', 40000, '2024-01-03'),
('전자제품', 120000, '2024-02-01'),
('전자제품', 80000, '2024-02-03'),
('의류', 20000, '2024-03-01'),
('가구', 90000, '2024-03-05'),
-- 2026 데이터 추가
('식품', 90000, '2026-01-01'),
('식품', 70000, '2026-01-02'),
('전자제품', 300000, '2026-01-03'),
('전자제품', 200000, '2026-01-04'),
('의류', 60000, '2026-02-01'),
('도서', 15000, '2026-02-03'),
('가구', 250000, '2026-03-01'),
('가구', 100000, '2026-03-05');

-- 년도별 + 카테고리별 ROLLUP
SELECT 
    year(SALE_DATE),
    CATEGORY,
    SUM(AMOUNT)
FROM SALES
GROUP BY year(SALE_DATE), CATEGORY WITH ROLLUP;
-- 년도 + 카테고리별 합계
-- 년도별 합계
-- 전제 합계

select * from SALES;

-- 월별 + 카테고리별 총 판매량 ROLLUP
select year(SALE_DATE),MONTH(SALE_DATE), CATEGORY, SUM(AMOUNT)
from SALES
group by year(SALE_DATE),MONTH(SALE_DATE),CATEGORY with rollup;

-- NULL 처리
-- 집계함수는 자동으로 NULL을 무시한다.

select * from EMPLOYEES;

select COUNT(*) from employees e; -- 전체 행
-- 속성을 넣으면 NULL값을 제외함

-- SALES테이블에서 카테고리의 개수 세기
-- DISTINCT : 중복되는 값을 제거한다.
select COUNT(distinct CATEGORY) from SALES;

-- IFNULL(컬럼,대체값)
select FIRST_NAME,SALARY,IFNULL(e.COMMISSION_PCT,0) 
from employees e;

INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES
(201, 'Chris', 'Brown', 'CBROWN', '2025-01-10', 'IT_PROG', NULL, NULL, 103, 60),
(202, 'Emma', 'Stone', 'ESTONE', '2025-02-15', 'FI_ACCOUNT', NULL, NULL, 108, 100),
(203, 'Liam', 'Smith', 'LSMITH', '2025-03-20', 'PU_CLERK', NULL, NULL, 114, 30),
(204, 'Olivia', 'Davis', 'ODAVIS', '2025-04-05', 'IT_PROG', NULL, NULL, 103, 60),
(205, 'Noah', 'Wilson', 'NWILSON', '2025-05-01', 'FI_ACCOUNT', NULL, NULL, 108, 100);

select * from EMPLOYEES where SALARY is null;

-- 전체 급여 평균
select AVG(IFNULL(SALARY,0)) from EMPLOYEES;

-- 형변환 함수
-- CAST(값 AS 타입);
-- CHAR : 문자열
-- SIGNED : 정수
-- DECIMAL : 소수
-- DATE : 날짜

-- 사원테이블에서 사원번호, 사원명, 급여를 조회하되,
-- 급여는 '급여 : XXX' 형태로 나오도록 작성하시오
select 
	EMPLOYEE_ID, 
	FIRST_NAME, 
	CONCAT('급여 : ', cast(SALARY as CHAR))
from EMPLOYEES;

-- ORDER BY
-- 쿼리 결과에 반환되는 행들을 특정 기준으로 정렬하고자 할 때 사용
-- ORDER BY절은 SELECT절의 가장 마지막에 기술
-- ASC : 오름차순(생략 가능)
-- DESC : 내림차순(생략 불가);

-- 사원테이블에서 급여를 많이 받는 순으로 사번, 이름, 급여를 출력하기
select EMPLOYEE_ID, FIRST_NAME, SALARY
from EMPLOYEES
where SALARY is not NULL
order by SALARY;

-- 정렬은 여러가지 기준으로 가능하다.
-- 급여가 같을 때 입사일이 늦은 순서대로 정리하기
select EMPLOYEE_ID, FIRST_NAME, SALARY, HIRE_DATE
from EMPLOYEES
where SALARY is not NULL
order by SALARY ASC, HIRE_DATE DESC;

select * from EMPLOYEES order by 7 ASC;


-- 순위를 구하는 함수
-- 행마다 순위를 붙여주는 함수

-- RANK() OVER(정렬)
select 
	RANK()OVER(order by SALARY DESC), 
	FIRST_NAME, 
	SALARY
from EMPLOYEES;
-- 공동 순위 발생
-- 다음 순위 건너 뜀 (1,2,2,4);

-- DENSE_RANK()
-- 공동순위는 있지만 건너뛰지 않음
select 
	DENSE_RANK()OVER(order by SALARY DESC), 
	FIRST_NAME, 
	SALARY
from EMPLOYEES;
-- ROW_NUMBER() : 무조건 순서대로 번호
select 
	ROW_NUMBER()OVER(order by SALARY DESC), 
	FIRST_NAME, 
	SALARY
from EMPLOYEES;











