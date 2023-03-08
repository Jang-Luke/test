package exam03;

import javax.swing.JOptionPane;

class CountDown extends Thread {
	public static int i = 10;
	public static int score = 0;
	public void run() {
		for ( ; i > 0; i--) {
			System.out.println(i);
			score++;
			try{Thread.sleep(1000);}catch(InterruptedException e) {}
		}
		System.out.println("버틴 시간 : " + score);
		System.out.println("GameOver..");
		System.exit(0);
	}
}

public class Main {

	public static void main(String[] args) throws Exception {

		String[] quizs = new String[]{
				"public static void main(String[] ar)",
				"Scanner sc = new Scanner(System.in)",
				"DataOutputStream dos = new DataOutputStream(os)"
		};

		new CountDown().start();
		while(true) {
			int index = (int)(Math.random()*3);
			String msg = JOptionPane.showInputDialog(quizs[index]);
			if(msg.equals(quizs[index])) {
				System.out.println("Success! : time +5");
				CountDown.i += 5;
			} else {
				System.out.println("Typo : time -3");
				CountDown.i -= 3;
			}
			System.out.println("현재 남은 시간 : " + CountDown.i);
		}

		//		for (int i = 0; i < quizs.length; i++) {
		//			String msg = JOptionPane.showInputDialog(quizs[i]);
		//			
		//			if(msg.equals(quizs[i])) {
		//				System.out.println("Success!");
		//			} else {
		//				System.out.println("Typo");
		//			}	
		//		}
		//		
		//		System.exit(0);
	}

}
