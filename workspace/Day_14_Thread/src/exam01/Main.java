package exam01;

class MyThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("�� ��° for : %d\n",i);
		}
	}
}
class MyThread2 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("�� ��° for : %d\n",i);
		}
	}
}
class MyThread3 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("�� ��° for : %d\n",i);
		}
	}
}
class MyThread4 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("�ټ� ��° for : %d\n",i);
		}
	}
}

public class Main {

	public static void main(String[] args) {
		
		// Thread �����
		// Step1 : Thread Ŭ������ ��ӹ޴� ����� ���� Ŭ������ �ۼ��Ѵ�.
		// Step2 : Thread Ŭ�����κ��� ��ӹ޴� public void run �޼��带 overriding �Ѵ�.
		// Step3 : ����ó�� �ϰ��� �ϴ� �ҽ��ڵ带 run ���ο� �����Ѵ�.
		// Step4 : ���� �Ϸ�� Ŭ������ �ν��Ͻ�ȭ �Ѵ�.
		// Step5 : ������� �ν��Ͻ��κ��� start() �޼��带 call �Ѵ�.
		// Step6 : ���� Thread�� ������� �ǻ�� Thread Ŭ������ run() �޼��带 �����Ѵ�. (���� Thread�� ���� ���� �ڵ带 �����Ѵ�.) 

		MyThread1 mt1 = new MyThread1();
		MyThread2 mt2 = new MyThread2();
		MyThread3 mt3 = new MyThread3();
		MyThread4 mt4 = new MyThread4();
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("ù ��° for : %d\n",i);
		}
	}
}
