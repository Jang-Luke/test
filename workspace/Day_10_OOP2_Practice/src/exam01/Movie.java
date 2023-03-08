package exam01;

public class Movie {
	
	private String movieName; 
	private String genre;
	private double stars;
	
	public Movie() {} //����Ʈ ������
	                  //����Ʈ �����ڰ� ������ ���ڰ��� ������ �־�߸�
	                  //�ν��Ͻ��� ������ �� ���� !
	                  //�����Ӱ� �Ϸ��� ����Ʈ �����ڸ� ���� ! 
	
	public Movie(String movieName, String genre, double stars) {
		this.movieName = movieName;
		this.genre = genre;
		this.stars = stars;         //constructor (������) 
	}                               //overloading
	//�����ڴ� �ʱⰪ�� ������ ,,���� ���� �ٲܶ� setter�� ��! 
	
	
	//getter, setter
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getStars() {
		return stars;
	}
	public void setStars(double stars) {
		this.stars = stars;
	}
	
	
}
