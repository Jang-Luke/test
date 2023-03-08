package exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_01_Practice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		// new Movie로 인스턴스를 만들면서 heap메모리에 저장되어
		// null값으로 초기화 해주지 않아도 됨 !
		// 주소를 담는 참조형이면 0이 아니라 null값이 들어감 

		


		while(true) {
			
			System.out.println("<< Netflix Simulator >>");
			System.out.println("1. 신규 영화 등록");
			System.out.println("2. 영화 목록 출력");
			System.out.println("3. 영화 목록 삭제");
			System.out.println("4. 영화 제목 수정");
			System.out.println("5. 영화 검색");
			System.out.println("0. 종료");
			System.out.print(">> ");

			int num = Integer.parseInt(sc.nextLine());

			if(num == 1) {

				System.out.print("영화 제목을 입력해 주세요 : ");
				String title = (sc.nextLine());

				System.out.print("영화 장르를 입력해 주세요 : ");
				String genre = (sc.nextLine());

				System.out.print("영화 평점을 입력해 주세요 : ");
				double stars = Double.parseDouble(sc.nextLine());//double형 변수 입력받는 메서드 !!

				System.out.println("입력이 완료됐습니다.");

				manager.addMovie(new Movie(title,genre,stars));


			}else if(num == 2) {

				ArrayList <Movie> movies = manager.getMovies();
				
				if(movies.size() == 0) {
					System.out.println("등록된 영화가 없습니다.");
				}
				System.out.println("제목\t장르\t평점");
				for(Movie movie : movies) {
					System.out.println(movie.getMovieName()+"\t"+
							           movie.getGenre()+"\t"+
							           movie.getStars());
					
					//movies에 담긴 ArrayList를 movie에 담음
					//ArrayList는 인스턴스라 movie에 .을 찍을 수 있다 !!
				}
			}else if(num == 3) {

				System.out.print("삭제할 영화 제목 : ");	
				String title = sc.nextLine();

				int result = manager.deleteByTitle(title);

				if(result == -1) {
					System.out.println("삭제하려는 영화가 존재하지 않습니다.");

				}
				else {
					System.out.println("삭제 완료했습니다.");
				}
			}else if(num == 4) {

				System.out.print("수정할 영화 제목을 입력해주세요 : ");
				String title = sc.nextLine();

				int index = manager.getIndexByTitle(title);
				
				if(index == -1) {
					System.out.println("해당 제목의 영화는 존재하지 않습니다.");
					
				}   else {
					System.out.print("변경할 제목 : ");
					String modTitle = sc.nextLine();

					System.out.print("변경할 장르 : ");
					String modGenre = sc.nextLine();

					System.out.print("변경할 평점 : ");
					double modScore = Double.parseDouble(sc.nextLine());

					manager.updateByIndex(index,new Movie(modTitle, modGenre, modScore));
					//title을 입력한 제목,장르,평점으로 바꾸기 !!

				}
			}
			else if(num == 5) {

				System.out.print("검색할 영화 제목을 입력해주세요 : ");

				String search = sc.nextLine();

				ArrayList <Movie> result = manager.getMovies(search);

				System.out.println("제목\t장르\t평점");

				if(result.size() == 0) {
					System.out.println("등록된 영화가 없습니다.");

				}else {
					for(Movie movie : result) {
						System.out.println(movie.getMovieName() + "\t" +
								           movie.getGenre() + "\t" +
								           movie.getStars());
					}
				}
			}
			else if(num == 0) {
				System.out.println("Netflix를 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("번호를 다시 확인해주세요.");
			}
		}
	}
}