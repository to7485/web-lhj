package ex3_generic.exam;

public class Main {
	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.setItem("사과");
		
		//문제1. 꺼낼때 형변환을 해야 한다.
		String item = (String)box.getItem();
		
		//문제2. 잘못된 타입이 들어가도 컴파일할 때 막기가 어렵다.
		//box.setItem(100);
		
		//int item2 = (int)box.getItem();
		String item2 = (String)box.getItem();
		
		//타입 안정성이 떨어지고, 형변환 코드가 많아지고
		//실수의 발견이 늦어진다.
		
		//제네릭을 사용하게 되면
		//꺼낼때 형변환이 필요없고, 잘못된 타입을 넣으면 컴파일 오류가 난다.
		//타입마다 변수를 만들어줄 필요가 없어서 재사용성이 크게 증가한다.
		//제네릭 타입변수에 들어갈 수 있는것은 클래스만 가능하다.
		
		ArrayPrinter ap = new ArrayPrinter();
		
		String[] names = {"홍길동","박길동","김길동"};
		//타입추론
		//인자로 전달한 값의 타입을 제네릭에 자동으로 전달
		ap.printArray(names);
		
		Integer[] nums = {10,20,30,40};
		ap.<Integer>printArray(nums);
		
		MemberResponse<Member> mr = 
					new MemberResponse<Member>(true, 
											  "테스트", 
											  new Member("홍길동",30));
		
		System.out.println(mr.isSuccess());
		System.out.println(mr.getData().getName());
		System.out.println(mr.getData().getAge());
		
		
		
		
		
		
		
		
	}
}
