package exams;

class A {
	public void funcA() {
		System.out.println("A �Դϴ�.");
	}
}

class B extends A {
	public void funcA() {
		System.out.println("B1 �Դϴ�.");
	}
	
	public void funcB() {
		System.out.println("B2 �Դϴ�.");
	}
}

class C extends A{
	
}

abstract class Animal {abstract public void sound();}

class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("�۸�");
	}
}

class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("�߿�");
	}
}

class Crow extends Animal {
	@Override
	public void sound() {
		System.out.println("���");
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
		
		// ������
		// Ŭ���� �� ��Ӱ��迡�� �θ�Ŭ���� �ڷ������� ���� ���� �������� �����Ǵ� ����
		// ���� Ŭ���� ���� ������ ���� Ŭ���� �ν��Ͻ��� �ּҸ� ������ �� �ִ�!

		A a = new B(); // up casting
		a.funcA();
		((B)a).funcB(); // down casting
		
		
		// �������� ������ �θ� Ŭ���� ���������� �⺻������ �ڽ��� Type ��ŭ�� ������ ����
		// ���� �ڽ��� Type�� �ƴ� ���Ե� �ν��Ͻ��� ��� ����� ����ϰ� �ʹٸ� Down casting �ʿ�
		// * ���� ��Ȳ : �ڽ� Ŭ�������� Overriding �� �޼���� Down Casting ���� ��� ����
	}
}
