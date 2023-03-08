package exam01;

public class Exam_01 {

	//Movie m = new Movie("아바타2","SF/액션",9.0);
	//여기에서도 인스턴스 만들기 가능 !


	public static void main(String[] args) {

//		//자료형을 맞춰줘야함!! Movie m = new Movie();
//		Movie m = new Movie("아바타2","SF/액션",9.0);
//		//인스턴스는 메인 메서드 안, 클래스 안에도 만들 수 있음 
//		//constructor를 이용하여 값 넣어주기 !
//		Movie s = new Movie("영웅","드라마",8.42);


		Movie[] movies = new Movie[] { //배열을 만든 것 !
				new Movie("아바타2","SF/액션",8.42),
				new Movie("영웅","드라마",8.42)
		};
		
		movies[1].setStars(10);
		
		for(int i = 0; i < movies.length; i++) {
			System.out.println(movies[i].getMovieName()+"\t"+movies[i].getGenre()+"\t"+movies[i].getStars());
		}
		
//		System.out.println(movies[0].getMovieName()+"\t"+movies[0].getGenre()+"\t"+movies[0].getStars());
		
	}
}