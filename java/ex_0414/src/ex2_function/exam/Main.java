package ex2_function.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("홍길동",20));
		members.add(new Member("박길동",18));
		members.add(new Member("이길동",40));
		members.add(new Member("김길동",27));
		
		//20세 이상인지 검증하는 람다식
		Predicate<Member> adult = m -> m.age >= 20;
		
		for(Member m : members) {
			if(adult.test(m)) {
				System.out.println(m.name+" / " +m.age);
			}
		}
		
		
		
		
		
		
	}
}
