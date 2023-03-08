package exam03;

import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Contact[] con = new Contact[3];
		int index = 0;

		while(true) {
			
			System.out.println("===이메일 입력===");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.지우기");
			System.out.println("0.프로그램 종료");

			int num = Integer.parseInt(sc.nextLine());

			if(num == 1) {
				System.out.print("이름을 입력하세요.");
				String name = sc.nextLine();
				System.out.println("번호를 입력하세요.");
				String number = sc.nextLine();
				System.out.println("메일을 입력하세요.");
				String mail = sc.nextLine();

				con[index++] = new Contact(name,number,mail);
			}

			else if(num == 2) {

				if(index == 0) {
					System.out.println("입력된 메일이 없습니다.");
				}
				else {
					for(int i = 0; con[i] != null; i++) {
						System.out.println("이름\t번호\t메일");
						System.out.println(con[i].getName()+"\t"+con[i].getNums()+"\t"+con[i].getMail());
					}
				}
			}
			else if(num == 3) {   //메일 지우기 !
				
				if(index == 0) {
					System.out.println("삭제할 메일이 없습니다.");
					continue;
				}
				con[--index] = null;
				System.out.println("삭제 되었습니다.");

			}
			else if(num == 0) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("번호를 제대로 입력해주세요.");
			}

		}
	}
}