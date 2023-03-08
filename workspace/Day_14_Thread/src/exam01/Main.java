package exam01;

class MyThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("두 번째 for : %d\n",i);
		}
	}
}
class MyThread2 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("세 번째 for : %d\n",i);
		}
	}
}
class MyThread3 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("네 번째 for : %d\n",i);
		}
	}
}
class MyThread4 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("다섯 번째 for : %d\n",i);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		
		// Thread 적용법
		// Step1 : Thread 클래스를 상속받는 사용자 정의 클래스를 작성한다.
		// Step2 : Thread 클래스로부터 상속받는 public void run 메서드를 overriding 한다.
		// Step3 : 병렬처리 하고자 하는 소스코드를 run 내부에 구현한다.
		// Step4 : 제작 완료된 클래스를 인스턴스화 한다.
		// Step5 : 만들어진 인스턴스로부터 start() 메서드를 call 한다.
		// Step6 : 메인 Thread가 만들어진 피상속 Thread 클래스의 run() 메서드를 실행한다. (메인 Thread와 각각 따로 코드를 실행한다.) 

		MyThread1 mt1 = new MyThread1();
		MyThread2 mt2 = new MyThread2();
		MyThread3 mt3 = new MyThread3();
		MyThread4 mt4 = new MyThread4();
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("첫 번째 for : %d\n",i);
		}
	}
}
