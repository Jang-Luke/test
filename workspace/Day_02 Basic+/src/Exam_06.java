import java.util.ArrayList;

public class Exam_06 {
	public static void main(String[] args) throws Exception {
		System.out.print("ASCII 10진수 코드 번호를 알고싶은 한 글자를 입력해주십시오. : ");
		int inputData1 = System.in.read();
		System.out.println("입력한 문자는 : " + (char)inputData1);
		char ch = (char)inputData1;
		int inputData2 = System.in.read();
		int inputData3 = System.in.read();
		int inputData4 = System.in.read();

		System.out.println("입력하신 글자 [" + ch + "] 의 ASCII 10진수 코드 번호는 " + inputData1 + "입니다.");
		System.out.println(inputData2);
		System.out.println(inputData3);
		System.out.println(inputData4);
		
	}

}
