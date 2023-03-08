package quiz01;

class PlusThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("+");	
		}
	}
}
class MinusThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");	
		}
	}
}
class MplyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("*");	
		}
	}
}

public class Main {
	public static void main(String[] args) {

		// + 를 출력하는 PlusThread
		// - 를 출력하는 MinusThread
		// * 를 출력하는 MplyThread
		// 를 각각 생성하여 각각 100개씩 기호를 동시에 출력하게 만들어봅시다.
		// 출력은 가로 방향으로 합시다. ex)+---**+-***+++-*+*+-*
		PlusThread pt = new PlusThread();
		MinusThread mt = new MinusThread();
		MplyThread mpt = new MplyThread();
		pt.start();
		mt.start();
		mpt.start();
	}
}
