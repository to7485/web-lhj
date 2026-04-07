package ex2_annotaion.custom;

import java.lang.annotation.Annotation;

//어노테이션에 전달된 값은 변수처럼 바로 접근할 수 있는게 아니다.
@MyAnnotation(value="안녕하세요", name="김철수", age=25)
public class Main {
	public static void main(String[] args) {
		Class clazz = Main.class;
		//getAnnotations() : 클래스, 메서드, 필드 등에 붙어있는 "모든 어노테이션"을 가져오는 메서드
		Annotation [] annos = clazz.getAnnotations();
		
		for(Annotation anno : annos) {
			System.out.println(anno);
		}
		
		//어노테이션에 들어있는 내용 출력하기
		//getAnnotation() : 특정 어노테이션 하나를 가져온다.
		MyAnnotation my = 
				(MyAnnotation)clazz.getAnnotation(MyAnnotation.class);
		
		System.out.println(my.value());
		System.out.println(my.name());
		System.out.println(my.age());
		
		
		
		
		
	}
}
