package ex1_List.ArrayList.stack;

import java.util.Stack;

//Stack
//LIFO(LastInFirstOut) 구조를 가지는 자료구조

public class StackExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		//스택에 데이터를 추가할 때
		//push()
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		//스택에 들어있는 내용 꺼내기
		//pop();
		System.out.println(stack.pop());
		
		//현재 맨위에 있는 값
		//peak();
		System.out.println(stack.peek());
	}
}





