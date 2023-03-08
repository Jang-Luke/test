package exam01;

public class Movie {
	
	private String movieName; 
	private String genre;
	private double stars;
	
	public Movie() {} //디폴트 생성자
	                  //디폴트 생성자가 없으면 인자값을 무조건 넣어야만
	                  //인스턴스를 생성할 수 있음 !
	                  //자유롭게 하려고 디폴트 생성자를 만듦 ! 
	
	public Movie(String movieName, String genre, double stars) {
		this.movieName = movieName;
		this.genre = genre;
		this.stars = stars;         //constructor (생성자) 
	}                               //overloading
	//생성자는 초기값을 넣을때 ,,쓰고 값을 바꿀때 setter를 씀! 
	
	
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
