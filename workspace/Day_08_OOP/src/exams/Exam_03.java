package exams;
import custom.Student;

public class Exam_03 {
	public static void main(String[] args) {

		Student studentJack = new Student();
		studentJack.setStdName("Jack").setKorScore(95).setEngScore(84).setMthScore(68);
		Student studentJane = new Student();
		studentJane.setStdName("Jane").setKorScore(100).setEngScore(50).setMthScore(95);
		Student studentLeez = new Student("Leez",67,88,75);
		Student studentFual = new Student("Faul",94,84,66);
		Student studentMike = new Student("Mike",81,80,86);
		Student studentMay = new Student();
		
//		System.out.println("-----------------");
//		System.out.println("이름 : " + studentJack.getStdName());
//		System.out.println("국어 : " + studentJack.getKorScore());
//		System.out.println("영어 : " + studentJack.getEngScore());
//		System.out.println("수학 : " + studentJack.getMthScore());
//		System.out.println("-----------------");
//		if (studentJack.getSumScore() % 3 == 0) {
//			System.out.printf("합계 : %d\n평균 : %.0f\n", studentJack.getSumScore(), studentJack.getAvgScore());
//		} else {
//			System.out.printf("합계 : %d\n평균 : %.2f\n", studentJack.getSumScore(), studentJack.getAvgScore());
//		}
//		System.out.println("-----------------");
		studentJack.showStdInfo();
//		System.out.println("-----------------");
//		System.out.println("이름 : " + studentJane.getStdName());
//		System.out.println("국어 : " + studentJane.getKorScore());
//		System.out.println("영어 : " + studentJane.getEngScore());
//		System.out.println("수학 : " + studentJane.getMthScore());
//		System.out.println("-----------------");
//		if (studentJane.getSumScore() % 3 == 0) {
//			System.out.printf("합계 : %d\n평균 : %.0f\n", studentJane.getSumScore(), studentJane.getAvgScore());
//		} else {
//			System.out.printf("합계 : %d\n평균 : %.2f\n", studentJane.getSumScore(), studentJane.getAvgScore());
//		}
//		System.out.println("-----------------");
		studentJane.showStdInfo();
		studentLeez.showStdInfo();
		studentFual.showStdInfo();
		studentMike.showStdInfo();
		studentMay.showStdInfo();
	}
}

class A {
	int a;
	public void func() {
		System.out.println(a);
	}
}

class B {
	int a;
}