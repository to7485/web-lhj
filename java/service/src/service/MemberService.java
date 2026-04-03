package service;

import member.Member;

//실제 기능을 만드는곳
public class MemberService {

	//매개변수자리에 들어올것은 member객체가 될거야
	public void register(Member member) {
		System.out.println("회원 등록을 시작합니다.");
		System.out.println("회원이름 : " + member.getName());
		System.out.println("나이 : " + member.getAge());
		System.out.println("회원 등록이 완료되었습니다.");
	}
	
	//성인인지 판단하는 checkAdult()메서드 만들기
	//20살 이상이면 "성인 회원입니다."
	//아니면 "미성년회원입니다."
	public void checkAdult(Member member) {
		if(member.getAge() >= 20) {
			System.out.println("성인 회원입니다.");
		} else {
			System.out.println("미성년 회원입니다.");
		}
	}
	
	
	
	
	
	
	
	
}
