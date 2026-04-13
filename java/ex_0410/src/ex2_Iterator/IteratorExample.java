package ex2_Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//반복자(Iterator)
//컬렉션 안에 들어있는 여러 데이터를 하나씩 꺼내서 확인하는 도구
//- 컬렉션의 처음부터 끝까지 이동한다.
//- 안에 들어있는 요소를 하나씩 꺼낸다.
//- 필요하면 현재 요소를 삭제할 수 있다.
public class IteratorExample {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		
		//Iterator 객체는 컬렉션 객체로부터 생성
		Iterator<Integer> iter = list.iterator();
		
		//Iterator의 주요 메서드
		//hasNext()
		//다음 요소가 있으면 true, 없으면 false를 반환한다.
		//next()
		//다음 요소를 하나 반환한다.
		//다음위치로 이동도 한다.
		
		//remove()
		//현재 반복자가 마지막으로 꺼낸 요소를 삭제한다.
		
		while(iter.hasNext()) {
			int val = iter.next();
			System.out.println(val);
		}
		
		//Set은 index가 없기 때문에 하나씩 꺼낼수가 없다.
		HashSet<String> set = new HashSet<String>();
		set.add("사과");
		set.add("바나나");
		set.add("포도");
		
		//반복자의 next()메서드를 통해 하나씩 꺼낼 수 있다.
		Iterator<String> iter2 = set.iterator();
		
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		System.out.println("----------------");
		
		//향상된 for문 내부에서 삭제는 불가능하다.
		//반복중에 remove()를 이용하여 삭제를 하면
		//Iterator가 관리하는 상태와 Set의 상태가 달라지게 된다.
		for(String f : set) {
			System.out.println(f);
		}
		System.out.println("----------------");
		//향상된 for문은 내부적으로 반복자를 사용하고 있다.
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			
			String f = it.next();
			
			if(f.equals("바나나")) {
				it.remove();//안전하게 삭제
			}
			
			System.out.println(f);
		}
		
		System.out.println(set);
		
		
		
		
		
	}
}




