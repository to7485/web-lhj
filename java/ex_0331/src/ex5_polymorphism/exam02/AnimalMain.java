package ex5_polymorphism.exam02;

//추상 클래스
abstract class Animal{
	
	//추상클래스에도 일반적인 필드나 메서드가 들어갈 수 있다.
	int feed;
	
	public void breath() {
		System.out.println("숨쉰다.");
	}
	
	//추상메서드
	public abstract void sound();
}

//추상클래스를 상속받은 클래스는 추상 메서드를 반드시
//오버라이딩해서 내용을 구현해야 한다.
class Dog extends Animal{
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}

class Zoo{
	public void printSound(Animal animal) {
		animal.sound();
	}
}


public class AnimalMain {
	public static void main(String[] args) {
			Zoo z = new Zoo();
			
			//추상클래스는 객체를 직접 생성할 수 없다.
			//Animal a = new Animal();
			
			z.printSound(new Dog());
			z.printSound(new Cat());
	}
}




