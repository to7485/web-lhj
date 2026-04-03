package ex2_object;

public class Main {
	public static void main(String[] args) {
		Product[] products = {
			new Product("키보드",5000,10), 
			new Product("마우스",25000,30), 
			new Product("모니터",30000,30)
		};
		
		for(Product p : products) {
			System.out.println(p);
		}
		
		
		
		Object[] arr = {"Java",100,3.14, new Employee("홍길동","개발팀")};
		
		//반복문으로 배열을 순회하면서
		//문자열이면 "문자열데이터 : xx"
		//정수면 "정수데이터 : xx"
		//실수면 "실수데이터 : xx"
		//Employee객체면 이름과 부서를 출력해주세요
		
		//instanceof
		for(Object o: arr) {
			if(o instanceof String) System.out.println("문자열데이터 : " + o);
			else if(o instanceof Integer) System.out.println("정수데이터 : " + o);
			else if(o instanceof Double) System.out.println("실수데이터 : " + o);
			else if(o instanceof Employee) {
				Employee e = (Employee)o;
				System.out.print("사원명 : " + e.name+", 부서 : " + e.dept);
			}
		}
		
		
		
		
		
		
		
		
		
	}
}
