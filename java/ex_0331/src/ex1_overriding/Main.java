package ex1_overriding;

public class Main {
	public static void main(String[] args) {
		
		Dog d = new Dog();
		d.sound();
		Cat c = new Cat();
		c.sound();
		
		RegularEmployee re = new RegularEmployee("박길동", 2900000);
		PartTimeEmployee pe = new PartTimeEmployee("김길동", 8, 20000);
		
		System.out.println(re.name + " " + re.getPay());
		System.out.println(pe.name + " " + pe.getPay());
	}
}







