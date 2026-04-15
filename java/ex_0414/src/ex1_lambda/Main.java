package ex1_lambda;

public class Main {
	public static void main(String[] args) {
		
		CalculatorService cs = new CalculatorService();
		
		Calculator c = (a,b) -> a + b;
		c.calc(10, 7);
		
		
		cs.execute(c);
		cs.execute((a,b) -> a-b);
		
		//람다식을 반환받아서 사용
		Calculator add = cs.getCalculator("add");
		Calculator sub = cs.getCalculator("sub");
		
		
		
		System.out.println(add.calc(2, 4));
		System.out.println(sub.calc(8, 6));
		
		
		
		
		
		
		
		
		
	}
}
