package exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_01_Practice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		// new Movie�� �ν��Ͻ��� ����鼭 heap�޸𸮿� ����Ǿ�
		// null������ �ʱ�ȭ ������ �ʾƵ� �� !
		// �ּҸ� ��� �������̸� 0�� �ƴ϶� null���� �� 

		


		while(true) {
			
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. �ű� ��ȭ ���");
			System.out.println("2. ��ȭ ��� ���");
			System.out.println("3. ��ȭ ��� ����");
			System.out.println("4. ��ȭ ���� ����");
			System.out.println("5. ��ȭ �˻�");
			System.out.println("0. ����");
			System.out.print(">> ");

			int num = Integer.parseInt(sc.nextLine());

			if(num == 1) {

				System.out.print("��ȭ ������ �Է��� �ּ��� : ");
				String title = (sc.nextLine());

				System.out.print("��ȭ �帣�� �Է��� �ּ��� : ");
				String genre = (sc.nextLine());

				System.out.print("��ȭ ������ �Է��� �ּ��� : ");
				double stars = Double.parseDouble(sc.nextLine());//double�� ���� �Է¹޴� �޼��� !!

				System.out.println("�Է��� �Ϸ�ƽ��ϴ�.");

				manager.addMovie(new Movie(title,genre,stars));


			}else if(num == 2) {

				ArrayList <Movie> movies = manager.getMovies();
				
				if(movies.size() == 0) {
					System.out.println("��ϵ� ��ȭ�� �����ϴ�.");
				}
				System.out.println("����\t�帣\t����");
				for(Movie movie : movies) {
					System.out.println(movie.getMovieName()+"\t"+
							           movie.getGenre()+"\t"+
							           movie.getStars());
					
					//movies�� ��� ArrayList�� movie�� ����
					//ArrayList�� �ν��Ͻ��� movie�� .�� ���� �� �ִ� !!
				}
			}else if(num == 3) {

				System.out.print("������ ��ȭ ���� : ");	
				String title = sc.nextLine();

				int result = manager.deleteByTitle(title);

				if(result == -1) {
					System.out.println("�����Ϸ��� ��ȭ�� �������� �ʽ��ϴ�.");

				}
				else {
					System.out.println("���� �Ϸ��߽��ϴ�.");
				}
			}else if(num == 4) {

				System.out.print("������ ��ȭ ������ �Է����ּ��� : ");
				String title = sc.nextLine();

				int index = manager.getIndexByTitle(title);
				
				if(index == -1) {
					System.out.println("�ش� ������ ��ȭ�� �������� �ʽ��ϴ�.");
					
				}   else {
					System.out.print("������ ���� : ");
					String modTitle = sc.nextLine();

					System.out.print("������ �帣 : ");
					String modGenre = sc.nextLine();

					System.out.print("������ ���� : ");
					double modScore = Double.parseDouble(sc.nextLine());

					manager.updateByIndex(index,new Movie(modTitle, modGenre, modScore));
					//title�� �Է��� ����,�帣,�������� �ٲٱ� !!

				}
			}
			else if(num == 5) {

				System.out.print("�˻��� ��ȭ ������ �Է����ּ��� : ");

				String search = sc.nextLine();

				ArrayList <Movie> result = manager.getMovies(search);

				System.out.println("����\t�帣\t����");

				if(result.size() == 0) {
					System.out.println("��ϵ� ��ȭ�� �����ϴ�.");

				}else {
					for(Movie movie : result) {
						System.out.println(movie.getMovieName() + "\t" +
								           movie.getGenre() + "\t" +
								           movie.getStars());
					}
				}
			}
			else if(num == 0) {
				System.out.println("Netflix�� �����մϴ�.");
				System.exit(0);
			}else {
				System.out.println("��ȣ�� �ٽ� Ȯ�����ּ���.");
			}
		}
	}
}