package exams;

class A {
	public void funcA() {
		System.out.println("A 입니다.");
	}
}

class B extends A {
	public void funcA() {
		System.out.println("B1 입니다.");
	}
	
	public void funcB() {
		System.out.println("B2 입니다.");
	}
}

class C extends A{
	
}

abstract class Animal {abstract public void sound();}

class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}

class Crow extends Animal {
	@Override
	public void sound() {
		System.out.println("까악");
	}
}


public class Exam_01 {
	public static void main(String[] args) {
		
		Animal cat = new Cat();
		Animal dog = new Dog();
		Animal crow = new Crow();
		dog.sound();
		cat.sound();
		crow.sound();
		
		// 다형성
		// 클래스 간 상속관계에서 부모클래스 자료형으로 만든 참조 변수에게 발현되는 성질
		// 상위 클래스 참조 변수는 하위 클래스 인스턴스의 주소를 저장할 수 있다!

		A a = new B(); // up casting
		a.funcA();
		((B)a).funcB(); // down casting
		
		
		// 다형성을 가지는 부모 클래스 참조변수는 기본적으로 자신의 Type 만큼의 참조만 가능
		// 만약 자신의 Type이 아닌 대입된 인스턴스의 모든 기능을 사용하고 싶다면 Down casting 필요
		// * 예외 상황 : 자식 클래스에서 Overriding 한 메서드는 Down Casting 없이 사용 가능
	}
}
