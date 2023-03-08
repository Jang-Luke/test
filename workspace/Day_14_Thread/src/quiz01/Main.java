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

		// + �� ����ϴ� PlusThread
		// - �� ����ϴ� MinusThread
		// * �� ����ϴ� MplyThread
		// �� ���� �����Ͽ� ���� 100���� ��ȣ�� ���ÿ� ����ϰ� �����ô�.
		// ����� ���� �������� �սô�. ex)+---**+-***+++-*+*+-*
		PlusThread pt = new PlusThread();
		MinusThread mt = new MinusThread();
		MplyThread mpt = new MplyThread();
		pt.start();
		mt.start();
		mpt.start();
	}
}
