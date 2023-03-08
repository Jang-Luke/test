package exan02;

import javax.swing.JOptionPane;

public class Exam_01 {
	public static void main(String[] args) {

		while(true) {
			String msg = JOptionPane.showInputDialog("클라이언트에게 보낼 메세지");
			
			JOptionPane.showMessageDialog(null, msg);
		}
	}
}
