package exam01;

public class Exam_01 {

	//Movie m = new Movie("�ƹ�Ÿ2","SF/�׼�",9.0);
	//���⿡���� �ν��Ͻ� ����� ���� !


	public static void main(String[] args) {

//		//�ڷ����� ���������!! Movie m = new Movie();
//		Movie m = new Movie("�ƹ�Ÿ2","SF/�׼�",9.0);
//		//�ν��Ͻ��� ���� �޼��� ��, Ŭ���� �ȿ��� ���� �� ���� 
//		//constructor�� �̿��Ͽ� �� �־��ֱ� !
//		Movie s = new Movie("����","���",8.42);


		Movie[] movies = new Movie[] { //�迭�� ���� �� !
				new Movie("�ƹ�Ÿ2","SF/�׼�",8.42),
				new Movie("����","���",8.42)
		};
		
		movies[1].setStars(10);
		
		for(int i = 0; i < movies.length; i++) {
			System.out.println(movies[i].getMovieName()+"\t"+movies[i].getGenre()+"\t"+movies[i].getStars());
		}
		
//		System.out.println(movies[0].getMovieName()+"\t"+movies[0].getGenre()+"\t"+movies[0].getStars());
		
	}
}