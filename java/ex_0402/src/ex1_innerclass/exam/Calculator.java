package ex1_innerclass.exam;

public class Calculator {

	static class Result{
		int value;
		
		public Result(int value) {
			this.value = value;
		}
		
		void show() {
			System.out.println("계산 결과 : " + value);
		}
	}
	
	Result add(int a, int b){
		return new Result(a+b);
	}
}
